package laboration3;

import java.util.ArrayList;

public class Bank {

	ArrayList<Customer> customerList;
	ArrayList<Account> accountList;
	
	int accountNumber;
	
	public Bank() {
		
		customerList = new ArrayList<Customer>();
		
		accountList = new ArrayList<Account>();
		
		accountNumber = 1000;					//s�tter f�rsta(konto o) kontonr till 1000
	}
	
	public String addCustomer(String name, double amo) {
		
		
		boolean control = false;								//testar om en person finns i customerList array
		String status= "Customer added";						//control bool blir true eller false
		for (Customer dummy : customerList) 
		{
			if (dummy.getName().equals(name)) {
				control = true;
				status = "The customer already exists";
				
			}
			
			break;

		}		

		if (!control) {											//om control �r false l�gger vi till en ny person med konton
			
			Customer newdummy = new Customer(name);
			Current newDummyCurr = new Current(newdummy,accountNumber++,amo);		
			Savings newDummySav = new Savings(newDummyCurr, accountNumber++);
			newdummy.addAccounts(newDummyCurr, newDummySav);
			customerList.add(newdummy);
			accountList.add(newDummySav);
			accountList.add(newDummyCurr);
		}
		
	
		
		return status;    //returnar stringen i toppen
		
	}
	
	public Customer findCustomer(String name) {
		
		Customer found = null;					//g�r en kontroll customer = null fr�n b�rjan
		
		for(Customer dummy : customerList) {
			if(dummy.getName().equals(name)) {			//g�r en range based loop som kollar om en customer med de namn som loopen �r p� finns
														//om det finns s�tter vi found till den personen
				found = dummy;
				break;
			}
		}
		
		if(found == null) {										//om den fortfarande �r null finns inte personen
			System.out.println("Customer does not exist");
		}
		
		return found;											//returna person
	}	
	
	public void transfer(String name, double amo) {
		
		Customer dummy = findCustomer(name);					//kallar p� findcustomer om findcustomer returnar en person(inte null) s� g�r en transfer till dennes current account.
		
		if(dummy!=null) {
			dummy.getCurrentAccount().transfer(amo);
		}
		
		
		
	}
	
	public void transfer(String name, String name2, double amo) {
		
		Customer from = findCustomer(name);										//kallar p� findcustomer tv� ggr
		Customer to = findCustomer(name2);
		
		from.getCurrentAccount().transfer(to.getCurrentAccount(),amo);				//skickar pengar mellan name och name2 genom att kalla p� transfer fr�n current.
		
		
	}
	
	public String checkAccount(int num) {
		
		
		String result = "Not a current account";			//s�tter string till detta
		
		int number = num+1 - 1000;							//num �r accountnr vi l�gger + 1 f�r att inte missa 1 eller sista personen
		
		if (number < accountList.size()) 													//kolla igenom accountlist
		{
			if (accountList.get(number).getAccountType().equals("Current")) {			//om det finns ett currentkonto f�r detta kontonr
				
				result = accountList.get(number).toString();						//skriv ut informationen om detta kontonr
			}
		}		
		
		return result;
		
	}
	
	public void annualChange() {
		
		for(Account accounts : accountList) {				//kollar igenom alla accounts och ger varje konto fee och interest med hj�lp av den metoden fr�n account
			accounts.annualChange();
		}
		
		
	}
	
	public String toString() {
		
		double amount = 0; 
		
		
		for( int i = 0; i < accountList.size(); i++) {								//kollar igenom listan med kontonr, h�mta alla deras kontobalans och l�gger det i en VB
			
			amount = amount + accountList.get(i).getBalance(); 
			
		}
		
		
		String txt = "Bank statistics\n";
		String utxt = "-------------------------\n";

		String txt2 = String.format("%10s %12d\n","Customers: ",customerList.size());				//skriver ut hur m�nga kunder som finns formaterat
		
		String txt3 = String.format("%11s %13.2f\n","Money: ",amount); 		//skriver ut hur mycket pengar som finns i banken formaterat
		
		
		return txt + utxt + txt2 + txt3; //l�gger ihop stringen
	}
}
