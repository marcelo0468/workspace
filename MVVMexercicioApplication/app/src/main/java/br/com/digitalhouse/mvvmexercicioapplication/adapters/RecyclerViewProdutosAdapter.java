package br.com.digitalhouse.mvvmexercicioapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.mvvmexercicioapplication.R;
import br.com.digitalhouse.mvvmexercicioapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mvvmexercicioapplication.model.Produtos;

public class RecyclerViewProdutosAdapter extends RecyclerView.Adapter<RecyclerViewProdutosAdapter.ViewHolder> {

    private List<Produtos> produtos;
    private RecyclerViewOnItemClickListener listener;
    private RecyclerView.ViewHolder holder;
    private int position;

    public RecyclerViewProdutosAdapter(List<Produtos> produtos, RecyclerViewOnItemClickListener listener){
        this.produtos = produtos;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_produtos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final Produtos produto = produtos.get(position);
        holder.bind(produto);
    }


    @Override
    public int getItemCount() {
        return produtos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewNomeDoProduto;
        private TextView textViewPreco;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewNomeDoProduto = itemView.findViewById(R.id.textViewNomeProduto);
            textViewPreco = itemView.findViewById(R.id.textViewPreco);
        }

        public void bind(Produtos produto) {
            textViewNomeDoProduto.setText(produto.getNomeDoProduto());
            textViewPreco.setText((int) produto.getPreco());
        }
    }
}
