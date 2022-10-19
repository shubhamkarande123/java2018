//functional interface - an interface with exactly one abstract method
interface Condition{
	boolean allowed(int value);
}

class Counter{
	
	public static int countIf(int[] numbers, Condition check){
		int count = 0;
		for(int number : numbers){
			if(check.allowed(number))
				++count;
		}
		return count;
	}
}

