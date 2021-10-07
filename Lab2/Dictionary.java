package laboration2;

import java.util.ArrayList;


public class Dictionary {

	ArrayList<Word> theDictionary;
	
	public Dictionary() {
		
		theDictionary = new ArrayList<Word>();
		
	}
	
	public void addWords(String arg) {
		
		//n�nting med en for loop som l�gger in ord i arrayen varje g�ng den 
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
           
			
            for(int j = numberOfWords()-1; j > i; j--) //loopa bakl�nges och j�mf�r orden, j �r st�rre �n i f�r att inte ta bort f�rsta ordet
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
		
			int min = i;  // det indexet som �r aktuellt i loopen
			
				for(int j = i+1; j < numberOfWords(); j++) { 
					
					if (theDictionary.get(min).getCounts() < theDictionary.get(j).getCounts()) // s�ker efter ett mindre element
					{ 
						
						min = j; // om det finns s�tter vi det element till minsta
					}
				}
			
				if (min != i) { //kollar om v�rdet p� min har �ndrats, om det har det s� byter vi plats p� elementen.
					
					Word swap = theDictionary.get(i); 
					theDictionary.set(i, theDictionary.get(min)); 
					theDictionary.set(min, swap); 
				}
		}
		
	}

	
	public void countOccurences() {
		
		
		removeDuplicates();
		
		sortDictionaryByCounts();
		
		int current = theDictionary.get(0).getCounts(); //utg�nsv�rde
		int count = 0;
		for(int i = 0; i < numberOfWords(); i++) {  
            
			if(current == theDictionary.get(i).getCounts() && i != numberOfWords()-1) { //om utg�ngsv�rdet e lika med element i counts och skiljd fr�n sista elementet
				count++;
			}
			
           else {
            		System.out.printf("%4d words occured %4d times.\n",count, current); 
            		count = 1;	//om bara ett ord f�rekommer x antal g�nger blir counts 1
            		
            		current = theDictionary.get(i).getCounts();
            		
            	}
            	
            }  
		
	}
	
	
	public String toString() {
		
		String result = ""; // tom string
		
		for(int i = 0; i < numberOfWords(); i++) {
			
			result +=  theDictionary.get(i).toString() + "\n"; // kallar p� toString fr�n word
			
		}
		
		return result;
		
	}
}
