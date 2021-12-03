//Spot
import java.util.*;
import java.io.*;
public class Spot implements Serializable
{
  protected int AmountSpotReserved;
  protected int Floor;
  protected int Parking;
  //default constructor
  public Spot()
  {
    this.Floor = 0;
    this.Parking = 0;
    this.AmountSpotReserved = 0;
  }//end default constructor

  //constructor
  public Spot(int Floor,int Parking, int AmountSpotReserved)
  {
    this.Floor = Floor;
    this.Parking = Parking;
    this.AmountSpotReserved = AmountSpotReserved;
  }//end constructor

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

  //set how many spots the user has reserved
  public void setAmountSpotReserved(int AmountSpotReserved)
  {
    this.AmountSpotReserved = AmountSpotReserved;
  }
  //get the floor
  public int getFloor()
  {
    return Floor;
  }//get the Floor

  //get the parking spot 
  public int getParking()
  {
    return Parking;
  }//end get parking

  //get how many spots
  public int getAmountSpotReserved()
  {
    return this.AmountSpotReserved;
  }//end  get hawmany spots

}//end of class
