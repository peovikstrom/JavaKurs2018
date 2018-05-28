public class Main {

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		
		Thread elevatorThread = new Thread(elevator);
		elevatorThread.start();
	}
}
