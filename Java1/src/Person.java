import java.util.Random;

public class Person implements Runnable {

	@Override
	public void run() {
		
	}
	
	public int pressedButtonAt() {
		Random rnd = new Random();
		boolean rndbool = rnd.nextBoolean();
		int rndfloor = rnd.nextInt(5);
		if (rndbool) {
			return rndfloor;
		} else return -1;
	}
}
