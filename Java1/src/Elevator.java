import java.lang.reflect.Array;
import java.util.*;


public class Elevator implements Runnable {
	int floorat = 0;
	boolean doorsOpened = false;
	boolean doorsClosed = false;
	
	@Override
	public void run() {
		Random rndint = new Random();
		Random rndbool = new Random();
		List<Person> personlist = new ArrayList<Person>();
		//if (rndbool.nextBoolean()) {
			Elevator elevator = new Elevator();
			setFloorAt(0);
			doorsOpened = true;
			Person person = new Person();
			person.setOnFloorAt(4);
			person.setGetOffFloor(0);
			person.setGetOnFloor(4);
			personlist.add(person);
			
		//}	
		System.out.println("Person at "  + person.getOnFloorAt());
		System.out.println("Going to " + person.getGetOffFloor());
		System.out.println("Elevator at floor: " + floorat);
		checkDoors();
		changeDoors();
		checkDoors();
		while (floorat != person.getGetOnFloor()) {
			if (floorat < person.getGetOnFloor()) {  
				movingElevator(true);
				//person.setOnFloorAt(floorat);
			} else {
				movingElevator(false);
				//person.setOnFloorAt(floorat);
			}
				 
		}
		System.out.println("Elevator at "  + floorat);
		System.out.println("Person at "  + person.getOnFloorAt());	
		checkDoors();
		changeDoors();
		checkDoors();
		while (floorat != person.getGetOffFloor()) {
			if (floorat < person.getGetOffFloor()) {  
				movingElevator(true);
				person.setOnFloorAt(floorat);
			} else {
				movingElevator(false);
				person.setOnFloorAt(floorat);
			}
		}	
		System.out.println("Elevator at "  + floorat);
		System.out.println("Person at "  + person.getOnFloorAt());	
		checkDoors();
		changeDoors();
		checkDoors();
	}
	
	private void changeDoors() {
		if (doorsOpened) {
				doorsOpened = false;
				doorsClosed = true; 
			} else {
				doorsOpened = true;
				doorsClosed = false;
			}
	}
	
	private void setFloorAt(int floorat) {
		this.floorat = floorat;
	}
	
	public int getFloorAt() {
		return floorat;
	}
	
	private boolean moveUp() {
		if (checkMax()) { 
			floorat = floorat + 1;
		} else
			System.out.println("Elevator at topfloor!");
			return checkMax();
	}
	
	private boolean moveDown() {
		if (checkMin()) { 
			floorat = floorat - 1;
		} else
			System.out.println("Elevator at bottomfloor!");
			return checkMin();
	}
	
	private boolean checkMin() {
		boolean check = false;
		if (floorat > 0) {
			check = true;
		}
		return check;
	}
	
	private boolean checkMax() {
		boolean check = false;
		if (floorat < 5) {
			check = true;
		}
		return check;
	}
	
	private void movingElevator(boolean direction) {
		boolean check = true;
		if (direction) {
			check = moveUp();
			if (check) {
				System.out.println("Moving up!");
			} 
		} else { 
			check = moveDown();
			if (check) {
				System.out.println("Moving down!");
			}
		}
	}
	
	private void checkDoors() {
		if (doorsOpened) {
				System.out.println("Doors opened!");
			} else System.out.println("Doors closed!");
		}
}
