
/**
 * Write a description of class Bank_Card here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Bank_Card
{    
    /* 
     *Here private attributes is declare for a Bank_Card class as card_id, client_name,issuer_bank,bank_account, and balance_amount.
     *Here private access modifier is used to protect the information within the class and external users cannot change or view the data without authorization.
     */
    private int card_id ;
    private String client_name;
    private String issuer_bank;
    private double balance_amount;
    private String bank_account;
    
    public Bank_Card(double balance_amount,int card_id,String issuer_bank,String bank_account)
    {
        this.card_id=card_id;
        this.client_name="";
        this.issuer_bank=issuer_bank;
        this.balance_amount=balance_amount;
        this.bank_account=bank_account;
    }
         //getters method
    public int getcard_id()
    {
        return this.card_id;
    }
    public String getclient_name()
    {
        return this.client_name;
    }
    public String getissuer_bank()
    {
        return this.issuer_bank;
    }
    public double getbalance_amount() 
    {
        return this.balance_amount;
    }   
    public String bank_account()
    {
        return this. bank_account;
    }
    //setters method
    public void setclient_name(String client_name)
    {
        this.client_name = client_name;
    }
    public void setbalance_amount(double balance_amount)
    {
        this.balance_amount = balance_amount;
        
    }
    //display method
    public void display()
    {
        System.out.println("The card id is : " + this.card_id);
        if(this.client_name ==""){
            System.out.println("The Client name is empty please fill it");
        }
        else{
            System.out.println("The Client Name is : "+ this.client_name);
        }
        System.out.println("The Issuer Bank is : " + this.issuer_bank);
        System.out.println("The Bank Account is : " + this.bank_account);
        System.out.println("The Balance Amount is : " + this.balance_amount);
    }
}
    
