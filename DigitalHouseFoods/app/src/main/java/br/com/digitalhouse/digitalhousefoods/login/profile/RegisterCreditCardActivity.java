package br.com.digitalhouse.digitalhousefoods.login.profile;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import br.com.digitalhouse.digitalhousefoods.R;

public class RegisterCreditCardActivity extends AppCompatActivity {

    private TextView textViewCancel;
    private TextView textViewOk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_credit_card);

        textViewCancel = findViewById(R.id.textCancel);
        textViewOk = findViewById(R.id.textOk);

        textViewCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        textViewOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RegisterCreditCardActivity.this, "Dados gravados com sucesso", Toast.LENGTH_SHORT).show();
                finish();
            }

        });

    }

}
