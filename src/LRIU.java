import java.util.LinkedHashMap;

public class LRIU {

	public static void main(String[] args) {
		LinkedHashMap<String, String> lmap= new LinkedHashMap<>(2, .75f, true);
		
		lmap.put("One", "One");
		lmap.put("Two","Two");
		lmap.put("Three", "Three");
		lmap.put("One", "One");
		lmap.put("Four", "Four");
		
		System.out.println(lmap);
	}

}
