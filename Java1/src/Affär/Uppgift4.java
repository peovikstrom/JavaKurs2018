package Aff�r;

public class Uppgift4 {
	
	public static void main(String[] args) {
		Item fotboll1 = new Item(10000,250,"Argentinsk Fotboll");
		Item fotbollsskor = new Item(10001,200,"Nike Fotbollsskor");
		Item m�lvaktshandskar1 = new Item(10002,100,"Addidas M�lvaktshandskar");
		Item fotboll2 = new Item(10003,50,"Kinesisk Fotboll");
		Item m�lvaktshandskar2 = new Item(10004,100,"Nike M�lvaktshandskar");
								
		Lager lager = new Lager();
		Kundvagn kundvagn = new Kundvagn();
		
		lager.addItem(fotboll1);
		lager.addItem(fotbollsskor);
		lager.addItem(m�lvaktshandskar1);
		lager.addItem(fotboll2);
		lager.addItem(m�lvaktshandskar2);
		
		System.out.println("Du har just nu f�ljande varor i din kundvagn:");
		kundvagn.addItem(fotboll1);
		kundvagn.addItem(m�lvaktshandskar1);;
		kundvagn.addItem(m�lvaktshandskar2);
		kundvagn.addItem(fotbollsskor);
		kundvagn.getAllItems();
		System.out.println();
		/*System.out.println("Du har just nu varor till ett pris av:");
		System.out.println();
		System.out.println("Totalsumma i kundvagn: " + kundvagn.countValueOfShoppingCart() + "kr");
		System.out.println();
		System.out.println("S�k efter beskrivning Kinesisk Fotboll i lagret");
		System.out.println();*/
		lager.searchItem("Kinesisk Fotboll");
		lager.searchItem("10002");
		//searchArticleDescr("Kinesisk Fotboll");
		//System.out.println();
		//System.out.println("S�k artikelnummer 10002 i lagret");
		//System.out.println(lager.searchArticleNumb(10002));
		//System.out.println();
		/*kundvagn.addItem(fotboll2);
		System.out.println("Du har just nu f�ljande varor i din kundvagn:");
		System.out.println();
		kundvagn.getAllItems();
		System.out.println();
		System.out.println("Du har just nu varor till ett pris av:");
		System.out.println();
		System.out.println("Totalsumma i kundvagn: " + kundvagn.countValueOfShoppingCart() + "kr");
		System.out.println();
		System.out.println("S�k p� pris 100kr i lagret");
		lager.searchPrice(100);
		System.out.println();
		System.out.println("S�k p� pris 75kr i lagret");
		lager.searchPrice(75);
		System.out.println("Ta bort alla varor ur kundvagn!");
		kundvagn.removeAllItems();
		System.out.println();
		System.out.println("Du har just nu varor till ett pris av:");
		System.out.println();
		System.out.println("Totalsumma i kundvagn: " + kundvagn.countValueOfShoppingCart() + "kr");*/
	}

}
