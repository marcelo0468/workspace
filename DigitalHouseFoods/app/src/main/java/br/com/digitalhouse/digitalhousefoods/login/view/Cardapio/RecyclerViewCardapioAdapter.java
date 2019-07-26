package br.com.digitalhouse.digitalhousefoods.login.view.Cardapio;

import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public class RecyclerViewCardapioAdapter extends RecyclerView.Adapter<RecyclerViewCardapioAdapter.ViewHolder> {

    private RestaurantPlates plates;
    private RecyclerViewClickListener listener;



    public RecyclerViewCardapioAdapter(RestaurantPlates plates, RecyclerViewClickListener listener) {
        this.plates = plates;
        this.listener = listener;
    }

    public RecyclerViewCardapioAdapter(Restaurant menu, ListaCardapioActivity listener) {

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
        final Restaurant plates = (RestaurantPlates) this.plates.get(position);
        viewHolder.setarConteudoNaTela((RestaurantPlates) plates);
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

        public void setarConteudoNaTela(br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates plates) {
            imageViewRestaurantC.setImageDrawable(ContextCompat.getDrawable(imageViewRestaurantC.getContext(), plates.getPlateImage()));
            textViewNameC.setText(plates.getPlateDescription());


        }
    }
}
