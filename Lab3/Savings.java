package laboration3;

public class Savings extends Account {

	public Savings(Current acc, int num) {
		
		super(acc, num);				//kallar på den andra constructorn i account som är savings.
		
		balance = 0.0;					//sätter savings balans till 0.
		
	}
	
	public void changeBalance(double amo) {
		
		balance = balance + amo; //ändrar savings balans med argumentet
		
		
	}
	
	public double getBalance(){
		return balance;
	}
}
