package gammalt;
import java.time.LocalDateTime;

public class Bokning {
	private LocalDateTime startTid;
	private LocalDateTime slutTid;
	private int uppskPris;
	
	public Bokning(LocalDateTime startTid, LocalDateTime slutTid, int uppskPris) {
		this.startTid = startTid;
		this.slutTid = slutTid;
		this.uppskPris = uppskPris;
	}
	
	public LocalDateTime getStartTid() {
		return startTid;
	}

	public LocalDateTime getSlutTid() {
		return slutTid;
	}

	public int getUppskPris() {
		return uppskPris;
	}

	@Override
	public String toString() {
		int min;
		if ((slutTid.getHour() - startTid.getHour()) == 0) {
			min = ((slutTid.getMinute() - startTid.getMinute()) * 20); 
			uppskPris = 50 + (min / 10);
			} else
				{ if (((slutTid.getHour() - startTid.getHour()) > 1) || ((slutTid.getMinute() - startTid.getMinute()) > 1)){
					min = ((slutTid.getMinute() - startTid.getMinute()) * 20);
					uppskPris = 150 + ((slutTid.getHour() - startTid.getHour()) * 50) + (min / 10);
					} else { 
						if ((slutTid.getHour() - startTid.getHour()) == 1) {
							uppskPris = 200;
						}
					}
				}

		String strStart = startTid.getYear() + "-" + addZeroToInt(startTid.getMonthValue()) + "-" + addZeroToInt(startTid.getDayOfMonth()) + " " + addZeroToInt(startTid.getHour()) + ":" + addZeroToInt(startTid.getMinute());
		strStart += " - " + addZeroToInt(slutTid.getHour()) + ":" + addZeroToInt(slutTid.getMinute()) + " Pris: " + uppskPris + "kr";
		return strStart;	
	}

	private String addZeroToInt(int integer) {
		if(integer < 10) {
			return "0" + integer;
		} else {
			return integer + "";
		}
	}
	
}
