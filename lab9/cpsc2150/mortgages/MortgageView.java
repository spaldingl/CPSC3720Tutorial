package cpsc2150.mortgages;
import java.util.*;

public class MortgageView implements IMortgageView{

    IMortgageController controller;
    Scanner in = new Scanner(System.in);

    /**
     *
     * @param c the Controller object
     * @pre c != NULL
     * @post = Controller = c
     */
    public void setController(IMortgageController c) {
        controller = c;
    }

    /**
     *
     * @return the house cost provided by the user
     */
    public double getHouseCost() {
        System.out.println("How much does the house cost?");
        double cost = in.nextDouble();
        return cost;


    }

    /**
     *
     * @return the down payment provided by the user
     */
    public double getDownPayment() {
        System.out.println("How much is the down payment?");
        double down = in.nextDouble();
        return down;
    }

    /**
     *
     * @return the years provided by the user
     */
    public int getYears() {
        System.out.println("How many years?");
        int years = in.nextInt();
        return years;
    }

    /**
     *
     * @return the monthly debt provided by the user
     */
    public double getMonthlyDebt() {
        System.out.println("How much are your monthly debt payments?");
        double payments = in.nextDouble();
        return payments;
    }

    /**
     *
     * @return the income provided by the user
     */
    public double getYearlyIncome() {
        System.out.println("How much is your yearly income?");
        in.nextLine();
        double income = in.nextDouble();
        in.nextLine();
        return income;
    }

    /**
     *
     * @return the credit score provided by the user
     */
    public int getCreditScore() {
        System.out.println("What is your credit score?");
        int creditScore = in.nextInt();
        return creditScore;
    }

    /**
     *
     * @return the name provided by the user
     */
    public String getName() {
        System.out.println("What's your name?");
        return(in.next());
    }

    /**
     *
     * @param s the message to provide to the user
     */
    public void printToUser(String s) {
        System.out.println(s);
    }

    /**
     *
     * @param p the monthly payment amount for the loan
     * @requires p >= 0
     */
    public void displayPayment(double p) {
        System.out.println("Monthly Payment: $" + p + "\n");
    }

    /**
     *
     * @param r the (APR) interest rate for the loan
     * @pre 0 <= r <= 1
     */
    public void displayRate(double r) {
        System.out.println("Interest Rate: " + r + "%");
    }

    /**
     *
     * @param a whether or not the mortgage application was approved
     * @pre a iff [loan was approved]
     */
    public void displayApproved(boolean a) {
    }

    /**
     *
     * @return whether or not the user would like to apply for another mortgage with the same customer
     */
    public boolean getAnotherMortgage() {
        Scanner in2 = new Scanner(System.in);
        boolean getAnother = false;
        System.out.println("Would you like to apply for another mortgage? Y/N");
        char another = in2.next().charAt(0);
        if (another == 'y' || another == 'Y') {
            getAnother = true;
        }

        return getAnother;

    }

    /**
     *
     * @return whether or not the user would like to enter another customer
     */
    public boolean getAnotherCustomer() {
        Scanner in3 = new Scanner(System.in);
        System.out.println("Would you like to consider another customer? Y/N");
        boolean getAnother = false;

        char another = in3.next().charAt(0);
        if (another == 'y' || another == 'Y') {
            getAnother = true;
        }
        return getAnother;

    }
}

