package br.com.digitalhouse.marveldesafioapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.marveldesafioapplication.R;
import br.com.digitalhouse.marveldesafioapplication.adapters.RecyclerViewMarvelAdapter;
import br.com.digitalhouse.marveldesafioapplication.model.Result;
import br.com.digitalhouse.marveldesafioapplication.viewmodel.MarvelViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerMarvel;
    private RecyclerViewMarvelAdapter adapter;
    private List<Result> results = new ArrayList<>();
    private MarvelViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MARVEL");

        initView();
        viewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);

        viewModel.buscarMarvel();

        viewModel.getMarvelLiveData().observe(this, (List<Result> results) -> {
            adapter.update(results);
        });

        viewModel.getLoadingLiveData().observe(this, loading -> {

        });


    }

    private void initView() {

        recyclerMarvel = findViewById(R.id.recyclerview);
        recyclerMarvel.setAdapter(adapter);
        adapter = new RecyclerViewMarvelAdapter(results);
        recyclerMarvel.setHasFixedSize(true);
        recyclerMarvel.setItemViewCacheSize(20);
        recyclerMarvel.setLayoutManager(new GridLayoutManager(this, 3));

    }
}
