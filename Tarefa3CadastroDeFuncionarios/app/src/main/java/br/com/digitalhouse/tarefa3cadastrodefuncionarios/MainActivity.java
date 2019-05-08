package br.com.digitalhouse.tarefa3cadastrodefuncionarios;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextEmail;
    EditText editTextEndereco;
    EditText editTextProfissao;
    Button btnEnviar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.nome);
        editTextEmail = findViewById(R.id.email);
        editTextEndereco = findViewById(R.id.endereco);
        editTextProfissao = findViewById(R.id.profissao);
        btnEnviar = findViewById(R.id.enviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();
                String endereco = editTextEndereco.getText().toString();
                String profissao = editTextProfissao.getText().toString();

                if(nome.equals("") || email.equals("") || endereco.equals("") || profissao.equals("")){
                    Toast.makeText(MainActivity.this, "Preencha todos os campos para enviar!", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MainActivity.this, "Cadastro OK.", Toast.LENGTH_SHORT).show();}
            }
        });
s


    }
}
