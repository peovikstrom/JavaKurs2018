package Aff�r;
import java.util.*;

public class Uppgift4 {
	
	public static void main(String[] args) {
		List<Item> item = new ArrayList<>();
		
		Item fotboll1 = new Item(10000,250,"Argentisk Fotboll");
		Item fotbollsskor = new Item(10001,200,"Nike Fotbollsskor");
		Item m�lvaktshandskar = new Item(10002,100,"Addidas M�lvaktshandskar");
		Item fotboll2 = new Item(10003,50,"Kinesisk Fotboll");
								
		Lager lager = new Lager();
		Kundvagn kundvagn = new Kundvagn();
		
		lager.addItem(fotboll1);
		lager.addItem(fotbollsskor);
		lager.addItem(m�lvaktshandskar);
		lager.addItem(fotboll2);
		
		/*System.out.println();
		lager.removeItem();
		lager.getAllItems();*/
		
		/*System.out.println("Du har just nu f�ljande varor i din kundvagn:");
		kundvagn.addItem(fotboll);
		kundvagn.getAllItems();*/
		lager.searchArticle("Fotboll");
	}

}
