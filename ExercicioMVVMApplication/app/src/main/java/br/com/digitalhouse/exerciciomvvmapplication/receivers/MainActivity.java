package br.com.digitalhouse.exerciciomvvmapplication.receivers;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.exerciciomvvmapplication.R;
import br.com.digitalhouse.exerciciomvvmapplication.data.database.Database;
import br.com.digitalhouse.exerciciomvvmapplication.data.database.dao.ProdutosDAO;
import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;
import br.com.digitalhouse.exerciciomvvmapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.exerciciomvvmapplication.recyclerView.RecyclerViewProdutosAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnItemClickListener {

    private RecyclerView recyclerViewProdutos;
    private RecyclerViewProdutosAdapter adapter;
    private ArrayList<Produtos> produtos = new ArrayList<>();
    private ArrayList<Produtos> selecionados = new ArrayList<>();
    private ProdutosDAO dao;
    private CheckBox select;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Produtos");



        recyclerViewProdutos = findViewById(R.id.recyclerViewProdutos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewProdutos.setLayoutManager(layoutManager);

        adapter = new RecyclerViewProdutosAdapter(produtos, this);

        recyclerViewProdutos.setAdapter(adapter);

        dao = Database.getDatabase(this).produtosDAO();

        buscarTodosProdutos();


        FloatingActionButton fab = findViewById(R.id.fabAdd);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AdicionaProdutoActivity.class);
                startActivity(intent);
            }
        });

        FloatingActionButton fab1 = findViewById(R.id.fabMore);
        fab1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SelecionadosActivity.class);
                intent.putExtra("SELECIONADOS", selecionados);
                startActivity(intent);

            }
        });
    }

    protected void onResume() {
        buscarTodosProdutos();
        selecionados.clear();
        super.onResume();
    }

    private void buscarTodosProdutos() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                List<Produtos> produtos = dao.getAll();

                MainActivity.this.runOnUiThread(() -> {
                    adapter.update(produtos);
                });

            }
        }).start();
    }

    @Override
    public void onClick(Produtos produtos) {
        selecionados.add(produtos);
        Toast.makeText(this, "Item selecionado: " +  produtos.getNomeProduto(), Toast.LENGTH_SHORT).show();
    }
}
