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


  public void CreateSpot()
  {
    for(int i = 1; i < 4; i++)
    {
      for(int j = 1; j < 6; i++)
      {
        
      }
    }
  }
  //sets the Floors
  public void setFloor(int Floor)
  {
    this.Floor = Floor;
  }//end set floor

  //sets the parking spots
  public void setParking()
  {
    this.Parking = Parking;
  }//end set spots

  //get the floor
  public int getFloor()
  {
    return Floor;
  }//get the Floor

  public int getParking()
  {
    return Parking;
  }//end get parking

  
}//end of class
