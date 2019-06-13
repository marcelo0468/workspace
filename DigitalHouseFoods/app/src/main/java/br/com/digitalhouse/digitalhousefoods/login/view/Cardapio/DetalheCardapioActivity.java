package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class DetalheCardapioActivity extends AppCompatActivity {

    private ImageView imageViewRestaurantC;
    private TextView textViewrestaurantNameC;
    private TextView textViewRestaurantName;
    private TextView textViewRestaurantName1;
    ArrayList<RestaurantPlates> menu =  (ArrayList<RestaurantPlates>) getIntent().getSerializableExtra("MENU");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);


        if (getIntent() != null && getIntent().getExtras() != null){
            RestaurantPlates menu = getIntent().getParcelableExtra("MENU");

            if(menu != null){
                imageViewRestaurantC.setImageResource(menu.getPlateImage());
                textViewRestaurantName.setText(menu.getPlateName());

            }
        }

    }

}
