package br.com.digitalhouse.digitalhousefoods.login.view.CreditCard;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import br.com.digitalhouse.digitalhousefoods.R;
import br.com.digitalhouse.digitalhousefoods.login.view.RecyclerViewClickListener;
import br.com.digitalhouse.digitalhousefoods.model.CreditCard;

public class RecyclerViewCreditCardAdapter extends RecyclerView.Adapter<RecyclerViewCreditCardAdapter.ViewHolder> {

    private List<CreditCard> cards;
    private RecyclerViewClickListener listener;

    public RecyclerViewCreditCardAdapter(List<CreditCard> cards, RecyclerViewClickListener listener){
        this.cards = cards;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.credit_card_recyclerview, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        final CreditCard card = cards.get(i);
        viewHolder.setarConteudoNaTela(card);
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(card);
            }
        });

    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewCardNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.name);
            textViewCardNumber = itemView.findViewById(R.id.cardNumber);
        }

        public void setarConteudoNaTela(CreditCard card) {
            textViewName.setText(card.getName());
            textViewCardNumber.setText(card.getCardNumber());
        }
    }

}
