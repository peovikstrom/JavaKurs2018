import java.util.Random;
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
		resetStartAndDestination();
		this.start();
	}
	
	@Override
	public void run() {
		System.out.println(this.name + " is at floor " + onFloorAt);
		System.out.println(this.name + " going to floor " + getOffFloor);
		while (true) {
			try        
			{
			    Thread.sleep(1000);
			} 
			catch(InterruptedException ex) 
			{
			    Thread.currentThread().interrupt();
			}
			if (onFloorAt == elevator.elevatorAtFloor) {
				if (elevator.doorsopened) {
					System.out.println(this.name + " enters elevator!");
					this.inElevator = true;
					elevator.doorsopened = false;
					if (this.inElevator) {
						System.out.println(this.name + " is in elevator!");
					
						System.out.println(this.name + " pressing button to floor to go to!");
						elevator.pressElevatorGoToButton(getOffFloor);
					}
				}
				
			} else { 
				elevator.pressElevatorGoToButton(onFloorAt);
			}
		} 
	}		
	
	public int rndFloor() {
		return ThreadLocalRandom.current().nextInt(0, elevator.topFloor + 1); 
	}

	private void resetStartAndDestination() {
		onFloorAt = rndFloor();
		getOffFloor = rndFloor();
	}
	
}
