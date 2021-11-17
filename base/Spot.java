//Spot
import java.util.*;
import java.io.*;
public class Spot implements Serializable
{
  protected int Floor;
  protected int Parking;
  protected int Status; 
  //default constructor
  public Spot()
  {
    this.Floor = 0;
    this.Parking = 0;
    this.Status = 0;
  }//end default constructor

  //constructor
  public Spot(int Floor,int Parking)
  {
    this.Floor = Floor;
    this.Parking = Parking;
    this.Status = 0;
  }//end constructor

  //Most likely the admin will have this option to create the parking spot
  public void CreateSpot(int Floor, int Parking)
  {
    int[][] ParkingSpot = new int[Floor][Parking];

    for(int i = 1; i < Floor; i++)
    {
      for(int j = 1; j < Parking; i++)
      {
        ParkingSpot[i][j] = 0;    
      }
    }
  }//end CreateSpot

  //this method will reserve the spot and change the status of the...
  //spot to one.
  public void ReserveSpot(int Floor, int Parking)
  {
    if(ParkingSpot[Floor][Parking].equals(0))
    {
      //changes the parking from opened to closed
      ParkingSpot[Floor][Parking] = 1;
      

      System.out.println("Your spot have been reserved!");
      System.out.println("");
    }//this will only execute if the parking spot is opened
  }//end ReserveSpot


  //sets the Floors
  public void setFloor(int Floor)
  {
    this.Floor = Floor;
  }//end set floor

  //sets the parking spots
  public void setParking(int Parking)
  {
    this.Parking = Parking;
  }//end set spots

  public void setStatus();
  {
    this.Status = Status;
  }
  //get the floor
  public int getFloor()
  {
    return Floor;
  }//get the Floor

  public int getParking()
  {
    return Parking;
  }//end get parking

  public int getStatus();
  {
    return Status;
  }//end get Status 
}//end of class
