package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView lvMovie;
    ArrayList<Movie> alMovieList;
    CustomAdapter caMovie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvMovie = findViewById(R.id.listViewMovie);

        alMovieList = new ArrayList<>();

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        date1.set(2014,11,15);
        date2.set(2015,05,15);

        Movie movie1 = new Movie("Avenger","2012","pg13","Action | Sci-Fi", date1,"Golden Village - Bishan", "Nick Fury of S.H.I.E.L.D. assembles a team of superheroes to save the planet from Loki and his army.",4);
        Movie movie2 = new Movie("Planes","2013","pg","Animation | Comedy", date2, "Cathay - AMK Hub", "A crop-dusting plane with a fear of heights lives his dream of competing in a famous around-the-world aerial race.",2);

        alMovieList.add(movie1);
        alMovieList.add(movie2);

        caMovie = new CustomAdapter(this,R.layout.movie_item,alMovieList);
        lvMovie.setAdapter(caMovie);


        lvMovie.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie currentItem = alMovieList.get(i);
                Intent intent = new Intent(getBaseContext(), MovieDetails.class);

                intent.putExtra("title",currentItem.getTitle());
                intent.putExtra("year",currentItem.getTitle());
                intent.putExtra("rated",currentItem.getRated());
                intent.putExtra("genre",currentItem.getGenre());
                intent.putExtra("date",currentItem.getDateString());
                intent.putExtra("theatre",currentItem.getIn_theatre());
                intent.putExtra("description",currentItem.getDescription());
                intent.putExtra("rating",currentItem.getRating());

                startActivity(intent);
            }
        });


    }



}
