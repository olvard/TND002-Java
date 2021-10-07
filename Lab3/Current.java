package laboration3;

import java.util.ArrayList;

public class Current extends Account {

	Customer theCustomer;
	
	ArrayList<Transaction> theTransactions;
	
	public Current(Customer name, int num, double amo) {
		
		super(num);										//kallar p� constructor fr�n account som �r account current.
		
		theTransactions = new ArrayList<Transaction>();
		
		theCustomer = name;				//ger kunden namn
		
		balance = amo;					//s�tter kundens balans
		
	}
	
	public Customer getCustomer() {
		
		return theCustomer;
		
	}
	
	public void transfer(double amount) { 

		
		double amountAbs = Math.abs(amount);  //g�r om till absolutbelopp, f�r att undvika  - -

		if (amount > 0) {						//kolla om ammount �r st�rre �n 0
			
			if (balance - amountAbs < 0) { //om summan p� current kontot �r mindre �n noll efter pengarna dragits

			amountAbs = balance;    //current kontonts summa till samma summa vi drar


			}

			balance -= amountAbs; 		//och sen drar vi den summan fr�n kontot f�r att nolla kontot/dra fr�n kontot
			
			otherAccount.balance += amountAbs; //l�gger till summan p� andra kontot

			theTransactions.add(new Transaction("to", otherAccount.getNumber(),amountAbs));  //l�gg till transaction


		} else if (amount < 0) {		//om det man vill dra �r mindre �n noll betyder det att transaktionen g�r �t andra h�llet.
			
			if(otherAccount.getBalance() - amountAbs < 0) {  //testar om summan p� savings kontot blir under noll efter pengarna dragits

				amountAbs = otherAccount.balance; //s�tter samma summa som dras till savings kontot balans
			}

			balance += amountAbs; 	//l�gger till pengar p� current kontot
			otherAccount.balance -= amountAbs;   //drar fr�n savings kontot.

			theTransactions.add(new Transaction("from", otherAccount.getNumber(), amountAbs)); 
		}



	}
	
	public void deposit(Current ToAnother, double amo) {
		
		
		balance += amo;	//l�gger till pengar fr�n annat konto p� current konto
		
		theTransactions.add(new Transaction("from", ToAnother.accountNumber , amo)); //listar transaktion
	}
	
	public void transfer(Current FromAcc, double amo) {
		
		//oklart kanske funkar
		
		FromAcc.deposit(this, amo); //kallar p� deposit
		
		theTransactions.add(new Transaction("to", FromAcc.accountNumber , amo)); //listar transaktionen
		
		balance -= amo; //drar pengar fr�n current konto
		
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
