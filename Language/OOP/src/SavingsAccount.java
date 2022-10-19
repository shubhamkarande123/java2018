package edu.met.banking;

final class SavingsAccount extends Account implements Profitable{
	
	//cannot be reassigned(const)
	static final double MIN_BAL = 10000;

	SavingsAccount(){
		balance = MIN_BAL;
	}
	
	public void deposit(double amount){
		balance += amount;
	}

	public void withdraw(double amount) throws InsufficientFundsException{
		if(balance - amount < MIN_BAL)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public double getInterest(int period){
		float rate = balance < 2 * MIN_BAL ? 4 : 5;
		return balance * period * rate / 100;
	}
}


