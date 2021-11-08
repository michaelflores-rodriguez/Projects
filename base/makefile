TM.class: ATM.java Admin.class User.class Money.class Map.class
	javac -g ATM.java

Admin.class: Admin.java Map.class Money.class User.class
	javac -g Admin.java

User.class: User.java Money.class Map.class
	javac -g User.java

Map.class: Map.java 
	javac -g Map.java

Money.class: Money.java
	javac -g Money.java

clean:
	rm *.class

run: ATM.class
	java ATM

runMoney: Money.class
	java Money

runUser: User.class
	java User

runAdmin: Admin.class
	java Admin

runMap: Map.java
	java Map

debug: ATM.class
	jdb ATM
