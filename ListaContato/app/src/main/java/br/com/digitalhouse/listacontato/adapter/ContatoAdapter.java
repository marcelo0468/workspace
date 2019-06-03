package br.com.digitalhouse.listacontato.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.listacontato.R;
import br.com.digitalhouse.listacontato.model.Contatos;

public class ContatoAdapter extends RecyclerView.Adapter<ContatoAdapter.ViewHolder> {

    private List<Contatos> listaContatos;
    public ContatoAdapter(List<Contatos> listaContatos) {
        this.listaContatos = listaContatos;
    }


    @NonNull
    @Override
    //Inflar o lay out do item
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_lista_item_contato, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        //Cria uma nova instancia e atribui valor da posição da lista
        Contatos novoContato = listaContatos.get(i);
        //adiciona valor na instancia
        viewHolder.bind(novoContato);
    }

    //Retorna tamanho da lista
    @Override
    public int getItemCount() {
        return listaContatos.size();
    }

    //Classe ViewHolder
    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView nomeContato;
        TextView numTelefone;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nomeContato = itemView.findViewById(R.id.txtNome);
            numTelefone = itemView.findViewById(R.id.txtFone);
        }

        public void bind(Contatos contato) {
            nomeContato.setText(contato.getNome());
            numTelefone.setText(""+contato.getTelefone());
        }
    }


}
