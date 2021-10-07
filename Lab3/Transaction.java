package laboration3;

public class Transaction {

	int theAccount;
	
	double theAmount;
	
	String tofrom;
	
	public Transaction(String name, int num, double amo) {
		
		theAccount = num;									//transaction definieras av kontonr, summa och vem
		
		theAmount = amo;
		
		tofrom = name;
		
		
	}
	
	public String toString() {
		
		String output = String.format("Money Transfer %5s Account %4d : %8.2f",tofrom, theAccount, theAmount);  //to string visar var pengar gick t vem och hur mkt
																												//8.2 8 siffror innan reserverade innan decimal 2 efter f för float.
		
		return output;
	}
	
}
