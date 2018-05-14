package Affär;

import java.util.*;
import java.util.stream.Collectors;

public class Lager extends Storage<Item> {
	
	public void searchArticleDescr(String searchObject) {
		List<Item> result = new ArrayList<>(); 
				result = storage
				.stream()
				.filter(item -> item.getDescription() == searchObject)
				.collect(Collectors.toList());
		if(result.isEmpty()) {
			System.out.println("No such item exist in storage!");
		} else {
				for (Item item : result) {
					System.out.println(item.toString());
				}
		}
	}
	
	public void searchArticleNumb(int searchObject) {
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
			}
		}
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
	
	public void searchItem(String itemToFind) {
		try {
			Integer value = Integer.parseInt(itemToFind);
			searchArticleNumb(value);
		} 
		catch (NumberFormatException e) {
			searchArticleDescr(itemToFind);
		}
	}
}
