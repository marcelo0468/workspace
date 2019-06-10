package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class RecyclerViewCardapioAdapter extends RecyclerView.Adapter<RecyclerViewCardapioAdapter.ViewHolder> {


    private List<RestaurantPlates> plates;
    private RecyclerViewCardapioAdapter listener;

    public RecyclerViewCardapioAdapter(List<RestaurantPlates> plates, RecyclerViewClickListener listener) {
        this.plates = plates;
        this.listener = (RecyclerViewCardapioAdapter) listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardapio_recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final RestaurantPlates plate = plates.get(i);
        viewHolder.setarConteudoNaTela(plate);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(plate);
            }
        });

    }

    @Override
    public int getItemCount() {
        return plates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewPlate1;
        private TextView textViewPlateName1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewPlate1 = itemView.findViewById(R.id.imageViewPlate1);
            textViewPlateName1 = itemView.findViewById(R.id.textViewPlate1Description);

        }

        public void setarConteudoNaTela(RestaurantPlates plate) {
            imageViewPlate1.setImageDrawable(ContextCompat.getDrawable(imageViewPlate1.getContext(), plate.getPlateImage()));
            textViewPlateName1.setText(plate.getPlateName());
        }
    }

    private void onClick(RestaurantPlates plate) {
    }
}
