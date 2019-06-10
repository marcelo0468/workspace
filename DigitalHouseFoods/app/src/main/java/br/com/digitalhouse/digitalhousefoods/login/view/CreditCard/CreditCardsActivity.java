package br.com.digitalhouse.digitalhousefoods.login.view.CreditCard;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.profile.RegisterCreditCardActivity;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class CreditCardsActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewCreditCardAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_cards);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView =findViewById(R.id.recyclerViewCreditCard);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewCreditCardAdapter(getCreditCard(), this);
        recyclerView.setAdapter(adapter);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(CreditCardsActivity.this, RegisterCreditCardActivity.class);
               startActivity(intent);
            }
        });
    }

    private List<CreditCard> getCreditCard() {
        List<CreditCard> card = new ArrayList<>();
        card.add(new CreditCard("Marcelo ELO", "1234 1234 1234 1234", 123));
        card.add(new CreditCard("Marcelo MASTERCARD", "2345 2345 2345 2345", 123));
        card.add(new CreditCard("Marcelo VISA", "3456 3456 3456 3456", 123));
        card.add(new CreditCard("Marcelo DINERS", "4321 4321 4321 4321", 123));
        return card;
    }


    @Override
    public void onClick(Restaurant restaurant) {

    }

    @Override
    public void onClick(RestaurantPlates plate) {

    }

    @Override
    public void onClick(CreditCard card) {

    }
}
