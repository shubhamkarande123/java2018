class GenWildcardTest{

	interface Stack<V>{
		void push(V item);
		V pop();
		boolean empty();
	}

	static class SimpleStack<V> implements Stack<V>{
		
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

		public void copy(Stack<? super V> target){
			for(Node n = top; n != null; n = n.below)
				target.push(n.value);
		}

	}

	static class FiniteStack<V> implements Stack<V>{
		
		private V[] values;
		private int count;

		FiniteStack(V[] store){
			values = store;
			count = 0;
		}

		public void push(V item){
			values[count++] = item; 
		}

		public V pop(){
			return values[--count];
		}

		public boolean empty(){
			return count == 0;
		}
	}

	private static void printStack(Stack<?> stack){
		for(int i = 0; !stack.empty(); ++i){
			if(i > 0) System.out.print(", ");
			System.out.print(stack.pop());
		}
		System.out.println();
		//stack.push(0);
	}

	public static void main(String[] args){
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("monday");
		a.push("tuesday");
		a.push("wednesday");
		a.push("thursday");
		a.push("friday");
		FiniteStack<String> b = new FiniteStack<>(new String[16]); 
		b.push("june");
		b.push("may");
		b.push("april");
		b.push("march");
		a.copy(b);
		SimpleStack<Interval> c = new SimpleStack<>();
		c.push(new Interval(3, 41));
		c.push(new Interval(4, 32));
		c.push(new Interval(5, 23));
		c.push(new Interval(6, 54));
		c.push(new Interval(7, 15));
		SimpleStack<Object> d = new SimpleStack<>();
		d.push("saturday");
		d.push(new Interval(2, 30));
		d.push(34.5);
		c.copy(d);
		printStack(a);
		System.out.println("--------------------------------");
		printStack(b);
		System.out.println("--------------------------------");
		printStack(c);
		System.out.println("--------------------------------");
		printStack(d);
	}
}


