package br.com.digitalhouse.digitalhousefoods.login.view;

import android.os.Parcelable;

import br.com.digitalhouse.digitalhousefoods.model.CreditCard;
import br.com.digitalhouse.digitalhousefoods.model.Restaurant;

public interface RecyclerViewClickListener {
    void onClick(Restaurant restaurant);
    void onClick(Parcelable[] plates);
    void onClick(CreditCard card);
}
