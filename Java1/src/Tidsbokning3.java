import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Tidsbokning3 {

	public static void main(String[] args) {
			
		List<Frisor> frisor = new ArrayList<>();
		
		Frisor kalle = new Frisor("Kalle");
		Frisor svenne = new Frisor("Svenne");
		Frisor anna = new Frisor("Anna");
		
		frisor.add(kalle);
		frisor.add(svenne);
		frisor.add(anna);
		
		String input = "";																		//Skapa variabeln input av typen sträng som är tom så att while satsen skall fungera
		
		String boknDatum = "", boknStartTid = "", boknSlutTid = "", frisorNamn="";
		
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime startTid = null;
		LocalDateTime slutTid = null;
		int uppskPris = 0;
				
		while (!input.equalsIgnoreCase("q")) {													//Kör while satsen så länge inte någon trycker på "q"											
			LocalDateTime[] q = new LocalDateTime[2];
			System.out.println("Choose (b) for booking, (c) to check allready made bookings or quit(q)");	//Skriv ut vilka val du kan göra
			//System.out.println("Following Hairdressers are working today " + frisor.get(0).frisorName + " " + frisor.get(1).frisorName + " " + frisor.get(2).frisorName);
			input = scanner.nextLine();															
			Bokning newBokning = null;
			boolean checkIfWrongInput = true;
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
					uppskPris = 0;
					
					newBokning = new Bokning(startTid,slutTid,uppskPris);
					}
						catch (DateTimeException e) {
							System.out.println("Wrong date or time format. Date should be YYYY-MM-DD, Time HH:MM.");
							checkIfWrongInput = false;
						}
					if (checkIfWrongInput) {
					boolean ingenLedig = false;
					for (Frisor f : frisor) {
						if (f.isFrisorFree(newBokning)) {
							f.addBokning(newBokning);
							ingenLedig = true;
							break;
						} 
					} if (ingenLedig) {
						System.out.println("Booked!");
					} else {
							System.out.println("No Hairdresser is free that time.");
						} 
					}
			} 
			if (input.equalsIgnoreCase("c")) {
				System.out.print("Frisör "); kalle.getFrisorName(); System.out.print(" "); kalle.printBokning();
				System.out.print("Frisör "); svenne.getFrisorName(); System.out.print(" "); svenne.printBokning();
				System.out.print("Frisör "); anna.getFrisorName(); System.out.print(" "); anna.printBokning();
			}
		}
	}
}			

