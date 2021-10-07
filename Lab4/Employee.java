package laboration4;

public abstract class Employee implements Comparable<Employee> {

    public static final int BYNAME = 0;

    public static final int BYSALARY = 1;

    public static final int BYTAXES = 2;

    public static int sortCriterion = 0;


   protected String firstName;
   protected String surName;
   protected int number;
   protected double salary;

    /***
     * initializes an instance of first, second, number and salary for an employee
     * @param firstName the first name
     * @param surName the second name
     * @param number the employee number
     * @param salary the salary of the employee
     */

    public Employee(String firstName, String surName, int number, double salary){

        this.firstName = firstName;
        this.surName = surName;
        this.number = number;
        this.salary = salary;

    }

    /***
     * changes the variable sortCriterion to arg
     * @param arg takes in BYNAME, BYSALARY or BYTAXES
     */

    public static void changeCriterion(int arg){

    sortCriterion = arg;

    }


    public abstract double computeTaxes();

    public String getName(){

        return this.surName;
    }

    public int getNumber(){

        return this.number;
    }

    public double getSalary(){

        return this.salary;
    }

    /***
     * creates a formatted string depending on sortCriterion
     * @return returns a formatted string
     */

    public String toString(){

        String output = "";

        if(sortCriterion == BYNAME) {
            output = String.format("%-12s %-12s %-8d", firstName, surName, number);
        }
        else if(sortCriterion == BYSALARY){
            output = String.format("%-12s %-12s %-8d %-13f", firstName, surName, number, salary);
        }
        else if(sortCriterion == BYTAXES){
            output = String.format("%-12s %-12s %-8d %-13f", firstName, surName, number, computeTaxes());
        }
        

        return output;
    }





}
