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
		
		String input = "";																		//Skapa variabeln input av typen str�ng som �r tom s� att while satsen skall fungera
		
		String boknDatum = "", boknStartTid = "", boknSlutTid = "";
		
		Scanner scanner = new Scanner(System.in);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		
		LocalDateTime startTid = null;
		LocalDateTime slutTid = null;
		int uppskPris = 0;
				
		while (!input.equalsIgnoreCase("q")) {													//K�r while satsen s� l�nge inte n�gon trycker p� "q"											
			System.out.println("Choose (b) for booking, (c) to check allready made bookings or quit(q)");	//Skriv ut vilka val du kan g�ra
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
						
						int bStThour = Integer.parseInt("" + startTid.getHour());
						String starthour= addZeroToInt(bStThour);
						int bStTmin = Integer.parseInt("" + startTid.getMinute());
						String startmin = addZeroToInt(bStTmin);
						int bSlThour = Integer.parseInt("" + slutTid.getHour());
						String endhour = addZeroToInt(bSlThour);
						int bSlTmin = Integer.parseInt("" + slutTid.getMinute());
						String endmin = addZeroToInt(bSlTmin);
						int bStT = Integer.parseInt(starthour + startmin);
						int bSlT = Integer.parseInt(endhour + endmin);
						if (bStT < bSlT) {
							newBokning = new Bokning(startTid,slutTid,uppskPris);
							} else {
								System.out.println("Quit Time can't be earlier then Start Time");
								checkIfWrongInput = false;
								}
					}
						catch (DateTimeException e) {
							System.out.println("Wrong date or time format. Date should be YYYY-MM-DD, Time HH:MM.");
							checkIfWrongInput = false;
						}
					if (checkIfWrongInput) {
					boolean ingenLedig = true;
					for (Frisor f : frisor) {
						if (f.isFrisorFree(newBokning)) {
							f.addBokning(newBokning);
							ingenLedig = false;
							break;
						}
					} if (ingenLedig) {
						System.out.println("No Hairdresser is free that time.");
					} else {
							System.out.println("Booked!");
							
						} 
					}
			} 
			if (input.equalsIgnoreCase("c")) {
				System.out.print("Hairdresser "); kalle.getFrisorName(); System.out.print(" "); kalle.printBokning();
				System.out.print("Hairdresser "); svenne.getFrisorName(); System.out.print(" "); svenne.printBokning();
				System.out.print("Hairdresser "); anna.getFrisorName(); System.out.print(" "); anna.printBokning();
			}
		} scanner.close();
	}
	
	private static String addZeroToInt(int integer) {
		if(integer < 10) {
			return "0" + integer;
		} else {
			return integer + "";
		}
	}
	
}			