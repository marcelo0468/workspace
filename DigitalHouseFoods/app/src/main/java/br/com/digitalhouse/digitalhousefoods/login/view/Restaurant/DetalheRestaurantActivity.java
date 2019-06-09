package br.com.digitalhouse.digitalhousefoods.login.view.Restaurant;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;

public class DetalheRestaurantActivity extends AppCompatActivity {

    private ImageView imageViewRestaurant;
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant);

        if (getIntent() != null && getIntent().getExtras() != null){
            Restaurant restaurant = getIntent().getParcelableExtra("RESTAURANT");

            if(restaurant != null){
                imageViewRestaurant.setImageResource(restaurant.getRestaurantImage());
                textViewName.setText(restaurant.getRestaurantName());
                textViewAddress.setText(restaurant.getRestaurantAddress());
                textViewHours.setText(restaurant.getRestaurantHours());
            }
        }

    }

}
