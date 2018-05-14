package Affär;

public class Kundvagn extends Storage<Item> {

	public String getOneItem(String itemToGet) {
	    for(Item itemsToGet : storage) {
	    		if(itemToGet.equalsIgnoreCase(itemsToGet.getDescription())) {
		            return itemsToGet.toString();
		        } 
		    }
	    return itemToGet = "No items found!";
	}
	
	public int countValueOfShoppingCart() {
		int value = 0;
		for(Item itemsToGet : storage) {
    			value = value + itemsToGet.getPrice();
	        } 
		return value;
	}
}
