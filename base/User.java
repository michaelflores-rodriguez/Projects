import java.util.*;
import java.io.*;
public class User extends Login implements Serializable
{
  protected Money MoneyAcc; 
  protected Spot spot;
   //Constructor default
   public User()
   {
     super();
     this.MoneyAcc = new Money();
     this.spot = new Spot();
   }//end default constructor
   
   //Constructor with values passed
   public User(String UserName, String PinNum)
   {
     super(UserName,PinNum);
     this.MoneyAcc = new Money();
     this.spot = new Spot(); 
   }//end constructor
 
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

   public Spot getSpot()
   {
     return this.spot;
   }//this will make the user class recognize the methods in the spot class  
}//end user class
