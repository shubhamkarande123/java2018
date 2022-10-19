import payroll.Employee;

class SubclassTest1{
	
	private static double getIncomeTax(Employee emp){
		double i = emp.getNetIncome();
		return i > 10000 ? 0.15 * (i - 10000) : 0;
	}

	public static void main(String[] args){
		Employee jack = new Employee(); //activating Employee using parameterless constructor
		jack.setHours(186);
		jack.setRate(52);
		System.out.printf("Jack's ID is %s, Income is %.2f and Tax is %.2f%n", jack.getId(), jack.getNetIncome(), getIncomeTax(jack));
		payroll.SalesPerson jill = new payroll.SalesPerson(186, 52, 48000); //activating SalesPerson using parameterized constructor
		System.out.printf("Jill's ID is %s, Income is %.2f and Tax is %.2f%n", jill.getId(), jill.getNetIncome(), getIncomeTax(jill));
		System.out.printf("Number of employees = %d%n", Employee.countInstances());

	}
}


