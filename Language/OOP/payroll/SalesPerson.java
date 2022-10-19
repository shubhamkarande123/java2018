package payroll;

public class SalesPerson extends Employee{

	private double sales;

	public SalesPerson(int h, float r, double s){
		super(h, r);
		sales = s;
	}

	public double getSales(){
		return sales;
	}
	
	public void setSales(double value){
		sales = value;
	}

	//overriding method of super class
	public double getNetIncome(){
		double income = super.getNetIncome();
		if(sales >= 20000)
			income += 0.05 * sales;
		return income;
	}
}

