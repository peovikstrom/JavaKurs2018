import java.util.Random;


public class Elevator implements Runnable {
	int floorAt = 0;
	boolean doorsOpened = false;
	boolean doorsClosed = false;
	
	@Override
	public void run() {
		//Random rnd = new Random();
		Person person = new Person();
		setFloorAt(0);
		System.out.println("Elevator at floor: " + getFloorAt());
		boolean doorsopen = openDoors();
		if (doorsopen) {
			System.out.println("Doors are open!");
		}
		int  rndInt = person.pressedButtonAt();
		
		if (rndInt != -1) {
			if (rndInt != getFloorAt()) {
				System.out.println("Someone pressed button on floor: " + rndInt);
			}
		}
		
		for (int i = 0; getFloorAt() < 5; i++) {
			movingElevator(true);
		}
	}
	
	private boolean openDoors() {
		doorsOpened = true;
		return doorsOpened;
	}
	
	private boolean closeDoors() {
		doorsOpened = true;
		return doorsOpened;
	}
	
	private void setFloorAt(int floorat) {
		this.floorAt = floorat;
	}
	
	public int getFloorAt() {
		return floorAt;
	}
	
	private boolean moveUp() {
		if (checkMax()) { 
			floorAt = floorAt + 1;
		} else
			System.out.println("Elevator at topfloor!");
			return checkMax();
	}
	
	private boolean moveDown() {
		if (checkMin()) { 
			floorAt = floorAt - 1;
		} else
			System.out.println("Elevator at bottomfloor!");
			return checkMin();
	}
	
	private boolean checkMin() {
		boolean check = false;
		if (floorAt > 0) {
			check = true;
		}
		return check;
	}
	
	private boolean checkMax() {
		boolean check = false;
		if (floorAt < 5) {
			check = true;
		}
		return check;
	}
	
	private void movingElevator(boolean direction) {
		boolean check = true;
		if (direction) {
			check = moveUp();
			if (check) {
				System.out.println("Elevator at floor: " + getFloorAt());
			} 
		} else { 
			check = moveDown();
			if (check) {
				System.out.println("Elevator at floor: " + getFloorAt());
			}
		}
	}
	
	private void checkDoors(boolean rndBool) {
		if (rndBool) {
			if (openDoors()) {
				System.out.println("Doors opened!");
			}
			if (closeDoors()) {
				System.out.println("Doors closed!");
			}
		}
	}
}
