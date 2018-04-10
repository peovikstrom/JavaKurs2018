import java.io.*;

public class Uppgift1 {
	
	public static void main(String[] args) throws IOException {
		
		String input = "";																		//Skapa variabeln input av typen str�ng som �r tom s� att while satsen skall fungera
		
		InputStreamReader inputStream = new InputStreamReader(System.in);						//L�s in valet du gjort
		BufferedReader br = new BufferedReader(inputStream);
		
		while (!input.equalsIgnoreCase("q")) {													//K�r while satsen s� l�nge inte n�gon trycker p� "q"											

			System.out.println("V�lj om du vill r�kna ord(o), bokst�ver(b), b�da(*) eller avsluta(q)");	//Skriv ut vilka val du kan g�ra
			
			input = br.readLine();																//L�s in valet fr�n bufferedreadern till variabeln input
			
			if (input.equalsIgnoreCase("o")) {													//Kolla om input �r lika med str�ngen "o"
				System.out.println("Du valde ord.");											
				System.out.println("Skriv en mening, sen r�knar datorn fram orden.");			
	
				String str;																		//Skapa en str�ng variabel
				int count;																		//Skapa en variabel f�r att r�kna ord
					
				str = (String) br.readLine();													//F�r �ver din mening fr�n bufferedreadern till variabeln str
				if (!str.isEmpty()) {															//Kolla om det �r en tom str�ng i s� fall tillbaka till huvudmenyn
					count = ordCount(str);														//Anrop av metoden f�r att r�kna ord
					if (count != 0) {															//Kollar att count inte �r noll, d� skrivs inget ut
						System.out.println("Det �r " + count + " ord i din mening");			//Skriv ut antal ord i din mening
					}
				}	
			}
			else if (input.equalsIgnoreCase("b")) {												//Kolla om input �r lika med str�ngen "b"
					System.out.println("Du valde bokst�ver");
					System.out.println("Skriv en mening, sen r�knar datorn fram orden.");
				
					String str;																	//Skapa en str�ng variabel
					int count;																	//Skapa en variabel f�r att r�kna bokst�ver
				
					str = (String) br.readLine();												//F�r �ver din mening fr�n bufferedreadern till variabeln str
					if (!str.isEmpty()) {														//Kolla om det �r en tom str�ng i s� fall tillbaka till huvudmenyn
						count = bokstCount(str);												//Anrop av metoden f�r att r�kna bokst�ver
				
						System.out.println("Det �r " + count + " bokst�ver i din mening");		//Skriv ut antal bokst�ver i din mening
					}	
				}
				else if (input.equalsIgnoreCase("*")) {
					System.out.println("Du valde b�da");
					System.out.println("Skriv en mening, sen r�knar datorn fram orden och bokst�verna.");
					
					String str;																	//Skapa en str�ng variabel
					int countOrd, countBokst;													//Skapa tv� variabler som r�knar ord och bokst�ver
											
					str = (String) br.readLine();												//F�r �ver din mening till variabeln str
					if (!str.isEmpty()) {														//Kolla om det �r en tom str�ng i s� fall tillbaka till huvudmenyn
						countOrd = ordCount(str);												//Anrop av metoden f�r att r�kna ord
						countBokst = bokstCount(str);											//Anrop av metoden f�r att r�kna bokst�ver	
					
						System.out.println("Det �r " + countBokst + " bokst�ver och " + countOrd + " ord i din mening");		//Skriv ut antal bokst�ver och ord i din mening
					}
			} 
						
		}
		if (!input.equalsIgnoreCase("q")) {										//Kolla om n�gon inte tryckt p� q
			return;																//i s� fall �terv�nd till b�rjan av if loopen 
		}
		else System.exit(0);													//annars avbryt programmet
	}
	
	private static int ordCount(String mening) {
		int count = 0;															//Skapar variabeln count av typen int som anv�nds f�r att r�kna ord
		char temp;																//Skapar en variabel av typen char f�r att kolla vad det �r f�r tecken
		String[] words = null;													//Skapar en array av typen String[] och nollar den
		
		for( int i = 0; i < mening.length( ); i++ )								//For loop som r�knar alla tecken i str�ngen mening
		{
		    temp = mening.charAt( i );											//Plocka ut ett tecken ur str�ngen och placera det i temp variabeln
		    		    
		    	if( temp != ' ' ) {												//Kollar att det inte �r ett mellanslag		

		    			words = mening.split("\\S+");							//Anv�nd split och l�gg orden i en array av str�ngar
		    		
		    			count = words.length;									//Placera l�ngden p� words arrayen i variabeln count
		    			break;													//Avbryter for loopen
		    		} else count = 0;											//S�tter variabeln count till noll ifall den hittat ett mellanslag
				} 
		
		return count;															//�terf�r variabeln count
	}
	
	private static int bokstCount(String mening) {
			
		int charCount = 0;														//Skapa en variabel f�r att r�kna antal bokst�ver
		char temp;																//Skapa en tempor�r variabel f�r att plocka ut alla bokst�ver ur orden
		
		for( int i = 0; i < mening.length( ); i++ )								//For loop som r�knar alla tecken i str�ngen
		{
		    temp = mening.charAt( i );											//Plocka ut ett tecken ur str�ngen och placera det i temp variabeln
		    
		    if( temp != ' ' ) {													//Kolla om tecknet �r ett mellanslag eller inte
		    																	//om inte mellanslag kolla om tecknet �r alfabetiskt
		    	if (Character.isLetter(temp))									//Kolla om tecknet �r alfabetiskt eller inte
		    		charCount++;												//om det �r alfabetiskt �ka p� charCount
		    }
		}
		
		return charCount;														//�terf�r variabeln charCount
	}
		
}
