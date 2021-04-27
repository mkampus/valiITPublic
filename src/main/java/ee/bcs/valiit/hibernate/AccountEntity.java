package ee.bcs.valiit.hibernate;

import javax.persistence.*;

@Table (name = "accounts")
@Entity
public class AccountEntity {

    @Id
    private String account_number;

    private String name;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    private Double balance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private Boolean block;

    public Boolean getBlock() {
        return block;
    }

    public void setBlock(Boolean block) {
        this.block = block;
    }


    public Double getBalance() {
        return balance;
    }

    public Double setBalance(Double balance) {
        this.balance = balance;
        return balance;
    }

}
