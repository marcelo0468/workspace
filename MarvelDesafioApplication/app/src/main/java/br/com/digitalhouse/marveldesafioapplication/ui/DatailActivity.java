package br.com.digitalhouse.marveldesafioapplication.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.appbar.AppBarLayout;
import com.squareup.picasso.Picasso;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import br.com.digitalhouse.marveldesafioapplication.R;
import br.com.digitalhouse.marveldesafioapplication.model.Result;

public class DatailActivity extends AppCompatActivity {

    private ImageView imageBack;
    private ImageView imageHero;
    private ImageView imageBackground;
    private TextView textTitle;
    private TextView textViewDescription;
    private TextView textViewPublished;
    private TextView textViewPrice;
    private TextView textViewPages;
    private AppBarLayout appBarLayout;


    private Result result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        initViews();


        result = getIntent().getParcelableExtra("comic");
        String transitionName = getIntent().getStringExtra("transitionName");
        imageHero.setTransitionName(transitionName);

        textTitle.setText(result.getTitle());
        textViewDescription.setText(Html.fromHtml(result.getDescription()));
        textViewPrice.setText("$" + result.getPrices().get(0).getPrice());
        textViewPages.setText(result.getPageCount().toString());


        Picasso.get()
                .load(result.getThumbnail().getPath() + "/portrait_small." + result.getThumbnail().getExtension())
                .placeholder(R.drawable.marvel_logo)
                .error(R.drawable.marvel)
                .into(imageHero);

        if (!result.getImages().isEmpty()) {
            Picasso.get()
                    .load(result.getImages().get(0).getPath() + "/landscape_small." + result.getImages().get(0).getExtension())
                    .placeholder(R.drawable.marvel)
                    .error(R.drawable.marvel)
                    .into(imageBackground);
        }


        try {
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ", Locale.getDefault());
            SimpleDateFormat format = new SimpleDateFormat("EEE, d MMM yyyy", Locale.getDefault());
            Date date = formatDate.parse(result.getDates().get(0).getDate());
            String dateString = format.format(date);
            textViewPublished.setText(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
        }


        imageHero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(DatailActivity.this, ZoomActivity.class);
                intent.putExtra("image", result.getThumbnail().getPath() + "/detail." + result.getThumbnail().getExtension());
                startActivity(intent);
            }
        });


        imageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                supportFinishAfterTransition();
            }
        });



        appBarLayout.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                imageHero.setVisibility(View.VISIBLE);
            } else if (Math.abs(verticalOffset) >= appBarLayout.getTotalScrollRange()) {
                imageHero.setVisibility(View.GONE);
            } else {
                imageHero.setVisibility(View.VISIBLE);
            }
        });
    }


    private void initViews() {
        imageBack = findViewById(R.id.imageBack);
        imageHero = findViewById(R.id.imageComic);
        imageBackground = findViewById(R.id.imageBackground);
        textTitle = findViewById(R.id.textTitle);
        textViewDescription = findViewById(R.id.textViewDesciption);
        textViewPublished = findViewById(R.id.textViewPublished);
        textViewPrice = findViewById(R.id.textViewPrice);
        textViewPages = findViewById(R.id.textViewPages);
        appBarLayout = findViewById(R.id.app_bar);
    }
}
