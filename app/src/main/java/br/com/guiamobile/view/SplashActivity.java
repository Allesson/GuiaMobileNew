package br.com.guiamobile.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import br.com.guiamobile.R;

public class SplashActivity extends Activity implements Runnable {

    private Handler splashScreen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        splashScreen = new Handler();
        splashScreen.postDelayed(SplashActivity.this, 100);
    }
    @Override
    public void run() {
        Intent minha = new Intent(SplashActivity.this, MainActivity.class);
        SplashActivity.this.startActivity(minha);
        SplashActivity.this.finish();
    }

}
