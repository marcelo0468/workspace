package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class ListaCardapioActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewCardapioAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_cardapio);


        recyclerView = findViewById(R.id.recyclerViewCardapio);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new RecyclerViewCardapioAdapter((Restaurant) getMenu(), this);
        recyclerView.setAdapter(adapter);

        ///recebe parcelablecomo receber parcelable


    }

    private ArrayList getMenu() {

        ArrayList restaurant = getIntent().getParcelableArrayListExtra("RESTAURANT");
        return restaurant;
    }

    @Override
    public void onClick(Restaurant menu) {

        Intent intent = new Intent(this, DetalheCardapioActivity.class);
        intent.putParcelableArrayListExtra("MENU", menu);
        startActivity(intent);

    }

    @Override
    public void onClick(Parcelable[] plates) {

    }


    @Override
    public void onClick(CreditCard card) {

    }


}
