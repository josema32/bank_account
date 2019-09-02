/*
 * Name:            Jose Ramirez
 * 
 * Program:         Account Class    
 * 
 * Description:     This class contains the constructor and main methods to be
 *                  used on the Bank Account application.
 * 
 * Date Started:    4/13/18
 * Last Modified:   4/20/18
 * 
 */

package ramirez;

public class Account
{
    // holds the customer name
    private String customerName;
    // holds the customer pin number
    private int    pinNum;
    // holds the customer current balance
    private double balance;
    // holds the customer account number
    private int    accountNo = 100;
    // generates a unique account number for each customer
    private static int    accountNoCounter = 101;
    
    
    // constructor
    public Account(String name, int pin, double bal)
    {
        customerName   = name;
        pinNum         = pin;
        balance        = bal;
        accountNo      = accountNoCounter++;
    }
    
    /** 
     *  Returns the customer's account balance.
     */
    public double getBalance()
    {
        return  balance;
    }
    
    /** 
     *  Handles deposits on the customer account.
     */
    public void setDeposit(double amount)
    {
        balance += amount;
    }
    
    /** 
     *  Handles withdrawals on the customer account, with conditions.
     */
    public void getWithdrawal(double amount)
    {
        if (balance > 0.00)
        {
            if (amount > balance)
            {
                balance -= amount;
                System.out.println("This amount has place an overdraft "  +
                                   "on your account. Please add to your " + 
                                   "balance to avoid fees.");
            }
            else
            {
                balance -= amount;
            }
        }
        else
        {
            System.out.println("You don't have enough funds on your account.");
        }
    }
    
    /** 
     *  Returns the customer's name on the account.
     */
    public String getCustomerName()
    {
        return customerName;
    }
    
    /** 
     *  Returns the customers account number.
     */
    public int getCustomerAccountNo()
    {
        return accountNo;
    }
    
    /** 
     *  Returns the customers account pin number.
     */
    public int getPinNum()
    {
        return pinNum;
    } 
} // end of class
