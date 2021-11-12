//Login

import java.util.*;
import java.io.*;

public abstract class Login implements Serializable
{
  protected String UserName;
  protected String PinNum;

  public Login()
  {
    this.UserName = "";
    this.PinNum = "";
  }//end default constructor
 
  public Login(String UserName, String PinNum)
  {
    this.UserName = UserName;
    this.PinNum = PinNum;
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
}
