import java.io.*;

public class Uppgift1 {
	
	public static void main(String[] args) throws IOException {
		
		String input = "";																		//Skapa variabeln input av typen sträng som är tom så att while satsen skall fungera
		
		InputStreamReader inputStream = new InputStreamReader(System.in);						//Läs in valet du gjort
		BufferedReader br = new BufferedReader(inputStream);
		
		while (!input.equalsIgnoreCase("q")) {													//Kör while satsen så länge inte någon trycker på "q"											

			System.out.println("Välj om du vill räkna ord(o), bokstäver(b), båda(*) eller avsluta(q)");	//Skriv ut vilka val du kan göra
			
			input = br.readLine();																//Läs in valet från bufferedreadern till variabeln input
			
			if (input.equalsIgnoreCase("o")) {													//Kolla om input är lika med strängen "o"
				System.out.println("Du valde ord.");											
				System.out.println("Skriv en mening, sen räknar datorn fram orden.");			
	
				String str;																		//Skapa en sträng variabel
				int count;																		//Skapa en variabel för att räkna ord
					
				str = (String) br.readLine();													//För över din mening från bufferedreadern till variabeln str
				if (!str.isEmpty()) {															//Kolla om det är en tom sträng i så fall tillbaka till huvudmenyn
					count = ordCount(str);														//Anrop av metoden för att räkna ord
				
					System.out.println("Det är " + count + " ord i din mening");				//Skriv ut antal ord i din meningen
				}	
			}
			else if (input.equalsIgnoreCase("b")) {												//Kolla om input är lika med strängen "b"
					System.out.println("Du valde bokstäver");
					System.out.println("Skriv en mening, sen räknar datorn fram orden.");
				
					String str;																	//Skapa en sträng variabel
					int count;																	//Skapa en variabel för att räkna bokstäver
				
					str = (String) br.readLine();												//För över din mening från bufferedreadern till variabeln str
					if (!str.isEmpty()) {														//Kolla om det är en tom sträng i så fall tillbaka till huvudmenyn
						count = bokstCount(str);												//Anrop av metoden för att räkna bokstäver
				
						System.out.println("Det är " + count + " bokstäver i din mening");		//Skriv ut antal bokstäver i din mening
					}	
				}
				else if (input.equalsIgnoreCase("*")) {
					System.out.println("Du valde båda");
					System.out.println("Skriv en mening, sen räknar datorn fram orden och bokstäverna.");
					
					String str;																	//Skapa en sträng variabel
					int countOrd, countBokst;													//Skapa två variabler som räknar ord och bokstäver
											
					str = (String) br.readLine();												//För över din mening till variabeln str
					if (!str.isEmpty()) {														//Kolla om det är en tom sträng i så fall tillbaka till huvudmenyn
						countOrd = ordCount(str);												//Anrop av metoden för att räkna ord
						countBokst = bokstCount(str);											//Anrop av metoden för att räkna bokstäver	
					
						System.out.println("Det är " + countBokst + " bokstäver och " + countOrd + " ord i din mening");		//Skriv ut antal bokstäver och ord i din mening
					}
			} 
						
		}
		if (!input.equalsIgnoreCase("q")) {										//Kolla om någon inte tryckt på q
			return;																//i så fall återvänd till början av if loopen 
		}
		else System.exit(0);													//annars avbryt programmet
	}
	
	private static int ordCount(String mening) {
		int count;																//Skapa variabeln count av typen int som används för att räkna ord
				
		String[] words = mening.split("\\s+");									//Använd split och lägg orden i en array av strängar
				
		count = words.length;													//Kontrollera antal strängar och placera värdet i count[0]
		
		return count;															//Återför variabeln count
	}
	
	private static int bokstCount(String mening) {
			
		int charCount = 0;														//Skapa en variabel för att räkna antal bokstäver
		char temp;																//Skapa en temporär variabel för att plocka ut alla bokstäver ur orden
		
		for( int i = 0; i < mening.length( ); i++ )								//For loop som räknar alla tecken i strängen
		{
		    temp = mening.charAt( i );											//Plocka ut ett tecken ur strängen och placera det i temp variabeln

		    if( temp != ' ' )													//Kolla om tecknet är ett mellanslag eller inte
		    	charCount++;													//Om tecknet inte är mellanslag så räkna upp antalet bokstäver
		}
		
		return charCount;														//Återför variabeln charCount
	}
		
}
