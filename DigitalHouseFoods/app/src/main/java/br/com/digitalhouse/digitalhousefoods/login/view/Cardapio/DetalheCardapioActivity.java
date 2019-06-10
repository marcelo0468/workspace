package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class DetalheCardapioActivity extends AppCompatActivity {

    private ImageView imageViewRestaurantPlate;
    private TextView textViewPlateName;
    private TextView textViewPlateDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardapio);

        if (getIntent() != null && getIntent().getExtras() != null){
            RestaurantPlates plates = getIntent().getParcelableExtra("PLATES");

            if(plates != null){
                imageViewRestaurantPlate.setImageResource(plates.getPlateImage());
                textViewPlateName.setText(plates.getPlateName());
                textViewPlateDescription.setText(plates.getPlateDescription());

            }
        }

    }
}
