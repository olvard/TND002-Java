package laboration3;

public class Customer {

	String name;
	
	Current currentAccount;
	
	Savings savingsAccount;
	
	public Customer(String n) {
		
		name = n;
		
	}
	
	public String getName() {
		
		return name;
	}
	
	public Current getCurrentAccount() {
		
		return currentAccount;
	}
	
	public void addAccounts(Current ac1, Savings ac2) {
		
		currentAccount = ac1;
		
		savingsAccount = ac2;

	}
	
	public String toString() {
		
		String output = "";
		
		output += String.format("%16s %15s\n","Name of customer", name);
		
		
		if(currentAccount != null && savingsAccount != null) {											//testar ifall current och savings konto finns
			output += String.format("%16s %15d\n","Current account", currentAccount.getNumber());		//om det finns skriver vi ut nummer för båda. formaterat
			output += String.format("%16s %15d\n","Savings account", savingsAccount.getNumber());
		}
		
		return output;
		
		
		
	}
	
}
