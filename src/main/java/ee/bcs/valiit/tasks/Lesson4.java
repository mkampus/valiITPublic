package ee.bcs.valiit.tasks;

import java.util.*;

public class Lesson4 {
    // Store account nr as a key and account balance as value
    private String Accountnumber;
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountnumber() {
        return Accountnumber;
    }

    public void setAccountnumber(String accountnumber) {
        Accountnumber = accountnumber;
    }

    public static void main(String[] args) {

//        Scanner scanner = new Scanner(System.in);
        HashMap<String, Double> accountBalanceMap = new HashMap<>();
        while (true) {
            System.out.println("\n" + "Welcome to MartBank! Whaddya' want?!?" + "\n" +
                    "\n" + "1 - createAccount " +
                    "\n" + "2 -getBalance" +
                    "\n" + "3 -depositMoney" +
                    "\n" + "4 -withdrawMoney" +
                    "\n" + "5 -transfer" +
                    "\n" + "6 -exit from MartBank!");

//            String firstInputWritten = scanner.nextLine();

            // TODO 1
            // Add command: "createAccount ${accountNr}"
            // this has to store accountNr with 0 balance
            //mapnimi.put on see mida vaja
            System.out.println("Account Number:");
            Scanner createAccount = new Scanner(System.in);
            String accountNumber = createAccount.next();
            double zeroMoney = 0.00;
            accountBalanceMap.put(accountNumber, zeroMoney);
            System.out.print("Account Number: " + accountNumber + " Your balance is: " + zeroMoney);
//                break;


            // TODO 2
            // Add command: "getBalance ${accountNr}"
            // this has to display account balance of specific account
//                System.out.println("Enter account number:");
//                Scanner getBalance = new Scanner(System.in);
//                String accountNumber = getBalance.next();
            if (!(accountBalanceMap.containsKey(accountNumber))) {
                System.out.println("No account found!");
            } else {
                System.out.print(accountBalanceMap.get(accountNumber));
                break;
            }


            // TODO 3
            // Add command: "depositMoney ${accountNr} ${amount}
            // this has to add specified amount of money to account
            // You have to check that amount is positive number


            // TODO 4
            // Add command: "withdrawMoney ${accountNr} ${amount}
            // This has to remove specified amount of money from account
            // You have to check that amount is positive number
            // You may not allow this transaction if account balance would become negative

            System.out.println("Enter account number:");
            Scanner accountNumberAsk = new Scanner(System.in);
//                String accountNumber = accountNumberAsk.next();
            double oldBalance = accountBalanceMap.get(accountNumber);
            if (!(accountBalanceMap.containsKey(accountNumber))) {
                System.out.println("No account found!");
            } else {
                System.out.println("How much do you wish to withdraw?");
                Scanner withdrawMoney = new Scanner(System.in);
                double amountToWithdraw = withdrawMoney.nextInt();
                if (amountToWithdraw <= 0) {
                    System.out.println("You cannot withdraw less or equal to 0.");
                    break;
                } else if ((accountBalanceMap.get(accountNumber) - amountToWithdraw) < 0) {
                    System.out.println("Your account cannot be negative!");
                    break;
                } else if ((accountBalanceMap.get(accountNumber) - amountToWithdraw) >= 0) {
                    double newBalance = oldBalance - amountToWithdraw;
                    accountBalanceMap.replace(accountNumber, newBalance);
                    System.out.println("Your account nr " + accountNumber + " now holds " + newBalance);
                    break;
                }
            }


//                Scanner accountNumberAsk = new Scanner(System.in);
//                String accountNumber = "0";
//                double oldBalance = 0;
            String toAccount = "0";
            double toAccountBalance = 0;
            double fromAccountBalance = 0;
            System.out.println("From which account do you wish to transfer?");
            String fromAccount = accountNumberAsk.next();
            fromAccountBalance = accountBalanceMap.get(fromAccount);
            System.out.println("How much do you wish to transfer?");
            double amountToTransfer = accountNumberAsk.nextInt();
            if (!(accountBalanceMap.containsKey(fromAccount))) {
                System.out.println("No account found!");
                break;
            } else if (amountToTransfer <= 0) {
                System.out.println("You cannot withdraw less or equal to 0.");
                break;
            } else if (fromAccountBalance < 0) {
                System.out.println("Your account cannot be negative!");
                break;
            }
            System.out.println("To which account to you wish to transfer?");
            toAccount = accountNumberAsk.next();
            toAccountBalance = accountBalanceMap.get(toAccount);
            if (!(accountBalanceMap.containsKey(toAccount))) {
                System.out.println("No account found!");
            } else if ((toAccountBalance < 0)) {
                System.out.println("You  cannot transfer to an account that is in the negative!");
                break;
            } else if (amountToTransfer <= 0) {
                System.out.println("You cannot transfer less or equal to 0.");
                break;
            } else if ((fromAccountBalance - amountToTransfer) < 0) {
                System.out.println("Your account that you are transferring from cannot be negative!");
                break;
            } else {
                double newBalance = fromAccountBalance - amountToTransfer;
                double newBalanceToAccount = toAccountBalance + amountToTransfer;
                accountBalanceMap.replace(fromAccount, newBalance);
                accountBalanceMap.replace(toAccount, newBalanceToAccount);
                System.out.println("Your account nr " + fromAccount + " now holds " + newBalance);
                System.out.println("Your account nr " + toAccount + " now holds " + newBalanceToAccount);
                break;
            }


            // TODO 5
            // Add command: "transfer ${fromAccount} ${toAccount} ${amount}
            // This has to remove specified amount from fromAccount and add it to toAccount
            // Your application needs to check that toAccount is positive
            // And from account has enough money to do that transaction


//            if (firstInputWritten.equalsIgnoreCase("6")) {
//                break;
//            } else {
//                System.out.println("Unknown command");
//                break;
//            }


        }
    }

