package ee.bcs.valiit.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController

public class Bank {
    public static HashMap<String, AccountData> accountBalanceMap = new HashMap<>();
    /// peab lisama getmapping 0 main menyy pmst, siis vahetad url et mida soovid teha


    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

@GetMapping("showall")
public String showAll{
String sql = "SELECT * FROM accounts";
Map<String, Object> paramMap = new HashMap<>();
String ShowAll = jdbcTemplate.queryForObject();

    }

    @GetMapping("createaccount/{accountNumber}/{name}")
    public String createAccount(@PathVariable("accountNumber") String accountNumber,
                                @PathVariable("name") String ownerName) {
        String sql = "INSERT INTO accounts(account_number, name, balance) VALUES(:dbAccNo, :dbName, :dbAmount)";
        Map<String, Object> paramMap = new HashMap<>();
        double balance = 0.0;
        paramMap.put("dbAccNo", accountNumber);
        paramMap.put("dbName", ownerName);
        paramMap.put("dbAmount", balance);
        jdbcTemplate.update(sql, paramMap);
//        AccountData account = new AccountData();
//        account.setAccountNumber(accountNumber);
//        account.setBalance(0.0);
//        account.setOwnerName(ownerName);
//        account.setLocked(false);
//        accountBalanceMap.put(accountNumber, account);
        return "New account added w balance =  " + balance + " " +
                "Account number is: " + accountNumber; //also locked = false
    }

    @GetMapping("getbalance/{accountNumber}")
    public String getBalance(@PathVariable("accountNumber") String accountNumber) {
        AccountData getBalanceRequest = accountBalanceMap.get(accountNumber);
        String sql = "SELECT balance FROM accounts WHERE account_number=:dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNumber);
        double dbBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);

        return "Your balance is :" + dbBalance;
    }

    @GetMapping("deposit/{accountNumber}/{depositAmount}")
    public String putDepositWeb(@PathVariable("accountNumber") String accountNumber,
                                @PathVariable("depositAmount") double deposit) {
        String sql = "SELECT balance FROM accounts WHERE account_number=:dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNumber);
        Double CurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class); // iga kord kui tahad andmeid saada
        if (deposit < 0) {
            return "Cannot deposit less than 0";
        } else {
            String sql1 = "UPDATE accounts SET balance=:newBalance WHERE account_number=:dbAccNo";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("dbAccNo", accountNumber);
            Double newBalance = CurrentBalance + deposit;
            paramMap1.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap1); // iga kord update  kui tahad uuendada
            return "Your money has been deposited. Your balance is " + newBalance;
        }

    }

    @GetMapping("withdraw/{accountnumber}/{withdrawAmount}")
    public String WithdrawMoney(@PathVariable("accountnumber") String accountNumber,
                                @PathVariable("withdrawAmount") double withdrawAmount) {
        String sql = "SELECT balance FROM accounts WHERE account_number=:dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNumber);
        Double CurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
//        AccountData getWithdrawRequest = accountBalanceMap.get(accountNumber);
//        double balance = getWithdrawRequest.getBalance();
        if (withdrawAmount <= 0) {
            return "You cannot withdraw less or equal to 0.";
        }
        if (CurrentBalance > withdrawAmount) {
            String sql1 = "UPDATE accounts SET balance=:newBalance WHERE account_number=:dbAccNo";
            Map<String, Object> paramMap1 = new HashMap<>();
            paramMap1.put("dbAccNo", accountNumber);
            Double newBalance = CurrentBalance - withdrawAmount;
            paramMap1.put("newBalance", newBalance);
            jdbcTemplate.update(sql1, paramMap1);
            return "You withdrew " + withdrawAmount + "  from account number   " + accountNumber +
                    "  your new balance is " + newBalance;
        }
        if ((CurrentBalance - withdrawAmount) < 0) {
            return "Your account cannot be negative!";
        }
        return "";
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
        String sql = "SELECT balance FROM accounts WHERE account_number=:dbFromAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbFromAccNo", accountNumber);
        Double FromAccountCurrentBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        Map<String, Object> paramMap1 = new HashMap<>();
        paramMap1.put("dbToAccNo", toAccount);
        String sqlTo = "SELECT balance FROM accounts WHERE account_number=:dbToAccNo";
        Double ToAccountCurrentBalance = jdbcTemplate.queryForObject(sqlTo, paramMap1, Double.class);
        if (amountToTransfer <= 0) {
            return "You cannot transfer less or equal to 0.";
        } else if (FromAccountCurrentBalance > amountToTransfer) {
            String sql1 = "UPDATE accounts SET balance=:FromNewBalance WHERE account_number=:dbFromAccNo";
            String sql2 = "UPDATE accounts SET balance=:ToNewBalance WHERE account_number=:dbToAccNo";
            Map<String, Object> paramMap2 = new HashMap<>();
            Map<String, Object> paramMap3 = new HashMap<>();
            Double FromNewBalance = FromAccountCurrentBalance - amountToTransfer;
            Double ToNewBalance = ToAccountCurrentBalance + amountToTransfer;
            paramMap2.put("FromNewBalance", FromNewBalance);
            paramMap2.put("dbFromAccNo", accountNumber);
            paramMap3.put("ToNewBalance", ToNewBalance);
            paramMap3.put("dbToAccNo", toAccount);
            jdbcTemplate.update(sql1, paramMap2);
            jdbcTemplate.update(sql2, paramMap3);
            return "You withdrew " + amountToTransfer + " from account number   " + accountNumber + " and deposited "
                    + amountToTransfer + " to other account " + toAccount;
        }
        return "The account you are transferring from cannot be negative.";
    }
//
//    //
//
//    @PutMapping("bank/account/{accountnumber}/lock") {
//
//    }


}

