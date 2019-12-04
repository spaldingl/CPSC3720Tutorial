package cpsc2150.mortgages;

/**
 * This is the Controller that partners with IMortgageView
 *
 * Defines: View: The IMortgageView
 * Initialization ensures: View != NULL
 */

public class MortgageController implements IMortgageController {

    IMortgageView view;

    public MortgageController(IMortgageView view) {
        this.view = view;
    }


    /**
     * This will handle the processing of a mortgage application
     * @pre: none
     * @post: none
     */
    public void submitApplication() {

        boolean newMort = true;
        boolean newCust = true;
        double cost;
        double down;
        int years;
        ICustomer Cust;
        IMortgage Mortgage;
        double debt;
        double income;
        int score;
        String name;


        while (newCust == true) {

            newMort = true;
            name = view.getName();

            //income
            income = view.getYearlyIncome();
            while (income <= 0) {
                String error = "Income must be greater than 0.";
                view.printToUser(error);
                income = view.getYearlyIncome();
            }

            //debt
            debt = view.getMonthlyDebt();
            while (debt < 0) {
                String error = "Debt must to be greater than or equal to 0.";
                view.printToUser(error);
                debt = view.getMonthlyDebt();
            }



            //credit score
            score = view.getCreditScore();
            while (score <= 0 || score >= 850) {
                String error = "Credit Score must be greater than 0 and less than 850";
                view.printToUser(error);
                score = view.getCreditScore();
            }

            while (newMort == true) {
                //house cost
                cost = view.getHouseCost();
                while (cost <= 0) {
                    String error = "Cost must be greater than 0.";
                    view.printToUser(error);
                    cost = view.getHouseCost();
                }

                //down payment
                down = view.getDownPayment();
                while (down <= 0 || down >= cost) {
                    String error = "Down Payment must be greater than 0 and less than the cost of the house.";
                    view.printToUser(error);
                    down = view.getDownPayment();
                }

                //years on loan
                years = view.getYears();
                while (years <= 0) {
                    String error = "Years must be greater than 0";
                    view.printToUser(error);
                    years = view.getYears();
                }


                //create new customer and mortgage
                Cust = new Customer(debt, income, score, name);
                Mortgage = new Mortgage(cost, down, years, Cust);
                view.printToUser(Cust.toString());
                view.printToUser(Mortgage.toString());

                newMort = view.getAnotherMortgage();
            }
            if(newMort == false) {
                newCust = view.getAnotherCustomer();
            }
        }


    }
}
