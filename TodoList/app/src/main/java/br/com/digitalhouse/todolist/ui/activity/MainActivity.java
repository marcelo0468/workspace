package br.com.digitalhouse.todolist.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import java.util.List;
import br.com.digitalhouse.todolist.R;
import br.com.digitalhouse.todolist.dao.Database;
import br.com.digitalhouse.todolist.dao.NotasDAO;
import br.com.digitalhouse.todolist.model.Nota;
import br.com.digitalhouse.todolist.ui.recyclerviewadapter.ListaNotasAdapter;
import br.com.digitalhouse.todolist.ui.recyclerviewadapter.listener.OnItemClickListener;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.CHAVE_NOTA;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.CHAVE_POSICAO;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.CODIGO_REQUISICAO_ALTERA_NOTA;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.CODIGO_REQUISICAO_INSERE_NOTA;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.CODIGO_RESULTADO_NOTA_CRIADA;
import static br.com.digitalhouse.todolist.ui.activity.NotaActivityConstantes.POSICAO_INVALIDA;

public class MainActivity extends AppCompatActivity {


    private ListaNotasAdapter adapter;
    private NotasDAO dao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nota nota = new Nota("Titulo", "nonononono");
        dao.insert(nota);
        List<Nota> todasNotas = pegaTodasNotas();
        configuraRecyclerView(todasNotas);
        configuraBotaoInsereNota();


    }

    private void configuraBotaoInsereNota() {
        View botaoInsereNota = findViewById(R.id.lista_notas_insere_nota);
        botaoInsereNota.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vaiParaFormularioNotaActivity();
            }
        });
    }

    private void vaiParaFormularioNotaActivity() {
        Intent iniciaFormularioNota = new Intent(MainActivity.this, FormularioNotaActivity.class);
        startActivityForResult(iniciaFormularioNota, CODIGO_REQUISICAO_INSERE_NOTA);
    }

    private List<Nota> pegaTodasNotas() {
        List<Nota> notas = dao.getAll();
        return notas;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(ehResultadoComNota(requestCode, resultCode, data)){
            Nota notaRecebida = (Nota) data.getSerializableExtra(CHAVE_NOTA);
            adiciona(notaRecebida);
        }

        if(requestCode == CODIGO_REQUISICAO_ALTERA_NOTA && requestCode == CODIGO_RESULTADO_NOTA_CRIADA && temNota(data) && data.hasExtra(CHAVE_POSICAO)){
            Nota notaRecebida = (Nota) data.getSerializableExtra(CHAVE_NOTA);
            int posicaoRecebida = data.getIntExtra(CHAVE_POSICAO, POSICAO_INVALIDA);
            dao.update(notaRecebida);
            adapter.altera(posicaoRecebida,notaRecebida);
        }

    }

    private void adiciona(Nota notaRecebida) {
        dao.insert(notaRecebida);
        adapter.adiciona(notaRecebida);
    }

    private boolean ehResultadoComNota(int requestCode, int resultCode, @Nullable Intent data) {
        return ehCodigoRequisicaoInsereNota(requestCode) && ehCodigoResultadoNotaCriada(resultCode) && temNota(data);
    }

    private boolean temNota(@Nullable Intent data) {
        return data != null && data.hasExtra(CHAVE_NOTA);
    }

    private boolean ehCodigoResultadoNotaCriada(int resultCode) {
        return resultCode == CODIGO_RESULTADO_NOTA_CRIADA;
    }

    private boolean ehCodigoRequisicaoInsereNota(int requestCode) {
        return requestCode == CODIGO_REQUISICAO_INSERE_NOTA;
    }

    private void configuraRecyclerView(List<Nota> todasNotas) {
        RecyclerView listaNotas = findViewById(R.id.lista_notas_recyclerview);
        configuraAdapter(todasNotas, listaNotas);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new NotaItemTouchHelperCallback(adapter));
        itemTouchHelper.attachToRecyclerView(listaNotas);
    }

    private void configuraAdapter(List<Nota> todasNotas, RecyclerView listaNotas) {
        adapter = new ListaNotasAdapter(this, todasNotas);
        listaNotas.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(Nota nota, int posicao) {
                vaiParaFormularioNotaActivity(nota, posicao);
            }
        });
    }

    private void vaiParaFormularioNotaActivity(Nota nota, int posicao) {
        Intent abreFormularioComNota = new Intent(MainActivity.this, FormularioNotaActivity.class);
        abreFormularioComNota.putExtra(CHAVE_NOTA, nota);
        abreFormularioComNota.putExtra(CHAVE_POSICAO, posicao);
        startActivityForResult(abreFormularioComNota, CODIGO_REQUISICAO_ALTERA_NOTA);
    }

}
