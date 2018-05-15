package Aff�r;

public class Item {
	private int artNumber;
	private int price;
	private String description;
	
	public Item(int artNumber, int price, String description) {
		this.artNumber = artNumber;
		this.price = price;
		this.description = description;
	}
		
	public int getArtNumber() {
		return artNumber;
	}
	
	public void setArtNumber(int artNumber) {
		this.artNumber = artNumber;
	}
	
	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		
		String strItem = description + "\t" + "Articlenumber: " + artNumber + "\t" + "Price: " + price + "kr";
		
		return strItem;
	}
}
