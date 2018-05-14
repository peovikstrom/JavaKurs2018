package gammalt;
import java.util.ArrayList;
import java.util.List;

public class Frisor {
	
	List<Bokning> bokningar = new ArrayList<>();
	String frisorName;
	
	public Frisor(String frisorName) {
		this.frisorName = frisorName;
	}
	
	public void printBokning() {
		System.out.println(bokningar);
	}
	
	public void addBokning(Bokning newBokning) {
		bokningar.add(newBokning);
	}
	
	public void getFrisorName () {
		System.out.print(frisorName);
	}
	
	public boolean isFrisorFree(Bokning newBokning) {
		boolean check = true;
		if (check) {
			for (Bokning v : bokningar) {
				
				boolean case1 = (v.getStartTid().isAfter(newBokning.getStartTid()) && v.getStartTid().isAfter(newBokning.getSlutTid()));
				boolean case2 = (v.getSlutTid().isBefore(newBokning.getStartTid()) && v.getSlutTid().isBefore(newBokning.getSlutTid()));
								
				if (case1 || case2) {
					check = true;
					break;
				}	
					else {
							check = false;
							break;
						}			
			}
			return check;
		} else return check;
	}
}
