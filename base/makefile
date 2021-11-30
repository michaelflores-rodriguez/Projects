TM.class: Menu.java Admin.class User.class Money.class Login.class Spot.class
	javac -g Menu.java

Admin.class: Admin.java Login.class Money.class User.class Spot.class
	javac -g Admin.java

User.class: User.java Money.class Spot.class Login.class
	javac -g User.java

Spot.class: Spot.java 
	javac -g Spot.java

Money.class: Money.java
	javac -g Money.java

Login.class: Login.java
	javac -g Login.java

clean:
	rm *.class
	rm *.dat

run: Menu.class
	java Menu

runMoney: Money.class
	java Money

runUser: User.class
	java User

runAdmin: Admin.class
	java Admin

runSpot: Spot.java
	java Spot

runLogin: Login.java
	java Login

debug: Menu.class
	jdb Menu
