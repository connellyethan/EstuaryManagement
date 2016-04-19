package main;

import java.awt.Dimension;
import java.awt.DisplayMode;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.util.Scanner;
import javax.swing.JFrame;

import misc.Preferences;
import misc.Utilities;
import model.GameState;
import screens.Controller;
import screens.EndGameScreen;
import screens.MainGameScreen;
import screens.MenuScreen;
import view.PreAlphaView;

public class PreAlphaMain {

	static PreAlphaView view;
	static JFrame frame;
	static GameState state;
	static Controller currentScreen;
	static PreAlphaMain game;
	private long lastTime, now;
	private final double ticksPerSecond = 60.0;
	private double nanosPerTick = 1000000000.0 / ticksPerSecond;
	private double deltaNs = 0;
	public boolean running;

	public PreAlphaMain() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame("PreAlpha!");
		
		
		view = new PreAlphaView();
		DisplayMode dm = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDisplayMode();
		// view.setPreferredSize(new Dimension(dm.getWidth(), dm.getHeight()));
		Preferences.setWINDOW_HEIGHT(600);
		Preferences.setWINDOW_WIDTH(900);
		view.setPreferredSize(new Dimension(Preferences.getWINDOW_WIDTH(), Preferences.getWINDOW_HEIGHT()));
		Utilities.setWindowHeight(view.getPreferredSize().getHeight(), view.getPreferredSize().getWidth());

		switchStates(GameState.MENU);

		frame.getContentPane().add(game.view);
		setFrameProperties();

		running = false;

	}

	private void setFrameProperties() {
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setUndecorated(false);
		/*
		 * try { frame.setIconImage(Util.loadImage("/icon.png", game)); } catch
		 * (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	public void start() {
		// TODO null checks
		running = true;
		run();
	}

	public void run() {
		view.requestFocus();
		lastTime = System.nanoTime();
		long sum = 0;
		long count = 1;
		while (running) {
			now = System.nanoTime();
			deltaNs += (now - lastTime);
			//System.out.println(sum/count);
			sum+=now - lastTime;
			count++;
			lastTime = now;
			if (deltaNs >= nanosPerTick) {
				onTick();
				deltaNs -= nanosPerTick;// possible set it to 0 alternatively,
				drawScreen(); // depending on certain factors
			}
		}
	}

	public void onTick() {
		if (state == GameState.MENU) {
			menuTick();
		} 
		else if (state == GameState.IN_GAME) {
			gameTick();
		} 
		else if (state == GameState.END_SCREEN) {

		}
	}

	private void menuTick() {
		if(currentScreen.shouldSwitchScreen()){
			switchStates(GameState.IN_GAME);
		}
	}
	
	private void gameTick(){
		currentScreen.onTick();
	}

	public void drawScreen() {
		view.render(currentScreen);
	}
	
	public void switchStates(GameState newState){
		System.out.println("SWITCHING STATES");
		if(view.getMouseListeners().length > 0){
			view.removeMouseListener(currentScreen);
		}
		if(view.getMouseMotionListeners().length > 0){
			view.removeMouseMotionListener(currentScreen);
		}
		
		state = newState;
		
		if(newState == GameState.MENU){
			currentScreen = new MenuScreen(); // Sets default screen
		}
		else if (newState == GameState.IN_GAME) {
			currentScreen = new MainGameScreen();
		} 
		else if (newState == GameState.END_SCREEN) {
			currentScreen = new EndGameScreen();
		}
		
		view.addMouseListener(currentScreen);
		view.addMouseMotionListener(currentScreen);
	}

}
