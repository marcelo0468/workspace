package br.com.digitalhouse.exerciciomvvmapplication.recyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.exerciciomvvmapplication.R;
import br.com.digitalhouse.exerciciomvvmapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.exerciciomvvmapplication.model.Produtos;

public class RecyclerViewProdutosAdapter extends RecyclerView.Adapter<RecyclerViewProdutosAdapter.ViewHolder> {

    private List<Produtos> produtos;
    private RecyclerViewOnItemClickListener listener;


    public RecyclerViewProdutosAdapter(List<Produtos> produtos, RecyclerViewOnItemClickListener listener){
        this.produtos = produtos;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_main_activity, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Produtos produto = produtos.get(position);
        viewHolder.bind(produto);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(produto);
            }
        });

    }

    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public void update(List<Produtos> produtos){
        this.produtos = produtos;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNomeProduto;
        private TextView textViewPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNomeProduto = itemView.findViewById(R.id.textViewProduto);
            textViewPreco = itemView.findViewById(R.id.textViewPreco);
        }

        public void bind(Produtos produto) {
            textViewNomeProduto.setText(produto.getNomeProduto());
            textViewPreco.setText(String.format("%.2f", produto.getPreco()));
        }
    }
}
