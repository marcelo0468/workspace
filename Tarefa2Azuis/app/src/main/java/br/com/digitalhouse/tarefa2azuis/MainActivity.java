package br.com.digitalhouse.tarefa2azuis;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCurioso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnCurioso = findViewById(R.id.btnCurioso);

        btnCurioso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "AZUL é a cor favorita de 45% das pessoas do mundo, possui 111 tons diferentes nomeados", Toast.LENGTH_LONG).show();

            }
        });

    }



}
