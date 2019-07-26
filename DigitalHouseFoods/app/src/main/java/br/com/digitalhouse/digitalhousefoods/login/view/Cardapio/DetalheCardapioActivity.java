package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class DetalheCardapioActivity extends AppCompatActivity {

    private ImageView imageViewRestaurantC;
    private TextView textViewRestaurantNameC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        imageViewRestaurantC = findViewById(R.id.imageViewMenu);
        textViewRestaurantNameC = findViewById(R.id.textViewRestaurantName);


        if (getIntent() != null && getIntent().getExtras() != null){
                RestaurantPlates menu = getIntent().getParcelableExtra("MENU");
                //Log.i("TAG", menu.getPlateName() );

            if(menu != null){
                imageViewRestaurantC.setImageResource(menu.getRestaurantImage());
                textViewRestaurantNameC.setText(menu.getRestaurantName());

            }
        }

    }

}
