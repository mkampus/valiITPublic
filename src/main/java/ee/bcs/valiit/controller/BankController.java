package ee.bcs.valiit.controller;


import ee.bcs.valiit.BankService.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController

public class BankController {
    public static HashMap<String, AccountData> accountBalanceMap = new HashMap<>();
    /// peab lisama getmapping 0 main menyy pmst, siis vahetad url et mida soovid teha


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired
    private BankService bankService;


    @GetMapping("createaccount/{accountNumber}/{name}")
    public String createAccount(@PathVariable("accountNumber") String accountNumber,
                                @PathVariable("name") String ownerName) {
        double balance = 0.0;
        bankService.createAccount(accountNumber, balance, ownerName);
        bankService.accountUnblock(accountNumber);
        return "New account added w balance =  " + balance + " " +
                "Account number is: " + accountNumber; //also locked = false
    }


    @GetMapping("getbalance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNumber) {
        if (bankService.checkedBlock(accountNumber)) {
            return "Your account is blocked";
        } else{
            AccountData getBalanceRequest = accountBalanceMap.get(accountNumber);
            double Balance = bankService.getBalance(accountNumber);
            return "Your balance is: " + Balance;
        }
    }

    @GetMapping("deposit/{accountNumber}/{depositAmount}")
    public String putDepositWeb(@PathVariable("accountNumber") String accountNumber,
                                @PathVariable("depositAmount") double deposit) {
        double newBalance = bankService.putDeposit(accountNumber, deposit);

        return "Your money has been deposited. Your balance is: " + newBalance;
    }


    @GetMapping("withdraw/{accountnumber}/{withdrawAmount}")
    public String WithdrawMoney(@PathVariable("accountnumber") String accountNumber,
                                @PathVariable("withdrawAmount") double withdrawAmount) {
        bankService.withdraw(accountNumber, withdrawAmount);
        double balance = bankService.getBalance(accountNumber);
        return "You withdrew " + withdrawAmount + "  from account number   " + accountNumber +
                "  your new balance is: " + balance;
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
        return bankService.transfer(accountNumber, amountToTransfer, toAccount);
    }

    //
//    //
//
//    @PutMapping("bank/account/{accountnumber}/lock") {
//
//    }
    String sql = "SELECT balance FROM accounts WHERE account_number=:dbFromAccNo";
//        Map<String, Object> paramMap = new HashMap<>();
//        paramMap.put("dbFromAccNo", accountNumber);
//        Double FromAccountCurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
//        Map<String, Object> paramMap1 = new HashMap<>();
//        paramMap1.put("dbToAccNo", toAccount);
//        String sqlTo = "SELECT balance FROM accounts WHERE account_number=:dbToAccNo";
//        Double ToAccountCurrentBalance = jdbcTemplate.queryForObject(sqlTo, paramMap1, Double.class);
//        if (amountToTransfer <= 0) {
//            return "You cannot transfer less or equal to 0.";
//        } else if (FromAccountCurrentBalance > amountToTransfer) {
//            String sql1 = "UPDATE accounts SET balance=:FromNewBalance WHERE account_number=:dbFromAccNo";
//            String sql2 = "UPDATE accounts SET balance=:ToNewBalance WHERE account_number=:dbToAccNo";
//            Map<String, Object> paramMap2 = new HashMap<>();
//            Map<String, Object> paramMap3 = new HashMap<>();
//            Double FromNewBalance = FromAccountCurrentBalance - amountToTransfer;
//            Double ToNewBalance = ToAccountCurrentBalance + amountToTransfer;
//            paramMap2.put("FromNewBalance", FromNewBalance);
//            paramMap2.put("dbFromAccNo", accountNumber);
//            paramMap3.put("ToNewBalance", ToNewBalance);
//            paramMap3.put("dbToAccNo", toAccount);
//            jdbcTemplate.update(sql1, paramMap2);
//            jdbcTemplate.update(sql2, paramMap3);
//            return "You withdrew " + amountToTransfer + " from account number   " + accountNumber + " and deposited "
//                    + amountToTransfer + " to other account " + toAccount;
//        }
//        return "The account you are transferring from cannot be negative.";

}

