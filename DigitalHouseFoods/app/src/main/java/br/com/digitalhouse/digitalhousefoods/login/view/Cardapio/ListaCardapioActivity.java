package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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
        Toast.makeText(this, "Teste ", Toast.LENGTH_SHORT).show();

        recyclerView = findViewById(R.id.recyclerViewCardapio);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        adapter = new RecyclerViewCardapioAdapter(getPlates(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<RestaurantPlates> getPlates(){
        List<RestaurantPlates> plates = new ArrayList<>();
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        plates.add(new RestaurantPlates("Teste", "teste", R.drawable.tflmain6));
        return plates;
    }

    @Override
    public void onClick(RestaurantPlates plates) {
        Intent intent = new Intent(this, DetalheCardapioActivity.class);
        intent.putExtra("PLATES", plates);
        startActivity(intent);
    }

    @Override
    public void onClick(CreditCard card) {

    }

    @Override
    public void onClick(Restaurant plates) {

    }
}
