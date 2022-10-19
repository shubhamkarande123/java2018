import java.util.*;

class TreeMapTest{
	
	public static void main(String[] args){
		Map<String, Interval> store = new TreeMap<>();
		store.put("monday", new Interval(6, 51));
		store.put("tuesday", new Interval(5, 12));
		store.put("wednesday", new Interval(7, 23));
		store.put("thursday", new Interval(2, 34));
		store.put("friday", new Interval(4, 25));
		store.put("monday", new Interval(3, 40));
		for(Map.Entry<String, Interval> pair : store.entrySet())
			System.out.printf("%s's interval is %s%n", pair.getKey(), pair.getValue());
		Scanner input = new Scanner(System.in);
		System.out.print("Key: ");
		String key = input.next();
		Interval val = store.get(key);
		if(val == null)
			System.out.println("No such key!");
		else
			System.out.printf("Value = %s%n", val);
	}
}


