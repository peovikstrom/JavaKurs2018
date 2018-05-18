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
			Integer sum = 0;
			Integer diff = 0;
			
			float multipl1 = 0;
			float multipl2 = 0;
			float produkt = 0;
			
			float taljare = 0;
			float namnare = 0;
			float kvot = 0; 
			System.out.println("choose (a) to add, choose (s) to subtract, choose (m) to multiply, choose (d) to divide or (q) to quit");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("a")) {
				System.out.println("Skriv in två tal, eller flera, att Addera. Summera genom att skriva in '='");
				while (!input.equalsIgnoreCase("=")) {
					input = scanner.nextLine();
					if (!input.equals("=")) {
						value.add(typeInIntValue(input));
					}
				}
				for (int i = 0; i < value.size(); i++) {
					sum = sum + value.get(i);
				}
				System.out.println();
				System.out.println("Summan blev: " + sum);
			} else {
				if (input.equalsIgnoreCase("s")) {
					System.out.println("Skriv in två tal, eller flera, att Subtrahera. Subtrahera genom att skriva in '='");
					while (!input.equalsIgnoreCase("=")) {
						input = scanner.nextLine();
						if (!input.equals("=")) {
							value.add(typeInIntValue(input));
						} 
					}
					for (int i = 0; i < value.size(); i++) {
							if (i == 0) {
								diff = value.get(i);
							} else {
								diff = diff - value.get(i);
							}
					}
					System.out.println();
					System.out.println("Differensen blev: " + diff);
				} else {
					if (input.equalsIgnoreCase("m")) {
						System.out.println("Skriv in två tal, att multiplicera:");
						System.out.print("Tal1: "); input = scanner.nextLine();
						multipl1 = (typeInFloatValue(input));
						if (!(multipl1 == -1)) {
							System.out.print("Tal2: "); input = scanner.nextLine();
							multipl2 = (typeInFloatValue(input));
							if (!(multipl2 == -1)) {
									produkt = multipl1 * multipl2;
									System.out.println();
									System.out.println("Produkten blev: " + produkt);
									System.out.println();
							}
						}
					} else {
						if (input.equalsIgnoreCase("d")) {
								boolean check = false;
								System.out.println("Skriv in två tal, att dividera:");
								System.out.print("Täljare: "); input = scanner.nextLine();
								taljare = (typeInFloatValue(input));
								if (!(taljare == -1)) {
									System.out.print("Nämnare: "); input = scanner.nextLine();
									namnare = (typeInFloatValue(input));
									if (!(namnare == -1)) {
										if (namnare == 0) {
											check = true;
										}
											if (!check) {
												kvot = taljare / namnare;
												System.out.println();
												System.out.println("Kvoten blev: " + kvot);
												System.out.println();
											} else {
												System.out.println();
												System.out.println("Täljaren får inte vara noll!");
											}
										}
									}
								}
							}
						}
					}
				} scanner.close();
			}

	private static Integer typeInIntValue(String input) {
		Integer value = 0;
		try {
			value = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			System.out.println();
			System.out.println("You need to type in numbers! Please type in new number.");
		}
	 return value;	
	}
	
	private static float typeInFloatValue(String input) {
		float value = 0;
		try {
			value = Float.parseFloat(input);
		} catch (NumberFormatException e) {
			value = -1;
			System.out.println();
			System.out.println("You need to type in numbers! Please try again.");
		}
	 return value;	
	}
}
