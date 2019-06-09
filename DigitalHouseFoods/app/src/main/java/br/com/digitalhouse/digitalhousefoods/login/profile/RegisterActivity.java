package br.com.digitalhouse.digitalhousefoods.login.profile;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutName;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutPassword;
    private TextInputLayout textInputLayoutPasswordC;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputLayoutName = findViewById(R.id.textInputRegisterName);
        textInputLayoutEmail = findViewById(R.id.textInputRegisterEmail);
        textInputLayoutPassword = findViewById(R.id.textInputRegisterPassword);
        textInputLayoutPasswordC = findViewById(R.id.textInputRegisterPasswordC);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!textInputLayoutPassword.getEditText().getText().toString().equals(textInputLayoutPasswordC.getEditText().getText().toString())){
                    Toast.makeText(RegisterActivity.this, "As senhas digitadas não conferem", Toast.LENGTH_SHORT).show();
                } else {Toast.makeText(RegisterActivity.this, "Registro atualizado com sucesso", Toast.LENGTH_SHORT).show();
                    finish();}
            }
        });


    }




}
