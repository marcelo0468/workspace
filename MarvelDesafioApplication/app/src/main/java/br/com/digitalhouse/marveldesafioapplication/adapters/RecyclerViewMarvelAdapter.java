package br.com.digitalhouse.marveldesafioapplication.adapters;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

import br.com.digitalhouse.marveldesafioapplication.R;
import br.com.digitalhouse.marveldesafioapplication.model.Result;
import br.com.digitalhouse.marveldesafioapplication.ui.DatailActivity;

public class RecyclerViewMarvelAdapter extends RecyclerView.Adapter<RecyclerViewMarvelAdapter.ViewHolder>{

    private List<Result> results;

    public RecyclerViewMarvelAdapter(List<Result> results) {
        this.results = results;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Result results = this.results.get(position);
        holder.bind(results);

        holder.itemView.setOnClickListener(v -> {
            String transitionName = "image_" + position;
            Intent intent = new Intent(holder.itemView.getContext(), DatailActivity.class);
            intent.putExtra("comic", results);
            intent.putExtra("transitionName", transitionName);

            holder.imageView.setTransitionName(transitionName);

            ActivityOptionsCompat options = ActivityOptionsCompat.
                    makeSceneTransitionAnimation((Activity) holder.itemView.getContext(),
                            holder.imageView, transitionName);

            holder.itemView.getContext().startActivity(intent, options.toBundle());
        });
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewComic);
            textView = itemView.findViewById(R.id.textViewTitle);
        }

        public void bind(Result results) {


            if(results.getThumbnail() != null){
                String poster = results.getThumbnail().getPath() + "/portrait_small." + results.getThumbnail().getExtension();
                Picasso.get()
                        .load(poster)
                        .placeholder(R.drawable.marvel)
                        .error(R.drawable.marvel)
                        .into(imageView);
            }

            textView.setText("# " + results.getIssueNumber());

        }
    }

    public void clear(){
        this.results.clear();
        notifyDataSetChanged();
    }

    public void update(List<Result> results) {
        if (this.results.isEmpty()){
            this.results = results;
        } else {
            this.results.addAll(results);
        }
        notifyDataSetChanged();
    }
}
