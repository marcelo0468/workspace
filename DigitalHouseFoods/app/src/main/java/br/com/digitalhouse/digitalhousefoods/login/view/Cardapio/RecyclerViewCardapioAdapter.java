package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.content.Intent;
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
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;

public class RecyclerViewCardapioAdapter extends RecyclerView.Adapter<RecyclerViewCardapioAdapter.ViewHolder> {

    private List<Restaurant> plates;
    private RecyclerViewClickListener listener;



    private Intent getIntent() {
        return null;
    }


    public RecyclerViewCardapioAdapter(List<Restaurant> restaurants, RecyclerViewClickListener listener) {
        this.plates = restaurants;
        this.listener = listener;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardapio_recycler_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Restaurant plates = this.plates.get(position);
        viewHolder.setarConteudoNaTela(plates);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(plates);
            }
        });
    }

    @Override
    public int getItemCount() {
        return plates.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewRestaurantC;
        private TextView textViewNameC;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewRestaurantC = itemView.findViewById(R.id.imageViewRestaurantC);
            textViewNameC = itemView.findViewById(R.id.restaurantNameC);
        }

        public void setarConteudoNaTela(Restaurant restaurant) {
            imageViewRestaurantC.setImageDrawable(ContextCompat.getDrawable(imageViewRestaurantC.getContext(), restaurant.getRestaurantImage()));
            textViewNameC.setText(restaurant.getRestaurantName());

        }
    }
}
