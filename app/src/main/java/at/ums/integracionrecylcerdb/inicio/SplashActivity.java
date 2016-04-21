package at.ums.integracionrecylcerdb.inicio;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import at.ums.integracionrecylcerdb.R;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Runnable ejecutable = new Runnable() {
            @Override
            public void run() {
                actividadPrincipal();
                finish();
            }
        };

        Handler miHandler = new Handler();
        miHandler.postDelayed(ejecutable, 1500);

    }
        public void actividadPrincipal(){
        Intent intento = new Intent(this, ActividadPrincipal.class);
        startActivity(intento);
    }

}
