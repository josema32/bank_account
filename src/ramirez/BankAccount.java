/*
 * Name:            Jose Ramirez
 * 
 * Program:         Bank Account Application    
 * 
 * Description:     This aplication creates 3 customers for a bank and 
 *                  manipulates different transactions to handle the customers 
 *                  financial information.
 * 
 * Date Started:    4/15/18
 * Last Modified:   4/20/18
 * 
 */

package ramirez;

import java.util.Scanner;
import java.text.DecimalFormat;

public class BankAccount 
{
    public static void main(String[] args) 
    {
        // scanner object for keyboard input
        Scanner keyboard = new Scanner(System.in);
        
        // holds the account number entered
        int     account;
        // validates the accounts
        boolean accountValidator  = false;
        // limits the chances to log in
        int     loopCounter       = 1;
        // holds the current customer entered pin number
        int     pinNum;
        // validates the customer password once entered
        boolean passwordValidator = false;
        
        // customer accounts
        Account bob   = new Account("Bob Bones", 1111, 100.00);
        Account mary  = new Account("Mary Mack", 2222, 200.00);
        Account sally = new Account("Sally Star", 1111, 300.00);
        
        // method calling the bank welcome message
        bankWelcomeMessage();
        
        // account validation section
        do
        {
            System.out.println("Please enter your account number: ");

            account = keyboard.nextInt();
            
            System.out.println("Please enter your 4 digit pin number: ");
                
            pinNum = keyboard.nextInt();

            if (account == bob.getCustomerAccountNo() && pinNum == bob.getPinNum())
            {
                accountValidator  = true;
                passwordValidator = true;
                accessAccount(bob);
            }
            else if (account == mary.getCustomerAccountNo() && pinNum == mary.getPinNum())
            {
                accountValidator  = true;
                passwordValidator = true;
                accessAccount(mary);
            }
            else if (account == sally.getCustomerAccountNo() && pinNum == sally.getPinNum())
            {
                accountValidator  = true;
                passwordValidator = true;
                accessAccount(sally);   
            }
            else if (loopCounter > 3)
            {
                System.out.println("\nPlease try again later or contact your financial institution.\n\n");
                bankThankYou();
                System.exit(0);
            }
            
            else
            {
                System.out.println("The account number and/or pin are incorrect.");
            }
            
            ++loopCounter;
            
        } while (!accountValidator && !passwordValidator || loopCounter == 2);
    }
    
    // Bank welcome banner.
    public static void bankWelcomeMessage()
    {
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*          WELCOME TO JAVA BEANS BANK           *");
        System.out.println("*                                               *");
        System.out.println("*************************************************\n\n");
    }
    
    // Bank thank you banner.
    public static void bankThankYou()
    {
        System.out.println("*************************************************");
        System.out.println("*                                               *");
        System.out.println("*              THANKS FOR VISITING!             *");
        System.out.println("*            WE HOPE TO SEE YOU SOON.           *");
        System.out.println("*                                               *");
        System.out.println("*************************************************\n\n");
    }
    
    // Menu options for the different account transactions.
    public static void optionMenu()
    {
        System.out.println("\nPlease choose an option from the menu: \n\n"
                          + "( 1 ) ==> Deposit\n"
                          + "( 2 ) ==> Withdrawal\n"
                          + "( 3 ) ==> Check Balance\n"
                          + "(-1 ) ==> Log Out\n");
    }
    
    // Handles the transaction operations for the current customer.
    public static void accessAccount(Account currentCust)
    {
        System.out.println("\n\nWelcome to your account " + 
                           currentCust.getCustomerName()  + ".\n");
        // scanner obaject instatiation for keyboard input
        Scanner keyboard  = new Scanner(System.in);
        // decimal formatting object instatiation for account transaction output
        DecimalFormat df1 = new DecimalFormat("$###,##0.00");    

        // holds the current user choice
        int    userOption;
        // holds the current user transaction amount
        double amount;
        
        // user transaction handling section
        do
        {
            optionMenu();
            
            userOption = keyboard.nextInt();
            
            switch (userOption)
            {
                case  1: System.out.println("\nHow much would you like to " + 
                                            "deposit: ");
                
                         amount = keyboard.nextDouble();
                         currentCust.setDeposit(amount);
                         break;
                
                case  2: System.out.println("\nEnter the amount you would like " +
                                            "to withdraw from the account: ");
                
                         amount = keyboard.nextDouble();
                         currentCust.getWithdrawal(amount);
                         break;
                    
                case  3: System.out.println("\nThis is your current balance: " + 
                                            df1.format(currentCust.getBalance()));
                         break;
                
                case -1: System.out.println("You have been logged out.\n\n");
                         bankThankYou();
                         System.exit(0);
                         break;
                         
                default: System.out.println("The option you have chosen is " + 
                                            "invalid, please try again.\n\n");
                         break;
            }  
        }while (userOption != -1);
    } // end of main
} // end of class 
