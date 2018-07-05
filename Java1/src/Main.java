public class Main {

	public static void main(String[] args) {
		Elevator elevator = new Elevator(0, 5, true);
		Person person1 = new Person(elevator, "Kalle");
		Person person2 = new Person(elevator, "Ulla");
		
	}
}
