import java.util.*;

public class Uppgift3 {

	public static void main(String[] args) {

		String input = "";

		Scanner scanner = new Scanner(System.in);

		while (!input.equalsIgnoreCase("q")) {
			System.out.println();
			System.out.println(
					"Choose (d) for Duplicates in Array, (s) for Duplicates in Set, (l) to put a value to the end of List");
			System.out.println(
					"(r) to remove first given value and shrink Array, (m) to create a Map with integer for keys and string for Value"); 
			System.out.println(" or quiting(q)");

			input = scanner.nextLine();

			if (input.equalsIgnoreCase("d")) {
				int[] arrayOfInt = {1,2,3,4,5,6,6,5,4,3,2,1};
				pickDuplicatesFromArray(arrayOfInt);
				
			} else if (input.equalsIgnoreCase("s")) {
				int setOfInt[] = { 1, 2, 3, 4, 5, 6, 6, 5, 4, 3, 2, 1 };
				pickDuplicatesFromSet(setOfInt);
				
			} else if (input.equalsIgnoreCase("l")) {
				List<Integer> listaOfInt = new ArrayList<Integer>();
				
				for (int i=0;i<10;i++) {
						listaOfInt.add((int) (Math.random() * 100));
		        }

				int putValue = 80;
				
				putValueAtEndOfList(listaOfInt, putValue);
				
			} else if (input.equalsIgnoreCase("r")) {
				int[] arrOfInt = new int[] { 10, 20, 30, 40, 50, 50, 40, 30, 20, 10 };
				int givenValue = 50;
				removeFirstGivenValueFromArray(arrOfInt,givenValue);
				
			} else if (input.equalsIgnoreCase("m")) {
				int[] intMapKey = { 8, 31, 12 };
				String[] strMapValue = { "Kalle", "Agnes", "Hugo" };
				createMapOfIntKeysAndStringValues(intMapKey, strMapValue);
				
			}
		}
		scanner.close();
	}

	private static Object resizeArray(Object oldArray, int newSize) { // Plockad kod från nätet, förstår principen bakom
																		// denna.
		int oldSize = java.lang.reflect.Array.getLength(oldArray); // Den kopierar den array man skickar in till den nya
																	// arrayen
		Class elementType = oldArray.getClass().getComponentType(); // och använder den storleken man skickar in på den
																	// nya arrayen.
		Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize); // Som sen returneras.
		int preserveLength = Math.min(oldSize, newSize);
		if (preserveLength > 0)
			System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
		return newArray;
	}

	public static void pickDuplicatesFromArray(int[] arrayOfInt) {
		// Plocka ur samtliga dubletter ur en Array av integers.
		System.out.print("All Elements in Int Array is : [");
		for (int i = 0; i < arrayOfInt.length; i++) {
			if (i < arrayOfInt.length - 1) {
				System.out.print(arrayOfInt[i] + ", ");
			} else {
				System.out.print(arrayOfInt[i]);
			}
		}
		System.out.print("]");
		System.out.println();
		for (int i = 0; i < arrayOfInt.length - 1; i++) {
			for (int j = i + 1; j < arrayOfInt.length; j++) {
				if ((arrayOfInt[i] == (arrayOfInt[j])) && (i != j)) {
					System.out.println("Duplicate Element is : " + arrayOfInt[j]);
				}
			}
		}
	}
	
	public static void pickDuplicatesFromSet(int setOfInt[]) {
		// Plocka ut samtliga dubletter ur ett Set av integers.
		Set<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < setOfInt.length; i++) {
			set.add(setOfInt[i]);
		}
		System.out.print("All Elements in Int Array is : [");
		for (int i = 0; i < setOfInt.length; i++) {
			if (i < setOfInt.length - 1) {
				System.out.print(setOfInt[i] + ", ");
			} else {
				System.out.print(setOfInt[i]);
			}
		}
		System.out.println("]");
		System.out.println();
		System.out.println("Duplicate Elements Removed!");
		System.out.println();
		System.out.println("Elements in Set is: " + set);
	}
	public static void removeFirstGivenValueFromArray(int[] arrOfInt,int givenValue) {
		// Plocka bort första givna värdet ur en Array av integers.
		System.out.print("All Elements in Int Array is : [");
		for (int i = 0; i < arrOfInt.length; i++) {
			if (i < (arrOfInt.length - 1)) {
				System.out.print(arrOfInt[i] + ", ");
			} else {
				System.out.print(arrOfInt[i]);
			}
		}
		System.out.print("] ");
		System.out.println();

		boolean checkRemoved = false;
		int[] interimArrOfInt = new int[arrOfInt.length];
		int j = 0;
		for (int i = 0; i < arrOfInt.length; i++) {
			if (arrOfInt[i] != givenValue) {
				interimArrOfInt[i + j] = arrOfInt[i];
			} else {
				if (!checkRemoved) {
					System.out.println("Removed first given element : " + givenValue);
					System.out.println();
					givenValue = 0;
					j = j - 1;
					checkRemoved = true;
				}
			}
		}
		if (checkRemoved) {
			for (int i = 0; i < arrOfInt.length; i++)
				arrOfInt[i] = interimArrOfInt[i];
			arrOfInt = (int[]) resizeArray(arrOfInt, arrOfInt.length - 1);
		}

		System.out.print("All Elements in Int Array is : [");
		for (int i = 0; i < arrOfInt.length; i++) {
			if (i < arrOfInt.length - 1) {
				System.out.print(arrOfInt[i] + ", ");
			} else {
				System.out.print(arrOfInt[i]);
			}
		}
		System.out.print("] ");
	}
	
	public static void createMapOfIntKeysAndStringValues(int[] intMapKey, String[] strMapValue) {
		// Skriv ut en map med key som integer och string som värde.
		System.out.print("Map Keys are : [");
		for (int i = 0; i < intMapKey.length; i++) {
			if (i < (intMapKey.length - 1)) {
				System.out.print(intMapKey[i] + ", ");
			} else {
				System.out.print(intMapKey[i]);
			}
		}
		System.out.print("]");
		System.out.println();

		System.out.print("Map Values is : [");
		for (int i = 0; i < strMapValue.length; i++) {
			if (i < (strMapValue.length - 1)) {
				System.out.print(strMapValue[i] + ", ");
			} else {
				System.out.print(strMapValue[i]);
			}
		}
		System.out.print("]");
		System.out.println();
		
		Map m1 = new HashMap();
		
		for (int k = 0; k < intMapKey.length; k++) {
			m1.put(intMapKey[k], strMapValue[k]);
		}
		System.out.println();
		System.out.println("Map Elements " + m1);
	}
	
	public static void putValueAtEndOfList(List<Integer> listaOfInt, int putValue) {
		// List, lägg till ett värde i slutet.
		System.out.println("Elements in List is: " + listaOfInt);
		listaOfInt.add(putValue);
		System.out.println();
		System.out.println("Element added at the end of List!");
		System.out.println();
		System.out.println("Elements in List is : " + listaOfInt);
	}
}
