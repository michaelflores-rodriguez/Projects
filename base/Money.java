import java.util.*;
import java.io.*;
public class Money implements Serializable
{
  protected double balance;

  //default constructor
  public Money()
  {
    this.balance = 0;
  }//end default constructor

  //parameter construstor
  public Money(double balance)
  {
    this.balance = balance;
  }//end parameter constructor

  //with this methood we will get the balance
  public double getBalance()
  {
    return this.balance;
  }//end get balance

  //this method sets the balance
  public void setBalance(double balance)
  {
    //This formula will round to 2 decimal places
    this.balance = Math.round(balance * 100.0)/100.0;
  }//end set the balance

  //this method will be activated by the admin to charge the user with a monthly fee
  public double getBalance_AfterFee(int months)
  {
    this.balance = balance - (15 * (months));
    this.balance = Math.round(this.balance * 100.0)/100.0; 
    return this.balance;
  }// end getBalance_AfterFee
}//end Money class
