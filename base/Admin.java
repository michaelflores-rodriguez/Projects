//Admin

import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Admin extends Login implements Serializable
{
  protected ArrayList<User> UserList;  
  protected List<List> SpotList;

  //default constructor
  public Admin()
  {
    super();
    this.UserList = new ArrayList<User>();
    this.SpotList = new ArrayList<List>();
    CreateParkingSpot();
  }//end constructor
  
  //constructor with strings passed
  public Admin(String UserName, String PinNum)
  {
    super(UserName,PinNum);
    this.UserList = new ArrayList<User>();
    this.SpotList = new ArrayList<List>();
  }//end paramiter constructor

  //create how many spots
  public void CreateParkingSpot()
  {
    ///--------------- I have to fins a way to add a Floor and add a Parking Spot by using a 2d arrayList------   
    // SpotList.add(new Spot(Row, Column);

    //This is floor 1
    List Floor1 = new ArrayList();
    //Thiese are the parking spots for floor 1
    Floor1.add(0,0);
    Floor1.add(1,0);
    Floor1.add(2,0);
    Floor1.add(3,0);
    Floor1.add(4,0);

    //This is floor 2 
    List Floor2 = new ArrayList();
    //These are the parking spots for floor 2
    Floor2.add(0,0);
    Floor2.add(1,0);
    Floor2.add(2,0);
    Floor2.add(3,0);
    Floor2.add(4,0);

    //This is floor 3
    List Floor3 = new ArrayList();
    //These are the parking spots for floor 3
    Floor3.add(0,0);
    Floor3.add(1,0);
    Floor3.add(2,0);
    Floor3.add(3,0);
    Floor3.add(4,0);

    SpotList.add(Floor1);
    SpotList.add(Floor2);
    SpotList.add(Floor3);
  }//end CreateParkingSpot

  //Now that I have the map displayed I can proceed to checking the status of the parking spot
  public void ParkingStatus()
  {
    //This will give me thestatus of the parking spot
    //If the status is 0 then the parking spot is open
    //If the status is 1  then the parking spot taken
    int  status = SpotList.get(i).get(j);
    if (status.equals(0))
    {
      for(int i = 0; i<3; i++)
      {
        System.out.print("In floor "+i+", the  following parking spots are available: ");
        for(int j = 0; j<4; j++)
        {
          System.out.print(j+ "| ");
        }//end spot display
      }//end floor 
    }//end if
  }//end Parking Status

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
  public ArrayList<User> getUserList()
  {
    return this.UserList;
  }//end get

  public List<List> getSpotList()
  {
    return this.SpotList;
  }
}//end Admin Class
