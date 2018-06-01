import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Elevator extends Thread {
	public int elevatorAtFloor;
	int bottomFloor;
	int topFloor;
	boolean doorsopened;
	boolean direction;
	
	public Set<Integer> SetOffFloorButtonsPressed = new HashSet<Integer>();
	public Set<Integer> SetOnFloorButtonsPressed = new HashSet<Integer>();

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
			if (SetOffFloorButtonsPressed.isEmpty())
			 if  (SetOnFloorButtonsPressed.isEmpty()) {
			 } else moveElevator();
		}
	}

	public synchronized void pressElevatorGoToButton(int buttonOfFloor, boolean listToCheck) {
		if (listToCheck) {
			SetOffFloorButtonsPressed.add(buttonOfFloor);
			System.out.println(SetOffFloorButtonsPressed);
		} else {
			SetOnFloorButtonsPressed.add(buttonOfFloor);
			System.out.println(SetOnFloorButtonsPressed);
		}
	}
	
	public boolean checkFloorInList(int elevatorAtFloor, boolean listToCheck) {
		if (listToCheck) {
			Iterator<Integer> iterator = SetOnFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement==elevatorAtFloor) {
		            return true;
		        }
		        return false;
		    }
		} else {
			Iterator<Integer> iterator = SetOffFloorButtonsPressed.iterator();
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
	
	public void removeFloorInList(int elevatorAtFloor, boolean listToCheck) {
		if (listToCheck) {
			Iterator<Integer> iterator = SetOnFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement==elevatorAtFloor) {
		            iterator.remove();
		        }
		    }
		} else {
			Iterator<Integer> iterator = SetOffFloorButtonsPressed.iterator();
		    while(iterator.hasNext()) {
		        Integer setElement = iterator.next();
		        if(setElement==elevatorAtFloor) {
		            iterator.remove();
		        }
		    }
		}
	}
	
	public void whatButtonsPressed() {
		System.out.println(SetOffFloorButtonsPressed);
	}

	public void removePersonFromElevatorList() {
		Iterator<Integer> iterator = SetOffFloorButtonsPressed.iterator();
	    while(iterator.hasNext()) {
	        Integer setElement = iterator.next();
	        if(setElement==elevatorAtFloor) {
	            iterator.remove();
	        }
	    }
	    System.out.println(SetOffFloorButtonsPressed);
	}
	
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
	
	/*public void setDoorsOpened(Boolean doorsOpened) {
		doorsopened = doorsOpened;
	}
	
	public boolean getDoorsOpened() {
		return doorsopened;*/

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
	
}		/*Random rndint = new Random();
		
		List<Person> personlist = new ArrayList<Person>();
				
		this.setFloorAt(0);
		this.doorsopened = true;
		//while (turns < 5) {
			Person person = new Person();
			
			//Thread personThread = new Thread(person);
			//personThread.start();
			ExecutorService executor = Executors.newFixedThreadPool(2);
			executor.submit(person);
			executor.submit(person);
			
			
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
	
	public void setFloorAt(int floorat) {
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
	
	public void movingElevator(boolean direction) {
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
		}*/
	

