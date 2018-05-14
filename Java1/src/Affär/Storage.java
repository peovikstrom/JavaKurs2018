package Affär;
import java.util.*;

public class Storage<T> {
		
	List<T> storage = new ArrayList<>();
	
	public void getAllItems() {
		storage.forEach(System.out::println);
		/*for (T v : storage)
			System.out.println(v);*/
	}
	
	public void addItem(T newItem) {
		storage.add(newItem);
	}
	
	/*public void removeItem(T itemToRemove) {
		storage.remove();
	}*/
	
}
