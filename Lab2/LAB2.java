package laboration2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LAB2 {
	
	private static BufferedReader consoleReader;
	
	private static BufferedReader fileReader;
	
	private static BufferedWriter fileWriter;
	
	

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		Dictionary test = new Dictionary(); // ny instans
		
		boolean run = true; // kontroll bool
		
		while(run) {
			
		switch(consoleInput("Select Option: ")) {
		
		case "end":
			
			System.out.println("bye"); // bryter while loopen
			run = false;
			break;
			
		case "1":
			
			//laddar in ny fil, fr�gar efter filnamnet och h�mtar. L�gger till orden fr�n filen med addwords i test arraylist
			
			System.out.println("Load from file\n");
			
			File inputFile = new File(consoleInput("Filename: ")); 
			
			try 
			{
				fileReader = new BufferedReader(new FileReader(inputFile)); 
				test.addWords(fileReader.readLine());
				
			}  
			catch (FileNotFoundException e) {
			    	
				System.out.println("File does not exist");
			    	
			    }
			
			catch(IOException e) {
			    
				System.out.println("IO error");
			}
			     
			break;
			
		case "2":
			
			//skriver ut en lista med alla ord, man kan v�lja output format genom att kalla p� changeformat fr�n klassen word.
			
			System.out.println("List content");
			
			String answer = consoleInput("Output format (0 or 1): ");
			
			Word.changeOutputFormat((Integer.parseInt(answer))); // Parse integer f�r att kunna anv�nda answer som �r en string som en int
			
			System.out.println(test.toString());
			
			break;
			
		case "3":
			
			System.out.println("Remove doubles and sort by number of counts"); //kallar p� metoder fr�n dictionary
			test.removeDuplicates();
			test.sortDictionaryByCounts();
			
			break;
			
		case "4":
			
			System.out.println("Count occureneces");
			
			test.countOccurences();
			
			break;
			
		case "5":
			
			//Skriver ut till en fil, fr�gar efter filnamn
			
			System.out.println("Save to file\n");
			
			try { 
				fileWriter = new BufferedWriter(new FileWriter(consoleInput("Filename: "))); //ny instans av bufferedwriter och filewriter 
				fileWriter.write(test.toString());
				fileWriter.close(); 
			} catch (IOException e) { 
				e.printStackTrace();   //standard error
			}
			
			break;
			
		default:
			
			System.out.println("Try again");
		
		}
	
		
		
	}
		
		
		
	}
	
	public static String consoleInput(String arg) throws IOException {
		
		consoleReader = new BufferedReader(new InputStreamReader(System.in));		//s�tter consolereader till en ny input stream

		try {
		
		System.out.println(arg); //fr�gan
		
		
		String answer = consoleReader.readLine(); //l�ser svaret
		
		
		return answer;
		}
		catch(IOException e){
			return " ";
		}
		
		
		
		
		
		
	
	}

	
}
