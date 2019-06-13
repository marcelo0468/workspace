package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class DetalheCardapioActivity extends AppCompatActivity {

    private ImageView imageViewRestaurantC;
    private TextView textViewRestaurantNameC;
    //ArrayList<RestaurantPlates> menu =  (ArrayList<RestaurantPlates>) getIntent().getSerializableExtra("MENU");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);


        if (getIntent() != null && getIntent().getExtras() != null){
            //Restaurant menu = getIntent().getParcelableExtra("MENU");
            Restaurant menu = (RestaurantPlates) getIntent().getSerializableExtra("MENU");

            if(menu != null){
                imageViewRestaurantC.setImageResource(((RestaurantPlates) menu).getPlateImage());
               //textViewRestaurantNameC.setText(menu.getRestaurantName());
                textViewRestaurantNameC.setText(((RestaurantPlates) menu).getPlateDescription());

            }
        }

    }

}
