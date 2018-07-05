import java.util.concurrent.ThreadLocalRandom;

public class Person extends Thread {

	private int onFloorAt = 0;
	private int getOffFloor = 0;
	//private boolean inElevator = false;
	private Elevator elevator;
	private String name;
	
	public Person(Elevator elevator, String name) {		//Konstruktor
		this.elevator = elevator;
		this.name = name;
		//this.inElevator = inElevator;
		resetStartAndDestination();
		this.elevator.listOnFloorButtonsPressed.add(onFloorAt);
		System.out.println(this.elevator.listOnFloorButtonsPressed);
		this.start();
	}
	
	@Override
	public void run() {
		personStart();
		while (true) {
			try        
			{
			    Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			/*if (!(elevator.checkFloorInList(elevator.elevatorAtFloor, true))) {
				if (!this.inElevator) {
					this.inElevator = true;
					this.elevator.listOffFloorButtonsPressed.add(this.getOffFloor);
					elevator.removeFloorInList(elevator.elevatorAtFloor, true);
					elevator.changeDoors();
				}
			} else { 
				this.elevator.listOnFloorButtonsPressed.add(this.onFloorAt);
			}*/
						
					/*if (elevator.checkFloorInList(elevator.elevatorAtFloor, true)) {
						this.inElevator = true;
						System.out.println(this.name + " enters elevator!");
						elevator.pressElevatorGoToButton(getOffFloor,true);
					}*/
				//} /*else { 
					
					//if (!elevator.doorsopened) elevator.pressElevatorGoToButton(getOffFloor,false);
					//}/* else {*/
						/*if (elevator.checkFloorInList(getOffFloor, false)) {
							System.out.println(this.name + " leaving elevator!");
							elevator.removeFloorInList(elevator.elevatorAtFloor, false);
						}*/
				//System.out.println(this.elevator.listOffFloorButtonsPressed);
				System.out.println(this.elevator.listOnFloorButtonsPressed);
			}
				/*} else {
					this.elevator.listOnFloorButtonsPressed.add(this.onFloorAt);
				}*/
					
					
			//} else { 
				//elevator.changeDoors();
			}	
		
			/*else {
				if (this.inElevator) {
					elevator.changeDoors();
					System.out.println(this.name + " leaves elevator!");
					this.inElevator = false;
					elevator.doorsopened = true;
					elevator.removePersonFromElevatorList();
				}*/
		
			
			
	
	//}
	
	private synchronized void personStart() {
		System.out.println(this.name + " is at floor " + onFloorAt);
		System.out.println(this.name + " going to floor " + getOffFloor);
		
		elevator.pressElevatorGoToButton(onFloorAt,false);
		
	}
	
	public int rndFloor() {
		return ThreadLocalRandom.current().nextInt(0, elevator.topFloor + 1); 
	}

	private void resetStartAndDestination() {
		onFloorAt = rndFloor();
		getOffFloor = rndFloor();
		while (onFloorAt == getOffFloor) {
			onFloorAt = rndFloor();
			getOffFloor = rndFloor();
		}
	}
	
}
