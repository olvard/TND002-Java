package laboration2;

import java.util.ArrayList;


public class Dictionary {

	ArrayList<Word> theDictionary;
	
	public Dictionary() {
		
		theDictionary = new ArrayList<Word>();
		
	}
	
	public void addWords(String arg) {
		
		//nånting med en for loop som lägger in ord i arrayen varje gång den 
		//hittar ett " "

		String[] string = arg.split("\\s+"); 

		
		for(int i = 0; i < string.length; i++) {
			
			theDictionary.add(new Word(string[i]));
		
		}
		
		
		
	}
	
	public int numberOfWords() {
		
		return theDictionary.size();
		
	}
	
	public void removeDuplicates() {

		for(int i = 0; i < numberOfWords(); i++) {  //loopa genom varje ord i arraryen
           
			
            for(int j = numberOfWords()-1; j > i; j--) //loopa baklänges och jämför orden, j är större än i för att inte ta bort första ordet
            {  
       
            	
                if(theDictionary.get(i).getWord().equals(theDictionary.get(j).getWord()))
 
                {  

                	theDictionary.get(i).increaseCounts();
                	theDictionary.remove(j);
                    
                }  
            }  
              
		}
		
	}
	
	public void sortDictionaryByCounts() 
	{
		
		for (int i = 0; i < numberOfWords() - 1; i++){ //
		
			int min = i;  // det indexet som är aktuellt i loopen
			
				for(int j = i+1; j < numberOfWords(); j++) { 
					
					if (theDictionary.get(min).getCounts() < theDictionary.get(j).getCounts()) // söker efter ett mindre element
					{ 
						
						min = j; // om det finns sätter vi det element till minsta
					}
				}
			
				if (min != i) { //kollar om värdet på min har ändrats, om det har det så byter vi plats på elementen.
					
					Word swap = theDictionary.get(i); 
					theDictionary.set(i, theDictionary.get(min)); 
					theDictionary.set(min, swap); 
				}
		}
		
	}

	
	public void countOccurences() {
		
		
		removeDuplicates();
		
		sortDictionaryByCounts();
		
		int current = theDictionary.get(0).getCounts(); //utgånsvärde
		int count = 0;
		for(int i = 0; i < numberOfWords(); i++) {  
            
			if(current == theDictionary.get(i).getCounts() && i != numberOfWords()-1) { //om utgångsvärdet e lika med element i counts och skiljd från sista elementet
				count++;
			}
			
           else {
            		System.out.printf("%4d words occured %4d times.\n",count, current); 
            		count = 1;	//om bara ett ord förekommer x antal gånger blir counts 1
            		
            		current = theDictionary.get(i).getCounts();
            		
            	}
            	
            }  
		
	}
	
	
	public String toString() {
		
		String result = ""; // tom string
		
		for(int i = 0; i < numberOfWords(); i++) {
			
			result +=  theDictionary.get(i).toString() + "\n"; // kallar på toString från word
			
		}
		
		return result;
		
	}
}
