class MethodTest{
	
	private static double getInterest(double invest, int period, float rate){
		double amount = invest * Math.pow(1 + rate / 100, period);
		return amount - invest;
	}

	public static void main(String[] args){
		double inv = Double.parseDouble(args[0]);
		int per = Integer.parseInt(args[1]);
		System.out.printf("Income in Silver scheme: %.2f%n", getInterest(inv, per, 8));
		System.out.printf("Income in Gold scheme: %.2f%n", getInterest(inv, per, 9));
	}
}


