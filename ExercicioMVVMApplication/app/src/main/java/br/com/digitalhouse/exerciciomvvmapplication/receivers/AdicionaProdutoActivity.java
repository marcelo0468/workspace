package br.com.digitalhouse.exerciciomvvmapplication.receivers;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.digitalhouse.exerciciomvvmapplication.R;
import br.com.digitalhouse.exerciciomvvmapplication.data.database.Database;
import br.com.digitalhouse.exerciciomvvmapplication.data.database.dao.ProdutosDAO;
import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;
import br.com.digitalhouse.exerciciomvvmapplication.recyclerView.RecyclerViewProdutosAdapter;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class AdicionaProdutoActivity extends AppCompatActivity {

    private TextInputLayout textInputLayoutNomeProduto;
    private TextInputLayout textInputLayoutPreco;
    private ProdutosDAO dao;
    private RecyclerViewProdutosAdapter adapter;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona_produto);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle("Produtos");

        textInputLayoutNomeProduto = findViewById(R.id.textInputNomeProduto);
        textInputLayoutPreco = findViewById(R.id.textInputPreco);
        btnSalvar = findViewById(R.id.btnSalvar);
        dao = Database.getDatabase(this).produtosDAO();

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String nomeProduto = textInputLayoutNomeProduto.getEditText().getText().toString();
                final Double preco = Double.valueOf(textInputLayoutPreco.getEditText().getText().toString());

                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        dao.insert(new Produtos(nomeProduto, preco));

                        AdicionaProdutoActivity.this.finish();
                    }
                }).start();
            }

        });

        FloatingActionButton fab = findViewById(R.id.fabAdicionaProdutoMore);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


}
