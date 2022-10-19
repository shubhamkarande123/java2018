import java.util.Iterator;

class IterationTest{

	static class SimpleStack<V> implements Iterable<V>{
		
		private Node top;

		private class Node{
			
			V value;
			Node below;

			Node(V val){
				value = val;
				below = top;
			}
		}

		public void push(V item){
			top = new Node(item);
		}

		public V pop(){
			V item = top.value;
			top = top.below;
			return item;
		}

		public boolean empty(){
			return top == null;
		}
	
		public Iterator<V> iterator(){
			return new Iterator<V>(){
				Node current = top;

				public boolean hasNext(){
					return current != null;
				}

				public V next(){
					V item = current.value;
					current = current.below;
					return item;
				}
			};
		}

	}

	public static void main(String[] args){
		int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81};
		System.out.println("Odd squares");
		for(int square : squares){
			if((square % 2) == 1)	
				System.out.println(square);
		}
		SimpleStack<Interval> intervals = new SimpleStack<>();
		intervals.push(new Interval(3, 41));
		intervals.push(new Interval(6, 32));
		intervals.push(new Interval(5, 23));
		intervals.push(new Interval(4, 54));
		intervals.push(new Interval(7, 15));
		System.out.println("Big intervals");
		for(Interval interval : intervals){
			if(interval.time() > 300)
				System.out.println(interval);
		}
	}
}


