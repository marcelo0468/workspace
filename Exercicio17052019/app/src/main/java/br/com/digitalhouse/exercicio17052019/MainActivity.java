package br.com.digitalhouse.exercicio17052019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textViewBoasVindas;
    private TextView textViewNome;
    private TextView textViewSobrenome;
    private TextView textViewIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewBoasVindas = findViewById(R.id.textViewBoasVindas);
        textViewNome = findViewById(R.id.textViewNome);
        textViewSobrenome = findViewById(R.id.textViewSobrenome);
        textViewIdade = findViewById(R.id.textViewIdade);

        Bundle bundle = getIntent().getExtras();

        textViewBoasVindas.setText("Olá "+ bundle.getString("NOME") + " seja bem-vindo!");
        textViewNome.setText("Nome: "+ bundle.getString("NOME") );
        textViewSobrenome.setText("Sobrenome: "+ bundle.getString("SOBRENOME"));
        textViewIdade.setText("Idade: "+ bundle.getString("IDADE"));

    }
}
