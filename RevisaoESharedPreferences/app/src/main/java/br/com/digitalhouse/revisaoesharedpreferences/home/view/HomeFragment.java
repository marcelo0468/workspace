package br.com.digitalhouse.revisaoesharedpreferences.home.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.adapters.RecyclerViewClickListener;
import br.com.digitalhouse.revisaoesharedpreferences.adapters.RecyclerViewContatoAdapter;
import br.com.digitalhouse.revisaoesharedpreferences.detalhe.view.DetalheActivity;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contato;


public class HomeFragment extends Fragment implements RecyclerViewClickListener {


    public HomeFragment() {
        // Required empty public constructor
    }

    private RecyclerView recyclerView;
    private RecyclerViewContatoAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        //add findviewbyid
        RecyclerView recyclerViewContato = view.findViewById(R.id.recyclerViewContato);
        //config recyclerview e adapter
        RecyclerViewContatoAdapter adapter = new RecyclerViewContatoAdapter(getContatos(), this);

        recyclerViewContato.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerViewContato.setAdapter(adapter);

        return view;
    }

    private List<Contato> getContatos() {
        List<Contato> contatos = new ArrayList<>();
        contatos.add(new Contato("Tairo", "11-91111-1111", R.drawable.ic_action_name_edit));
        contatos.add(new Contato("Jessica", "11-91111-1111", R.drawable.ic_action_name_edit));
        contatos.add(new Contato("Jair", "11-91111-1111", R.drawable.ic_action_name_edit));
        contatos.add(new Contato("Vinicius", "11-91111-1111", R.drawable.ic_action_name_edit));
        contatos.add(new Contato("Eduardo", "11-91111-1111", R.drawable.ic_action_name_edit));
        contatos.add(new Contato("Ivan", "11-91111-1111", R.drawable.ic_action_name_edit));

        return contatos;


    }

    @Override
    public void onClick(Contato contato) {
        Intent intent = new Intent(getContext(), DetalheActivity.class);
        intent.putExtra("CONTATO", contato);
        startActivity(intent);
    }
}
