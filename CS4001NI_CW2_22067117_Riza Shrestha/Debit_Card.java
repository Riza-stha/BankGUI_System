
/**
 * Write a description of class Debit_Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Debit_Card extends Bank_Card
{
    // attributes
    /*
     *Here private attributes is declare for a Debit_Card class as pin_number, withdrawal_amount, date_of_Withdrawal and hasWithdrawal.
     *Here private access modifier is used to protect the information within the class and external users cannot change or view the data without authorization.
     */
    private int pin_number;
    private double withdrawal_amount;
    private String date_of_Withdrawal;
    private boolean hasWithdrawn;
    //constructor
    public Debit_Card(double balance_amount,int card_id,String issuer_bank,String bank_account,String client_name, int pin_Number)
    {
        super(balance_amount,card_id,issuer_bank,bank_account);
        super.setclient_name(client_name);
        this.pin_number=pin_Number;
        hasWithdrawn=false;
    }
    // getters methods
    public int getpin_number()
    {
        return this.pin_number;
    }
    public double getwithdrawal_amount()
    {
        return this.withdrawal_amount;
    }
    public String getdate_of_Withdrawal()
    {
        return this.date_of_Withdrawal;
    }
    public boolean gethasWithdrawn()
    {
        return this.hasWithdrawn;
    }
    //setter method for withdrawal amount
    public void setwithdrawal_amount(double withdrawal_amount)
    {
        this.withdrawal_amount=withdrawal_amount;
    }
    /*Withdraw method
     * withdraw method deduct the money directly from the client account.*/
    public void withdraw(double withdrawal_amount, String date_of_Withdrawal, int pin_number)
    { 
        /*If the entered pin_number is valid,
         * withdrawal_amount is less than instance variable balance_amount
         * then only the amount can be wihdrawn.*/
         if(pin_number == this.pin_number){
            if(withdrawal_amount <= getbalance_amount()){
            setbalance_amount(getbalance_amount() - withdrawal_amount);
            this.withdrawal_amount = withdrawal_amount;
            this.date_of_Withdrawal = date_of_Withdrawal;
            hasWithdrawn = true;
            System.out.println("Successfully Withdrawn");/*If the requirements are true than this message is output to the user*/
        }
        else{
            System.out.println("Not Enough Balance");/*If the requirements are not fulfilled then this message is output to the user*/
        }
        } 
    }
    //display method
    public void display()//display the details of Debit_Card.
    {
        super.display();// Calls the display method of parent class Bank_Card.
        System.out.println("Pin Number = " + pin_number);
         if(hasWithdrawn == true){
        System.out.println("Withdrawal Amount = " + this.withdrawal_amount);
        System.out.println("Date of Withdrawal =  " + this.date_of_Withdrawal);
    }
    else{
          System.out.println("Balance Amount = " + this.getbalance_amount());
        }
    }
}
    
    