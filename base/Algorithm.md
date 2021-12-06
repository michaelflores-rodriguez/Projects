# Goals
We need to create a program that lets people login with a username and password. After logging in they would have a menu that lets them reserve a parking spot plus if they wanted, they have the option to edit it. The user will be able to see a map of the spots that are available. The User will not be able to have more than one spot reserved. If the user has negative money in their account, they will not be able to reserve a spot until the pay. The user will also need to tell the program when they have left or done with the spot. As soon as they choose “free spot” the spot will free up and delete the user from the map and show that the spot is open. The user will also have the option to edit their username or password. However, if the username the user picked is already taken then they will not be able to do it. The admin will have the option to create users, delete users, list all the users, and charge the user a fee. The admin will also have an option to create a new map replacing the other one so that the parking spots free once the map hits for the users to be able to reserve their parking spot. The user is responsible for having money in their bank account.

The users will consist of ArrayList more object oriented and they will all be saved by the admin. Both the admin and user class will inherit from Login class which is an abstract class. The usdrs will be given a default parking spot starting at floor 0 and spot 0. For the spots there need to be a 2D Array to display the map and keep track of the parking spots. The Map will show the spots opened represented by 0 and if the spots are taken then they will be represented by 1. If a user reserves a spot and then the admin creates a new map then the users spot will be deleted (basically it will reset the values).

## Classes
 1) Menu
 2) Admin
 3) User
 4) Money
 5) Spot

## Inputs
 1) Username
 2) Password
 3) Withdraw
 4) Deposit
 5) Users select if they want to not have that spot
 6) The user inputs what floor and parking spot they want
 7) The user selects row and column
 8) Option for the user to change their username or password

## Output
 1) User list
 2) User balance in account
 3) User Spot with floor and spot
 4) The number of spots each user has reserved

