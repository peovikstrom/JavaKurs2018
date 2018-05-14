package Aff�r;
import java.util.*;

public class Storage<T> {
		
	List<T> storage = new ArrayList<>();
	
	public void getAllItems() {
		//storage.forEach(System.out::println);
		for (T element : storage) //Exempel f�r att se vad i princip raden ovan g�r.
			System.out.println(element.toString());
	}
	
	public void addItem(T newItem) {
		storage.add(newItem);
	}
	
	public void removeItem(T itemToRemove) {
		storage.remove(itemToRemove);
	}
	
	public void removeAllItems() {
		storage.removeAll(storage);
	}
}
