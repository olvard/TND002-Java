package laboration1;

import java.util.ArrayList;

public class Building {
	
	private ArrayList<Person> residents;
	
	private int number;
	
	private String streetName;
	
	
		public Building(String streetN, int num) {
			streetName = streetN;
			number = num;
			
			residents = new ArrayList<Person>();
			
		}
		
		public boolean addPerson(Person x) {
			
			//for loop kolla om personen finns i arrayen, om inte true + add.
			
			boolean result = true;
			
			Person dummy;
			
			for(int i = 0; i < residents.size(); i++) {
				
				dummy = residents.get(i);
				
				if(dummy == x){
					result = false;
					
				}
				
			}
			
			if(result) {
			residents.add(x);
			
			}
			return result;
		}
		
		public void removePerson(Person x) {
			
			for(int i = 0; i < residents.size(); i++) {
				
				
				if(residents.get(i) == x)
				{
					
					residents.remove(i);
				}
				
			}
			
		}
		
		public int getNumber(){
			
			return number;
			
		}
		
		public String getStreet() {
			
			return streetName;
		}
		
		public int residents() {
			
			return residents.size();
			
			
		}
		
		public String toString() {
			
			return streetName + " " + number + " ,Number of residents: " + residents();
			
		}

}
