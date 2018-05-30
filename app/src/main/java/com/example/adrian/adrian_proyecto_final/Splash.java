package com.example.adrian.adrian_proyecto_final;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adrian.adrian_proyecto_final.activities.LoginActivity;

public class Splash extends AppCompatActivity {
    boolean user_logged = false;
    // Duración en milisegundos que se mostrará el splash
    private final int DURACION_SPLASH = 2000; // 2 segundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        /**
         * Leemos los SharedPreferences, esto para saber si hay un usuario loggeado
         */
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); // Leemos los shared preferences guardados
        user_logged = preferences.getBoolean("user_logged", false);

        /**
         * Creamos un nuevo intento, dependiendo de si tenemos un usuario logeado o no, sera el activity que se abrira
         */




        new Handler().postDelayed(new Runnable() {
            public void run() {
                if (user_logged) {
                    Intent intent = new Intent(getApplicationContext(), com.example.adrian.adrian_proyecto_final.activities.MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                }
            }

            ;
        },DURACION_SPLASH);
    }
}
