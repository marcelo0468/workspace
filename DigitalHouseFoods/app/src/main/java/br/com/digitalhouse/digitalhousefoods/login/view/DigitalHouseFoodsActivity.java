package br.com.digitalhouse.digitalhousefoods.login.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.profile.RegisterActivity;
import br.com.digitalhouse.digitalhousefoods.login.view.Restaurant.ListaDeRestaurantesActivity;

public class DigitalHouseFoodsActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnLoginFacebook;
    private Button btnRegister;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private CheckBox checkBoxRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_digital_house_foods);

        initViews();


        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DigitalHouseFoodsActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });

        btnLoginFacebook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginAuthorized();
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((textInputLayoutEmail.getEditText().getText().toString().equals("mail@mail.com") &&
                        textInputLayoutPassword.getEditText().getText().toString().equals("123123")) || checkBoxRemember.isChecked()){
                    loginAuthorized();
                } else {
                    Toast.makeText(DigitalHouseFoodsActivity.this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();}
            }
        });

        final SharedPreferences preferences = getSharedPreferences("APP", MODE_PRIVATE);
        textInputLayoutEmail.getEditText().setText(preferences.getString("EMAIL", ""));
        textInputLayoutPassword.getEditText().setText(preferences.getString("PASSWORD", ""));

        checkBoxRemember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               if(checkBoxRemember.isChecked()){
                   String email = textInputLayoutEmail.getEditText().getText().toString();
                   String password = textInputLayoutPassword.getEditText().getText().toString();
                   preferences.edit().putString("EMAIL", email).apply();
                   preferences.edit().putString("PASSWORD", password).apply();
               }
               loginAuthorized();
            }
        });

    }

    private void loginAuthorized() {
        Intent intent = new Intent(DigitalHouseFoodsActivity.this, ListaDeRestaurantesActivity.class);
        startActivity(intent);
    }

    private void initViews() {
        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutPassword = findViewById(R.id.textInputLayoutPassword);
        btnLogin = findViewById(R.id.buttonLogin);
        btnLoginFacebook = findViewById(R.id.buttonLoginFacebook);
        btnRegister = findViewById(R.id.buttonRegister);
        checkBoxRemember = findViewById(R.id.checkBoxRemember);
    }

}
