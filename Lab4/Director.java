package laboration4;

import java.util.ArrayList;

public class Director extends Employee{

    ArrayList<Worker> WORKERS;

    public Director(String name, String surname, int number, double salary){

        super(name, surname, number, salary);

        WORKERS = new ArrayList<Worker>();
    }

    /***
     * computes the taxes for a director, adds the bonus to the salary and multiplies by 0.25
     * @return the calculated tax
     */

    public double computeTaxes() {

        double total = this.salary + computeBonus();

        return total*0.25;
    }

    /***
     * compareTo method sorts salary,name and taxes depending on sortCriterion
     * @param arg takes employee as argument
     * @return 1, -1 or 0
     */

    public int compareTo(Employee arg) {
        int result = 1337;

        if(sortCriterion == BYSALARY) {


            if (arg.getSalary() > this.salary) {
                result = 1;
            }

            if (arg.getSalary() < this.salary) {
                result = -1;
            }

            if (arg.getSalary() == this.salary) {
                result = 0;
            }
        }

        if(sortCriterion == BYNAME) {

            //result = arg.getName().compareTo(this.surName);

            if (arg.getName().charAt(0) < this.surName.charAt(0)) {
                result = 1;
            }

            if (arg.getName().charAt(0) > this.surName.charAt(0)){
                result = -1;
            }

            if (arg.getName().equals(this.surName)) {
                result = 0;
            }
        }

        if(sortCriterion == BYTAXES) {

            if (arg.computeTaxes() > this.computeTaxes()) {
                result = 1;
            }

            if (arg.computeTaxes() < this.computeTaxes()){
                result = -1;
            }

            if (arg.computeTaxes() == this.computeTaxes()) {
                result = 0;
            }
        }

        return result;
    }

    /***
     * adds a worker to the arraylist of workers
     * @param arg takes worker as argument
     */

    public void addEmployee(Worker arg){

        WORKERS.add(arg);

    }

    /***
     * calculates the bonus by looping through the arraylist of workers and summing their salaries
     * @return the cumulative sum of the salarys of the workers multiplied by 0.1 for 10% bonus
     */

    public double computeBonus(){

        double bonus = 0;

        for(int i = 0; i < WORKERS.size(); i++){

            bonus += WORKERS.get(i).getSalary();

        }

        bonus = bonus*0.1;

        return bonus;
    }
}
