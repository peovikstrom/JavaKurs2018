import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
public class Tidsbokning2 {

		public static void main(String[] args) {
			
			ArrayList<LocalDateTime[]> boknDatumLista = new ArrayList<>();
								
			String input = "";																		//Skapa variabeln input av typen sträng som är tom så att while satsen skall fungera
			
			String boknDatum = "", boknStartTid = "", boknSlutTid = "";
			
			Scanner scanner = new Scanner(System.in);
			
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

			LocalDateTime startTid = LocalDateTime.now();
			LocalDateTime slutTid = LocalDateTime.now();
			
			
			
			while (!input.equalsIgnoreCase("q")) {													//Kör while satsen så länge inte någon trycker på "q"											
					LocalDateTime[] q = new LocalDateTime[2];
					System.out.println("Choose (b) for booking, (c) to check allready made bookings or quit(q)");	//Skriv ut vilka val du kan göra
					input = scanner.nextLine();															
					
					if (input.equalsIgnoreCase("b")) {													
						try {
							System.out.println("Enter the date you want to book. (ex. 2011-01-01):");		
							boknDatum = scanner.nextLine();
							
							System.out.println("Enter the Starttime for your booking. (ex. 12:00):");		
							boknStartTid = scanner.nextLine();
				
							System.out.println("Enter the Quittime for your booking. (ex. 13:00):");			
							boknSlutTid = scanner.nextLine();
								
							
							
							startTid = LocalDateTime.parse(boknDatum + " " + boknStartTid, formatter);
							
							slutTid = LocalDateTime.parse(boknDatum + " " + boknSlutTid, formatter);
							q[0] = startTid;
							q[1] = slutTid;
							
							boolean dubbelbokning = tidenRedanTagen(boknDatumLista, startTid, slutTid);
							
							if (dubbelbokning) { 
								boknDatumLista.add(q);
								System.out.println("You have made a booking: " + boknDatum	+  " between " + boknStartTid + " and " + boknSlutTid);
								/*int si = boknDatumLista.size(); 
								if (si > 0) {
									for (int i = 0; boknDatumLista.size() > i; i++) {
											DateTimeFormatter formatterTime = DateTimeFormatter.ofPattern("HH:mm");
										
											String startTidString = boknDatumLista.get(i)[0].format(formatterTime);
											String slutTidString = boknDatumLista.get(i)[1].format(formatterTime);
										
											DateTimeFormatter formatterDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
										
											String bokningsDatumString = boknDatumLista.get(i)[0].format(formatterDate);
										
											System.out.println("Booking " + i + " Date: " + bokningsDatumString + " Starttime: " + startTidString + " Quittime: " + slutTidString);
										
									}
								} else
									System.out.println("No bookings found.");*/
												
							} else {
									System.out.println("That time is already taken. Choose another time.");
	
									}		
						} 
						catch (DateTimeException e) {
								System.out.println("Wrong date or time format. Date should be YYYY-MM-DD and Time HH:MM");
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
									
										System.out.println("Booking " + i + " Date: " + bokningsDatumString + " Starttime: " + startTidString + " Quittime: " + slutTidString);
									
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
			boolean check = true;
			for (int i = 0; i < t; i++) {
					LocalDateTime[] befintligBokning = boknDatumLista.get(i);
					
					boolean case1 = (befintligBokning[0].isAfter(nyStartTid) && befintligBokning[0].isAfter(nySlutTid));
					boolean case2 = (befintligBokning[1].isBefore(nyStartTid) && befintligBokning[1].isBefore(nySlutTid));
										
					if (case1 || case2) {
						check = true;
					}	
						else {
								check = false;
								break;
							}			
			}
			if (check)  
				return check;
				else return check;
		}
		
}
		

			
	

				