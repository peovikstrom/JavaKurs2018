public class Main {

	public static void main(String[] args) {
		Elevator elevator = new Elevator();
		Person person1 = new Person(elevator);
		
		Thread personThread1 = new Thread(person1);
		personThread1.start();
		
		Thread personThread2 = new Thread(person1);
		personThread2.start();
		
	}
}
