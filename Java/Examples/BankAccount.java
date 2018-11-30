/* See README.TXT for information about this software */
 Source: https://courses.cs.washington.edu/courses/cse142/01au/dist/BankAccount.java
/**
   A Bank Account.
*/
public class BankAccount {
  private double balance;  // the current balance of the account
  private String ownerName; // the name of the person who owns this account
  private int accountNumber;  // the account number of this account

  /** Create a new bank account with a zero balance and a unique account number
      @param ownerName the owner of the account
  */
  public BankAccount(String ownerName) {
    this.ownerName = ownerName;  // note: cannot leave off "this." here!
    this.balance = 0.0;
    this.assignNewAccountNumber();  // invoke one of the account's own methods
  }

  /** Assign this account a new unique account number */
  private void assignNewAccountNumber() {
    // take the next available account number:
    this.accountNumber = this.nextAccountNumber;
    // update the account number for the next account to use:
    this.nextAccountNumber = this.nextAccountNumber + 1;
  }
  // this *static* instance variable is shared by all accounts, so each
  // time we create a new account, we can read and then update this 
  // instance variable.  it's a piece of magic that we haven't explained yet.
  private static int nextAccountNumber = 1;

  /** Return the current balance.
      @return the current balance.
  */
  public double getBalance() {
    return this.balance;
  }

  /** Deposit into account.
      @param amount the amount to deposit
      @return whether or not the transaction was successful
  */
  public boolean deposit(double amount) {
    return this.updateBalance(amount);
  }

  /** Withdraw from account.
      @param amount the amount to withdraw
      @return whether or not the transaction was successful
  */
  public boolean withdraw(double amount) {
    return this.updateBalance(- amount);
  }

  /** A helper method that adds its argument to the balance, if it
      wouldn't cause an overdraft.
      @param amount the amount to add to the balance (negative to withdraw)
      @return whether or not the transaction was successful 
  */
  private boolean updateBalance(double amount) {
    if (this.balance + amount < 0) {
      // don't change the balance, if this would overdraw it.  
      // print an error message instead.
      System.out.println("Sorry, you don't have that much money to withdraw.");
      return false;
    } else {
      // update the balance
      this.balance = this.balance + amount;
      return true;
    }
  }

  /** Transfer an amount of money from my account to another account.
      @param otherAccount the account to transfer to
      @param amount the amount to transfer
  */
  public void transferTo(BankAccount otherAccount, double amount) {
    // first, try to withdraw from my account
    boolean withdrawalOK = this.withdraw(amount);
    
    // if my account had enough money, then do the deposit, 
    // otherwise do nothing
    if (withdrawalOK) {
      otherAccount.deposit(amount);
    }
  }

  /** Compute a string representation of the account, e.g. for printing out */
  public String toString() {
    return "BankAccount#" + this.accountNumber + 
      " (owned by " + this.ownerName + "): current balance: " + this.balance;
  }

  /** A method to test out the BankAccount operations */
  public static void test() {
    BankAccount myAccount = new BankAccount("Joe Bob");
    myAccount.deposit(100.00);
    myAccount.deposit(250.00);
    myAccount.withdraw(50.00);
    System.out.println(myAccount);  // automatically calls myAccount.toString()

    BankAccount yourAccount = new BankAccount("Sue Jane");
    yourAccount.deposit(75.50);
    yourAccount.withdraw(20.00);
    System.out.println(yourAccount);

    yourAccount.withdraw(1000000.00);
    System.out.println(yourAccount);

    myAccount.transferTo(yourAccount, 60.00);

    System.out.println(myAccount);
    System.out.println(yourAccount);
  }

}