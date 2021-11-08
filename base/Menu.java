//Menu
import java.util.*;
import java.io.*;
import java.util.Scanner;


public class Menu implements Serializable
{
   protected String UserName;
   protected String Pin;
   protected static Admin admin = new Admin("00000", "12345");

  public static void main(String[] args)
  {
    
    int i = 0;

   //Read the file
   try
    {
      FileInputStream fIn = new FileInputStream("SerialUsers.dat");
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
        String Pin = scanner.nextLine();
        if (UserName.equals("00000") && Pin.equals("12345"))
        {
          adminMenu(admin,UserName, Pin);
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
	System.out.println(admin.getPinNum());
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
      FileOutputStream fo = new FileOutputStream("SerialUsers.dat");
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
        System.out.println("5) Create / Edit Map");
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
          admin.CreateUser(UserName, Pin);
         
        }
        
        //delete user
        else if (UserInput.equals("2"))
        { 
          System.out.print("Enter the corresponding number of the user you want to delete:  ");
          i = input.nextInt();
          input.nextLine();
          admin.DeleteUser(i);
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
        }

        else if (UserInput.equals("5"))
        { 
          admin.setMap();
        }

        else if (UserInput.equals("6"))
        { 
          admin.getMap();
        }

        //go back to choosing  if admin or user
        else if (UserInput.equals("7"))
        {
          go = false;
        }
       
    }//end while
  }//end admin menu method
  
  //user menu method
  public static void userMenu(Admin admin, String UserName,String Pin, int userIndex)
  {
    int i = 0;
    Scanner scanner = new Scanner(System.in);
    Scanner money = new Scanner(System.in);
    //temp user loging in
    User currentUser = null;
    //send the index of the user whose account number equals to the parameter
    userIndex = admin.SelectUser(UserName, Pin);
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
          //Checks balance
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
           if (dinero < admin.getUserList().get(userIndex).getChecking().getBalance())
           {
              System.out.println("Balance: " + admin.getUserList().get(userIndex).getWithdraw_Balance(dinero) + "$");
              System.out.println("");
           }//end if
            //Otherwise error
            else
            {
              System.out.println("Sorry amount taken out cannot exeed more than balance! ");
            }//end else
          }//end if
         
          //Deposit money
          if ( UserInput.equals("3"))
          {
            System.out.println("How much will you like to deposit: ");
            double dinero = money.nextDouble();
            System.out.println("Balance: " + admin.getUserList().get(userIndex).getDeposit_Balance(dinero) + "$");
          }//end if deposit

          if( UserInput.equals("4")
          {
            
          }//end option 4

          if( UserInput.equals("5"))
          {
            start = false; 
          }//end option 5
        }//end while
      }//end if checkings account
     
      //Savings account
      else if( UserInput.equals("2") )
      {
        boolean end = true;
        while (end)
        {
          System.out.println("Reserve/Edit Menu");
          System.out.println("1) Create Parking Reservation");
          System.out.println("2) Edit Parking Reservation");
          System.out.println("3) Delete Parking Reservation");
          System.out.println("4) Previous menu");
          UserInput = scanner.nextLine();

          //Create Parking Reservation
          if ( UserInput.equals("1"))
          {
            System.out.println("");
          }//ends if balance

          //Edit Reservation
          if ( UserInput.equals("2"))
          {
              System.out.println("");

          }//end if

          //Delete Parking Reservation
          if ( UserInput.equals("3"))
          {
            System.out.println("");
          }//end if deposit money

          //Back to previous menu
          if(UserInput.equals("4"))
          {
            end = false;
          }//end if
        }//end while
      }//Savings menu ends

    if(UserInput.equals("3"))
    {
    System.out.println("Going back to main menu");
    currentUser = null;
    }//ends exit menu
        
  }//end Picking account menu
 }//end user menu

}//end Menu class
