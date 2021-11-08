//Admin

import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Admin implements Serializable
{
  protected String UserName;
  protected String PinNum;
  protected Vector<User> UserList;  
  //protected ArrayList<User> CustomerList;

  //default constructor
  public Admin()
  {
    this.UserName = "";
    this.PinNum = "";
    this.UserList = new Vector<User>();
    //this.CustomerList = new ArrayList<User>();
  }//end constructor
  
  //constructor with strings passed
  public Admin(String UserName, String PinNum)
  {
    this.UserName = UserName;
    this.PinNum = PinNum;
    this.UserList = new Vector<User>();
    //this.CustomerList = new ArrayList<User>();
  }//end constructor

  //set Account number, pass a string into the method 
  public void setUserName(String UserName)
  {
    this.UserName = UserName;
  }//end void 

  ////set pin number, pass a string into the method 
  public void setPinNum(String PinNum)
  {
    this.PinNum = PinNum;
  }//end method

  //set account number
  public String getUserName()
  {
    return this.UserName;
  }//end method
 
  //set pin number
  public String getPinNum()
  {
    return this.PinNum;
  }//end method

  //create user method, passes accoount and pin from ATM class
  public void CreateUser(String UserName,String Pin)
  {
    int i = 0;
    //creates a new user
    if (UserName.equals(getUserList().get(i).getUserName()))
    {
      System.out.println("This username already exist");
    }
   
    else
    {
      UserList.add(new User(UserName, Pin));
      System.out.println("You have created a new user!");
      System.out.println("");
    }  
  }//end method
  
  //delete user  method
  public void DeleteUser(int i)
  {
    System.out.println("You deleted user " + i  + " with UserName: " + UserList.get(i).getUserName());
    UserList.remove(i);
    System.out.println("");
  } 
  
  //list user method
  //this method will list the user, user account num, user pin num, and the balance...
  //for both checking and savings accounts
  public void ListUser()
  {
    for (int i = 0; i < UserList.size(); i++)
    {
      System.out.println("User " + i); 
      System.out.println(" Account Number: " + UserList.get(i).getUserName());
      System.out.println(" PinNum: "+UserList.get(i).getPinNum());
      System.out.println(" Account Balance: "+UserList.get(i).getMoney().getBalance() + "$");
      System.out.println("---------------------------------------------------");
    } 
  }
  
  //Charges the montly fee to  all the User accounts
  public void ApplyFee(int months)
  {
    for (int i = 0; i < UserList.size(); i++)
    {
      getUserList().get(i).getMoney().getBalance_AfterFee(months);
    }
  }
  
  //Select user
  //this method will select a user from the user vector
  public int SelectUser(String AccountNum, String PinNum)
  {
    for (int i = 0; i < UserList.size(); i++)
    { 
      if ( (getUserList().get(i).getUserName().equals(UserName)) && (getUserList().get(i).getPinNum().equals(PinNum)))
      {
        return i;
      }
    }
     return -1;
  }

  //get  the users
  public Vector<User> getUserList()
  {
    return this.UserList;
  }//end get
}//end Admin Class
