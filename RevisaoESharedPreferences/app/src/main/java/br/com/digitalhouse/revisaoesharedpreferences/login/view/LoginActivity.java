package br.com.digitalhouse.revisaoesharedpreferences.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.home.view.HomeActivity;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;
    private Switch switchLembrar;
    private Button btnEntrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutSenha);
        switchLembrar = findViewById(R.id.switchLembrar);
        btnEntrar = findViewById(R.id.btbEntrar);

        final SharedPreferences preferences = getSharedPreferences("APP", MODE_PRIVATE);
        textInputLayoutEmail.getEditText().setText(preferences.getString("EMAIL", ""));
        textInputLayoutSenha.getEditText().setText(preferences.getString("SENHA", ""));

        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(switchLembrar.isChecked()){
                    String email = textInputLayoutEmail.getEditText().getText().toString();
                    String senha = textInputLayoutSenha.getEditText().getText().toString();
                    preferences.edit().putString("EMAIL", email).commit();
                    preferences.edit().putString("SENHA", senha).apply();

                }

                Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }

}
