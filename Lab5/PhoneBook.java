import java.io.*;
import java.util.ArrayList;

public class PhoneBook {

    private ArrayList<Person> listOfNumbers;
    private BufferedReader reader;


    public PhoneBook(){

        listOfNumbers = new ArrayList<Person>();

    }

    public String load(String filename) throws FileNotFoundException {

        String answer = "Phone book loaded";
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String aLine;
        String[] dummy;

        try {
            while (!((aLine = reader.readLine()) == null)) {
                dummy = aLine.split(" +");
                listOfNumbers.add(new Person(dummy[0], dummy[1], Integer.parseInt(dummy[2])));
            }
            reader.close();

        }catch(IOException e){

            answer = "Try again";

        }

        return answer;
    }

    public ArrayList<Person> search(String nameOrnum) {

        ArrayList<Person> found = new ArrayList<Person>();

        try {
            int ifNum = Integer.valueOf(nameOrnum);
            for (int i = 0; i < listOfNumbers.size(); i++) {

                if (listOfNumbers.get(i).getPhoneNumber() == ifNum)

                    found.add(listOfNumbers.get(i));
            }
        }catch(NumberFormatException ierr){
            for (int j = 0; j < listOfNumbers.size(); j++) {

                if (listOfNumbers.get(j).getSurname().equals(nameOrnum))

                    found.add(listOfNumbers.get(j));
            }
        }
        return found;
    }

    public boolean addPerson(String fullName, int number) {

        boolean NOexists = true;

        String[] firstSecond = fullName.split(" ");

        String first = firstSecond[0];
        String second = firstSecond[1];

        Person dummy;

        for (int j=0; j < listOfNumbers.size(); j++) {
            dummy = listOfNumbers.get(j);

            if (dummy.getFullName().equals(first + " " + second) || dummy.getPhoneNumber() == number) {
                NOexists = false;
            }
        }

        if (NOexists) {
            listOfNumbers.add(new Person(first, second, number));
        }

        return NOexists;
    }

    public String deletePerson(int inNumber, String inName) {

        String answer = "the person/number does not exist.";

        for(int i = 0; i < listOfNumbers.size(); i++ ){

            if(listOfNumbers.get(i).getFullName().equals(inName) && listOfNumbers.get(i).getPhoneNumber() == inNumber){
                listOfNumbers.remove(i);
                answer = "Person deleted.";
            }

        }

        return answer;

    }


    public String save(String filename) throws IOException {

        String answer = "Saved " + listOfNumbers.size() + " people to the file";
        String result = "";

        try {
            File outputFile = new File(filename);
            outputFile.createNewFile();
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            for (int j = 0; j < listOfNumbers.size(); j++) {
                result = listOfNumbers.get(j).getFullName() + " " + listOfNumbers.get(j).getPhoneNumber() + "\n";
                writer.write(result);
                writer.newLine();
            }
            writer.close();

        }catch(IOException e){
            answer = "Could not save to the file";
        }

        return answer;
    }
}
