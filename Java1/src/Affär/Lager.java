package Affär;

import java.util.*;
import java.util.regex.*;
import java.util.stream.Collectors;

public class Lager extends Storage<Item> {
	
	public Item searchArticle(String searchObject) {

		List<Item> result = storage
				.stream()
				.filter(item -> item.getDescription() == searchObject)
				.collect(Collectors.toList());
		
		if(result.isEmpty()) {
			return null;
		} else {
			return result.get(0);
		}
		
		
	}
}
