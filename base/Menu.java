//Menu
import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Menu implements Serializable
{
   protected String UserName;
   protected String PinNum;
   protected static Admin admin = new Admin("00000", "12345");

  public static void main(String[] args)
  {
    
    int i = 0;

   //Read the file
   try
    {
      FileInputStream fIn = new FileInputStream("Users.dat");
      ObjectInputStream objIn = new ObjectInputStream(fIn);
      admin = (Admin)objIn.readObject();
    }

    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }//end try

    boolean keepgoing = true;
    Scanner scanner = new Scanner(System.in);
    while (keepgoing)
    {
      System.out.println("Choose one of the following by entering their corresponding number.");
      System.out.println("1) Admin");
      System.out.println("2) User");
      System.out.println("3) Exit");
      String UserInput = scanner.nextLine();
      //Determinating if is Admin or User loggin
      if (UserInput.equals("1"))
      {
        System.out.print("Enter Account number: ");
        String UserName = scanner.nextLine();
        System.out.print("Enter Pin number: ");
        String PinNum = scanner.nextLine();
        System.out.println("");
        if (UserName.equals("00000") && PinNum.equals("12345"))
        {
          adminMenu(admin,UserName, PinNum);
        }//end if
     
        else
        {
          System.out.println("You are an imposter try again!");
        }//end else
      }//end if

      //*************************************************************************User Menu********************************************************
      else if(UserInput.equals("2") )
      {
        System.out.print("Enter Account number: ");
        String UserName = scanner.nextLine();
        System.out.print("Enter Pin number: ");
        String Pin = scanner.nextLine();
        int userIndex = admin.SelectUser(UserName,Pin);
        System.out.println(admin.getUserList().get(i).getUserName());
	System.out.println(admin.getUserList().get(i).getPinNum());
        System.out.println("");
        
        System.out.println(userIndex);
	if(userIndex == -1)
        {
	  System.out.println("User not found, try again");
	}//end if
	else{
	  userMenu(admin,UserName,Pin, userIndex);
	}//end else
        
      }//end else if

      //exit the program
      else if(UserInput.equals("3"))
      {
        System.out.println("See you next time!");
        System.out.println("");
        keepgoing = false;
      }//ends exit menu
     
       
    }//end while
    
    //Writes the file
    try
    {
      FileOutputStream fo = new FileOutputStream("Users.dat");
      ObjectOutputStream objOut = new ObjectOutputStream(fo);
      objOut.writeObject(admin);
    }

    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }//end try   
  
  }//end main


  //Admin menu method
  public static void adminMenu(Admin admin, String UserName, String Pin)
  {
    int i = 0;
    boolean go = true;
    Scanner input = new Scanner(System.in);
    while (go)
    {
        System.out.println("Choose one of the following by entering their corresponding number.");
        System.out.println("1) Add User");
        System.out.println("2) Delete User");
        System.out.println("3) Apply Monthly Fee");
        System.out.println("4) List of users");
        System.out.println("5) Create Map");
        System.out.println("6) Display Map");
        System.out.println("7) Exit to loggin");
        String UserInput = input.nextLine();
        
        //Add user
        if (UserInput.equals("1"))
        { 
          //Ask admin to enter the account num and pin num for the new user
          
          System.out.print("Enter User Account Number: ");
          UserName = input.nextLine();
          System.out.print("Enter User Pin Number: ");
          Pin = input.nextLine();
          System.out.println("");

          admin.CreateUser(UserName, Pin);
        }
        
        //delete user
        else if (UserInput.equals("2"))
        { 
          System.out.print("Enter the corresponding number of the user you want to delete:  ");
          i = input.nextInt();
          input.nextLine();
          admin.DeleteUser(i);
          System.out.println("");
        }

        //apply interest to all the users savings account
        else if (UserInput.equals("3"))
        {
          System.out.print("Enter how many months: ");
          int months = input.nextInt();
          admin.ApplyFee(months);
          input.nextLine();
          System.out.println("The interest has been applied");
          System.out.println("");
        }

        //list all the users
        else if (UserInput.equals("4"))
        {
          admin.ListUser();
          System.out.println("");
        }

        else if (UserInput.equals("5"))
        {
          System.out.print("Enter how many floor the parking will have:  ");
          int Floor = input.nextInt();
          input.nextLine();
          System.out.print("Enter how many spots the parking will have:  ");
          int Parking = input.nextInt();
          input.nextLine();
          admin.CreateSpot(Floor,Parking);
          System.out.println("");
        }
        else if (UserInput.equals("6"))
        { 
          admin.DisplayMap();
        }

        //go back to choosing  if admin or user
        else if (UserInput.equals("7"))
        {
          go = false;
        }
       
    }//end while
  }//end admin menu method
  
  //user menu method
  public static void userMenu(Admin admin, String UserName,String PinNum, int userIndex)
  {
    int i = 0;
    Scanner scanner = new Scanner(System.in);
    Scanner money = new Scanner(System.in);
    //temp user loging in
    User currentUser = null;
    //send the index of the user whose account number equals to the parameter
    userIndex = admin.SelectUser(UserName, PinNum);
    //from the admins userlist get the user at that index and select as current user
    currentUser = admin.getUserList().get(userIndex);
    //while user has not log out
    while(currentUser != null)
    {

      System.out.println("Choose one of the following");
      System.out.println("1) Account Information");
      System.out.println("2) Reserve/Edit Parking Spot Reservation");
      System.out.println("3) Back to logging");
      String UserInput = scanner.nextLine();

      if (UserInput.equals("1"))
      {
        boolean start = true;
        while(start)
        {
          //We are now in chekings account
          System.out.println("");
          System.out.println("1) Account balance");
          System.out.println("2) Withdraw");
          System.out.println("3) Depositing");
          System.out.println("4) Edit Account");
          System.out.println("5) Previous menu");

          //Gets user input if user wants to see balance, withdraw, or deposit into account.
          UserInput = scanner.nextLine();
          //Money balance
          if( UserInput.equals("1"))
          {
            System.out.println("Balance: " + admin.getUserList().get(userIndex).getMoney().getBalance()  + "$");
            System.out.println("");
          }//end if balance

          //withdraw money.
          if( UserInput.equals("2"))
          {
            System.out.println("How much will you like to withdraw: ");
            double dinero = money.nextDouble();

           //If the balance is grater than the money withdraw continue to withdraw.
           if (dinero < admin.getUserList().get(userIndex).getMoney().getBalance())
           {
              System.out.println("Balance: " + admin.getUserList().get(userIndex).getWithdraw_Balance(dinero) + "$");
              System.out.println("\n");
           }//end if
            //Otherwise error
            else
            {
              System.out.println("Sorry amount taken out cannot exeed more than balance!\n ");
            }//end else
          }//end if
         
          //Deposit money
          if ( UserInput.equals("3"))
          {
            System.out.println("How much will you like to deposit: ");
            double dinero = money.nextDouble();
            System.out.println("Balance: " + admin.getUserList().get(userIndex).getDeposit_Balance(dinero) + "$");
            System.out.println("");
          }//end if deposit

          if( UserInput.equals("4"))
          {
            boolean b = true;
            while(b)
            {
              System.out.println("Choose one of the following!");
              System.out.println("1) Edit Username");
              System.out.println("2) Edit Pin number");
              System.out.println("3) Previous menu");

              UserInput = scanner.nextLine();
              if( UserInput.equals("1"))
              {
                System.out.print("Enter your new username: ");
                UserName = scanner.nextLine();
                System.out.println("");
                boolean Duplicate = false;
                for ( i = 0; i < admin.UserList.size(); i++)
                {
                  //this will find a user with the same username if it already exist
                  if (admin.getUserList().get(i).getUserName().equals(UserName))
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
                  admin.getUserList().get(userIndex).setPinNum(PinNum);
                  System.out.print("Your new username is: " + admin.getUserList().get(userIndex).getUserName());
                  System.out.println("");
                }//end else

              }//end option 1

              else if(UserInput.equals("2"))
              {
                System.out.print("Enter your new Pin number: ");
                PinNum = scanner.nextLine();
                admin.getUserList().get(userIndex).setPinNum(PinNum);
                System.out.print("Your new Pin number is: " + admin.getUserList().get(userIndex).getPinNum());
                System.out.println("");
              }//end option 2
  
              else if(UserInput.equals("3")) 
              {
                b = false;
              }//end option 3
            }//end while b     
          }//end option 4

          if( UserInput.equals("5"))
          {
            start = false; 
          }//end option 5
        }//end while start
      }//end if Account
     
      //Parking Spot
      else if( UserInput.equals("2") )
      {
        boolean end = true;
        while (end)
        {
          System.out.println("Reserve/Edit Menu");
          System.out.println("1) Reserve Parking Spot");
          System.out.println("2) Check Parking Reservation");
          System.out.println("3) Cancel Parking Spot  Reservation");
          System.out.println("4) Previous menu");
          UserInput = scanner.nextLine();

          //Reserve Parking Spot
          if ( UserInput.equals("1"))
          {
            System.out.println("Choose one of the following by entering their corresponding number.");
            System.out.println("1) Display All parking Spots");
            //This will be implemented in the future
            //System.out.println("2) Display Specific floor Parking spot Available");
            System.out.println("2) Previous Menu");
            UserInput = scanner.nextLine();
	    boolean a = true;
            while(a)
 	    {
              if ( UserInput.equals("1"))
              {
  	        //this will display all parking spot available
  	        System.out.println("0 means available. 1 means unavailable. ");
                admin.DisplayMap(); 
                System.out.print("Enter the floor you will like to reserve your parking spot: ");
                int Floor = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter the Spot you will like to reserve your parking spot: ");
                int ParkingSpot = scanner.nextInt();
                scanner.nextLine();
                admin.ReserveSpot(Floor, ParkingSpot, userIndex);
                System.out.println("");
                a = false;
              }//end display All parking Spot Plus Reservation
/*
              else if ( UserInput.equals("2"))
              {
                System.out.print("Enter the floor you will like to check: ");
                int Floor = scanner.nextInt();
                scanner.nextLine();
                //this method will display the specific floor with the parking spots available
                //if there are not any, the program should ask the user to pick another floor
                admin.SpecificFloor(Floor);
                System.out.print("Enter the Spot you will like to reserve your parking spot: ");
                int ParkingSpot = scanner.nextInt();
       	        scanner.nextLine();
	        admin.ReserveSpot(Floor, ParkingSpot, userIndex); 
              }//end display specific floor Plus reservation
*/	     
              else if(UserInput.equals("2"))
 	      {
  	        a = false;
              }//end exit menu
            }//ends while a
          }//end if Reserve Parking Spot

          //Check Reservation
          else if ( UserInput.equals("2"))
          {
            admin.CheckReservation(userIndex); 
            System.out.println("");
          }//end if

          //Delete Parking Reservation
          if ( UserInput.equals("3"))
          {
            admin.FreeSpot(userIndex);
            System.out.println("");
          }//end if deposit money

          //Back to previous menu
          if(UserInput.equals("4"))
          {
            end = false;
            System.out.println("");
          }//end if
        }//end while
      }//menu ends

    else if(UserInput.equals("3"))
    {
      System.out.println("Going back to main menu");
      currentUser = null;
    }//ends exit menu        
   }//end Picking account menu
 }//end user menu


}//end Menu class
