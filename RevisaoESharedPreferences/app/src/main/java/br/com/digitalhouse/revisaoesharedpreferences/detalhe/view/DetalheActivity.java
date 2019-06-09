package br.com.digitalhouse.revisaoesharedpreferences.detalhe.view;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import br.com.digitalhouse.revisaoesharedpreferences.R;
import br.com.digitalhouse.revisaoesharedpreferences.model.Contato;

public class DetalheActivity extends AppCompatActivity {

    private ImageView imageViewContato;
    private TextInputLayout textInputLayoutEmail;
    private TextInputLayout textInputLayoutSenha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalhe);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        textInputLayoutEmail = findViewById(R.id.textInputLayoutEmail);
        textInputLayoutSenha = findViewById(R.id.textInputLayoutSenha);
        imageViewContato = findViewById(R.id.circleImageViewFoto);

        Contato contato = getIntent().getParcelableExtra("CONTATO");

        if (contato != null){
            textInputLayoutEmail.getEditText().setText(contato.getNome());
            textInputLayoutSenha.getEditText().setText(contato.getTelefone());
            imageViewContato.setImageResource(contato.getImagem());
        }

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

}
