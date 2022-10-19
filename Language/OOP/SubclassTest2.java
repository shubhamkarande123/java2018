import payroll.*;

class SubclassTest2{

	private static double getAverageIncome(Employee[] group){
		double total = 0;
		for(Employee member : group){
			total += member.getNetIncome();
		}
		return total / group.length;
	}

	private static double getTotalSales(Employee[] group){
		double total = 0;
		for(Employee member : group){
			if(member instanceof SalesPerson){
				SalesPerson sp = (SalesPerson)member; //explicit narrowing conversion
				total += sp.getSales();
			}
		}
		return total;
	}
	
	public static void main(String[] args){
		Employee[] department = new Employee[5];
		department[0] = new Employee(186, 52);
		department[1] = new Employee(175, 95);
		department[2] = new SalesPerson(194, 48, 56000); //implicit widening conversion
		department[3] = new Employee(168, 254);
		department[4] = new SalesPerson(174, 54, 44000);
		for(Employee emp : department)
			System.out.printf("%d\t%.2f%n", emp.getId(), emp.getNetIncome());
		System.out.printf("Average income: %.2f%n", getAverageIncome(department));
		System.out.printf("Total sales   : %.2f%n", getTotalSales(department));
	}
}


