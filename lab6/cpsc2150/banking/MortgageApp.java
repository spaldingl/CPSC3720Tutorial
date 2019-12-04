package cpsc2150.banking;

/**
 * Created by kplis on 1/23/2018.
 */
public class MortgageApp {

    public static void main(String [] args)
    {
        double cost = 150000;
        double dp = 30000;
        int y = 30;

        //customer constructor
        double debt = 100;
        double inc = 60000;
        int score = 725;
        String name = "Billy Bob";

        ICustomer c = new Customer(debt, inc, score, name);
        c.applyForLoan(dp, cost, y);



        System.out.println(c.toString());


    }
}
