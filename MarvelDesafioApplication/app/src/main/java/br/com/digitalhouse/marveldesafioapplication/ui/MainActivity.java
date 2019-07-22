package br.com.digitalhouse.marveldesafioapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toolbar;

import java.util.ArrayList;

import br.com.digitalhouse.marveldesafioapplication.R;
import br.com.digitalhouse.marveldesafioapplication.adapters.RecyclerViewMarvelAdapter;
import br.com.digitalhouse.marveldesafioapplication.viewmodel.MarvelViewModel;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerMarvel;
    private RecyclerViewMarvelAdapter adapter;
    private MarvelViewModel MarvelViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("MARVEL");

        initView();

        MarvelViewModel.buscarMarvel();


        MarvelViewModel.getMarvelLiveData().observe(this, results -> {
            adapter.update(results);
        });


        MarvelViewModel.getLoadingLiveData().observe(this, loading -> {

        });



    }

    private void initView() {

        MarvelViewModel = ViewModelProviders.of(this).get(MarvelViewModel.class);
        recyclerMarvel = findViewById(R.id.recyclerview);
        recyclerMarvel.setAdapter(adapter);
        adapter = new RecyclerViewMarvelAdapter(new ArrayList<>());
        recyclerMarvel.setHasFixedSize(true);
        recyclerMarvel.setItemViewCacheSize(30);
        recyclerMarvel.setAdapter(adapter);
        recyclerMarvel.setLayoutManager(new GridLayoutManager(this, 3));

    }
}
