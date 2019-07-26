package br.com.digitalhouse.exerciciomvvmapplication.receivers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Parcelable;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import br.com.digitalhouse.exerciciomvvmapplication.R;
import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;

public class SelecionadosActivity extends AppCompatActivity {

    private TextView total;
    private ArrayList<Produtos> selecionados;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selecionados);

        total = findViewById(R.id.totalselecionado);

        if(getIntent() != null && getIntent().getExtras() != null){
            selecionados = getIntent().getParcelableArrayListExtra("SELECIONADOS");
            if(selecionados != null){
                double totalacum = 0;
                String produtos = " ";
                for (int i = 0 ; i < selecionados.size(); i++
                     ) {
                    totalacum += selecionados.get(i).getPreco();
                    produtos = produtos + selecionados.get(i).getNomeProduto()+" ";
                }
                total.setText("Valor da seleção: " + totalacum + " " + produtos);


            }
        }

    }
}
