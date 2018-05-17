import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equalsIgnoreCase("q")) {
			List<Integer> value = new ArrayList<>();
			Integer sum = 0;
			System.out.println("choose (a) to add, choose (s) to subtract, choose (m) to multiply, choose (d) to divide or (q) to quit");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("a")) {
				input = scanner.nextLine();
				value.add(typeInValue(input));
				for (int i = 0; i < value.size(); i++) {
					sum = sum + value.get(i);
				}
			} 
			System.out.println(sum);
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
