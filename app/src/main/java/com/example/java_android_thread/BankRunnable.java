package com.example.java_android_thread;

import android.widget.Toast;

/**
 * Created by i330014059 on 22/04/2016.
 */
public class BankRunnable implements Runnable {
    private Bank bank;
    /**
     * Starts executing the active part of the class' code. This method is
     * called when a thread is started that has been created with a class which
     * implements {@code Runnable}.
     */
    BankRunnable(Bank bank){
        this.bank = bank;
    }
    public void run() {
        for(int i = 0; i < 100; i++){
            try {
                synchronized (bank){
                    this.bank.withdraw("Philippe", 1000);
                }
                synchronized (bank){
                    this.bank.withdraw("Philippe", -1000);
                }
            } catch (UnknownCustomerException e) {
                e.printStackTrace();
            } catch (NotEnoughMoneyException e) {
                e.printStackTrace();
            }
        }
    }
}
