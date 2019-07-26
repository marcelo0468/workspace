package br.com.digitalhouse.mvvmexercicioapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mvvmexercicioapplication.adapters.RecyclerViewProdutosAdapter;
import br.com.digitalhouse.mvvmexercicioapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mvvmexercicioapplication.model.Produtos;

public class MainActivity extends AppCompatActivity implements RecyclerViewOnItemClickListener {

    private FloatingActionButton fab_add;
    private FloatingActionButton fab_More;
    private RecyclerView recyclerViewProdutos;
    private RecyclerViewProdutosAdapter adapter;
    private List<Produtos> listaDeProdutos = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Produtos prod = new Produtos();
        prod.setNomeDoProduto("Produto1");
        prod.setPreco(100.00);

        listaDeProdutos.add(prod);

        fab_add = findViewById(R.id.fabAdd);
        fab_More = findViewById(R.id.fabMore);
        recyclerViewProdutos = findViewById(R.id.recyclerviewProdutos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewProdutos.setLayoutManager(layoutManager);

        adapter = new RecyclerViewProdutosAdapter(listaDeProdutos, this);

        recyclerViewProdutos.setAdapter(adapter);



    }
}