    // TODO 1
    // Add command: "createAccount ${accountNr}"
    // this has to store accountNr with 0 balance
    //mapnimi.put on see mida vaja
    public static String createAccount(String text) {
        System.out.println("Account Number:");
        Scanner createAccount = new Scanner(System.in);
        String accountNumber = createAccount.next();
        double zeroMoney = 0.00;
//        accountBalanceMap.put(accountNumber, zeroMoney);
        System.out.print("Account Number: " + accountNumber + " Your balance is: " + zeroMoney);
//        break;

        return " ";
    }


// TODO 2
// Add command: "getBalance ${accountNr}"
// this has to display account balance of specific account

//public static String getBalance() {
//
//
//        String accountNumber = getBalance();
//        if (!(accountBalanceMap.containsKey(accountNumber))) {
//        System.out.println("No account found!");
//        } else {
//        System.out.print(accountBalanceMap.get(accountNumber));
//        break;
//        }
//
//        }


    // TODO 3
// Add command: "depositMoney ${accountNr} ${amount}
// this has to add specified amount of money to account
// You have to check that amount is positive number
    public static String depositMoney(String accNr, Double deposit) {

        if (deposit <= 0) {
            System.out.println("You cannot deposit 0 or less!");
        } else {
//            double oldBalance = accountBalanceMap.get(accNr);
//            double newBalance = oldBalance + deposit;
//            accountBalanceMap.put(accNr, newBalance);
            System.out.print("Your money has been deposited!");
//            System.out.print("Your account nr " + accNr + " now holds " + accountBalanceMap.get(accNr));
        }
        return "";
    }
}


// TODO 4
// Add command: "withdrawMoney ${accountNr} ${amount}
// This has to remove specified amount of money from account
// You have to check that amount is positive number
// You may not allow this transaction if account balance would become negative


// TODO 5
// Add command: "transfer ${fromAccount} ${toAccount} ${amount}
// This has to remove specified amount from fromAccount and add it to toAccount
// Your application needs to check that toAccount is positive
// And from account has enough money to do that transaction



