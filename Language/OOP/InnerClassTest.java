class InnerClassTest{

	//nested member class - class defined with static modifier within another class
	//can only refer to static members of outer class
	//can define static as well as non-static members
	static class OddCondition implements Condition{
		
		public boolean allowed(int n){
			return (n % 2) == 1;
		}
	}

	//inner member class - class defined without static modifier within another class
	//can refer to static as well as non-static members of outer class
	//can only define non-static members
	class BigCondition implements Condition{
		
		private int limit;

		BigCondition(int limit){
			this.limit = limit;
		}

		public boolean allowed(int n){
			return n > limit;
		}
	}
	
	public static void main(String[] args){
		int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
		System.out.print("All squares:");
		for(int s : squares)
			System.out.printf(" %d", s);
		System.out.println();
		System.out.printf("Number of odd squares = %d%n", Counter.countIf(squares, new InnerClassTest.OddCondition()));
		System.out.printf("Number of big squares = %d%n", Counter.countIf(squares, new InnerClassTest().new BigCondition(50)));
		int max = 20; //effectively final as it is referenced from the inner local class
		//passing an instance of an inner local anonymous class which implements Condition
		System.out.printf("Number of low squares = %d%n", Counter.countIf(squares, new Condition(){
			public boolean allowed(int val){
				//final int max = 20; // capturing outer method's local variable by value (copy)
				return val < max; 
			}
		}));
		//max += 5;
	}
}


