import java.time.DateTimeException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

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
		String strStart = startTid.getYear() + "-" + addZeroToInt(startTid.getMonthValue()) + "-" + addZeroToInt(startTid.getDayOfMonth()) + " " + addZeroToInt(startTid.getHour()) + ":" + addZeroToInt(startTid.getMinute());
		strStart += " - " + addZeroToInt(slutTid.getHour()) + ":" + addZeroToInt(slutTid.getMinute());
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
