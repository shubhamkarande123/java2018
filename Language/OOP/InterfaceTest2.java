interface TaxPayer{
	
	int pin();

	double annualIncome();

	//extension method - a new method added to an interface with a default implementation
	//which is shared by all the classes which have already implemented that interface
	default double incomeTax(int age){
		float tx = age < 60 ? 0.15f : 0.12f;
		double ex = annualIncome() - 120000;
		return ex > 0 ? tx * ex : 0;
	}
}

class Cashier extends payroll.Employee implements TaxPayer{

	public Cashier(int h, float r){
		super(h, r);
	}

	public int pin(){
		return getId();
	}

	public double annualIncome(){
		return 12 * getNetIncome() + 25000;
	}
}

class Dealer implements TaxPayer{

	private int id;
	private double sales;

	public Dealer(int i, double s){
		id = i;
		sales = s;
	}

	public int pin(){
		return id;
	}

	public double annualIncome(){
		return 0.2 * sales;
	}
}

class InterfaceTest2{

	public static void main(String[] args){
		TaxPayer jill = new Cashier(190, 210);
		TaxPayer jack = new Dealer(505, 4800000);
		System.out.printf("Jill the Cashier - PIN is %d and Tax is %.2f%n", jill.pin(), jill.incomeTax(32));
		System.out.printf("Jack the Dealer - PIN is %d and Tax is %.2f%n", jack.pin(), jack.incomeTax(65));
	}
}


