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
		//S�g till hissen att komma till mig om den inte redan �r hos mig och �r �ppen
		//N�r jag �r i hissen, ber�tta f�r den vart jag vill �ka
		//�r hissen framme d�r jag vill vara? I s� fall hoppa ut om d�rrarna �r �ppna... V�nta n�gra sekunder och best�m sen vart du vill h�r n�st.
	}
	
	public void pressedButton(Elevator elevator2) {
		elevator2.pressButton(onFloorAt);
	}

	
}
