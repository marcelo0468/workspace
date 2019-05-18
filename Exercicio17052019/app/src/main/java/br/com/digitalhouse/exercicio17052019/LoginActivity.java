package br.com.digitalhouse.exercicio17052019;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutNome;
    private TextInputLayout textInputLayoutSobrenome;
    private TextInputLayout textInputLayoutIdade;
    private Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputLayoutNome = findViewById(R.id.textInputLayoutNome);
        textInputLayoutSobrenome = findViewById(R.id.textInputLayoutSobrenome);
        textInputLayoutIdade = findViewById(R.id.textInputLayoutIdade);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = textInputLayoutNome.getEditText().getText().toString();
                String sobrenome = textInputLayoutSobrenome.getEditText().getText().toString();
                Editable idade = textInputLayoutIdade.getEditText().getText();

                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("NOME", nome);
                bundle.putString("SOBRENOME", sobrenome);
                bundle.putString("IDADE", String.valueOf(idade));
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}
