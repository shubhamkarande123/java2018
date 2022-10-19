class VarArgTest{

	private static double average(double first, double second){
		return (first + second) / 2;
	}

	private static double average(double first, double second, double third){
		return (first + second + third) / 3;
	}

	//var-arg method (double... = double[])
	private static double average(double first, double second, double... remaining){
		double total = first + second;
		for(double value : remaining)
			total += value;
		return total / (remaining.length + 2);
	}

	public static void main(String[] args){
		System.out.printf("Average of two values = %f%n", average(19.4, 24.3));
		System.out.printf("Average of three values = %f%n", average(19.4, 24.3, 21.5));
		System.out.printf("Average of five values = %f%n", average(19.4, 24.3, 21.5, 17.6, 28.2)); //average(19.4, 24.3, new double[]{21.5, 17.6, 28.2})
	}
}


