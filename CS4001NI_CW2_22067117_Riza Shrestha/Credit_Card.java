
/**
 * Write a description of class Credit_Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Credit_Card extends Bank_Card
{
    //artributes
    /*
     * Here private attributes is declare for a Credit_Card class as cvc_number, Credit_limit, interest_rate, expiration_date, grace_period and isGranted.
     *Here private access modifier is used to protect the information within the class and external users cannot change or view the data without authorization.
     */
    private int cvc_number;
    private double credit_limit;
    private double interest_rate;
    private String expiration_date;
    private int grace_period;
    private boolean isGranted; 
    /* Constructors
     * constructor doesnot contain any return type and it's name should be same as class name.
     */
    public Credit_Card( int card_id, String client_name, String issuer_bank, String bank_account, int balance_amount, int cvc_number, double interest_rate,String expiration_date)
       {
            /*A call is made to the parent class Bank_Card constructor with four parameters and a setter methhod setclient_name.*/
           super(balance_amount,card_id, issuer_bank, bank_account);
           super.setclient_name(client_name);
           this.cvc_number=cvc_number;
           this.interest_rate=interest_rate;
           this.expiration_date=expiration_date;
           this.isGranted=false;
       }
       //getters method
    public int getcvc_number()
    {
        return this.cvc_number;
    }
    public double getcredit_limit()
    {
        return this.credit_limit;
    }
    public double getinterest_rate()
    {
        return this.interest_rate;
    }
    public String getexpiration_date()
    {
        return this.expiration_date;
    }
    public int getgrace_period()
    {
        return this.grace_period;
    }
    public boolean getisGranted()
    {
        return this.isGranted;
    }
    //setters method
    public void setcredit_card(double credit_limit,int grace_period)
    {
        if(credit_limit<=(2.5*super.getbalance_amount()))
        /*  Only the credit card is issued to the client if the credit limit is less than or equal to 2.5 times the balance amount of class Bank Card.*/
        {
            this.credit_limit = credit_limit;
            this.grace_period = grace_period;
            this.isGranted = true;
        }
        else{
            System.out.println("Credit card not issued");
        } 
    }
    public void cancelCredit_Card()//cancelCredit_Card removes the client's credit card.
    {
        if(isGranted){
            this.cvc_number = 0;
            this.credit_limit = 0;
            this.grace_period = 0;
            this.isGranted = false;
        }
        else{
            System.out.println("Credit card has not issued");
        }
    }
    //display method
     public void display()
     {
         super.display();
         if(isGranted==true){
            System.out.println("Credit Limit:" + credit_limit);
            System.out.println("Grace Period:" +  grace_period);
        }
        else{
                System.out.println("Credit Denied");
            }
    }
}

