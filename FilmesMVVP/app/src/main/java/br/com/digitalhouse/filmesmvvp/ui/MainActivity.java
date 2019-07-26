package br.com.digitalhouse.filmesmvvp.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.filmesmvvp.R;
import br.com.digitalhouse.filmesmvvp.adapters.RecyclerViewFimesAdapter;
import br.com.digitalhouse.filmesmvvp.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.filmesmvvp.model.Filme;
import br.com.digitalhouse.filmesmvvp.viewmodel.FilmesViewModel;


public class MainActivity extends AppCompatActivity implements RecyclerViewOnItemClickListener {

    private RecyclerView recyclerViewNotidias;
    private ProgressBar progressBar;
    private RecyclerViewFimesAdapter adapter;
    private ArrayList<Filme> filmes = new ArrayList<>();
    private FilmesViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Filmes em cartaz");

        progressBar = findViewById(R.id.progressBar);
        recyclerViewNotidias = findViewById(R.id.recyclerViewFilmes);
        recyclerViewNotidias.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewFimesAdapter(filmes, this);
        recyclerViewNotidias.setHasFixedSize(true);
        recyclerViewNotidias.setAdapter(adapter);

        // Fazer a inicialização do view model
        viewModel = ViewModelProviders.of(this).get(FilmesViewModel.class);

        // Buscar os dados no repository
        viewModel.buscarfilmes();

        // Adicionar os observables
        viewModel.getfilmesLiveData().observe(this, filmes -> {
            adapter.update(filmes);
        });

        viewModel.getLoadingLiveData().observe(this, isLoading ->{
            if(isLoading){
                progressBar.setVisibility(View.VISIBLE);
            }else{
                progressBar.setVisibility(View.GONE);
            }
        } );

        viewModel.getErrorLiveData().observe(this,throwable -> {
            Snackbar.make(recyclerViewNotidias, throwable.getMessage(), Snackbar.LENGTH_SHORT).show();
        });

    }

    @Override
    public void onItemClick(Filme filme) {

        Toast.makeText(MainActivity.this, "Selecionado: " + filme.getTitulo(), Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(MainActivity.this, DetalheFilmeActivity.class);
        intent.putExtra("FILMESELECIONADO", filme);
        startActivity(intent);

    }
}