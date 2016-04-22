package com.example.java_android_thread;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
public class MainActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bank model = new Bank("UIC Bank");
        ControllerSimple cs = new ControllerSimple(model);
        ViewSimple vs = (ViewSimple)findViewById(R.id.textView1);
        vs.setMVC(model, cs);
        // Adding two accounts to the model to check that the view
        // correctly displays the result (2500).
        model.addAccount(new CreditAccount("Philippe", 1000));
        try {
            model.addAccount(new StudentAccount("Meunier", 1500));
        } catch(NotEnoughMoneyException ex) {
            // This should never happen!
            Toast.makeText(this, "This should never happen!", Toast.LENGTH_SHORT).show();
        }
        // Add a ViewGetMoney view with a ControllerGetMoney controller
        // and the same model as before.
        ControllerGetMoney cgm = new ControllerGetMoney(model);
        ViewGetMoney vgm = (ViewGetMoney)findViewById(R.id.button1);
        vgm.setMVC(model, cgm);
        // Add a ViewWithdraw view that uses a ControllerWithdraw controller
        // and the same model as before.
        ControllerWithdraw cw = new ControllerWithdraw(model);
        ViewWithdraw vw = (ViewWithdraw)findViewById(R.id.button2);
        vw.setMVC(model, cw);
        BankRunnable b1 = new BankRunnable(model);
        Thread t1 = new Thread(b1, "Thread1");
        BankRunnable b2 = new BankRunnable(model);
        Thread t2 = new Thread(b2, "Thread2");

        t1.start();
        t2.start();
    }
}

