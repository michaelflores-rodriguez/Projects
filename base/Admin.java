//Admin

import java.util.*;
import java.io.*;
import java.util.Scanner;
public class Admin extends Login implements Serializable
{
  protected ArrayList<User> UserList;  
  protected int[][] ParkingSpot;
 // protected List<List> SpotList;

  //default constructor
  public Admin()
  {
    super();
    this.UserList = new ArrayList<User>();
    
    //this.SpotList = new ArrayList<List>();
  }//end constructor
 
  //constructor with strings passed
  public Admin(String UserName, String PinNum)
  {
    super(UserName,PinNum);
    this.UserList = new ArrayList<User>();
    this.ParkingSpot = new int[][]{{-1},{-1}};
  //this.SpotList = new ArrayList<List>();
  }//end paramiter constructor

  //This method will allow the admin to create the paerking spots by inputing the numbers of floors and Parking Spots
  public void CreateSpot(int Floor, int Parking)
  {
    //this for loop will reset the values of floor,Parking and Spots reserved back to 0 for each user
    for(int i = 0; i < UserList.size(); i++)
    {
      int Pizo = 0;
      int Estacionamiento = 0;
      int Espacios_Reservados = 0;
      getUserList().get(i).getSpot().setFloor(Pizo);
      getUserList().get(i).getSpot().setParking(Estacionamiento);
      getUserList().get(i).getSpot().setAmountSpotReserved(Espacios_Reservados);
    }//end for


    this.ParkingSpot = new int[Floor][Parking];
    System.out.println("Floor size: "+ParkingSpot.length);
    System.out.println("Parking size: "+ParkingSpot[0].length);
    for(int i = 0; i < Floor; i++)
    {
      for(int j = 0; j < Parking; j++)
      {
        this.ParkingSpot[i][j] = 0;    
      }//end For Parking
    }//end For Floor
  }//end CreateSpot

  //this will reserve the spot for the admin 
  public void ReserveSpot(int Floor, int Parking, int i)
  {
    //This if will check if the user owes any mony to the admin
    //If they owe money(blance is negative) then a message will say they cannot reserve spot due to negative funds
    if(getUserList().get(i).getMoney().getBalance() < 0)
    {
      System.out.println("You cannot reserve a spot until you pay what you owe me!\n");
    }//end if

    //This else will know the user does not owe anything to the admin
    else
    {
      //This line makes the program check if the user already
      //have a parking spot reserved. Users cannot have more than 1 spot reserved.
      if(getUserList().get(i).getSpot().getAmountSpotReserved() == 0) 
      {
        if(ParkingSpot[Floor][Parking] == 0)
        {
          //changes the parking from opened to closed
          ParkingSpot[Floor][Parking] = 1;
          getUserList().get(i).getSpot().setFloor(Floor);
          getUserList().get(i).getSpot().setParking(Parking);
          int AmountSpotReserved = 1; 
          getUserList().get(i).getSpot().setAmountSpotReserved(AmountSpotReserved);

          System.out.println("Parking Reservation has been made!");
          System.out.println("");
        }//this will only execute if the parking spot is opened

        else if(ParkingSpot[Floor][Parking] == 1)
        {
          System.out.println("This parking spot is not available");
        }//end else if
      }//end if, this if makes sure the user does not already have a spot reserved 
    
      //This will let the user know they cannot reserve a spot because they already have one
      else if(getUserList().get(i).getSpot().getAmountSpotReserved() == 1)
      {
        System.out.println("Cannot reserve more than 1 parking Spot at a time!");
        System.out.println("");
      }//end elseif
    }//end else
  }//end ReserveSpot
 
  //in this method the user will be able to notify the system that they have left.
  //This will cause the system to open the spot that was reserved by the user
  public void FreeSpot(int i)
  {
     if(ParkingSpot[getUserList().get(i).getSpot().getFloor()][getUserList().get(i).getSpot().getParking()] == 1)
     {
       ParkingSpot[getUserList().get(i).getSpot().getFloor()][getUserList().get(i).getSpot().getParking()] = 0;
       getUserList().get(i).getSpot().setFloor(-1);
       getUserList().get(i).getSpot().setParking(-1);
       int AmountSpotReserved = 0;
       getUserList().get(i).getSpot().setAmountSpotReserved(AmountSpotReserved);
       System.out.println("Now you are able to reserve another Parking Spot!");
       System.out.println("");    
     }//end if
//ParkingSpot[getUserList().get(i).getSpot().getFloor()][getUserList().get(i).getSpot().getParking()] == 0
     else
     {
       System.out.println("You do not have a spot to delete!");
     }//end else if
  }//end free spot

