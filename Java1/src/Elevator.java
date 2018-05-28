import java.lang.reflect.Array;
import java.util.*;


public class Elevator implements Runnable {
	int floorat = 0;
	boolean doorsopened = false;
	boolean prbutton = false;
	int turns = 0;
	
	@Override
	public void run() {
		Random rndint = new Random();
		List<Person> personlist = new ArrayList<Person>();
		this.setFloorAt(0);
		this.doorsopened = true;
		while (turns < 3) {
			Person person = new Person();
			int rndfloorgetoff = rndint.nextInt(5);
			int rndfloorgeton = rndint.nextInt(5);
			while (rndfloorgetoff == rndfloorgeton) {
				rndfloorgetoff = rndint.nextInt(5);
				rndfloorgeton = rndint.nextInt(5);
			}
			person.setGetOffFloor(rndfloorgetoff);
			person.setGetOnFloor(rndfloorgeton);
			person.setOnFloorAt(rndfloorgeton);
			person.setDoorsOpened(false);
			personlist.add(person);
			System.out.println("Listan innehåller: " + personlist.size());
			System.out.println("Person at "  + person.getOnFloorAt());
			System.out.println("Elevator at floor: " + this.floorat);
			System.out.println("Person wants to go to "  + person.getGetOffFloor());
			if (!this.doorsopened && person.getDoorsOpened()) {
				prbutton = true;
				changeDoors();
				person.setDoorsOpened(this.doorsopened);
			} else changeDoors();
			while (this.floorat != person.getGetOnFloor() || prbutton) {
				if (this.floorat < person.getGetOnFloor()) {  
					movingElevator(true);
					//person.setOnFloorAt(this.floorat);
				} else {
					movingElevator(false);
					//person.setOnFloorAt(this.floorat);
				} 
			}
			prbutton = false;
			
			if (!doorsopened) {
				changeDoors();
				System.out.println("Person steps in elevator at "  + this.floorat);
				prbutton = true;
				changeDoors();
			} 
			if (!doorsopened) {
				while (this.floorat != person.getGetOffFloor() && prbutton) {
					if (this.floorat < person.getGetOffFloor()) {  
						movingElevator(true);
						person.setOnFloorAt(this.floorat);
					} else {
						movingElevator(false);
						person.setOnFloorAt(this.floorat);
					}
				}
			}	
			prbutton = false;
			
			if (!doorsopened) {
				changeDoors();
			}
			System.out.println("Person leaves elevator at "  + this.floorat);
			personlist.remove(person);
			System.out.println("Listan innehåller: " + personlist.size());
			System.out.println();
			turns++;
		}	
	}
	
	private void changeDoors() {
		if (doorsopened) {
				doorsopened = false;
			} else {
				doorsopened = true;
			}
		if (doorsopened) {
			System.out.println("Doors opened!");
		} else System.out.println("Doors closed!");
	}
	
	private void setFloorAt(int floorat) {
		this.floorat = floorat;
	}
	
	public int getFloorAt() {
		return this.floorat;
	}
	
	private boolean moveUp() {
		if (checkMax()) { 
			this.floorat = this.floorat + 1;
		} else
			System.out.println("Elevator at topfloor!");
			return checkMax();
	}
	
	private boolean moveDown() {
		if (checkMin()) { 
			this.floorat = this.floorat - 1;
		} else
			System.out.println("Elevator at bottomfloor!");
			return checkMin();
	}
	
	private boolean checkMin() {
		boolean check = false;
		if (this.floorat > 0) {
			check = true;
		}
		return check;
	}
	
	private boolean checkMax() {
		boolean check = false;
		if (this.floorat < 5) {
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
				System.out.println("Elevator at: " + this.floorat);
			} 
		} else { 
			check = moveDown();
			if (check) {
				System.out.println("Moving down!");
				System.out.println("Elevator at: " + this.floorat);
			}
		}
	}
	
	private boolean personPressedButton(Person person, Boolean buttonPressed) {
		return buttonPressed;
	}
}
