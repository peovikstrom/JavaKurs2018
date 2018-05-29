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
		
		pressedButton();
		
		//Vart vill jag?
		//Säg till hissen att komma till mig om den inte redan är hos mig och är öppen
		//När jag är i hissen, berätta för den vart jag vill åka
		//Är hissen framme där jag vill vara? I så fall hoppa ut om dörrarna är öppna... Vänta några sekunder och bestäm sen vart du vill här näst.
	}
	
	public void pressedButton(Elevator elevator2) {
		elevator2.pressButton(onFloorAt);
	}

	
}
