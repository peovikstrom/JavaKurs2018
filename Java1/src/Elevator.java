import java.util.*;
import java.util.Iterator;

public class Elevator extends Thread {
	public int elevatorAtFloor;
	int bottomFloor;
	int topFloor;
	boolean doorsopened;
	boolean direction;
	
	public List<Integer> listOffFloorButtonsPressed = new ArrayList<Integer>();
	public List<Integer> listOnFloorButtonsPressed = new ArrayList<Integer>();

	public Elevator(int floorAt, int numOfFloors, boolean doorsOpened) {
		this.elevatorAtFloor = floorAt;
		this.topFloor = numOfFloors;
		this.bottomFloor = 0;
		this.doorsopened = doorsOpened;
		this.direction = true;
		this.start();
	}
	
	@Override
	public void run() {
		while (true) {
			try        
			{
			    Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			if (!(listOnFloorButtonsPressed.isEmpty())) {
						if (checkFloorInList(elevatorAtFloor, true)) {
							if (listOnFloorButtonsPressed.contains(elevatorAtFloor)) {
								changeDoors();
							} else {
								moveElevator();
							}
						 } else {
							 if (doorsopened) {
								 changeDoors();
							 }
							 moveElevator();
						 }
				} else {
						moveElevator();
					}
				}
	}		

	public synchronized void pressElevatorGoToButton(int buttonOfFloor, boolean listToCheck) {
		if (listToCheck) {
			listOnFloorButtonsPressed.add(buttonOfFloor);
		} else {
			listOffFloorButtonsPressed.add(buttonOfFloor);
		}
	}
	
	public synchronized boolean checkFloorInList(int elevatorAtFloor, boolean listToCheck) {
		if (listToCheck) {
			Iterator<Integer> iterator = listOnFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement == elevatorAtFloor) {
		        	this.removeFloorInList(this.elevatorAtFloor, true);
		        	System.out.println(this.listOnFloorButtonsPressed);
		            return true;
		        }
		        System.out.println(setElement);
		        return false;
		    }
		} else {
			Iterator<Integer> iterator = listOffFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement==elevatorAtFloor) {
		            return true;
		        }
		        return false;
		    }
		}
		return listToCheck;
	}
	
	public synchronized void removeFloorInList(int elevatorAtFloor, boolean listToCheck) {
		if (listToCheck) {
							listOnFloorButtonsPressed.remove(0);
		    } System.out.println(listOnFloorButtonsPressed);
		} /*else {
			Iterator<Integer> iterator = listOffFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement==elevatorAtFloor) {
		            iterator.remove();
		        }
		    }
		}
	}*/
	
	public void moveElevator() {
		if (this.direction) {
			this.moveUp();
			System.out.println("Moving Up!");
			} else {
				this.moveDown();
				System.out.println("Moving Down!");
			}
		System.out.println("Elevator at " + elevatorAtFloor);
		}
	
	private boolean moveUp() {
		if (this.elevatorAtFloor != this.topFloor) { 
			this.elevatorAtFloor++;
		} else {
			direction = false;
		}
		return direction;
	}
	
	private boolean moveDown() {
		if (this.elevatorAtFloor != this.bottomFloor) {
			this.elevatorAtFloor--;
		} else {
				direction = true;
		} return direction;
	}
	
	public void changeDoors() {
		if (doorsopened) {
			doorsopened = false;
		} else {
			doorsopened = true;
		}
		if (doorsopened) {
			System.out.println("Doors opened!");
		} else System.out.println("Doors closed!");
	}
}	

