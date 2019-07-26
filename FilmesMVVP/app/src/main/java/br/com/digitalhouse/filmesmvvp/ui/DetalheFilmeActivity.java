package br.com.digitalhouse.filmesmvvp.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.digitalhouse.filmesmvvp.R;
import br.com.digitalhouse.filmesmvvp.model.Filme;

public class DetalheFilmeActivity extends AppCompatActivity {

    private ArrayList<Filme> filmes;
    private TextView titulo;
    private TextView descricao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_filme);



        if(getIntent() != null && getIntent().getExtras() != null){
            filmes = getIntent().getParcelableExtra("FILMESELECIONADO");
            if(filmes != null){

                titulo = findViewById(R.id.textViewTitulo);
                descricao = findViewById(R.id.textViewDescricao);
                titulo.setText(filmes.get(0).getTitulo());
                descricao.setText((filmes.get(0).getDescricao()));

            }
        }

    }
}
