import java.util.*;

class TreeSetTest{
	
	public static void main(String[] args){
		//Set<Interval> store = new TreeSet<>();
		Set<Interval> store = new TreeSet<>((i, j) -> j.seconds() - i.seconds());
		store.add(new Interval(6, 51));
		store.add(new Interval(5, 12));
		store.add(new Interval(7, 23));
		store.add(new Interval(2, 34));
		store.add(new Interval(4, 25));
		store.add(new Interval(5, 111));
		for(Interval i : store)
			System.out.println(i);
	}
}


