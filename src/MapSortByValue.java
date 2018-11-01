import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class MapSortByValue {
	
	public static void main(String[] args) {
		HashMap<String, Integer> h=new HashMap<>();
		h.put("Anil", 1);
		h.put("Litu", 2);
		h.put("Asit",3);
		h.put("Chintu", 4);
		h.put("Smiti", 7);
		h.put("Mousumi",9);
		
		System.out.println(h);
		
		ArrayList<Map.Entry<String, Integer>> a=new ArrayList<>(h.entrySet());
		
		Collections.sort(a,(x,y)->x.getValue().compareTo(y.getValue()));
		
		System.out.println(a);
		
		Collections.sort(a,(x,y)->x.getKey().compareTo(y.getKey()));
		
		System.out.println(a);
		
		
	}

}
