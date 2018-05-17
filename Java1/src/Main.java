import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		String input = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equalsIgnoreCase("q")) {
			List<Integer> value = new ArrayList<>();
			float valuediv1 = 0;
			float valuediv2 = 0;
			Integer value1 = 0;
			Integer value2 = 0;
			Integer sum = 0;
			float sumdiv = 0; 
			System.out.println("choose (a) to add, choose (s) to subtract, choose (m) to multiply, choose (d) to divide or (q) to quit");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("a")) {
				System.out.println("Skriv in två tal, eller flera, att addera, summera genom att skriva in '='");
				while (!input.equalsIgnoreCase("=")) {
					input = scanner.nextLine();
					if (!input.equals("=")) {
						value.add(typeInValue(input));
					}
				}
				for (int i = 0; i < value.size(); i++) {
					sum = sum + value.get(i);
				}
				System.out.println();
				System.out.println("Summan är: " + sum);
			} else {
				if (input.equalsIgnoreCase("s")) {
					System.out.println("Skriv in två tal, eller flera, att Subtrahera, subtrahera genom att skriva in '='");
					while (!input.equalsIgnoreCase("=")) {
						input = scanner.nextLine();
						if (!input.equals("=")) {
							value.add(typeInValue(input));
						} 
					}
					value.sort(Comparator.reverseOrder());
					//Collections.reverse(value);
					System.out.println(value);
					for (int i = 0; i < value.size(); i++) {
							sum = value.get(i) - sum;
							System.out.println(sum + " " + value.get(i));
					}
					System.out.println();
					System.out.println("Summan är: " + sum);
				} else {
					if (input.equalsIgnoreCase("m")) {
						System.out.println("Skriv in två tal, att multiplicera:");
						System.out.print("Tal1: "); input = scanner.nextLine();
						value1 = (typeInValue(input));
						System.out.print("Tal2: "); input = scanner.nextLine();
						value2 = (typeInValue(input));
						sum = value1 * value2;
						System.out.println();
						System.out.println(value1 + " * " + value2 + " = " + sum);
						System.out.println();
					} else {
						if (input.equalsIgnoreCase("d")) {
								boolean check = false;
								System.out.println("Skriv in två tal, att diviera:");
								System.out.print("Tal1: "); input = scanner.nextLine();
								valuediv1 = (typeInValue(input));
										System.out.print("Tal2: "); input = scanner.nextLine();
										valuediv2 = (typeInValue(input));
										if (valuediv2 == 0) {
											check = true;
										}
								if (!check) {
										sumdiv = valuediv1 / valuediv2;
										System.out.println();
										System.out.println(valuediv1 + " / " + valuediv2 + " = " + sumdiv);
										System.out.println();
									} else {
										System.out.println();
										System.out.println("Talet man delar med får inte vara noll!");
									}
								}
							}
						}
					}
				} scanner.close();
			}

	private static Integer typeInValue(String input) {
		Integer value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("You need to type in numbers!");
		}
	 return value;	
	}
	
}
