package com.gabo.recipes.presentation;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gabo.recipes.R;
import com.gabo.recipes.presentation.search.RecipeSearchActivity;

public class SplashActivity extends AppCompatActivity {

    private final static Long SPLASH_DURATION  = 3000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_activity);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startApp();
            }
        }, SPLASH_DURATION);
    }

    private void startApp() {

        Intent intent = new Intent(SplashActivity.this, RecipeSearchActivity.class);
        startActivity(intent);
        finish();
    }
}
