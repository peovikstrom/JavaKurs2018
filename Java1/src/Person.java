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
		this.inElevator = inElevator;
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
			
				//System.out.println(this.elevator.listOnFloorButtonsPressed);
			}
				
			}	
				
	private synchronized void personStart() {
		System.out.println(this.name + " is at floor " + onFloorAt);
		System.out.println(this.name + " going to floor " + getOffFloor);
		
		elevator.pressElevatorGoToButton(onFloorAt,false);
		if (onFloorAt == elevator.elevatorAtFloor && elevator.doorsopened) {
			this.inElevator = true;
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
