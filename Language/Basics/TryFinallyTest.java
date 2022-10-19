class TryFinallyTest{
	
	private static void run(String[] args){
		System.out.println("Acquiring resources");
		try{
			double value = Double.parseDouble(args[0]);
			System.out.printf("Square of %s is %s%n", value, value * value);
		}finally{
			System.out.println("Releasing resources");
		}
	}

	public static void main(String[] args){
		System.out.println("Welcome user.");
		try{
			run(args);
		}catch(Exception e){
			System.out.println(e);
		}
		System.out.println("Goodbye user.");
	}
}


