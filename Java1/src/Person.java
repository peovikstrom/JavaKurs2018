import java.util.Random;

public class Person implements Runnable {

	private int onFloorAt = 0;
	private boolean inElevator = false;
	private int getOffFloor = 0;
	private Random rndint = new Random();
	private Elevator elevator;
	
	public Person(Elevator elevator) {		//Konstruktor
		
	}
	
	@Override
	public void run() {
		Elevator elevator = new Elevator();
		int maxFloors = elevator.numOfFloors;
		onFloorAt = rndFloor(maxFloors);
		System.out.println("Person is at floor " + onFloorAt);
		getOffFloor = rndFloor(maxFloors);
		System.out.println("Person going to floor " + getOffFloor);
		if (onFloorAt != elevator.floorat) {
			System.out.println("Pressing button!");
			elevator.pressElevatorGetHereButton(onFloorAt);
		} if (elevator.doorsopened) {
			System.out.println("Enter elevator!");
			inElevator = true;
			System.out.println("In elevator!");
			System.out.println("Pressing button to floor to go to!");
			elevator.pressElevatorGetHereButton(getOffFloor);
		}
				
		elevator.whatButtonsPressed();
		
		
		//Vart vill jag?
		//Säg till hissen att komma till mig om den inte redan är hos mig och är öppen
		//När jag är i hissen, berätta för den vart jag vill åka
		//Är hissen framme där jag vill vara? I så fall hoppa ut om dörrarna är öppna... Vänta några sekunder och bestäm sen vart du vill här näst.
	}
	
	public int rndFloor(int maxNumOfFloors) {
		return rndint.nextInt(maxNumOfFloors); 
	}
	
}
