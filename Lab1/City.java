package laboration1;

public class City {
	
	private Allbuildings infrastructure;
	
	private Inhabitants people;
	
	public City() {
		
		infrastructure = new Allbuildings();
		
		people = new Inhabitants();
		
	}
	
	
	public void addPerson(String first, String last, int age, String street, int num) {
		
		Person dummy = people.addPerson(first, last, age);
		
		if(dummy != null)
		{
			
			Building bld = infrastructure.getBuilding(street, num);
			bld.addPerson(dummy);
			dummy.setAdress(bld);
			System.out.println("Person added.");
		}
		else
		{
			
			System.out.println("Person exists.");
			
		};
		
		
		
		
	}
	
	public void movePerson(String first, String last, int age, String street, int num) {
		
		Person p = people.searchPerson(first, last, age);
		
		
		
		if(p != null) {
			
			p.getAdress().removePerson(p);
			Building bld = infrastructure.getBuilding(street, num);
			bld.addPerson(p);
			p.setAdress(bld);
			infrastructure.cleanUp();
			
			
		}
		
	
		
		
	}
	
	public String listBuildings() {
		
		
		return this.infrastructure.toString();
		
	}
	
	public String listPeople() {
		
		return this.people.toString();
		
	}
	
	public String toString() {
		
		return "City statistics: \n " +  infrastructure.getNumberOfBuildings() + people.getNumberOfPeople();
		
	}

}
