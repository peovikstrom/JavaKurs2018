package Affär;

import java.util.*;
import java.util.stream.Collectors;

public class Lager extends Storage<Item> {
	
	public Item searchArticleDescr(String searchObject) {
		List<Item> result = new ArrayList<>(); 
				result = storage
				.stream()
				.filter(item -> item.getDescription().toLowerCase().contains(searchObject.toLowerCase()))
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			System.out.println("No such item exist in storage!");
		} else {
				for (Item item : result) {
					System.out.println(item.toString());
					return item;
				}
		}
		return null;
	}
	
	public Item searchArticleNumb(int searchObject) {
		List<Item> result = new ArrayList<>(); 
				result = storage
				.stream()
				.filter(item -> item.getArtNumber() == searchObject)
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			System.out.println("No such item exist in storage!");
		} else {
			for (Item item : result) {
				System.out.println(item.toString());
				return item;
			}
		} return null;
	}
	
	public void searchPrice(int searchObject) {
		List<Item> result = new ArrayList<>(); 
				result = storage
				.stream()
				.filter(item -> item.getPrice() == searchObject)
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			System.out.println("No such item exist in storage!");
		} else { 
			for (Item item : result) {
				System.out.println(item.toString());
			}
		}
	}
	
	public boolean searchItem(String itemToFind) {
		boolean check = false;
		boolean check1 = false;
		try {
			Integer value = Integer.parseInt(itemToFind);
			searchArticleNumb(value);
			check1 = true;
		} 
		catch (NumberFormatException e) {
			searchArticleDescr(itemToFind);
		}
		if (check1) {
			check = true;
			return check;
		} else {
			check = false;
			return check;
		}
	}
}
