package laboration4;

public class Worker extends Employee{

    public Worker(String firstName, String surname, int number, double salary){
        super(firstName, surname, number, salary);
    }

    /***
     * compareTo method sorts salary,name and taxes depending on sortCriterion
     * @param arg takes employee as argument
     * @return 1, -1 or 0
     */

    public int compareTo(Employee arg){

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
     * computes the tax for a worker by multiplying his salary by 0.25 for 25% tax
     * @return the total tax for a worker
     */

    public double computeTaxes() {
        return this.salary*0.25;
    }
}
