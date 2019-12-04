package cpsc2150.banking;

import sun.java2d.pipe.AlphaPaintPipe;

import java.util.stream.StreamSupport;

import static java.lang.Math.pow;

/**
 * @author Spalding Latham 3/8/2019
 * @invariants - down > .035
 *             - 15 >= years >= 30
 *             - principal > 0
 *             - cost > 0
 */
public class Mortgage extends AbsMortgage implements IMortgage {
    private double down;
    private int years;
    private ICustomer customer;
    private double payments;
    private double principal;
    private double cost;
    private double debtToIncome;
    private int numPayments;
    private double percentDown;
    private double YEARS_UNDER_ADD = .005;
    private double YEARS_OVER_ADD = .01;
    private double DOWN_NOT_PREFERRED_ADD = .005;

    /**
     *
     * @param cost cost of the house
     * @param down down payment customer puts on the house
     * @param years amount of years for the loan
     * @param customer customer object that holds loan values
     * @requires cost > 0 && down > .035 && 15 <= years <= 30
     * @ensures this.down = down && this.cost = cost && this.years = years && this.customer = customer
     *          && principal = getPrincipal && payments = getPayment && numPayments = years / 12
     *          && percentDown = down / cost
     */
    Mortgage(double cost, double down, int years, ICustomer customer){
            this.down = down;
            this.cost = cost;
            this.years = years;
            this.customer = customer;

            principal = getPrincipal();
            payments = getPayment();


            numPayments = years * 12;
            percentDown = down / cost;



    }


    /**
     *
     * @return true if the loan is approved, false otherwise
     *
     * @post loanApproved iff (Rate*12 < RATE_TOO_HIGH and PercentDown >= MIN_PERCENT_DOWN and DebtToIncomeRatio <= DTOITOOHIGH)
     */
    public boolean loanApproved(){
        boolean approval = false;

        debtToIncome = (customer.getMonthlyDebtPayments() + payments) / (customer.getIncome() / 12);
        //check loan requirements
        if(((getRate()) < RATETOOHIGH) && (percentDown >= MIN_PERCENT_DOWN) && (debtToIncome <= DTOITOOHIGH)){
            approval = true;
        }
        return approval;

    }

    /**
     *
     * @return the monthly payment on the loan
     *
     * @post getPayment = Payment
     */
    public double getPayment(){


        double pay = 0;
        numPayments = years * 12;
        pay = ((getRate() / 12) * getPrincipal()) / (1 - pow((1 + (getRate() / 12)), (-1 * (years * 12))));

        return pay;

    }


    /**
     *
     * @return the interest rate (apr) for this customer
     * @pre:
     * @post getRate = Rate * 12
     */
    public double getRate(){
        int credit = customer.getCreditScore();
        double rate = .025;

        if(years < MAX_YEARS){
            rate += YEARS_UNDER_ADD;
        } else {
            rate += YEARS_OVER_ADD;
        }

        if(percentDown < PREFERRED_PERCENT_DOWN){
            rate += DOWN_NOT_PREFERRED_ADD;
        }

        if(credit < BADCREDIT){
            rate += VERYBADRATEADD;
        }
        else if((credit >= BADCREDIT) && (credit < FAIRCREDIT)){
            rate += BADRATEADD;
        }
        else if((credit >= FAIRCREDIT) && (credit < GOODCREDIT)){
            rate += NORMALRATEADD;
        }
        else if((credit >= GOODCREDIT) && (credit < GREATCREDIT)){
            rate += GOODRATEADD;
        }

        return rate;
    }

    /**
     *
     * @return the principal amount of the loan
     * @post getPrincipal = Principal
     */
    public double getPrincipal(){
        return(cost - down);
    }


    /**
     *
     * @return the number of years the loan is for
     * @post getYears = Years
     */
    public int getYears(){
        return years;
    }



}
