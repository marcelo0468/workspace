package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;

public class DetalheCardapioActivity extends AppCompatActivity {

    private ImageView imageViewRestaurant;
    private TextView textViewName;
    private TextView textViewAddress;
    private TextView textViewHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_cardapio);


    }
}
