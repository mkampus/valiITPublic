package ee.bcs.valiit.controller;


import ee.bcs.valiit.tasks.Lesson4;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController

public class Bank {
    public static HashMap<String, Double> accountBalanceMap = new HashMap<>();
    /// peab lisama getmapping 0 main menyy pmst, siis vahetad url et mida soovid teha


    @GetMapping("createaccount/{accountNumber}")
    public void createAccount(@PathVariable("accountNumber") String accountNumber) {
        accountBalanceMap.put(accountNumber, 0.0);
        System.out.println("New account added w balance =  " + accountBalanceMap.get(accountNumber) +
                "Account number is: " + accountNumber);
    }

//    @GetMapping("sample/employees/{a}")
//    public Employee rosterGet(@PathVariable ("a") int a){
//        Employee tagastus = employeeList.get(a);
//        return tagastus;
//    }

    @GetMapping("getbalance/{accountNumber}")
    public Double getBalance(@PathVariable("accountNumber") String accountNumber) {
        return accountBalanceMap.get(accountNumber);
    }

    @GetMapping("deposit/{accountNumber}/{depositAmount}")
    public String putDepositWeb(@PathVariable("accountNumber") String accNr, @PathVariable("depositAmount")double deposit) {
//        String putDeposit = "Your balance is: " + accountBalanceMap.get(accountNumber);
        return
    }


}
