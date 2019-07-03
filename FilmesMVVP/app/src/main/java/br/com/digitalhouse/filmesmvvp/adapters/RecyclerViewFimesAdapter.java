package br.com.digitalhouse.filmesmvvp.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.filmesmvvp.R;
import br.com.digitalhouse.filmesmvvp.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.filmesmvvp.model.Filme;

public class RecyclerViewFimesAdapter extends RecyclerView.Adapter<RecyclerViewFimesAdapter.ViewHolder> {

    private List<Filme> filmes;
    private RecyclerViewOnItemClickListener listener;

    public RecyclerViewFimesAdapter(List<Filme> filmes, RecyclerViewOnItemClickListener listener) {
        this.filmes = filmes;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_filme_item, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Filme filme= filmes.get(position);

        viewHolder.bind(filme);

        //Vincula o evendo de click do item e repassa para o listener
        viewHolder.itemView.setOnClickListener(v -> {
            // Viculamos o click no item
            listener.onItemClick(filme);
        });
    }

    @Override
    public int getItemCount() {
        return filmes.size();
    }

    public void update(List<Filme> filmesList) {
        this.filmes = filmesList;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewTitulo;
        private TextView textViewDescricao;
        private TextView textViewData;
        private TextView textViewDirecao;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewTitulo = itemView.findViewById(R.id.textViewTitle);
            textViewData = itemView.findViewById(R.id.textViewData);
            textViewDescricao = itemView.findViewById(R.id.textViewDescricao);
            textViewDirecao = itemView.findViewById(R.id.textViewDirecao);
        }

        public void bind(Filme filme) {
            textViewTitulo.setText(filme.getTitulo());
            textViewData.setText(filme.getData());
            textViewDescricao.setText(filme.getDescricao());
            textViewDirecao.setText((filme.getDirecao()));

        }
    }
}