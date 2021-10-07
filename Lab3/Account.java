package laboration3;

public class Account {

	protected int accountNumber;							//protected används för att komma åt variablerna i subclasses
	
	protected String accountType;
	
	protected double balance;
	
	protected Account otherAccount;
	
	static double FEE;								//initierar statiska variabler fee och interest
	static double INTEREST;
	
	public Account(int acc) {
		
		accountNumber = acc;					//första constructor sätter vi till current.
		
		accountType = "Current";
	}
	
	public Account(Current konto, int acc) {
		
		accountType = "Savings";				//andra till savings, här säger vi även att other account = savings.
		
		accountNumber = acc;
		
		otherAccount = konto;
		
		konto.otherAccount = this;					//kopierar in adress till otheraccount
		
		
		
	}
	
	public String getAccountType() {
		
		return accountType;
	}
	
	public int getNumber() {
		
		return accountNumber;
	}
	
	public double getBalance() {
		
		return balance;
	}
	
	public void annualChange() {
		FEE = 10.0;								
		INTEREST = 1.02;					//fast summa %
		
		if(accountType == "Current") {			//om det är current dras fee från balance
			
			balance = balance - FEE;
			
		}
		
		if(accountType == "Savings") {
			
			balance = balance*INTEREST;			//om det är savings får man 2% ränta
			
		}
		
		
	}
}

