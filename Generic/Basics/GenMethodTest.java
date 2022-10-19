class GenMethodTest{

	private static<T> T select(int sign, T first, T second){
		if(sign < 0)
			return first;
		return second;
	}
	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = select(s, "monday", "tuesday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = select(s, 4.3, 3.4);
		System.out.printf("Selected double = %s%n", sd);
		int si = select(s, 123456, 0xABCDEF);
		System.out.printf("Selected int = %s%n", si);
	}
}


