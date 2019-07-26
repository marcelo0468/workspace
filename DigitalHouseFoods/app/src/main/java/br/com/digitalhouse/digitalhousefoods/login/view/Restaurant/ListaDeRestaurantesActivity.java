package br.com.digitalhouse.digitalhousefoods.login.view.Restaurant;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.profile.ProfileActivity;
import br.com.digitalhouse.digitalhousefoods.login.view.Cardapio.DetalheCardapioActivity;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class ListaDeRestaurantesActivity extends AppCompatActivity implements RecyclerViewClickListener {

    private RecyclerView recyclerView;
    private RecyclerViewRestaurantAdapter adapter;
    private Object RestaurantPlates;


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
        
        List<RestaurantPlates> rp1 = new ArrayList<>();
        rp1.add(new RestaurantPlates("Seafood paella", "Descircao", R.drawable.plate1));
        rp1.add(new RestaurantPlates("Som tam", "Descircao", R.drawable.plate2));
        rp1.add(new RestaurantPlates("Poutine", "Descircao", R.drawable.plate3));
        rp1.add(new RestaurantPlates("Stinky tofu", "Descircao", R.drawable.plate4));
        rp1.add(new RestaurantPlates("French toast", "Descircao", R.drawable.plate5));
        rp1.add(new RestaurantPlates("Chicken parm", "Descircao", R.drawable.plate6));
        rp1.add(new RestaurantPlates("Fish 'n' chips", "Descircao", R.drawable.plate7));
        rp1.add(new RestaurantPlates("Tacos", "Descircao", R.drawable.plate8));
        rp1.add(new RestaurantPlates("Pho", "Descircao", R.drawable.plate9));
        rp1.add(new RestaurantPlates("Pastel de nata", "Descircao", R.drawable.plate10));

        List<RestaurantPlates> rp2 = new ArrayList<>();
        rp2.add(new RestaurantPlates("Butter garlic crab", "Descircao", R.drawable.plate11));
        rp2.add(new RestaurantPlates("Poke", "Descircao", R.drawable.plate12));
        rp2.add(new RestaurantPlates("Croissant", "Descircao", R.drawable.plate13));
        rp2.add(new RestaurantPlates("Arepas", "Descircao", R.drawable.plate14));
        rp2.add(new RestaurantPlates("Massaman curry", "Descircao", R.drawable.plate15));
        rp2.add(new RestaurantPlates("Bunny chow", "Descircao", R.drawable.plate16));
        rp2.add(new RestaurantPlates("Kebab", "Descircao", R.drawable.plate17));
        rp2.add(new RestaurantPlates("Piri-piri chicken", "Descircao", R.drawable.plate18));
        rp2.add(new RestaurantPlates("Lechón", "Descircao", R.drawable.plate19));
        rp2.add(new RestaurantPlates("Tom yum goong", "Descircao", R.drawable.plate20));

        List<RestaurantPlates> rp3 = new ArrayList<>();
        rp3.add(new RestaurantPlates("Chicken rice", "Descircao", R.drawable.plate21));
        rp3.add(new RestaurantPlates("Penang assam laksa", "Descircao", R.drawable.plate22));
        rp3.add(new RestaurantPlates("Hummus", "Descircao", R.drawable.plate23));
        rp3.add(new RestaurantPlates("Marzipan", "Descircao", R.drawable.plate24));
        rp3.add(new RestaurantPlates("Pierogi", "Descircao", R.drawable.plate25));
        rp3.add(new RestaurantPlates("Hamburger", "Descircao", R.drawable.plate26));
        rp3.add(new RestaurantPlates("Peking duck", "Descircao", R.drawable.plate27));
        rp3.add(new RestaurantPlates("Sushi", "Descircao", R.drawable.plate28));
        rp3.add(new RestaurantPlates("Chocolate", "Descircao", R.drawable.plate29));
        rp3.add(new RestaurantPlates("Neapolitan pizza", "Descircao", R.drawable.plate30));

        List<RestaurantPlates> rp4 = new ArrayList<>();
        rp4.add(new RestaurantPlates("Masala dosa", "Descircao", R.drawable.plate31));
        rp4.add(new RestaurantPlates("Pasta", "Descircao", R.drawable.plate32));
        rp4.add(new RestaurantPlates("Arancini", "Descircao", R.drawable.plate33));
        rp4.add(new RestaurantPlates("Lasagne", "Descircao", R.drawable.plate34));
        rp4.add(new RestaurantPlates("Osso Buco alla Milanese", "Descircao", R.drawable.plate35));
        rp4.add(new RestaurantPlates("Ribolita", "Descircao", R.drawable.plate36));
        rp4.add(new RestaurantPlates("Saltimboca", "Descircao", R.drawable.plate37));
        rp4.add(new RestaurantPlates("Torrone", "Descircao", R.drawable.plate38));
        rp4.add(new RestaurantPlates("Tiramissu", "Descircao", R.drawable.plate39));
        rp4.add(new RestaurantPlates("Ma Po Tofu", "Descircao", R.drawable.plate40));

        List<RestaurantPlates> rp5 = new ArrayList<>();
        rp5.add(new RestaurantPlates("Vitel", "Descircao", R.drawable.tflmain6));
        rp5.add(new RestaurantPlates("Salad", "Descircao", R.drawable.tflmain1));
        rp5.add(new RestaurantPlates("Fish", "Descircao", R.drawable.tflmain2));
        rp5.add(new RestaurantPlates("Cube", "Descircao", R.drawable.tflmain3));
        rp5.add(new RestaurantPlates("Meat", "Descircao", R.drawable.tflmain4));
        rp5.add(new RestaurantPlates("Sirloin", "Descircao", R.drawable.tflmain5));
        rp5.add(new RestaurantPlates("Chococrepe", "Descircao", R.drawable.tfldessert1));
        rp5.add(new RestaurantPlates("Ball", "Descircao", R.drawable.tfldessert2));
        rp5.add(new RestaurantPlates("Ice cream cake", "Descircao", R.drawable.tfldessert3));
        rp5.add(new RestaurantPlates("Ice roll", "Descircao", R.drawable.tfldessert4));

        List<Restaurant> restaurant = new ArrayList<>();
        restaurant.add(new Restaurant("Olive Garden", "17985 Biscayne Blvd Aventura, FL 33160, EUA", "Close at 23pm", R.drawable.tflmain1, rp1));
        restaurant.add(new Restaurant("Red Lobster", "2522 Candler Rd Decatur, GA 30032, EUA", "Close at 22pm", R.drawable.tflmain2, rp2));
        restaurant.add(new Restaurant("The French Laundry", "6640 Washington St, Yountville, CA 94599, EUA", "Close at 23pm", R.drawable.tflmain3, rp3));
        restaurant.add(new Restaurant("Bubba Gump", "1501 Broadway New York, NY 10036, EUA", "Close at 22pm", R.drawable.tflmain4, rp4));
        restaurant.add(new Restaurant("Tony Roma's", "200 East Fremont St, Las Vegas, NV 89101, EUA", "Close at 00am", R.drawable.tflmain5, rp5));

        return restaurant;
    }

    @Override
    public void onClick(Parcelable[] plates) {

    }

    @Override
    public void onClick(CreditCard card) {

    }

    @Override
    public void onClick(Restaurant restaurant) {

        Intent intent = new Intent(this, DetalheCardapioActivity.class);
        intent.putParcelableArrayListExtra("RESTAURANT", (ArrayList<? extends Parcelable>) RestaurantPlates);
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
