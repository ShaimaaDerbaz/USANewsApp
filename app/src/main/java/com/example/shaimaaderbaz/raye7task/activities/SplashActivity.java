package com.example.shaimaaderbaz.raye7task.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shaimaaderbaz.raye7task.R;

public class SplashActivity extends AppCompatActivity {
   Context mContext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        mContext=this;
        Thread timer=new Thread() {
            public void run() {

                try
                {
                    sleep(3000);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally {

                        AllNewsActivity.start(mContext);

                }
            }

        };
        timer.start();
    }
}
