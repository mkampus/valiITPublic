package ee.bcs.valiit.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table (name = "accounts")
@Entity
public class HibernateAccount {

    @Id
    private String account_number;

    private Double balance;

    private Boolean block;

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }

    public void setAccountNumber(String accountNumber) {
        this.account_number = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getAccountNumber(){
        return account_number;
    }
}
