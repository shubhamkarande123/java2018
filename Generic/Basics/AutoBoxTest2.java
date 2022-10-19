class AutoBoxTest2{

	/*
	private static String select(int sign, String first, String second){
		if(sign < 0)
			return first;
		return second;
	}

	private static double select(int sign, double first, double second){
		if(sign < 0)
			return first;
		return second;
	}
	*/

	private static Object select(int sign, Object first, Object second){
		if(sign < 0)
			return first;
		return second;
	}
	public static void main(String[] args){
		int s = Integer.parseInt(args[0]);
		String ss = (String)select(s, "monday", "tuesday");
		System.out.printf("Selected String = %s%n", ss);
		double sd = (double)select(s, 4.3, 3.4);
		System.out.printf("Selected double = %s%n", sd);
		int si = (int)select(s, 123456, "ABCDEF");
		System.out.printf("Selected int = %s%n", si);
	}
}


