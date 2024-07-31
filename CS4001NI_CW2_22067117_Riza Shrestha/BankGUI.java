
/**
 * Write a description of class BankGUI here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.util.ArrayList;// import the ArrayList class
import javax.swing.JOptionPane;
public class BankGUI implements ActionListener
{
    private JFrame obj;
    private JPanel panel_obj;
    private JButton obj_DebitCard;
    private JButton obj_CreditCard;
    
    private JFrame obj1;
    private JPanel panel_1obj;
    private JLabel label_DC;
    private JLabel label_id;
    private JLabel label_balanceAmount;
    private JLabel label_bankAccount ;
    private JLabel label_issuerBank;
    private JLabel label_clientName;
    private JLabel label_PINnumber;
    private JLabel label_withdrawalAmount;
    private JLabel label_dateOfWithdrawal;
    private JTextField text_one;
    private JTextField text_two;
    private JTextField text_three;
    private JTextField text_four;
    private JTextField text_five;
    private JTextField text_six;
    private JTextField text_seven;
    private JButton obj_AddDebit;
    private JButton obj_ChangeCredit;
    private JButton obj_Withdraw;
    private JButton obj_GoBack1;
    private JButton obj_Display;
    private JButton obj_Clear;
    private JComboBox box_1;
    private JComboBox box_2 ;
    private JComboBox box_3; 
    
    
    private JFrame obj2;
    private JPanel panel_2obj;
    private JLabel label_CC;
    private JLabel label_id1;
    private JLabel label_balanceAmount1;
    private JLabel label_bankAccount1;
    private JLabel label_issuerBank1;
    private JLabel label_clientName1;
    private JLabel label_CVCnumber;
    private JLabel label_interestRate;
    private JLabel label_expirationDate;
    private JLabel label_creditLimit;
    private JLabel label_gracePeriod;
    private JTextField text_1;
    private JTextField text_2;
    private JTextField text_3;
    private JTextField text_4;
    private JTextField text_5;
    private JTextField text_6;
    private JTextField text_7;
    private JTextField text_8;
    private JTextField text_9;
    private JButton obj_AddCredit;
    private JButton obj_ChangeDebit;
    private JButton obj_GoBack;
    private JButton obj_SetCredit;
    private JButton obj_Display1;
    private JButton obj_Clear1;
    private JButton obj_CancelCredit;
    private JComboBox box_one;
    private JComboBox box_two ;
    private JComboBox box_three; 
    ArrayList<Bank_Card>Arr_List = new ArrayList<Bank_Card>();
    public void actionPerformed(ActionEvent e)
    {
        //If CreditCard button is clicked
        if (e.getSource() == obj_CreditCard)
        {
            //calling method M2
            M2();
        }
        //If DebitCard button is clicked
        else if (e.getSource()==obj_DebitCard)
        {
            //calling method M1
            M1();
        }
        //add button for Debit_Card
        else if(e.getSource() == obj_AddDebit)
        {
            try{
                
            double balance_amount = Double.valueOf(text_two.getText());
            int card_id = Integer.valueOf(text_one.getText());
            String bank_account = text_three.getText();
            String issuer_bank = text_four.getText();
            String client_name = text_five.getText();
            int pin_Number = Integer.valueOf(text_six.getText());
            //Create a new Debit_Card object
            Debit_Card obj_debit= new Debit_Card(balance_amount,card_id,issuer_bank,bank_account,client_name,pin_Number);
            //new
            boolean b = true;
            //new
            for(Bank_Card Bank : Arr_List)
            {
                //instance of operator for getting the value of card_id only
                if (Bank instanceof Debit_Card)
                {
                    //down casting to access getcard_id()methid
                    Debit_Card card = (Debit_Card)Bank;
                    //compare the card_id of the new object with existing objects
                    if(card.getcard_id() == card_id)
                    {
                        b = false;
                    }
                }
            }
            //add the new object to the ArrayList if the card_id is unique
            if (b == true){
                //oject of class: Debit_Card
                Arr_List .add(obj_debit);
                 //display success message
                JOptionPane.showMessageDialog(panel_1obj,"The debit card has been added succesfully");
            }
            //display error message if the card_id already exists
            else if(b == false){
                JOptionPane.showMessageDialog(panel_1obj,"This card id " + card_id + " already exists");
            }
        }
        catch(NumberFormatException NF)
        {
            JOptionPane.showMessageDialog(panel_1obj,"Error detection. ");
        }
        }
        //add button for Withdrawal
        else if(e.getSource() == obj_Withdraw)
        {
            // Get input values from text fields and combo boxes
            int card_id = Integer.valueOf(text_one.getText());
            double withdrawal_amount = Double.valueOf(text_seven.getText());
            int pin_Number = Integer.valueOf(text_six.getText());
            String Day = box_1.getSelectedItem().toString();
            String Month = box_2.getSelectedItem().toString();
            String Year = box_3.getSelectedItem().toString();
            String date_of_Withdrawal = Day +" "+ Month +" "+ Year;
            // Loop through the list of bank cards
            for( Bank_Card card:Arr_List) 
            {
                 // Check if the card is a Debit Card instance
                if(card instanceof Debit_Card)
                {
                    //Down Casting 
                    Debit_Card debit = (Debit_Card) card;
                    //Check if the card with the given card_id is found
                    if(debit.getcard_id() == card_id)
                    {
                        //Display a message box to show the input information.
                        JOptionPane.showMessageDialog(panel_1obj,
                        "\nThe card id is " + card_id +
                        "\nThe withdrawal amount is " + withdrawal_amount +
                        "\nThe date of withdrawal is " + date_of_Withdrawal + 
                        "\nThe pin number is " + pin_Number);
                        
                        //calling withdraw method from Debit_Card object
                        debit.withdraw(withdrawal_amount,date_of_Withdrawal, pin_Number);
                        //Display a message box to indicate that the balance has been successfully updated.
                        JOptionPane.showMessageDialog(panel_1obj,"Successfully Updated");
                    }
                 else {
                     //Display a message box to indicate that the given card id is invalid.
                     JOptionPane.showMessageDialog(panel_1obj,"The card id is invalid");
                 }
                 //Check if the given PIN number matches the PIN number of the card
                 if (pin_Number == debit.getpin_number()){
                     if(withdrawal_amount <= debit.getbalance_amount()){
                          //Call the withdraw method from the Debit_Card object to update the balance.
                         debit.withdraw(withdrawal_amount, date_of_Withdrawal, pin_Number);
                         //Display a message box to show the withdrawal amount and the remaining balance.
                         JOptionPane.showMessageDialog(panel_1obj,
                         "Balance withdrawal successful."+ "\n" + 
                         "Withdrawal amount is:" + withdrawal_amount +"\n"+
                         "The left over balance is: "+ debit.getbalance_amount());
                     }
                     else{
                         //Display a message box
                         JOptionPane.showMessageDialog(panel_1obj,"Not enough balance");
                     }
                }
                else{
                    //Display a message box
                    JOptionPane.showMessageDialog(panel_1obj,"Wrong Pin Number");   
                }
              }
            }
        }
       
        //add button for Display
        else if(e.getSource() == obj_Display)
        {
            try{
                // variables to call display method
                int debit_cardID = Integer.parseInt(text_one.getText());
                double debit_balanceAmount = Double.valueOf(text_two.getText());
                String debit_bankAccount = text_three.getText();
                String debit_issuerBank = text_four.getText();
                String debit_clientName = text_five.getText();
                int debit_pinNumber = Integer.parseInt(text_six.getText());
                double debit_withdrawalAmount = Double.parseDouble(text_seven.getText());
                //get value of combobox using get selected item and convert into string by'toString()'
                String debit_Date = box_1.getSelectedItem().toString();
                String debit_Month = box_2.getSelectedItem().toString();
                String debit_Year = box_3.getSelectedItem().toString();
                //adding year,month and day in a single comboBox
                String debit_withdrawalDate = debit_Date + "-" + debit_Month + "-"+ debit_Year;
                // calling debit card method for display
                for (Bank_Card card : Arr_List) {
                    if (card instanceof Debit_Card){
                        Debit_Card debitCard = (Debit_Card) card;
                        debitCard.display();
                        }
                    }
                } catch(Exception exception) {
                    //Display a meessage
                    JOptionPane.showMessageDialog(panel_1obj,"Invalid Input");
                }
            }
        //add button for Clear    
        else if(e.getSource() == obj_Clear)
        {
            //clearing all text fields by setting the text to an empty string
            text_one.setText(" ");
            text_two.setText(" ");
            text_three.setText(" ");
            text_four.setText(" ");
            text_five.setText(" ");
            text_six.setText(" ");
            text_seven.setText(" ");
            //Resetting all combo boxes to the first index(defults)
            box_1.setSelectedIndex(0);
            box_2.setSelectedIndex(0);
            box_3.setSelectedIndex(0);
            //showing a message dialog
            JOptionPane.showMessageDialog(panel_1obj,"Cleared");
        }
        //add button for Go back
        else if(e.getSource() == obj_GoBack1)
        {
            // Call the method M()
            M();
        }
        //add button for Change Credit card
        else if(e.getSource() == obj_ChangeCredit)
        {
            //Call the method M2()
            M2();
        }
        //add button for Add Credit  
        else if(e.getSource() == obj_AddCredit)
         {
             try{
                 //Get the values from the input fields
             int card_id = Integer.valueOf(text_1.getText());
             int balance_amount = Integer.valueOf(text_2.getText());
             String bank_account = text_3.getText();
             String issuer_bank = text_4.getText();
             String client_name = text_5.getText();
             int cvc_number = Integer.valueOf(text_6.getText());
             double interest_rate = Double.valueOf(text_7.getText());
             String DAY = box_one.getSelectedItem().toString();
             String MONTH = box_two.getSelectedItem().toString();
             String YEAR = box_three.getSelectedItem().toString();
             String expiration_date = YEAR + MONTH + DAY;
           
            boolean b1 = true;
            // Check if the card ID already exists in the list of Bank_Card objects
            for(Bank_Card Bank : Arr_List)
               {
                   //here instanceof operator is used to get the value of credit card object only
                   if( Bank instanceof Credit_Card)
                   {
                       //downcasting the object to Credit_Card
                       Credit_Card credit_obj = (Credit_Card) Bank;
                   
                       //checking the value of card id is duplicate or not
                       if(credit_obj.getcard_id() == card_id)
                       {
                       b1 = false;
                       }
                   }
               }
            if(b1 == true)
            {
                //obj for class credit card
               Credit_Card obj_credit = new Credit_Card(card_id, client_name, issuer_bank,bank_account,balance_amount,cvc_number,interest_rate,expiration_date);
               Arr_List.add(obj_credit);
               
            
               JOptionPane.showMessageDialog(panel_2obj, "Sucessfully added Credit Card");
               
               
            }
            else
            {
                JOptionPane.showMessageDialog(panel_2obj, " This card id " + card_id + " already Exists");
            }
        }
        catch(NumberFormatException NF)
        {
            JOptionPane.showMessageDialog(panel_2obj,"Error detected ");
        }
        }
         
        //add button for Go Back  
        else if(e.getSource() == obj_GoBack)
        {
            M();//calls the method M()
        }
        else if(e.getSource() == obj_ChangeDebit)
        {
            M1();//calls the method M1()
        }
         //add button for set credit
        else if(e.getSource() == obj_SetCredit)
        {
            // Get values from the input fields
            int card_id = Integer.valueOf(text_1.getText());
            int grace_period = Integer.valueOf(text_9.getText());
            double credit_limit = Double.valueOf(text_8.getText());
            // Loop through the array list to find the credit card with the matching card ID
            for(Bank_Card Bank : Arr_List)
            {
                // Check if the object in the array is an instance of the Credit_Card class
                if(Bank instanceof Credit_Card)
                {
                    // Downcast the Bank object to a Credit_Card object
                    Credit_Card credit = (Credit_Card) Bank;
                    // If the card ID matches the input card ID, display the grace period and credit limit
                    if(credit.getcard_id() == card_id)
                    {                     
                       String message = "The Grace Period is : " + grace_period + "\n"+
                       "The Credit Limit is : " + credit_limit;
                       JOptionPane.showMessageDialog(panel_2obj, message);
                       // If the credit limit is less than or equal to 2.5 times the current balance, update the credit card's credit limit and grace period
                       if (credit_limit <= credit.getbalance_amount() * 2.5)
                       {
                          credit.setcredit_card(credit_limit, grace_period);
                          JOptionPane.showMessageDialog(panel_2obj, "Credit Limit sucessfully updated.");
                       }
                       else
                       {
                           // If the credit limit is greater than 2.5 times the current balance, display an error message
                          JOptionPane.showMessageDialog(panel_2obj, "The credit limit cannot be greater than 2.5 times the current balance.") ;
                       }                       
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panel_2obj, "Card id not found. Please enter a valid card id");
                    }
                }                
            }
        }        
        //add button for Cancel Credit card
        else if (e.getSource() == obj_CancelCredit)
        {
            // Get values from the input fields
            int card_id =  Integer.valueOf(text_1.getText());
            
            for (Bank_Card bC : Arr_List)
            {
                if (bC instanceof Credit_Card)
                {
                    // Downcast the object to Credit_Card
                    Credit_Card card_obj = (Credit_Card) bC;
                    if (card_obj.getcard_id() == card_id)
                    {
                         // Cancel the credit card
                        card_obj.cancelCredit_Card();
                        JOptionPane.showMessageDialog(panel_2obj, "Credit card sucessfully cancelled. ");
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(panel_2obj, "Card id not found. Please enter a valid card id");
                    }
                }
            }
        }
        
        else if (e.getSource() == obj_Display1)
        {
            try {
                //variables to call display method
                int card_id = Integer.valueOf(text_1.getText());
                String client_name = text_5.getText();
                String issuer_bank = text_4.getText();
                String bank_account = text_3.getText();
                double balance_amount = Double.valueOf(text_2.getText());
                int cvc_number = Integer.valueOf(text_6.getText());
                double interest_rate = Double.valueOf(text_7.getText());
                // get value of combobox using get selected item and convert into string by toString()'
                String credit_Day = box_one.getSelectedItem().toString();
                String credit_Month = box_two.getSelectedItem().toString();
                String credit_Year = box_three.getSelectedItem().toString();
                //adding year,month and day in a single comboBox
                String expiration_date = credit_Day + "-" + credit_Month + "-"+ credit_Year;
                // calling credit card method for display
                for (Bank_Card B_obj : Arr_List)
                {
                    if (B_obj instanceof Credit_Card)
                    {
                        Credit_Card Credit_card = (Credit_Card) B_obj;
                        Credit_card.display();
                    }
                }
            }
            catch(Exception exception)
            {
                JOptionPane.showMessageDialog(panel_2obj,"Invalid Input");
            }
        }
        
        else if (e.getSource() == obj_Clear1)
        {
            //clearing all text fields by setting the text to an empty string
            text_1.setText(" ");
            text_2.setText(" ");
            text_3.setText(" ");
            text_4.setText(" ");
            text_5.setText(" ");
            text_6.setText(" ");
            text_7.setText(" ");
            text_8.setText(" ");
            text_9.setText(" ");
            //Resetting all combo boxes to the first index(defults)
            box_one.setSelectedIndex(0);
            box_two.setSelectedIndex(0);
            box_three.setSelectedIndex(0);
            //showing a message dialog
            JOptionPane.showMessageDialog(panel_2obj,"Cleared");
        }
}
    public void M()
    {
        //Creates a JFrame obj
        obj = new JFrame();
        obj.setTitle("Coursework GUI");
        obj.setBounds(15,10,650,500);
        obj.setResizable(true);
        
        //Creates a JPanel obj 
        panel_obj = new JPanel();
        panel_obj.setBounds(0,0,750,500);
        panel_obj.setBackground(Color.decode("#E6E6FA"));
        panel_obj.setLayout(null);
        
        // Create a JButton for Debit Card and set its properties
        obj_DebitCard = new JButton("Debit Card");
        obj_DebitCard.setBounds(75,70,500,150);
        obj_DebitCard.setFont(new Font("Arial",Font.BOLD,55));
        obj_DebitCard.setBackground(Color.decode("#FFFAFA"));
        panel_obj.add(obj_DebitCard);
        obj_DebitCard.addActionListener(this);
        
        // Create a JButton for Credit Card and set its properties
        obj_CreditCard = new JButton("Credit Card");
        obj_CreditCard.setBounds(75,270,500,150);
        obj_CreditCard.setFont(new Font("Arial",Font.BOLD,55));
        obj_CreditCard.setBackground(Color.decode("#FFFAFA"));
        panel_obj.add(obj_CreditCard);
        obj_CreditCard.addActionListener(this);
        
        //adding JPanel to JFrame
        obj.add(panel_obj);
        obj.setVisible(true);
        
        
    }
    public void M1()
    {
         //JFrame obj
        obj1 = new JFrame();
        obj1.setTitle("Coursework GUI");
        obj1.setBounds(15,10,650,500);
        obj1.setResizable(true);
        
        //JPanel
        panel_1obj = new JPanel();
        panel_1obj.setBounds(0,0,650,500);
        panel_1obj.setBackground(Color.decode("#E6E6FA"));
        panel_1obj.setLayout(null);
        
        //JLabel labels for input fields
        label_DC= new JLabel("Debit Card");
        label_DC.setBounds(260,10,200,50);
        label_DC.setFont(new Font("Arial",Font.PLAIN,25));
        panel_1obj.add(label_DC);
        
        label_id = new JLabel("Card id");
        label_id.setBounds(30,30,120,130);
        label_id.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_id);
        
        label_balanceAmount = new JLabel("Balance amount");
        label_balanceAmount.setBounds(30,70,120,130);
        label_balanceAmount.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_balanceAmount);
        
        label_bankAccount = new JLabel("Bank account");
        label_bankAccount.setBounds(30,110,120,130);
        label_bankAccount.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_bankAccount);
        
        label_issuerBank = new JLabel("Issuer Bank");
        label_issuerBank.setBounds(350,30,120,130);
        label_issuerBank.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_issuerBank);
        
        label_clientName = new JLabel("Client name");
        label_clientName.setBounds(350,70,120,130);
        label_clientName.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_clientName);
        
        label_PINnumber= new JLabel("PIN number");
        label_PINnumber.setBounds(350,110,120,130);
        label_PINnumber.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_PINnumber);
        
        label_withdrawalAmount= new JLabel("Withdrawal amount");
        label_withdrawalAmount.setBounds(30,220,200,130);
        label_withdrawalAmount.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_withdrawalAmount);
        
        label_dateOfWithdrawal= new JLabel("Date of Withdrawal");
        label_dateOfWithdrawal.setBounds(30,260,200,130);
        label_dateOfWithdrawal.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(label_dateOfWithdrawal);
        
        //JText
        text_one = new JTextField();
        text_one.setBounds(160,85,120,21);
        text_one.setBackground(Color.WHITE);
        text_one.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_one);
        
        text_two = new JTextField();
        text_two.setBounds(160,125,120,21);
        text_two.setBackground(Color.WHITE);
        text_two.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_two);
        
        text_three = new JTextField();
        text_three.setBounds(160,165,120,21);
        text_three.setBackground(Color.WHITE);
        text_three.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_three);
        
        text_four = new JTextField();
        text_four.setBounds(450,85,120,21);
        text_four.setBackground(Color.WHITE);
        text_four.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_four);
        
        text_five = new JTextField();
        text_five.setBounds(450,125,120,21);
        text_five.setBackground(Color.WHITE);
        text_five.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_five);
        
        text_six = new JTextField();
        text_six.setBounds(450,165,120,21);
        text_six.setBackground(Color.WHITE);
        text_six.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_six);
        
        text_seven = new JTextField();
        text_seven.setBounds(180,275,120,21);
        text_seven.setBackground(Color.WHITE);
        text_seven.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(text_seven);
        
        //JButton
        obj_AddDebit = new JButton("Add Debit Card");
        obj_AddDebit.setBounds(85,220,140,21);
        obj_AddDebit.setBackground(Color.WHITE);
        obj_AddDebit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_AddDebit);
        obj_AddDebit.addActionListener(this);
        
        obj_ChangeCredit = new JButton("Change to Credit Card");
        obj_ChangeCredit.setBounds(370,220,185,21);
        obj_ChangeCredit.setBackground(Color.WHITE);
        obj_ChangeCredit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_ChangeCredit);
        obj_ChangeCredit.addActionListener(this);
        
        obj_Withdraw = new JButton("Withdraw");
        obj_Withdraw.setBounds(100,380,100,21);
        obj_Withdraw.setBackground(Color.WHITE);
        obj_Withdraw.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_Withdraw);
        obj_Withdraw.addActionListener(this);
        
        obj_GoBack1 = new JButton("Go Back");
        obj_GoBack1.setBounds(400,270,95,21);
        obj_GoBack1.setBackground(Color.WHITE);
        obj_GoBack1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_GoBack1);
        obj_GoBack1.addActionListener(this);
        
        obj_Display = new JButton("Display");
        obj_Display.setBounds(300,380,90,21);
        obj_Display.setBackground(Color.WHITE);
        obj_Display.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_Display);
        obj_Display.addActionListener(this);
        
        obj_Clear = new JButton("Clear");
        obj_Clear.setBounds(500,380,90,21);
        obj_Clear.setBackground(Color.WHITE);
        obj_Clear.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(obj_Clear);
        obj_Clear.addActionListener(this);
        
        //JComboBox
        box_1 = new JComboBox();
        box_1.setBounds(180,315,50,21);
        box_1.setBackground(Color.WHITE);
        box_1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(box_1);
        for(int i = 1; i<31;i++)
        {
            box_1.addItem(i);
        }
        
        
        String[] WithdrawalMonth = {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
        box_2 = new JComboBox(WithdrawalMonth);
        box_2.setBounds(260,315,100,21);
        box_2.setBackground(Color.WHITE);
        box_2.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(box_2);
        
        box_3 = new JComboBox();
        box_3.setBounds(390,315,60,21);
        box_3.setBackground(Color.WHITE);
        box_3.setFont(new Font("Arial",Font.PLAIN,15));
        panel_1obj.add(box_3);
        for(int i = 2000; i<2024;i++)
        {
            box_3.addItem(i);
        }
          
        //adding JPanel to JFrame
        obj1.add(panel_1obj);
        obj1.setVisible(true);
    }
     public void M2()
    {
        //JFrame obj
        obj2 = new JFrame();
        obj2.setTitle("Coursework GUI");
        obj2.setBounds(15,10,650,500);
        obj2.setResizable(true);
        
        //JPanel
        panel_2obj = new JPanel();
        panel_2obj.setBounds(0,0,650,500);
        panel_2obj.setBackground(Color.decode("#E6E6FA"));
        panel_2obj.setLayout(null);
        
        //JLabel
        label_CC= new JLabel("Credit Card");
        label_CC.setBounds(260,10,200,50);
        label_CC.setFont(new Font("Arial",Font.PLAIN,25));
        panel_2obj.add(label_CC);
        
        label_id1 = new JLabel("Card id");
        label_id1.setBounds(30,30,120,130);
        label_id1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_id1);
        
        label_balanceAmount1 = new JLabel("Balance amount");
        label_balanceAmount1.setBounds(30,70,120,130);
        label_balanceAmount1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_balanceAmount1);
        
        label_bankAccount1 = new JLabel("Bank account");
        label_bankAccount1.setBounds(30,110,120,130);
        label_bankAccount1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_bankAccount1);
        
        label_issuerBank1 = new JLabel("Issuer Bank");
        label_issuerBank1.setBounds(350,30,120,130);
        label_issuerBank1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_issuerBank1);
        
        label_clientName1 = new JLabel("Client name");
        label_clientName1.setBounds(350,70,120,130);
        label_clientName1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_clientName1);
        
        label_CVCnumber = new JLabel("CVC number");
        label_CVCnumber.setBounds(350,110,120,130);
        label_CVCnumber.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_CVCnumber);
        
        label_interestRate = new JLabel("Interest Rate");
        label_interestRate.setBounds(30,220,200,130);
        label_interestRate.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_interestRate);
        
        label_expirationDate = new JLabel("Expiration Date");
        label_expirationDate.setBounds(30,260,200,130);
        label_expirationDate.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_expirationDate);
        
        label_creditLimit = new JLabel("Credit Limit");
        label_creditLimit.setBounds(30,300,180,130);
        label_creditLimit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_creditLimit);
        
        label_gracePeriod = new JLabel("Grace Period");
        label_gracePeriod.setBounds(350,300,180,130);
        label_gracePeriod.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(label_gracePeriod);
        
        //JText
        text_1 = new JTextField();
        text_1.setBounds(160,85,120,21);
        text_1.setBackground(Color.WHITE);
        text_1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_1);
        
        text_2 = new JTextField();
        text_2.setBounds(160,125,120,21);
        text_2.setBackground(Color.WHITE);
        text_2.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_2);
        
        text_3 = new JTextField();
        text_3.setBounds(160,165,120,21);
        text_3.setBackground(Color.WHITE);
        text_3.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_3);
        
        text_4 = new JTextField();
        text_4.setBounds(450,85,120,21);
        text_4.setBackground(Color.WHITE);
        text_4.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_4);
        
        text_5 = new JTextField();
        text_5.setBounds(450,125,120,21);
        text_5.setBackground(Color.WHITE);
        text_5.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_5);
        
        text_6= new JTextField();
        text_6.setBounds(450,165,120,21);
        text_6.setBackground(Color.WHITE);
        text_6.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_6);
        
        text_7 = new JTextField();
        text_7.setBounds(150,275,120,21);
        text_7.setBackground(Color.WHITE);
        text_7.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_7);
        
        text_8 = new JTextField();
        text_8.setBounds(150,355,120,21);
        text_8.setBackground(Color.WHITE);
        text_8.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_8);
        
        text_9 = new JTextField();
        text_9.setBounds(450,355,120,21);
        text_9.setBackground(Color.WHITE);
        text_9.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(text_9);
        
        
        
        //JButton
        obj_AddCredit = new JButton("Add Credit Card");
        obj_AddCredit.setBounds(85,220,145,21);
        obj_AddCredit.setBackground(Color.WHITE);
        obj_AddCredit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_AddCredit);
        obj_AddCredit.addActionListener(this);
        
        obj_ChangeDebit = new JButton("Change to Debit Card");
        obj_ChangeDebit.setBounds(400,275,185,21);
        obj_ChangeDebit.setBackground(Color.WHITE);
        obj_ChangeDebit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_ChangeDebit);
        obj_ChangeDebit.addActionListener(this);
        
        obj_GoBack = new JButton("Go Back");
        obj_GoBack.setBounds(440,315,95,21);
        obj_GoBack.setBackground(Color.WHITE);
        obj_GoBack.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_GoBack);
        obj_GoBack.addActionListener(this);
        
        obj_SetCredit = new JButton("Set Credit Limit");
        obj_SetCredit.setBounds(100,400,140,21);
        obj_SetCredit.setBackground(Color.WHITE);
        obj_SetCredit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_SetCredit);
        obj_SetCredit.addActionListener(this);
        
        obj_Display1 = new JButton("Display");
        obj_Display1.setBounds(320,400,90,21);
        obj_Display1.setBackground(Color.WHITE);
        obj_Display1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_Display1);
        obj_Display1.addActionListener(this);
        
        obj_Clear1 = new JButton("Clear");
        obj_Clear1.setBounds(500,400,80,21);
        obj_Clear1.setBackground(Color.WHITE);
        obj_Clear1.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_Clear1);
        obj_Clear1.addActionListener(this);
        
        obj_CancelCredit = new JButton("Cancel Credit Card");
        obj_CancelCredit.setBounds(370,220,170,21);
        obj_CancelCredit.setBackground(Color.WHITE);
        obj_CancelCredit.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(obj_CancelCredit);
        obj_CancelCredit.addActionListener(this);
        //JComboBox
        box_one = new JComboBox();
        box_one.setBounds(150,315,50,21);
        box_one.setBackground(Color.WHITE);
        box_one.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(box_one);
        for(int i = 1; i<31;i++)
        {
            box_one.addItem(i);
        }
        
        String[] expirationMonth = {"January","Feburary","March","April","May","June","July","August","September","October","November","December"};
        box_two = new JComboBox(expirationMonth);
        box_two.setBounds(215,315,100,21);
        box_two.setBackground(Color.WHITE);
        box_two.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(box_two);
        
        
        box_three = new JComboBox();
        box_three.setBounds(330,315,60,21);
        box_three.setBackground(Color.WHITE);
        box_three.setFont(new Font("Arial",Font.PLAIN,15));
        panel_2obj.add(box_three);
        for(int i = 2000; i<2024;i++)
        {
            box_three.addItem(i);
        }
        
        //adding JPanel to JFrame
        obj2.add(panel_2obj);
        obj2.setVisible(true);
    
    }
    public static void main(String [] args)
        {
            BankGUI gui = new BankGUI();
            gui.M();
        }
}

