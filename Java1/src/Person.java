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
		System.out.println(this.name + " is at floor " + onFloorAt);
		System.out.println("Hissen är på: " + elevator.elevatorAtFloor);
		elevator.pressElevatorGoToButton(onFloorAt,false);
		while (true) {
			try        
			{
			    Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			if (!elevator.doorsopened) {
				System.out.println(elevator.elevatorAtFloor);
				if (elevator.checkFloorInList(elevator.elevatorAtFloor, true)) {
					this.inElevator = true;
					elevator.removeFloorInList(elevator.elevatorAtFloor, true);
					System.out.println(elevator.SetOnFloorButtonsPressed);
					/*if (!this.inElevator) {
					if (onFloorAt == elevator.elevatorAtFloor) {
						
							System.out.println(this.name + " enters elevator!");
							this.inElevator = true;
							System.out.println(this.name + " pressing button to floor to go to!");
							elevator.pressElevatorGoToButton(getOffFloor,true);
							System.out.println(this.name + " going to floor " + getOffFloor);
						} 
					} else {
						//elevator.changeDoors();
						//this.inElevator = false;
					}*/
					//elevator.changeDoors();
					//elevator.doorsopened = false;
				} 
			} else elevator.changeDoors();
			
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
