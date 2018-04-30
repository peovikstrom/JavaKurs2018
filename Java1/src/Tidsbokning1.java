import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.io.IOException;
public class Tidsbokning1 {

		public static void main(String[] args) throws IOException {
			
			List<LocalDateTime[]> boknDatumLista = new ArrayList<>();
								
			String input = "";																		//Skapa variabeln input av typen sträng som är tom så att while satsen skall fungera
			
			String boknDatum = "", boknStartTid = "", boknSlutTid = "";
			
			Scanner scanner = new Scanner(System.in);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

			LocalDateTime startTid = LocalDateTime.now();
			LocalDateTime slutTid = LocalDateTime.now();
			
			LocalDateTime[] q = new LocalDateTime[2];
			
			while (!input.equalsIgnoreCase("q")) {													//Kör while satsen så länge inte någon trycker på "q"											
					System.out.println("Choose (b) for booking, (c) to check allready made bookings or quit(q)");	//Skriv ut vilka val du kan göra
					input = scanner.nextLine();															
						
					if (input.equalsIgnoreCase("b")) {													
						try {
							System.out.println("Enter the date you want to book. (ex. 2011-01-01):");		
							boknDatum = scanner.nextLine();
							
							System.out.println("Enter the Starttime for your booking. (t.ex. 12:00):");		
							boknStartTid = scanner.nextLine();
				
							System.out.println("Enter the Quittime for your booking. (t.ex. 13:00):");			
							boknSlutTid = scanner.nextLine();
								
							startTid = LocalDateTime.parse(boknDatum + " " + boknStartTid, formatter);
							
							slutTid = LocalDateTime.parse(boknDatum + " " + boknSlutTid, formatter);
							q[0] = startTid;
							q[1] = slutTid;
							} 
								catch (DateTimeException e) {
									System.out.println("Wrong date or time format. Date should be YYYY-MM-DD and Time HH:MM");
								}
					
							boolean dubbelbokning = tidenRedanTagen(boknDatumLista, startTid, slutTid);
							
							if (dubbelbokning) { 
												System.out.println("That time is already taken. Choose another time.");
												
							} else {										
							
							
								// -1 = startid < sluttid, 1 startid > sluttid  
								if (startTid.compareTo(slutTid) < 0) {
										boknDatumLista.add(q);
										System.out.println("You have made a booking: " + boknDatum	+  " between " + boknStartTid + " and " + boknSlutTid);
								} else {
									if (startTid.isEqual(slutTid) || startTid.isAfter(slutTid)) 
									 System.out.println("Quittime cannot be greater or equal to Starttime. Choose another time.");
								}
							}					
								
						} else {
						if (input.equalsIgnoreCase("c")) {						
							if (boknDatumLista.size() > 0) {
								for (int i = 0; boknDatumLista.size() > i; i++) {
										DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
									
										String startTidString = boknDatumLista.get(i)[0].format(formatterTime);
										String slutTidString = boknDatumLista.get(i)[1].format(formatterTime);
									
										DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
									
										String bokningsDatumString = boknDatumLista.get(i)[0].format(formatterDate);
									
										System.out.println("Booking Date: " + bokningsDatumString + " Starttime: " + startTidString + " Quittime: " + slutTidString);
									
								}
							} else
								System.out.println("No bookings found.");
						} else {
							if (input.equalsIgnoreCase("q")) {
								System.exit(0); 
							} else
								return;																//i så fall återvänd till början av if loopen
								
						}
					} 
			} scanner.close();
			
		}
		private static boolean tidenRedanTagen(List<LocalDateTime[]> boknDatumLista, LocalDateTime nyStartTid, LocalDateTime nySlutTid) {
			int t = boknDatumLista.size();
			for (int i = 0; t > i; i++) {
					
					LocalDateTime[] befintligBokning = boknDatumLista.get(i);
					boolean case1 = befintligBokning[0].isAfter(nyStartTid) && befintligBokning[1].isAfter(nySlutTid) /*&& befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isAfter(nySlutTid)*/;
					boolean case2 = befintligBokning[0].isBefore(nyStartTid)  &&  befintligBokning[1].isBefore(nySlutTid) /*&& befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isAfter(nySlutTid)*/;
					boolean case3 = befintligBokning[0].isAfter(nyStartTid) && befintligBokning[1].isEqual(nySlutTid) /*&& befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isBefore(nySlutTid)*/;
					boolean case4 = befintligBokning[0].isEqual(nyStartTid) && befintligBokning[1].isBefore(nySlutTid) /*&& befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isBefore(nySlutTid)*/;
					boolean case5 = befintligBokning[0].isBefore(nyStartTid) && befintligBokning[1].isAfter(nySlutTid) /*&& befintligBokning[0].isBefore(nySlutTid) && befintligBokning[1].isEqual(nySlutTid)*/;
					boolean case6 = befintligBokning[0].isAfter(nyStartTid) && befintligBokning[1].isBefore(nySlutTid) /*&& befintligBokning[0].isAfter(nySlutTid) && befintligBokning[1].isEqual(nySlutTid)*/;
					
					if(case1 || case2 || case3 || case4 || case5 || case6) {
						return true;
					}
			}
			return false;
		}
		
}
		

			
	

				