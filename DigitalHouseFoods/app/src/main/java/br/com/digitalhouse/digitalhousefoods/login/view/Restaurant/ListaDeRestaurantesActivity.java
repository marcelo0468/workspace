package br.com.digitalhouse.digitalhousefoods.login.view.Restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.profile.ProfileActivity;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;

public class ListaDeRestaurantesActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestaurantAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_de_restaurantes);

        recyclerView = findViewById(R.id.recyclerViewRestaurant);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerViewRestaurantAdapter(getRestaurant(), this);
        recyclerView.setAdapter(adapter);

    }

    private List<Restaurant> getRestaurant(){
        List<Restaurant> restaurant = new ArrayList<>();
        restaurant.add(new Restaurant("Olive Garden","17985 Biscayne Blvd Aventura, FL 33160, EUA", "Close at 23pm",R.drawable.tflmain1));
        restaurant.add(new Restaurant("Red Lobster","2522 Candler Rd Decatur, GA 30032, EUA", "Close at 22pm",R.drawable.tflmain2));
        restaurant.add(new Restaurant("The French Laundry","6640 Washington St, Yountville, CA 94599, EUA", "Close at 23pm",R.drawable.tflmain3));
        restaurant.add(new Restaurant("Bubba Gump","1501 Broadway New York, NY 10036, EUA", "Close at 22pm",R.drawable.tflmain4));
        restaurant.add(new Restaurant("Tony Roma's","200 East Fremont St, Las Vegas, NV 89101, EUA", "Close at 00am",R.drawable.tflmain5));
        return restaurant;
    }

    @Override
    public void onClick(Restaurant restaurant) {
        Intent intent = new Intent(this, DetalheRestaurantActivity.class);
        intent.putExtra("RESTAURANT", restaurant);
        startActivity(intent);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            Intent intent = new Intent(ListaDeRestaurantesActivity.this, ProfileActivity.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
