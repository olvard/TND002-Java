package laboration1;

import java.util.ArrayList;

public class Inhabitants {

	ArrayList<Person> thePeople;
	
		public Inhabitants() {
			
			thePeople = new ArrayList<Person>();
			
		}
	
		public Person addPerson(String first, String last, int age) {
			
			//loopa igenom thePeople och kolla om personen first last age finns, om inte lägg till personen i arrayen
			
			Person subject = searchPerson(first, last, age);
			
			
			if(subject != null) {

				return null;
			}
			else {
				
				subject = new Person(first, last, age);
				thePeople.add(subject);
				return subject;
			}
			
			
		
			
			
			
		}
		
		public Person searchPerson(String first, String last, int age) {
			
			Person object = null;			
			
			
			for(int i = 0; i < thePeople.size(); i++) {
				
				
				if(thePeople.get(i).isPerson(first, last, age)) {
					object = thePeople.get(i);
					
				}
				
			}
			
			return object;
			
			
		}
		
		
		
		
		public String getNumberOfPeople() {
			
			return "Number of people: " + thePeople.size();
			
		}
		
		public String toString() {
			
			String result = new String();
			
			for(int i = 0; i < thePeople.size(); i++) {
				
				result = result + thePeople.get(i) + "\n";
				
			}
			
			
			return "List of inhabitants:\n" + result;
			
		}
}
