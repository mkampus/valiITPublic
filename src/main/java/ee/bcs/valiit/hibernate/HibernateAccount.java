package ee.bcs.valiit.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="accounts")
@Entity
public class HibernateAccount {
    // Juhul kui on auto increment id tulp
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;

    // andmebaasis peab olema tulba nimi: account_number
    @Id
    private String account_number;

    private Double balance;

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String accountNumber) {
        this.account_number = accountNumber;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
