import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equalsIgnoreCase("q")) {
			List<Integer> value = ArrayList<Integer>();
			Integer value2 = 0;
			Integer sum = 0;
			System.out.println("choose (a) to add, choose (s) to subtract, choose (m) to multiply, choose (d) to divide or (q) to quit");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("a")) {
				input = scanner.nextLine();
				typeInValue(input);
			}

		}
	}
		
	private static Integer typeInValue(String input) {
		Integer value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println("You need to type in numbers!");
		}
	 return value;	
	}
	
}
