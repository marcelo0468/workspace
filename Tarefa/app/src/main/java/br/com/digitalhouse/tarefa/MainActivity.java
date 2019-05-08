package br.com.digitalhouse.tarefa;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextEmail;
    Button btnEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        editTextEmail = findViewById(R.id.editTextEmail);
        btnEnviar = findViewById(R.id.btnEnviar);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = editTextNome.getText().toString();
                String email = editTextEmail.getText().toString();


                if (nome.equals("")){
                    Toast.makeText(MainActivity.this, "Preencha campo Nome!", Toast.LENGTH_LONG).show();
                    return;
                }

                if (email.equals("")){
                    Toast.makeText(MainActivity.this, "Preencha campo Email!", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(MainActivity.this, "Validação OK!", Toast.LENGTH_SHORT).show();

            }
        });


    }
}
