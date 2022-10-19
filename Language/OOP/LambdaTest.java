class LambdaTest{
	
	private static boolean isOdd(int n){
		return (n % 2) == 1;
	}

	public static void main(String[] args){
		int[] squares = {1, 4, 9, 16, 25, 36, 49, 64, 81, 100};
		System.out.print("All squares:");
		for(int s : squares)
			System.out.printf(" %d", s);
		System.out.println();
		//passing a method reference (::) which will be invoked by a runtime generated class which implements Condition
		System.out.printf("Number of odd squares = %d%n", Counter.countIf(squares, LambdaTest::isOdd));
		int m = 50; //effectively final
		System.out.printf("Number of big squares = %d%n", Counter.countIf(squares, n -> n > m));
	}
}


