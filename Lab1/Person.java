package laboration1;

public class Person {

	private String firstName;
	private String lastName;
	private int age;
	private Building adress;
	
	public static boolean WITHAGE = true;
	public static boolean NOAGE = true;
	private static boolean theFormat;
	
		public Person(String first, String last, int ager) {
			firstName = first;
			lastName = last;
			age = ager;
			
			
		}
		
		public void setAdress(Building bld) {
			
			adress = bld;
			
			bld.getStreet();
			bld.getNumber();
			
		}
	
		public Building getAdress() {
			
			return adress;
		}
		
		public boolean isPerson(String first, String last, int ager){
			
			if(firstName.equals(first) && lastName.equals(last) && age == ager) {
				
				return true;
			}
			else {
				
				return false;
			}
			
		}
		
		public static void changeFormat(boolean arg) {
			theFormat = arg;
		}
		
		public String toString() {
			
			if(theFormat == false)
			{
				return firstName + " " + lastName + ", " + "Age: " + age;
				
			}
			else 
			{
			
				return firstName + " " + lastName;
			}
			
		}
	
}
