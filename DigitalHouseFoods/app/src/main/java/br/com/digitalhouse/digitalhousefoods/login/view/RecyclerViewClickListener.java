package br.com.digitalhouse.digitalhousefoods.login.view;

import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;
import br.com.digitalhouse.digitalhousefoods.model.RestaurantPlates;

public interface RecyclerViewClickListener {
    void onClick(Restaurant restaurant);
    void onClick(RestaurantPlates plates);
    void onClick(CreditCard card);
}
