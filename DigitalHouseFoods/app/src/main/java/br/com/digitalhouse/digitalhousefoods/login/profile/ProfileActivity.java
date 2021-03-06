package br.com.digitalhouse.digitalhousefoods.login.profile;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.view.CreditCard.CreditCardsActivity;

public class ProfileActivity extends AppCompatActivity {

    private Button btnCreditCard;
    private Button btnSaveProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        btnCreditCard = findViewById(R.id.buttonCreditCard);
        btnSaveProfile = findViewById(R.id.buttonSaveProfile);

        btnCreditCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, CreditCardsActivity.class);
                startActivity(intent);
            }
        });

        btnSaveProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ProfileActivity.this, "Perfil salvo com sucesso", Toast.LENGTH_SHORT).show();
               finish();
            }
        });


    }
}
