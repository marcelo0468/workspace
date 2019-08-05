package br.com.digitalhouse.mycarapplication.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.mycarapplication.R;
import br.com.digitalhouse.mycarapplication.adapters.RecyclerViewAbastecimentoAdapter;
import br.com.digitalhouse.mycarapplication.dao.AbastecimentoDAO;
import br.com.digitalhouse.mycarapplication.dao.Database;
import br.com.digitalhouse.mycarapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mycarapplication.model.Abastecimento;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private AbastecimentoDAO dao;
    private RecyclerView recyclerViewAbastecimento;
    private RecyclerViewAbastecimentoAdapter adapter;
    private List<Abastecimento> abastecimentoList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Controle de consumo");

        recyclerViewAbastecimento = findViewById(R.id.lista_abastecimentos);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerViewAbastecimento.setLayoutManager(layoutManager);

        adapter = new RecyclerViewAbastecimentoAdapter(abastecimentoList, this);

        recyclerViewAbastecimento.setAdapter(adapter);

        dao = Database.getDatabase(this).abastecimentoDAO();

        atualizaLista();


        FloatingActionButton fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, AbastecimentoActivity.class);
            startActivity(intent);
        });


    }

    void atualizaLista() {
        dao.getAllRxJava()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(abastecimentos -> {
                    adapter.update(abastecimentos);
                }, throwable -> {
                    Log.i("TAG", "buscarTodosOsAbastecimentos: " + throwable.getMessage());
                });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


}
