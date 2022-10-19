package edu.met.banking;

//cannot be instantiated
public abstract class Account{
	
	long id;
	protected double balance;

	public long getId(){
		return id;
	}

	public double getBalance(){
		return balance;
	}

	//must override in subclass
	public abstract void deposit(double amount);
	
	public abstract void withdraw(double amount) throws InsufficientFundsException;

	//not overridable in subclass
	public final void transfer(double amount, Account that) throws InsufficientFundsException{
		if(this == that)
			throw new IllegalTransferException();
		this.withdraw(amount);
		that.deposit(amount);
	}
}