  //this method will allow the user to check the reservation they have made
  public void CheckReservation(int i)
  {
    //checks if the user already have a spot reserved
    if(getUserList().get(i).getSpot().getAmountSpotReserved() == 1)
    {
      System.out.println("You have a reserved spot in Floor: "+getUserList().get(i).getSpot().getFloor()+ " ParkingSpot: "+getUserList().get(i).getSpot().getParking());
    }//end if
  
    //This  else will display an error
    else
    {
      System.out.println("You do not have any spot reservation!\n");
    }//end else
  }//end Check Reservation

  //This method displays the map the admin has created
  public void DisplayMap()
  {
    int Floor = ParkingSpot.length;
    int Parking = ParkingSpot[1].length;
    System.out.println("");
    System.out.println("");
    System.out.print("Spots:   ");
    for (int nums = 0; nums < Parking; nums++) 
    {
      System.out.print(nums);
    }//end for
    System.out.println("");
    System.out.print("         ");

    for (int nums = 0; nums < Parking; nums++)
    {
      System.out.print("_");
    }
    System.out.println("");

    for(int i = 0; i < Floor; i++)
    {
      System.out.print("Floor: "+i+"|");
      for(int j = 0; j < Parking; j++)
      {
        System.out.print(ParkingSpot[i][j]);   
      }
      System.out.println("");
    }
    System.out.println("");
    System.out.println(""); 
  }

  //create user method, passes accoount and pin from ATM class
  public void CreateUser(String UserName,String Pin)
  {
    boolean Duplicate = false;
    for (int i = 0; i < UserList.size(); i++)
    {
      //this will find a user with the same username if it already exist
      if (getUserList().get(i).getUserName().equals(UserName))
      {
        Duplicate = true;
      }//end if
    }//end for
 
    //if the user name already exist it wont create the new user
    if(Duplicate == true)
    {
      System.out.println("Cannot create because this username already exists");
      System.out.println("");
    }//end if

    //if no user name exist with this username then it will create the new user
    else
    {
      //creates a new user
      UserList.add(new User(UserName, Pin));
      System.out.println("You have created a new user!");
      System.out.println("");
    }//end else
      
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
      System.out.println(" User " + i); 
      System.out.println(" Username Number: " + UserList.get(i).getUserName());
      System.out.println(" PinNum: "+UserList.get(i).getPinNum());
      System.out.println(" User Floor: "+UserList.get(i).getSpot().getFloor());
      System.out.println(" User Parking Spot: "+UserList.get(i).getSpot().getParking());
      System.out.println(" Spots User Reserved:  "+UserList.get(i).getSpot().getAmountSpotReserved());
      System.out.println(" Account Balance: "+UserList.get(i).getMoney().getBalance() + "$");
      System.out.println("---------------------------------------------------");
    }//end for loop
  }//end ListUser
  
  //Charges the montly fee to  all the User accounts
  public void ApplyFee(int months)
  {
    for (int i = 0; i < UserList.size(); i++)
    {
      getUserList().get(i).getMoney().getBalance_AfterFee(months);
    }//end for loop
  }//end appleay fee
  
  //Select user
  //this method will select a user from the user vector
  public int SelectUser(String UserName, String PinNum)
  {
    for (int i = 0; i < UserList.size(); i++)
    { 
      //This if makes sure it takes the correct user
      if ( (getUserList().get(i).getUserName().equals(UserName)) && (getUserList().get(i).getPinNum().equals(PinNum)))
      {
        return i;
      }//end if 
    }//end for loop
     return -1;
  }//end Select User
 
  //get  the users
  public ArrayList<User> getUserList()
  {
    return this.UserList;
  }//end get

}//end Admin Class
