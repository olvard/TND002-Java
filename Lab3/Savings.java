package laboration3;

public class Savings extends Account {

	public Savings(Current acc, int num) {
		
		super(acc, num);				//kallar p� den andra constructorn i account som �r savings.
		
		balance = 0.0;					//s�tter savings balans till 0.
		
	}
	
	public void changeBalance(double amo) {
		
		balance = balance + amo; //�ndrar savings balans med argumentet
		
		
	}
	
	public double getBalance(){
		return balance;
	}
}
