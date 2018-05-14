package gammalt;
import java.time.LocalDateTime;
import java.util.*;
public class Uppgift3 {

	public static void main(String[] args) {
		
		String input = "";
		
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equalsIgnoreCase("q")) {											
			
			System.out.println("Choose (d) for Duplicates in Array, (s) for Duplicates in Set, (l) to put a value to the end of List");
			System.out.println("(r) to remove first given value and shrink Array, (m) to create a Map with integer for keys and string for Value");	//Skriv ut vilka val du kan göra
			System.out.println(" or quit(q)");
			
			input = scanner.nextLine();															
			
			if (input.equalsIgnoreCase("d")) {
				//Plocka ur samtliga dubletter ur en Array av integers.
				int[] arrayOfInt = new int[] {10,20,30,40,50,50,40,30,20,10};
				
				System.out.print("All Elements in Int Array is : [");
		        for(int i = 0; i < arrayOfInt.length; i++) {
		        	if (i < 9) {
		        	 System.out.print(arrayOfInt[i] + ", ");
		        	} else {
		        		System.out.print(arrayOfInt[i]);
		        		}
		        	}
		        System.out.print("]");
		        System.out.println();
				for (int i = 0; i < arrayOfInt.length-1; i++)
		        {
		            for (int j = i+1; j < arrayOfInt.length; j++)
		            {
		                if( (arrayOfInt[i] == (arrayOfInt[j])) && (i != j) )
		                {
		                    System.out.println("Duplicate Element is : "+arrayOfInt[j]);
		                }
		            }
		        }
			} else 
				if (input.equalsIgnoreCase("s")) {
					//Plocka ut samtliga dubletter ur ett Set av integers.
					int setOfInt[] = {1,2,3,4,5,5,4,3,2,1};
				    
					Set<Integer> set = new HashSet<Integer>();
			        for(int i = 0; i < setOfInt.length; i++) {
			            set.add(setOfInt[i]);
				    }
			        System.out.print("All Elements in Int Array is : [");
			        for(int i = 0; i < setOfInt.length; i++) {
			        	if (i < 9) {
			        	 System.out.print(setOfInt[i] + ", ");
			        	} else {
			        		System.out.print(setOfInt[i]);
			        		}
			        	}
			        System.out.println("]");
			        System.out.println();
			        System.out.println("Elements in Set is : " + set);
				
			} else 
				if (input.equalsIgnoreCase("l")) {
			        //List, lägg till ett värde i slutet.
			        List<Integer> listaOfInt = new ArrayList<Integer>();
			        listaOfInt.add(10);
			        listaOfInt.add(20);
			        listaOfInt.add(30);
			        listaOfInt.add(40);
			        listaOfInt.add(50);
			                
					System.out.println("Elements in List is : " + listaOfInt);
					listaOfInt.add(80);
					System.out.println("Element added at the end of List!");
					System.out.println("Elements in List is : " + listaOfInt);
			} else 
					if (input.equalsIgnoreCase("r")) {
						//Plocka bort första givna värdet ur en Array av integers.
						int[] arrOfInt = new int[] {10,20,30,40,50,50,40,30,20,10};
						int givenValue = 50;
				
						System.out.print("All Elements in Int Array is : [");
				        for(int i = 0; i < arrOfInt.length; i++) {
				        	if (i < (arrOfInt.length - 1)) {
				        	 System.out.print(arrOfInt[i] + ", ");
				        	} else {
				        		System.out.print(arrOfInt[i]);
				        	}
				        }
				        System.out.print("] ");
				        System.out.println();
				        
				        boolean checkRemoved = false;
						int[] interimArrOfInt = new int[10];
						int j = 0;
				        for (int i = 0; i < arrOfInt.length; i++)
				        {
					        	if (arrOfInt[i] != givenValue) {
					        		   interimArrOfInt[i+j] = arrOfInt[i];
					        	} else {
					        		if (!checkRemoved) {
					        			System.out.println("Removed first given element : " + givenValue);
					        			givenValue = 0; j=j-1;
					        			checkRemoved = true;
					        		}
					        	}	
				        }
				        if (checkRemoved) {
				        	for (int i = 0; i < arrOfInt.length; i++)
				        		arrOfInt[i] = interimArrOfInt[i];
				        	arrOfInt = (int[])resizeArray(arrOfInt, 9);
				        }
				
				        System.out.print("All Elements in Int Array is : [");
				        for(int i = 0; i < arrOfInt.length; i++) {
				        	if (i < 8) {
				        	 System.out.print(arrOfInt[i] + ", ");
				        	} else {
				        		System.out.print(arrOfInt[i]);
				        	}
				        }
				        System.out.print("] ");
				        System.out.println();
					
			} else 
					if (input.equalsIgnoreCase("m")) {  
						//Skriv ut en map med key som integer och string som värde.
				        int[] intMapKey = {8,31,12,14};  
				        String[] strMapValue = {"Kalle","Agnes","Hugo","Josefin"};
				        System.out.print("Map Keys are : [");
				        for(int i = 0; i < intMapKey.length; i++) {
				        	if (i < (intMapKey.length - 1)) {
				        	 System.out.print(intMapKey[i] + ", ");
				        	} else {
				        		System.out.print(intMapKey[i]);
				        		}
				        	}
				        System.out.print("]");
				        System.out.println();
				        
				        System.out.print("Map Values is : [");
				        for(int i = 0; i < strMapValue.length; i++) {
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
		}
	}
					private static Object resizeArray (Object oldArray, int newSize) { //Plockad kod från nätet, förstår principen bakom denna.
						   int oldSize = java.lang.reflect.Array.getLength(oldArray);  //Den kopierar den array man skickar in till den nya arrayen 
						   Class elementType = oldArray.getClass().getComponentType(); //och använder den storleken man skickar in på den nya arrayen.	
						   Object newArray = java.lang.reflect.Array.newInstance(elementType, newSize); //Som sen returneras.
						   int preserveLength = Math.min(oldSize, newSize);
						   if (preserveLength > 0)
						      System.arraycopy(oldArray, 0, newArray, 0, preserveLength);
						   return newArray; }		
			
}
