package laboration3;

import java.util.ArrayList;

public class Current extends Account {

	Customer theCustomer;
	
	ArrayList<Transaction> theTransactions;
	
	public Current(Customer name, int num, double amo) {
		
		super(num);										//kallar på constructor från account som är account current.
		
		theTransactions = new ArrayList<Transaction>();
		
		theCustomer = name;				//ger kunden namn
		
		balance = amo;					//sätter kundens balans
		
	}
	
	public Customer getCustomer() {
		
		return theCustomer;
		
	}
	
	public void transfer(double amount) { 

		
		double amountAbs = Math.abs(amount);  //gör om till absolutbelopp, för att undvika  - -

		if (amount > 0) {						//kolla om ammount är större än 0
			
			if (balance - amountAbs < 0) { //om summan på current kontot är mindre än noll efter pengarna dragits

			amountAbs = balance;    //current kontonts summa till samma summa vi drar


			}

			balance -= amountAbs; 		//och sen drar vi den summan från kontot för att nolla kontot/dra från kontot
			
			otherAccount.balance += amountAbs; //lägger till summan på andra kontot

			theTransactions.add(new Transaction("to", otherAccount.getNumber(),amountAbs));  //lägg till transaction


		} else if (amount < 0) {		//om det man vill dra är mindre än noll betyder det att transaktionen går åt andra hållet.
			
			if(otherAccount.getBalance() - amountAbs < 0) {  //testar om summan på savings kontot blir under noll efter pengarna dragits

				amountAbs = otherAccount.balance; //sätter samma summa som dras till savings kontot balans
			}

			balance += amountAbs; 	//lägger till pengar på current kontot
			otherAccount.balance -= amountAbs;   //drar från savings kontot.

			theTransactions.add(new Transaction("from", otherAccount.getNumber(), amountAbs)); 
		}



	}
	
	public void deposit(Current ToAnother, double amo) {
		
		
		balance += amo;	//lägger till pengar från annat konto på current konto
		
		theTransactions.add(new Transaction("from", ToAnother.accountNumber , amo)); //listar transaktion
	}
	
	public void transfer(Current FromAcc, double amo) {
		
		//oklart kanske funkar
		
		FromAcc.deposit(this, amo); //kallar på deposit
		
		theTransactions.add(new Transaction("to", FromAcc.accountNumber , amo)); //listar transaktionen
		
		balance -= amo; //drar pengar från current konto
		
	}
	
	public String toString() {
		
		String output = String.format("%20s %15s\n", "Customer",theCustomer.getName());			//skriver ut 5 rader formatterad information
		output += String.format("%20s %15s\n", "Account Number", accountNumber);
		output += String.format("%20s %15s\n", "Balance", balance);
		output += String.format("%20s %15s\n", "Savings",otherAccount.getBalance());
		output += String.format("%20s\n" , "List of transactions");
		

		for (int j=0; j < theTransactions.size(); j++) {  				//loopar igenom transactions arrayen och skriver ut den.
			output += theTransactions.get(j).toString() + "\n";
		}
		
		return output;
	
	
}
}
