//University
//In here I the program  will run
//This program's purpose is to demonstrate the Object Oriented  Skills

import java.util.*;
import java.io.*;
import java.util.Scanner;

public class University()
{
  protected static Admin admin = new Admin("00000", "12345");
  protected String UserName;
  protected String Pin;
  
  //in here we will select the floor the user or Admin inputs
  public int SelectFloor(int Floor)
  {
    
  }
  
  //in here we will select the parking spot the user or Admin inputs
  public int SelectParkingSpot(int ParkingSpot)
  {

  }//end Select parking spot

  //in here we will show all the parking spots avaible
  public void DisplayAllParking()
  {
      for(int i = 0; i<3 ;i++)
      {
        System.out.println("Avaible Parking Spot for Floor: "+ i);
        System.out.println("Are the following: ");
        for(int  j =  0; j<5 ; j++)
        {
          int  status = SpotList.get(i).get(j);
          if (status.equals(0))
          {
            System.out.print(j + "| ");
          }//end if
        }//end parking selection
      }//end floor selection  
  }//DisplayAllParking

  //In here a specific floors parking spot will be displayed 
  //Only the open parking spots will be displayed
  public void DisplayFloorParking(int Floor)
  {
    for(int i = Floor; i<=Floor ;i++)
    {
      System.out.println("Avaible Parking Spot for Floor: "+ i);
      System.out.println("Are the following: ");
      for(int  j =  0; j<5 ; j++)
      {
        int  status = SpotList.get(i).get(j);
        if (status.equals(0))
        {
          System.out.print(j + "| ");
        }//end if
      }//end chosing parking spot
    }//end floor
  }//end display specific floor parking spot

//end University class
