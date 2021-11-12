import java.util.*;
import java.io.*;
public class Money implements Serializable
{
  protected double balance;


  public Money()
  {
    this.balance = 0;
  }

  public Money(double balance)
  {
    this.balance = balance;
  }

  public double getBalance()
  {
    return this.balance;
  }

  public void setBalance(double balance)
  {
    //This formula will round to 2 decimal places
    this.balance = Math.round(balance * 100.0)/100.0;
  }

  public double getBalance_AfterFee(int months)
  {
    this.balance = balance - (15 * (months));
    this.balance = Math.round(this.balance * 100.0)/100.0; 
    return this.balance;
  }
}
