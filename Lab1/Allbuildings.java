package laboration1;

import java.util.ArrayList;

public class Allbuildings {
	
	ArrayList<Building> theBuildings;
	
		public Allbuildings() {
			
			theBuildings = new ArrayList<Building>();
			
		}
	
		public Building getBuilding(String streetn, int num) {
			
			Building result;
			
			for(int i = 0; i < theBuildings.size(); i++) {
				
				result = theBuildings.get(i);
				
				if(result.getStreet().equals(streetn) && result.getNumber() == num) {
					
					System.out.println("Building already exists.");
					
					return result;
					 
				}
				
				
			}
			
				
			result = new Building(streetn, num);
			theBuildings.add(result);
			System.out.println("Building added.");
			
			
			return result;
			
		}
		
		public String getNumberOfBuildings() {
			
			return "Number of buildings: " + theBuildings.size() + "\n";
			
		}
		
		public void cleanUp() {
			
			
			
			for(int i = 0; i < theBuildings.size(); i++) {
				
				if(theBuildings.get(i).residents() == 0) {
					
					theBuildings.remove(i);
				}
				
			}
			
		}
		
		public String toString() {
			
			String result = new String();
			
			for(int i = 0; i < theBuildings.size(); i++) {
				
				result =  result + theBuildings.get(i) + "\n";
				
			}
			
			return "List of all buildings:\n " + result;
			
		}

}
