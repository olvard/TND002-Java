package laboration4;

import java.util.ArrayList;
import java.util.Collections;

public class Company {

    ArrayList<Employee> ALL;

    public Company(){

        ALL = new ArrayList<Employee>();

    }

    /***
     * adds and director the arraylist of employess
     * @param arg takes in a director as argument
     */

    public void addEmployee(Director arg){

        ALL.add(arg);
    }

    /***
     * adds a worker to the arraylist of employess and a worker to the director
     * @param arg1 A worker
     * @param arg2 A director
     */

    public void addEmployee(Worker arg1, Director arg2){

        ALL.add(arg1);
        arg2.addEmployee(arg1);

    }

    /***
     * to string method returns a concatenated string that varies depending on sortCriterion
     * @return returns a concatenated string
     */

    public String toString(){

        String output ="";

        output += "List of Employees" + "\n";
        output += "--------------------------" + "\n";

        if(Employee.sortCriterion == Employee.BYNAME) {
            output += String.format("%-12s %-12s %-8s\n", "First name", "Surname", "Number");


        }

        if(Employee.sortCriterion == Employee.BYSALARY) {
            output += String.format("%-12s %-12s %-8s %-13s\n", "First name", "Surname", "Number", "Salary");


        }

        if(Employee.sortCriterion == Employee.BYTAXES) {
            output += String.format("%-12s %-12s %-8s %-13s\n", "First name", "Surname", "Number", "Tax");


        }

        Collections.sort(ALL);

        for(int e = 0; e < ALL.size(); e++){

            output += ALL.get(e).toString() + "\n";
        }


        return output;
    }
}
