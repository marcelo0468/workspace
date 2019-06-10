package br.com.digitalhouse.digitalhousefoods.login.view.Restaurant;

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

public class RecyclerViewRestaurantAdapter extends RecyclerView.Adapter<RecyclerViewRestaurantAdapter.ViewHolder> {

    private List<Restaurant> restaurants;
    private RecyclerViewClickListener listener;

    public RecyclerViewRestaurantAdapter(List<Restaurant> restaurants, RecyclerViewClickListener listener){
        this.restaurants = restaurants;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.restaurant_recyclerview_item, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        final Restaurant restaurant = restaurants.get(position);
        viewHolder.setarConteudoNaTela(restaurant);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(restaurant);
            }
        });
    }

    @Override
    public int getItemCount() {
        return restaurants.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewRestaurant;
        private TextView textViewName;
        private TextView textViewAddress;
        private TextView textViewHours;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewRestaurant = itemView.findViewById(R.id.imageViewRestaurant);
            textViewName = itemView.findViewById(R.id.restaurantName);
            textViewAddress = itemView.findViewById(R.id.restaurantAddress);
            textViewHours = itemView.findViewById(R.id.restaurantHours);
        }

        public void setarConteudoNaTela(Restaurant restaurant) {
            imageViewRestaurant.setImageDrawable(ContextCompat.getDrawable(imageViewRestaurant.getContext(), restaurant.getRestaurantImage()));
            textViewName.setText(restaurant.getRestaurantName());
            textViewAddress.setText(restaurant.getRestaurantAddress());
            textViewHours.setText(restaurant.getRestaurantHours());
        }
    }
}
