package com.example.adrian.adrian_proyecto_final.activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.adrian.adrian_proyecto_final.R;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private NestedScrollView nestedScrollView;


    private TextInputEditText textInputEditTextUsuario, textInputEditTextContraseña;
    private CheckBox checkBoxMantenerSesion;
    private AppCompatButton buttonLogin;
    private AppCompatTextView textViewRegistrarNuevoUsuario;
    private String[] usuarios;
    private String[] users_saved;
    private String user, password, user_saved, pass_saved;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initViews();
        initListeners();
        initSharedPreferences();


    }

    private void initSharedPreferences() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        editor = preferences.edit();

        //lee los sharedPreferences
        if (preferences.contains("user_logged") && preferences.getBoolean("user_logged", false) == true) {
            checkBoxMantenerSesion.setChecked(true);
        } else {
            checkBoxMantenerSesion.setChecked(false);
        }
    }

    /**
     * Este metodo inicializa las vistas, hace la vinculacion de los objetos
     */
    private void initViews() {
        nestedScrollView = (NestedScrollView) findViewById(R.id.nestedScrollView);
        textInputEditTextUsuario = (TextInputEditText) findViewById(R.id.textInputEditTextUser);
        textInputEditTextContraseña = (TextInputEditText) findViewById(R.id.textInputEditTextPassword);

        checkBoxMantenerSesion = (CheckBox) findViewById(R.id.checkboxMantenerSesion);

        buttonLogin = (AppCompatButton) findViewById(R.id.appCompatButtonLogin);

        textViewRegistrarNuevoUsuario = (AppCompatTextView) findViewById(R.id.textViewLinkRegister);
    }

    /**
     * Inicializa los Listeners
     */
    private void initListeners() {
        buttonLogin.setOnClickListener(this);
        textViewRegistrarNuevoUsuario.setOnClickListener(this);
        checkBoxMantenerSesion.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.appCompatButtonLogin:
                if (!initFile()) { // Si no se encuentra el archivo de los usuarios posiblemente no haya ninguno guardado
                    Toast.makeText(this, R.string.not_users_saved, Toast.LENGTH_LONG).show();
                    return;
                }
                // verifyCheckBox();
                verifyUser();
                break;

            case R.id.textViewLinkRegister:
                //Abre el activity Register
                Intent intentRegister = new Intent(getApplicationContext(), RegisterActivity.class);

                startActivity(intentRegister);
                break;

            case R.id.checkboxMantenerSesion:
                if (checkBoxMantenerSesion.isChecked()) {
                    editor.putBoolean("user_logged", true);
                    editor.apply();
                } else {
                    editor.putBoolean("user_logged", false);
                    editor.apply();
                }
        }
    }

    /**
     * verificar si el usuario y la contrasena son correctos.
     */
    private void verifyUser() {
        user = textInputEditTextUsuario.getText().toString();
        password = textInputEditTextContraseña.getText().toString();


        if ((user.length() == 0) || (password.length() == 0)) {
            Snackbar.make(nestedScrollView, getString(R.string.user_or_pass_empty), Snackbar.LENGTH_LONG).show();
        } else {
            for (int i = 0; i <= usuarios.length - 1; i++) {

                // En caso de que llegue al final del archivo y los datos no correspondan con los ingresados termina el ciclo for
                if (i == usuarios.length - 1) {
                    Snackbar.make(nestedScrollView, getString(R.string.wrong_user_or_password), Snackbar.LENGTH_LONG).show();
                    return;
                }

              users_saved = usuarios[i].split(","); // Leemos linea por linea el archivo donde estan guardados los datos de los usuarios y hacemos un nuevo arreglo con los datos de la linea
                user_saved = users_saved[  1];// leemos el correo
                    pass_saved = users_saved[2]; // leemos la contraseña

                if ((user_saved.equals(user)) && (pass_saved.equals(password))) {
                    Intent intentMainFragment = new Intent(getApplicationContext(), MainActivity.class);
                    intentMainFragment.putExtra("USERNAME", users_saved[0]); // usuario
                    intentMainFragment.putExtra("EMAIL", users_saved[1]); // correo
                    startActivity(intentMainFragment);
                    return;
                } else {

                }
            }



        }

    }

    @NonNull
    private Boolean initFile() {
        try {
            BufferedReader fin =
                    new BufferedReader(
                            new InputStreamReader(
                                    openFileInput("usuarios.txt")));

            usuarios = fin.readLine().split(";");
            fin.close();
            return true;
        } catch (Exception ex) {
            Log.e("Ficheros", "Error al leer fichero desde memoria interna");
            return false;
        }
    }
}
