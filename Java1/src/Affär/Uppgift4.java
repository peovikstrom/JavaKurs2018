package Affär;

import java.util.Scanner;

public class Uppgift4 {
	
	public static void main(String[] args) {
		Item fotboll1 = new Item(10000,250,"Argentinsk Fotboll");
		Item fotboll2 = new Item(10001,50,"Kinesisk Fotboll");
		Item fotbollsskor1 = new Item(10002,200,"Nike Fotbollsskor");
		Item fotbollsskor2 = new Item(10003,175,"Addidas Fotbollsskor");
		Item målvaktshandskar1 = new Item(10004,50,"Målvaktshandskar");
		Item målvaktshandskar2 = new Item(10005,100,"Nike Målvaktshandskar");
		Item fotbollströja1 = new Item(10006,200,"Nike Fotbollströja");
		Item fotbollsbyxor1 = new Item(10007,150,"Nike Fotbollsbyxor");
		Item fotbollströja2 = new Item(10008,170,"Addidas Fotbollströja");
		Item fotbollsbyxor2 = new Item(10009,120,"Addidas Fotbollsbyxor");
		
		Lager lager = new Lager();
		Kundvagn kundvagn = new Kundvagn();
		
		String input =""; 
		
		lager.addItem(fotboll1);
		lager.addItem(fotboll2);
		lager.addItem(fotbollsskor1);
		lager.addItem(fotbollsskor2);
		lager.addItem(målvaktshandskar1);
		lager.addItem(målvaktshandskar2);
		lager.addItem(fotbollströja1);
		lager.addItem(fotbollsbyxor1);
		lager.addItem(fotbollströja2);
		lager.addItem(fotbollsbyxor2);
		
		Scanner scanner = new Scanner(System.in);
		
		while (!input.equalsIgnoreCase("q")) {
			System.out.println("Choose (s) to see shoppingcart, choose (a) to add items to shoppingcart, choose (r) to remove items from shoppingcart");
			System.out.println("choose (c) to checkout shoppingcart, choose (l) to check storage, choose (i) to search an item in storage or (q) to quit");
			input = scanner.nextLine();
			if (input.equalsIgnoreCase("s")) {
				showShoppingCart(kundvagn);
			} else {
				if (input.equalsIgnoreCase("l")) {
					System.out.println("This is available today:");
					lager.printAllItems();
					System.out.println();
				} else {
					if (input.equalsIgnoreCase("a")) {
						System.out.println("Type in articlenumber for the item you want to buy: ");
						input = scanner.nextLine();
						try {
							Integer value = Integer.parseInt(input);
							Item foundObj = lager.searchArticleNumb(value);
							if (foundObj != null) {
								kundvagn.addItem(foundObj);
								lager.removeItem(foundObj);
								showShoppingCart(kundvagn);
							} else {
								System.out.println();
							}
						} catch (NumberFormatException e){
							System.out.println("Input not an integer");
							System.out.println();
						}
					} else {
						if (input.equalsIgnoreCase("r")) {
							System.out.println("Type in articlenumber for the item you want to remove: ");
							input = scanner.nextLine();
							try {
								Integer value = Integer.parseInt(input);
								Item foundObj = kundvagn.getOneItem(value);
								if (foundObj != null) {
									lager.addItem(kundvagn.getOneItem(value));
									kundvagn.removeItem(kundvagn.getOneItem(value));
									showShoppingCart(kundvagn);
								} else {
									System.out.println("Can't remove item, item don't exist in shoppingcart or shoppingcart empty.");
									System.out.println();
								}
							} catch (NumberFormatException e){
								System.out.println("Input not an integer!");
								System.out.println();
							}
						} else {
							if (input.equalsIgnoreCase("c")) {
								if (kundvagn.storage.size() != 0) {
									checkOutShopCart(kundvagn);
								} else {
									System.out.println("Can't checkout, shoppingcart empty.");
									System.out.println();
								}
							} else {
								if (input.equalsIgnoreCase("i")) {
									System.out.println("Type in articlenumber or description the item you want to find: ");
									input = scanner.nextLine();
									System.out.println();
									lager.searchItem(input);
									System.out.println();
								}
							}
						}
					}
				}
			} 
		}
			scanner.close();
	}
	
	private static void showShoppingCart(Kundvagn kundvagn) {
		try {
			System.out.println();
			System.out.println("Shoppingcart contains following items:");
			kundvagn.printAllItems();
			System.out.println();
			System.out.println("Totalsumma i kundvagn: " + kundvagn.countValueOfShoppingCart() + "kr");
			System.out.println();
		} catch (ArithmeticException e) {
			System.out.println("Something went mathematically wrong!");
		}
	}
	
	private static void checkOutShopCart(Kundvagn kundvagn) {
		try { 
			int frakt = 90;
			int shopCartValue = kundvagn.countValueOfShoppingCart();
			int totalSum = 0;
			System.out.println("Receipt");
			System.out.println("----------------------------------------------------------------");
			kundvagn.printAllItems();
			System.out.println();
			System.out.println("Items costs " + shopCartValue + "kr");
			System.out.println();
			System.out.println("Freight: " + frakt);
			totalSum = shopCartValue + frakt;
			System.out.println();
			System.out.println("Total amount to pay: " + totalSum);
			System.out.println();
			kundvagn.removeAllItems();
		} 
		catch (ArithmeticException e) {
			System.out.println("Something went mathematically wrong!");
		}
	}
}
