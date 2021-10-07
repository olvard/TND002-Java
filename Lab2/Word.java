package laboration2;

public class Word {

	private String theWord;
	
	private int counts;
	
	private static int outputFormat;
	
	public Word(String ord) {
		
		theWord = ord;
		
		counts = 1;
		
	}
	
	public String getWord() {
		
		return theWord;
		
	}
	
	public int getCounts() {
		
		return counts;
		
	}
	
	public void increaseCounts() {
		
		counts = counts +1;
		
	}
	
	public static void changeOutputFormat(int arg) {
		
		if(arg == 0) {
			outputFormat = 0;
		}
		
		if(arg != 0){
			outputFormat = 1;
		}
		
	}
		
	
	public String toString() {
		
		String retur = null;
		
		if(outputFormat == 0) {
			retur =  "The word " + theWord + " has occured " + counts + " times.";
		}
		
		if(outputFormat == 1) {
			retur = "The word is: " + theWord;
		}
		
		return retur;
	}
	
}
