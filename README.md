# **Banking Application**
Simple CLI banking application in Java

-----

## **Steps to setup the program:**

1. Install latest version of JDK (JDK 18 or up) from [here](https://www.oracle.com/java/technologies/downloads/)

2. Make sure to setup Environment Variables for [Java](https://www.java.com/en/download/help/path.html).
   (Set _JAVA_HOME_ to the location of JDK installation)

3. Install any Java IDE. ([IntelliJ IDEA](https://www.jetbrains.com/idea/download/) recommended)

4. Download current repository

## **Steps to run the program:**
### **Method 1:**

1. Open the downloaded `Banking_Application` folder in IntelliJ IDEA

2. Navigate to `src` folder and open Main.java

3. Right click and select `Run 'Main.main()'` or press `Shift+F10` on keyboard to run the program

Alternatively,

### **Method 2:**

1. Open Command Prompt or Terminal and navigate to `Banking_Application/src` folder

2. Here type following commands: <br>
   `javac Main.java` <br>
   `java Main`

***
<br>

## **Commands:**

1. CREATE: Create new account <br>
   Syntax: `CREATE CODE NAME`<br>
   Example: CREATE ACC01 xyz

2. DEPOSIT: Deposit amount <br>
   Syntax: `DEPOSIT CODE AMOUNT` <br>
   Example: DEPOSIT ACC01 1000 <br>

3. WITHDRAW: Withdraw amount <br>
   Syntax: `WITHDRAW CODE AMOUNT` <br>
   Example: WITHDRAW ACC01 500 <br>

4. BALANCE: Check avaible balance <br>
   Syntax: `BALANCE CODE` <br>
   Example: BALANCE ACC01 <br>






