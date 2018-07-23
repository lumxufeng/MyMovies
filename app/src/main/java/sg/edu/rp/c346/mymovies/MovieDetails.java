package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import android.widget.RatingBar;
import android.widget.TextView;

/**
 * Created by 16043921 on 23/7/2018.
 */

public class MovieDetails extends AppCompatActivity{

    TextView tvTitle;
    TextView tvYear;
    TextView tvGenre;
    TextView tvWatch;
    TextView tvTheatre;
    ImageView ivRated;
    TextView tvDescription;
    RatingBar rbRating;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_details);

        ivRated = findViewById(R.id.imageViewRated);
        tvTitle = findViewById(R.id.textViewTitle);
        tvYear = findViewById(R.id.textViewYear);
        tvGenre = findViewById(R.id.textViewGenre);
        tvDescription = findViewById(R.id.textViewDescrip);
        tvWatch = findViewById(R.id.textViewWatch);
        tvTheatre = findViewById(R.id.textViewTheatre);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String description = intentReceived.getStringExtra("description");
        String theatre = intentReceived.getStringExtra("theatre");
        String watched = intentReceived.getStringExtra("date");
        String rated = intentReceived.getStringExtra("rated");
        int rating = intentReceived.getIntExtra("rating",0);

        tvTitle.setText(title);
        tvYear.setText(year + " - ");
        tvGenre.setText(genre);
        tvDescription.setText(description);
        tvWatch.setText("Watch on: " + watched);
        tvTheatre.setText("In Theatre: " + theatre);

        rbRating.setRating(rating);
        rbRating.setIsIndicator(true);


        if(rated.equals("g")){
            ivRated.setImageResource(R.drawable.rating_g);
        }
        else if(rated.equals("pg")){
            ivRated.setImageResource(R.drawable.rating_pg);
        }
        else if(rated.equals("pg13")){
            ivRated.setImageResource(R.drawable.rating_pg13);
        }
        else if(rated.equals("nc16")){
            ivRated.setImageResource(R.drawable.rating_nc16);
        }
        else if(rated.equals("m18")){
            ivRated.setImageResource(R.drawable.rating_m18);
        }
        else if(rated.equals("r21")){
            ivRated.setImageResource(R.drawable.rating_r21);
        }


    }
}
