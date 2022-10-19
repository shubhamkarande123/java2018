class AutoBoxTest1{

	private static Double getBalance(String name){
		String[] names = {"jack", "jill", "john", "jane", "jeff"};
		double[] balances = {12000, 19000, 15000, 9000, 5000};
		for(int i = 0; i < names.length; ++i){
			if(names[i].equals(name))
				return balances[i]; //boxing
		}
		return null;
	}

	public static void main(String[] args){
		Double bal = getBalance(args[0]);
		if(bal == null)
			System.out.println("Name not found!");
		else{
			double val = bal; //unboxing
			System.out.printf("Balance: %.2f%n", val);
		}
	}
}


