package br.com.digitalhouse.mycarapplication.view;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.SimpleTimeZone;

import br.com.digitalhouse.mycarapplication.R;
import br.com.digitalhouse.mycarapplication.dao.AbastecimentoDAO;
import br.com.digitalhouse.mycarapplication.dao.Database;
import br.com.digitalhouse.mycarapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mycarapplication.model.Abastecimento;

public class AbastecimentoActivity extends AppCompatActivity {
    private Button ok;
    private TextInputLayout textInputLayoutOdometro;
    private TextInputLayout textInputLayoutLitros;
    private TextInputLayout textInputLayoutNomeDoPosto;
    private AbastecimentoDAO dao;

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abastecimento);

        textInputLayoutOdometro = findViewById(R.id.textInputLayoutOdometro);
        textInputLayoutLitros = findViewById(R.id.textInputLayoutLitros);
        textInputLayoutNomeDoPosto = findViewById(R.id.textInputLayoutNomeDoPosto);

        setUpToolbar();
        setTitle("Abastecimento");

        TextView dataatual = (TextView) findViewById(R.id.editTextDataAbastecimento);
        String currentDateString = DateFormat.getDateInstance().format(new Date());
        dataatual.setText(currentDateString);

        TextView horaatual = (TextView) findViewById(R.id.editTextTime);
        String currentTimeString = DateFormat.getTimeInstance().format(new Date());
        horaatual.setText(currentTimeString);

        dao = Database.getDatabase(this).abastecimentoDAO();

        ok = findViewById(R.id.button);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int odometro = Integer.parseInt(textInputLayoutOdometro.getEditText().getText().toString());
                double litros = Double.parseDouble(textInputLayoutLitros.getEditText().getText().toString());
                String nomeDoPosto = textInputLayoutNomeDoPosto.getEditText().getText().toString();

                new Thread(()-> {
                    dao.insert(new Abastecimento(odometro, litros, nomeDoPosto));
                }).start();
                finish();
            }
        });



    }


    protected void setUpToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if(toolbar != null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) { //Botão adicional na ToolBar
        switch (item.getItemId()) {
            case android.R.id.home:  //ID do seu botão (gerado automaticamente pelo android, usando como está, deve funcionar
                startActivity(new Intent(this, MainActivity.class));  //O efeito ao ser pressionado do botão (no caso abre a activity)
                finishAffinity();  //Método para matar a activity e não deixa-lá indexada na pilhagem
                break;
            default:break;
        }
        return true;
    }

}

