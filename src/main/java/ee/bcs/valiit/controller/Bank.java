package ee.bcs.valiit.controller;


import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController

public class Bank {
    public static HashMap<String, Account> accountBalanceMap = new HashMap<>();
    /// peab lisama getmapping 0 main menyy pmst, siis vahetad url et mida soovid teha


    @GetMapping("createaccount/{accountNumber}/{balance}/{name}")
    public static String createAccount(@PathVariable("accountNumber") String accountNumber,
                                       @PathVariable("balance") Double balance,
                                       @PathVariable("name") String ownerName) {
        Account account = new Account();
        account.setAccountNumber(accountNumber);
        account.setBalance(balance);
        account.setOwnerName(ownerName);
        account.setLocked(false);

        accountBalanceMap.put(accountNumber, 0.0);
        return "New account added w balance =  " + accountBalanceMap.get(accountNumber) +
                "Account number is: " + accountNumber; //also locked = false
    }

    @GetMapping("getbalance/{accountNumber}")
    public static Double getBalance(@PathVariable("accountNumber") String accountNumber) {
        return accountBalanceMap.get(accountNumber);
    }

    @GetMapping("deposit/{accountNumber}/{depositAmount}")
    public static String putDepositWeb(@PathVariable("accountNumber") String accountNumber,
                                       @PathVariable("depositAmount") double deposit) {

        if (deposit > 0) {
            double oldBalance = getBalance(accountNumber);
            accountBalanceMap.put(accountNumber, oldBalance + deposit);
        }
        String ReturnBalance = "Your money has been deposited. Your balance is " + accountBalanceMap.get(accountNumber);
        return ReturnBalance;
//        String putDeposit = "Your balance is: " + accountBalanceMap.get(accountNumber);
    }


// TODO 4
// Add command: "withdrawMoney ${accountNr} ${amount}
// This has to remove specified amount of money from account
// You have to check that amount is positive number
// You may not allow this transaction if account balance would become negative

    @GetMapping("withdraw/{accountnumber}/{withdrawAmount}")
    public String WithdrawMoney(@PathVariable("accountnumber") String accountNumber,
                                @PathVariable("withdrawAmount") double withdrawAmount) {
        double balance = 0;
        if (accountBalanceMap.get(accountNumber) > withdrawAmount) {
            balance = accountBalanceMap.get(accountNumber) - withdrawAmount;
            accountBalanceMap.put(accountNumber, balance);
        }
        return "After withdrawing your new balance is " + accountBalanceMap.get(accountNumber);
    }


    // TODO 5
// Add command: "transfer ${fromAccount} ${toAccount} ${amount}
// This has to remove specified amount from fromAccount and add it to toAccount
// Your application needs to check that toAccount is positive
// And from account has enough money to do that transaction
    @GetMapping("transfer/{fromAccount}/{amount}/{toAccount}")
    public String TransferMoney(@PathVariable("fromAccount") String accountNumber,
                                @PathVariable("amount") double amountToTransfer,
                                @PathVariable("toAccount") String toAccount) {
        double fromAccountBalance = getBalance(accountNumber);
        double toAccountBalance = getBalance(toAccount);
        if (!(accountBalanceMap.containsKey(toAccount))) {
            return "No account found!";
        } else if ((toAccountBalance < 0)) {
            return "You  cannot transfer to an account that is in the negative!";

        } else if (amountToTransfer <= 0) {
            return "You cannot transfer less or equal to 0.";
        } else if ((fromAccountBalance - amountToTransfer) < 0) {
            return "Your account that you are transferring from cannot be negative!";
        } else {
            double newBalance = fromAccountBalance - amountToTransfer;
            double newBalanceToAccount = toAccountBalance + amountToTransfer;
            accountBalanceMap.replace(accountNumber, newBalance);
            accountBalanceMap.replace(toAccount, newBalanceToAccount);
            return "Your account nr " + accountNumber + " now holds " + newBalance +
                    "Your account nr " + toAccount + " now holds " + newBalanceToAccount;
        }
    }

    //

    @PutMapping("bank/account/{accountnumber}/lock") {

    }


}

// teha map strig accountist, mitte double.