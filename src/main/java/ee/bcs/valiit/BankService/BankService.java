package ee.bcs.valiit.BankService;

import ee.bcs.valiit.AccountRepository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class BankService {
    @Autowired
    private BankRepository bankRepository;

    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void createAccount(String accountNr, Double balance, String name) {
        bankRepository.createAccount(accountNr, balance, name);
//        bankRepository.accountUnblock(accountNr);
    }

    public double getBalance(String accountNr) {

        return bankRepository.getBalance(accountNr);
    }

    public Double putDeposit(String accountNr, Double deposit) {
        return bankRepository.update(accountNr, bankRepository.getBalance(accountNr) + deposit);

    }

    public String withdraw(String accountNr, Double amount) {
        if (amount <= 0) {
            return "You cannot withdraw less or equal to 0.";
        }
        if (bankRepository.getBalance(accountNr) > amount) {
            bankRepository.update(accountNr, bankRepository.getBalance(accountNr) - amount);
        }
        return "";
    }

    public String transfer(String accountNr, double amountToTransfer, String toAccount) {

        Double FromAccountCurrentBalance = getBalance(accountNr);

//        Double ToAccountCurrentBalance = getBalance(toAccount);
        if (amountToTransfer <= 0) {
            return "You cannot transfer less or equal to 0.";

        } else if (FromAccountCurrentBalance > amountToTransfer) {
            withdraw(accountNr, amountToTransfer);
            putDeposit(toAccount, amountToTransfer);
            return "You withdrew " + amountToTransfer + " from account number   " + accountNr + " and deposited "
                    + amountToTransfer + " to other account " + toAccount;
        }
        return "The account you are transferring from cannot be negative.";

    }

    public Boolean checkedBlock(String accountNr) {
        return bankRepository.showIfBlocked(accountNr);
    }

    public void accountUnblock(String accountNumber){
        bankRepository.accountUnblock(accountNumber);
    }

    public void accountBlock (String accountNumber){
        bankRepository.accountBlock(accountNumber);
    }

}
