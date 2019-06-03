package br.com.digitalhouse.listacontato.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.listacontato.R;
import br.com.digitalhouse.listacontato.adapter.ContatoAdapter;
import br.com.digitalhouse.listacontato.model.Contatos;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerViewContatos;
    ContatoAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewContatos = findViewById(R.id.listaContatosRecyclerView);
        adapter = new ContatoAdapter(listaDeContatos());
        recyclerViewContatos.setAdapter(adapter);
        recyclerViewContatos.setLayoutManager(new GridLayoutManager(this, 1));
    }

    private List<Contatos> listaDeContatos(){
        List<Contatos> contatos = new ArrayList<>();
        contatos.add(new Contatos("Marcelo", 222222));
        contatos.add(new Contatos("Rodrigo", 111111));
        contatos.add(new Contatos("Cristiane", 444444));
        contatos.add(new Contatos("Lucas",555555));
        contatos.add(new Contatos("Andrei", 666666));
        contatos.add(new Contatos("Ronaldo", 777777));
        contatos.add(new Contatos("Nelson", 888888));
        contatos.add(new Contatos("Maria", 999999));
        return contatos;

    }
}
