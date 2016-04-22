package com.example.java_android_thread;

/**
 * Created by i330014059 on 22/04/2016.
 */
public interface IAccount {
    String getName();
    int getMoney();
    void withdraw(int amount) throws NotEnoughMoneyException;
}

