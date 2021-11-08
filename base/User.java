import java.util.*;
import java.io.*;
public class User implements Serializable
{
  protected String UserName;
  protected String PinNum;
  protected double Withdraw;
  protected double Deposit;
  protected Money MoneyAcc; 
 
   //Constructor default
   public User()
   {
     this.MoneyAcc = new Money(); 
     this.UserName = "00001"; 
     this.PinNum = "00000";
   }//end default constructor
   
   //Constructor with values passed
   public User(String UserName, String PinNum)
   {
     this.MoneyAcc = new Money();
     this.UserName = UserName;
     this.PinNum = PinNum;
   }//end constructor 
   
   //set account number pass it a string of account
   public void setUserName(String UserName)
   {
     this.UserName = UserName;
   }//end void

   //set pin number, pass it a string of pin
   public void setPinNum(String UserPinNum)
   {
     this.PinNum = PinNum;
   }//end void
  
   //get the account  number
   public String getUserName()
   {
     return this.UserName;
   }//end get
   
   //getpin number
   public String getPinNum()
   {
     return this.PinNum;
   }//end get

   //get deposti method for money account 
   public double getDeposit_Balance(double dinero)
   {
     double newBalance = ( this.MoneyAcc.getBalance() + dinero);
     MoneyAcc.setBalance(newBalance);
     return newBalance;
   }//end deposit method

   //get withdraw  method for money account
   public double getWithdraw_Balance(double dinero)
   {
     double newBalance = (this.MoneyAcc.getBalance() - dinero);
     MoneyAcc.setBalance(newBalance);
     return newBalance;

   }//end method
  

   //this gives the user class access to the money class for the admin class to refer to it
   public Money getMoney()
   {
     return this.MoneyAcc;
   }
  
}//end user class
