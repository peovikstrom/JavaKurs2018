package Affär;

public class Kundvagn extends Storage<Item> {

	public Item getOneItem(int itemToGet) {
	    for(Item itemsToGet : storage) {
	    		if(itemToGet == itemsToGet.getArtNumber()) {
	    			return itemsToGet;
		        }  
		    } return null;
	}
	
	public int countValueOfShoppingCart() {
		int value = 0;
		for(Item itemsToGet : storage) {
    			value = value + itemsToGet.getPrice();
	        } 
		return value;
	}
}
