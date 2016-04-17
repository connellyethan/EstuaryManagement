package model;

public enum ObsType {
	TRASH(0), INVASIVE_PLANT(1), NON_INVASIVE_PLANT(2), INVASIVE_ANIMAL(3),
	NON_INVASIVE_ANIMAL(4), POLLUTION(5);
private int value;
	private ObsType(int value){
		this.value = value;
	}
}