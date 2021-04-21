package ee.bcs.valiit.AccountRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class BankRepository {

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr, Double balance, String name) {
        String sql = "INSERT INTO accounts(account_number, balance, name) VALUES(:dbAccNo, :dbAmount, :dbName)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", balance);
        paramMap.put("dbName", name);
        jdbcTemplate.update(sql, paramMap);
    }

    public double getBalance(String accountNr) {
        String sql = "SELECT balance FROM accounts WHERE account_number=:dbAccNo";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        double dbBalance = jdbcTemplate.queryForObject(sql, paramMap, Double.class);
        return dbBalance;
    }

    public Double update (String accountNr, Double amount){
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("dbAccNo", accountNr);
        paramMap.put("dbAmount", amount);
        String sql = "UPDATE accounts SET balance=:dbAmount WHERE account_number=:dbAccNo";
        jdbcTemplate.update(sql, paramMap);
        return amount;
    }

    public Boolean showIfBlocked (String accNo){
        String sql = "SELECT block FROM accounts WHERE account_number = :dbAccountNumber";
        Map<String,Object> paramMap = new HashMap <>();
        paramMap.put("dbAccountNumber", accNo);
        Boolean blocked = jdbcTemplate.queryForObject(sql, paramMap, Boolean.class);
        return blocked;
    }

    public void accountUnblock (String accountNumber){
        String sql = "UPDATE accounts SET block = :dbBlocked WHERE account_number = :dbAccountNumber";
        Map<String,Object> paramMap = new HashMap <>();
        paramMap.put("dbAccountNumber", accountNumber);
        Boolean dbValue = false;
        paramMap.put("dbBlocked", dbValue);
        jdbcTemplate.update(sql, paramMap);
    }


//    public Double deposit(String accountNumber, Double deposit) {
//        Double CurrentBalance = getBalance(accountNumber);
//        String sql1 = "UPDATE accounts SET balance=:newBalance WHERE account_number=:dbAccNo";
//        Map<String, Object> paramMap1 = new HashMap<>();
//        paramMap1.put("dbAccNo", accountNumber);
//        Double newBalance = CurrentBalance + deposit;
//        paramMap1.put("newBalance", newBalance);
//        jdbcTemplate.update(sql1, paramMap1); // iga kord update  kui tahad uuendada
//        return newBalance;
//    }

//    public void withdraw(String accountNumber, double withdrawAmount) {
//        Double CurrentBalance = getBalance(accountNumber);
//        String sql1 = "UPDATE accounts SET balance=:newBalance WHERE account_number=:dbAccNo";
//        Map<String, Object> paramMap1 = new HashMap<>();
//        paramMap1.put("dbAccNo", accountNumber);
//        Double newBalance = CurrentBalance - withdrawAmount;
//        paramMap1.put("newBalance", newBalance);
//        jdbcTemplate.update(sql1, paramMap1);
//    }
}
