package com.sm.demo.salesmanagement;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.sm.demo.salesmanagement.login.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();

            }
        }, SPLASH_TIME_OUT);
    }
}
