package com.example.babybest.alcquizapp;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

public class MainActivity extends AppCompatActivity {

    /**
     * Duration of wait
     **/
    private final int SPLASH_DISPLAY_LENGTH = 3000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         /* New Handler to start the Home-Activity
         * and close this Splash-Screen after some seconds.*/

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                /* Create an Intent that will start the Home-Activity. */

                Intent mainIntent = new Intent(MainActivity.this, Home.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        }, SPLASH_DISPLAY_LENGTH);
    }
}

