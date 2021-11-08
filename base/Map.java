//Map class

import java.util.*;
import java.io.*;

public class Map implements Serializable
{
  protected int Column;
  protected int Row;

  //defult constructor
  public Map()
  {
    this.Row = 0;
    this.Column = 0;
  }//end defult constructor
  
  //Constructor
  public Map(int Row, int Column)
  {
    this.Row = Row;
    this.Column = Column;
  }//end constructor 
  
  //set map
  public void setMap(int Row, int Column)
  {
    System.out.println("This is the map: ");
    for(int i = 0; i < Row - 1; i++)
    {
      System.out.print("|   o   |");
      
      for(int j = 0; j < Column; j++)
      {
        System.out.print("--------");
      }//end column for loop
    }//end row for loop 
  }//end setMap

  public void getMap()
  {
    
  }
}//end Map class 
