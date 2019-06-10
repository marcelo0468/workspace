package br.com.digitalhouse.digitalhousefoods.login.view.CreditCard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;

public class DetalheCreditCards extends AppCompatActivity {

    private TextView textViewName;
    private TextView textViewCardNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_cards);

        if (getIntent() != null && getIntent().getExtras() != null){
            CreditCard creditCard = getIntent().getParcelableExtra("CARDS");

            if(creditCard != null){
                textViewName.setText(creditCard.getName());
                textViewCardNumber.setText(creditCard.getCardNumber());
            }
        }

    }
}
