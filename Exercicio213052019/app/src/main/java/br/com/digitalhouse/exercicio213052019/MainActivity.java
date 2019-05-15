package br.com.digitalhouse.exercicio213052019;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextPrecoDoProduto;
    EditText editTextPorcentagemDeDesconto;
    Button btnValorTotalAPagar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        editTextPrecoDoProduto = findViewById(R.id.editPrecoDoProduto);
        editTextPorcentagemDeDesconto = findViewById(R.id.editPorcentagemDeDesconto);
        btnValorTotalAPagar = findViewById(R.id.btnValorTotalAPagar);
        
        btnValorTotalAPagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double preco = Double.parseDouble(editTextPrecoDoProduto.getText().toString());
                double desconto = Double.parseDouble(editTextPorcentagemDeDesconto.getText().toString());
                String valor = String.valueOf(preco - (preco*(desconto/100)));
                Toast.makeText(MainActivity.this, "Valor a ser pago R$: " + valor, Toast.LENGTH_LONG).show();
                
            }
        });
        
    }
}
