package br.com.digitalhouse.mycarapplication.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import br.com.digitalhouse.mycarapplication.R;
import br.com.digitalhouse.mycarapplication.interfaces.RecyclerViewOnItemClickListener;
import br.com.digitalhouse.mycarapplication.model.Abastecimento;
import br.com.digitalhouse.mycarapplication.view.MainActivity;

public class RecyclerViewAbastecimentoAdapter extends RecyclerView.Adapter<RecyclerViewAbastecimentoAdapter.ViewHolder> {

    private List<Abastecimento> abastecimentos;
    private RecyclerViewOnItemClickListener listener;

//    public RecyclerViewAbastecimentoAdapter(List<Abastecimento> abastecimentos, RecyclerViewOnItemClickListener listener) {
//        this.abastecimentos = abastecimentos;
//        this.listener = listener;
//    }

    public RecyclerViewAbastecimentoAdapter(List<Abastecimento> abastecimentoList, MainActivity mainActivity) {
        this.abastecimentos = abastecimentoList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.content_main, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

        final Abastecimento abastecimento = abastecimentos.get(position);
        viewHolder.bind(abastecimento);

        viewHolder.itemView.setOnClickListener(v -> {
            listener.onItemClick(abastecimento);
        });
    }

    @Override
    public int getItemCount() {
        return abastecimentos.size();
    }

    public void update(List<Abastecimento> abastecimentos) {
        this.abastecimentos = abastecimentos;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewOdometro;
        private TextView textViewLitros;
        private TextView textViewNomeDoPosto;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewOdometro = itemView.findViewById(R.id.odometro);
            textViewLitros = itemView.findViewById(R.id.litros);
            textViewNomeDoPosto = itemView.findViewById(R.id.nomeDoPosto);
        }

        public void bind(Abastecimento abastecimento) {
            textViewOdometro.setText(String.valueOf(abastecimento.getOdometro()));
            textViewLitros.setText(String.valueOf(abastecimento.getLitros()));
            textViewNomeDoPosto.setText(abastecimento.getNomeDoPosto());
        }
    }
}
