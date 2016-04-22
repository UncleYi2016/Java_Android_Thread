package com.example.java_android_thread;

/**
 * Created by i330014059 on 22/04/2016.
 */
public class CreditAccount extends Account {
    public CreditAccount(String name, int money) {
        super(name, money);
    }
    // The withdraw method of the CreditAccount class simply subtracts the
    // amount of money given as argument to the method from the amount of
    // money currently stored in the account. A credit account is allowed to
    // have a negative amount of money in the account, so money can be
    // withdrawn from a credit account even if this makes the amount of money
    // in the credit account become negative.
    // The public getMoney method and the protected setMoney method are
    // inherited from the superclass Account.
    public synchronized void withdraw(int amount) {
        // Sleep between [0, 5) milliseconds.
        try {
            Thread.sleep((int)(5 * Math.random()));
        } catch(InterruptedException ex) {
        }
        // Get the current amount of money from the account.
        int money = getMoney();
        // Sleep between [0, 5) milliseconds.
        try {
            Thread.sleep((int)(5 * Math.random()));
        } catch(InterruptedException ex) {
        }
        // Change the current amount of money of the account.
        setMoney(money - amount);
    }
    public static void TestCreditAccount() {
        CreditAccount c = new CreditAccount("Philippe", 1000);
        System.out.println(c.getName() == "Philippe");
        System.out.println(c.getMoney() == 1000);
        c.setMoney(2000);
        System.out.println(c.getMoney() == 2000);
        c.withdraw(500);
        System.out.println(c.getMoney() == 1500);
        c.withdraw(2000);
        System.out.println(c.getMoney() == -500);
    }
}
