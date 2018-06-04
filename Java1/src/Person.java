import java.util.concurrent.ThreadLocalRandom;

public class Person extends Thread {

	private int onFloorAt = 0;
	private int getOffFloor = 0;
	private boolean inElevator = false;
	private Elevator elevator;
	private String name;
	
	public Person(Elevator elevator, String name) {		//Konstruktor
		this.elevator = elevator;
		this.name = name;
		//this.inElevator = inElevator;
		resetStartAndDestination();
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
			if (elevator.doorsopened) {
				if (!this.inElevator) {
					if (elevator.checkFloorInList(elevator.elevatorAtFloor, true)) {
						this.inElevator = true;
						System.out.println(this.name + " enters elevator!");
						elevator.pressElevatorGoToButton(getOffFloor,true);
					}
				} else {
					/*if (!elevator.doorsopened) {
						//elevator.pressElevatorGoToButton(getOffFloor,false);
					} else {*/
						if (elevator.checkFloorInList(getOffFloor, false)) {
							System.out.println(this.name + " leaving elevator!");
							elevator.removeFloorInList(elevator.elevatorAtFloor, false);
						}
					}
				}
			//} else { 
				//elevator.changeDoors();
			//}	
			
			/*else {
				if (this.inElevator) {
					elevator.changeDoors();
					System.out.println(this.name + " leaves elevator!");
					this.inElevator = false;
					elevator.doorsopened = true;
					elevator.removePersonFromElevatorList();
				}
			}*/
			
			
		} 
	}		
	
	private synchronized void personStart() {
		System.out.println(this.name + " is at floor " + onFloorAt);
		System.out.println("Elevator is at floor : " + elevator.elevatorAtFloor);
		System.out.println(this.name + " going to floor " + getOffFloor);
		System.out.println(this.name + " pressing button outside elevator at " + onFloorAt);
		elevator.pressElevatorGoToButton(onFloorAt,false);
		System.out.println("Elevator going to floor " + onFloorAt);
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
