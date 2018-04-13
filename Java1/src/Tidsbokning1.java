import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Tidsbokning1 {

		public static void main(String[] args) throws IOException {
			List<LocalDateTime[]> boknDatumLista = new ArrayList<>();
								
			String input = "";																		//Skapa variabeln input av typen sträng som är tom så att while satsen skall fungera
			
			InputStreamReader inputStream = new InputStreamReader(System.in);						//Läs in valet du gjort
			BufferedReader br = new BufferedReader(inputStream);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
						
			while (!input.equalsIgnoreCase("q")) {													//Kör while satsen så länge inte någon trycker på "q"											

			System.out.println("Välj (b) för bokning, (c) för att kolla bokningsschema eller avsluta(q)");	//Skriv ut vilka val du kan göra
				
			input = br.readLine();																//Läs in valet från bufferedreadern till variabeln input
				
			if (input.equalsIgnoreCase("b")) {													
									
					String boknDatum, boknStartTid, boknSlutTid;								//Skapa temporära String variabler för datum, starttid och sluttid  
												
					System.out.println("Skriv in datum du vill boka(t.ex. 2011-01-01):");		//Läs in datum från bufferedreadern till variabeln boknDatum
					boknDatum = br.readLine();
					
					System.out.println("Skriv in Starttid för bokningen(t.ex. 12:00):");		//Läs in starttid från bufferedreadern till variabeln boknStartTid
					boknStartTid = br.readLine();
					
					System.out.println("Skriv in Sluttid för bokningen(t.ex. 13:00):");			//Läs in sluttid från bufferedreadern till variabeln boknSlutTid
					boknSlutTid = br.readLine();
					
					LocalDateTime startTid, slutTid;													
					startTid = LocalDateTime.parse(boknDatum + " " + boknStartTid, formatter);
					slutTid = LocalDateTime.parse(boknDatum + " " + boknSlutTid, formatter);
					LocalDateTime[] q = new LocalDateTime[2];
					
					q[0] = startTid;
					q[1] = slutTid;
					
					boolean dubbelbokning = tidenRedanTagen(boknDatumLista, startTid, slutTid);
					
					if (dubbelbokning) { 
										System.out.println("Den tiden är redan tagen! Välj ny tid");
										
					} else {										
					
					
						// -1 = startid < sluttid, 1 tvärtom  
						if (startTid.compareTo(slutTid) < 0) {
								boknDatumLista.add(q);
								System.out.println("Du har gjort en bokning: " + boknDatum	+  " mellan klockan " + boknStartTid + " och " + boknSlutTid);
						} else 
							System.out.println("Sluttiden får inte vara mindre än eller samma som starttiden.");
						}
										
					
							
				} else 
				if (input.equalsIgnoreCase("c")) {						
					for (int i = 0; boknDatumLista.size() > i; i++) {
						DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
						
						String startTidString = boknDatumLista.get(i)[0].format(formatterTime);
						String slutTidString = boknDatumLista.get(i)[1].format(formatterTime);
						
						DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						
						String bokningsDatumString = boknDatumLista.get(i)[0].format(formatterDate);
						
						System.out.println("Bokning Datum: " + bokningsDatumString + " Starttid: " + startTidString + " Sluttid: " + slutTidString);
						
					}
				} else {
					if (input.equalsIgnoreCase("q")) {
						System.exit(0); 
					} else
						return;																//i så fall återvänd till början av if loopen
						
				}
			
			}
		}

		private static boolean tidenRedanTagen(List<LocalDateTime[]> boknDatumLista, LocalDateTime nyStartTid,
				LocalDateTime nySlutTid) {
			for (int i = 0; boknDatumLista.size() > i; i++) {
					
					LocalDateTime[] befintligBokning = boknDatumLista.get(i);
					boolean case1 = befintligBokning[0].isBefore(nyStartTid) && befintligBokning[1].isAfter(nyStartTid) && befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isAfter(nySlutTid);
					boolean case2 = befintligBokning[0].isAfter(nyStartTid)  &&  befintligBokning[1].isAfter(nyStartTid) && befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isAfter(nySlutTid);
					boolean case3 = befintligBokning[0].isBefore(nyStartTid) && befintligBokning[1].isAfter(nyStartTid) && befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isBefore(nySlutTid);
					boolean case4 = befintligBokning[0].isAfter(nyStartTid) && befintligBokning[1].isAfter(nyStartTid) && befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isBefore(nySlutTid);
					
					if(case1 || case2 || case3 || case4) {
						return true;
					}
			}
			return false;
		}
		
}
		

			
	

				