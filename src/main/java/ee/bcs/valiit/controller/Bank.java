package ee.bcs.valiit.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Scanner;

@RestController

public class Bank {
    public static HashMap<String, AccountData> accountBalanceMap = new HashMap<>();
    /// peab lisama getmapping 0 main menyy pmst, siis vahetad url et mida soovid teha


    @GetMapping("createaccount/{accountNumber}/{name}")
    public static String createAccount(@PathVariable("accountNumber") String accountNumber,
                                       @PathVariable("name") String ownerName) {
        AccountData account = new AccountData();
        account.setAccountNumber(accountNumber);
        account.setBalance(0.0);
        account.setOwnerName(ownerName);
        account.setLocked(false);
        accountBalanceMap.put(accountNumber, account);
        return "New account added w balance =  " + account.getBalance() + " " +
                "Account number is: " + accountNumber; //also locked = false
    }

    @GetMapping("getbalance/{accountNumber}")
    public static String getBalance(@PathVariable("accountNumber") String accountNumber) {
        AccountData getBalanceRequest = accountBalanceMap.get(accountNumber);
        double balance = getBalanceRequest.getBalance();
        if (getBalanceRequest.isLocked()) {
            return "Account is locked.";
        }
        return "Your balance is :" + balance;
    }

    @GetMapping("deposit/{accountNumber}/{depositAmount}")
    public static String putDepositWeb(@PathVariable("accountNumber") String accountNumber,
                                       @PathVariable("depositAmount") double deposit) {
        AccountData getDepositRequest = accountBalanceMap.get(accountNumber);
        double balance = getDepositRequest.getBalance();
        if (getDepositRequest.isLocked()) {
            return "Account is locked.";
        }
        if (deposit > 0) {
            balance = balance + deposit;
            getDepositRequest.setBalance(balance);
        }

        return "Your money has been deposited. Your balance is " + getDepositRequest.getBalance();
    }

    @GetMapping("withdraw/{accountnumber}/{withdrawAmount}")
    public String WithdrawMoney(@PathVariable("accountnumber") String accountNumber,
                                @PathVariable("withdrawAmount") double withdrawAmount) {
        AccountData getWithdrawRequest = accountBalanceMap.get(accountNumber);
        double balance = getWithdrawRequest.getBalance();
        if (!(accountBalanceMap.containsKey(accountNumber))) {
            return "No account found!";
        }
        if (withdrawAmount <= 0) {
            return "You cannot withdraw less or equal to 0.";
        }
        if (getWithdrawRequest.isLocked()) {
            return "Account is locked.";
        }
        if (getWithdrawRequest.getBalance() > withdrawAmount) {
            balance = getWithdrawRequest.getBalance() - withdrawAmount;
            getWithdrawRequest.setBalance(balance);
            return "You withdrew "  + withdrawAmount + "  from account number   " + getWithdrawRequest.getAccountNumber() +
                    "  your new balance is " + getWithdrawRequest.getBalance();
        }
        if ((getWithdrawRequest.getBalance() - withdrawAmount) < 0) {
            return "Your account cannot be negative!";
        }
        return "";
    }


//    // TODO 5
//// Add command: "transfer ${fromAccount} ${toAccount} ${amount}
//// This has to remove specified amount from fromAccount and add it to toAccount
//// Your application needs to check that toAccount is positive
//// And from account has enough money to do that transaction
//    @GetMapping("transfer/{fromAccount}/{amount}/{toAccount}")
//    public String TransferMoney(@PathVariable("fromAccount") String accountNumber,
//                                @PathVariable("amount") double amountToTransfer,
//                                @PathVariable("toAccount") String toAccount) {
//        double fromAccountBalance = getBalance(accountNumber);
//        double toAccountBalance = getBalance(toAccount);
//        if (!(accountBalanceMap.containsKey(toAccount))) {
//            return "No account found!";
//        } else if ((toAccountBalance < 0)) {
//            return "You  cannot transfer to an account that is in the negative!";
//
//        } else if (amountToTransfer <= 0) {
//            return "You cannot transfer less or equal to 0.";
//        } else if ((fromAccountBalance - amountToTransfer) < 0) {
//            return "Your account that you are transferring from cannot be negative!";
//        } else {
//            double newBalance = fromAccountBalance - amountToTransfer;
//            double newBalanceToAccount = toAccountBalance + amountToTransfer;
//            accountBalanceMap.replace(accountNumber, newBalance);
//            accountBalanceMap.replace(toAccount, newBalanceToAccount);
//            return "Your account nr " + accountNumber + " now holds " + newBalance +
//                    "Your account nr " + toAccount + " now holds " + newBalanceToAccount;
//        }
//    }
//
//    //
//
//    @PutMapping("bank/account/{accountnumber}/lock") {
//
//    }


}

// teha map strig accountist, mitte double.