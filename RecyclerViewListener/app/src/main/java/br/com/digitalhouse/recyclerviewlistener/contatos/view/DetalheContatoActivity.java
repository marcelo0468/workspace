package br.com.digitalhouse.recyclerviewlistener.contatos.view;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import br.com.digitalhouse.recyclerviewlistener.R;
import br.com.digitalhouse.recyclerviewlistener.contatos.model.Contato;
import de.hdodenhof.circleimageview.CircleImageView;

public class DetalheContatoActivity extends AppCompatActivity {

    private TextView textViewNome;
    private CircleImageView circleContato;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe_contato);

        if (getIntent() != null && getIntent().getExtras() != null){
            Contato contato = getIntent().getParcelableExtra("CONTATO");

            if(contato != null){
                //posso usar o contato para mostrar os dados na tela
                textViewNome = findViewById(R.id.textViewContato);
                textViewNome.setText(contato.getNome());
                circleContato = findViewById(R.id.circleImageViewContato);
                circleContato.setImageResource(contato.getFoto());
            }
        }
    }
}
