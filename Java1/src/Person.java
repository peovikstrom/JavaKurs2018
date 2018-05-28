import java.util.List;
import java.util.Random;

public class Person implements Runnable {

	private int onFloorAt = 0;
	private int getOnFloor = 0;
	private int getOffFloor = 0;
	private boolean doorsOpened;
	
	@Override
	public void run() {
		
	}
	
	public void setDoorsOpened(Boolean doorsOpened) {
		this.doorsOpened = doorsOpened;
	}
	
	public boolean getDoorsOpened() {
		return doorsOpened;
	}
	
	public int getOnFloorAt() {
		return onFloorAt;
	}
	
	public void setOnFloorAt(int onFloorAt) {
		this.onFloorAt = onFloorAt;
	}
	
	public int getGetOnFloor() {
		return getOnFloor;
	}
	
	public void setGetOnFloor(int onFloorAt) {
		this.getOnFloor = onFloorAt;
	}

	public int getGetOffFloor() {
		return getOffFloor;
	}

	public void setGetOffFloor(int getOffFloor) {
		this.getOffFloor = getOffFloor;
	}

	public boolean checkIfFirstOrSub(List<Person> person) {
		if (person.size() <= 0) {
			return true;
		}
		return false;
	}
	
	public boolean checkUpDown() {
		if (onFloorAt < getOffFloor) {
			return true;
		} else return false;
		
	}
}
