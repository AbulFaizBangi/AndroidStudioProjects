package com.example.marvelmoviesapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.marvelmoviesapp.R;
import com.example.marvelmoviesapp.Movie;
import com.example.marvelmoviesapp.MovieAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity<Movie> extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MovieAdapter movieAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Iron Man", R.drawable.iron_man));
        movieList.add(new Movie("Captain America", R.drawable.captain_america));
        movieList.add(new Movie("HULK", R.drawable.hulk));
        movieList.add(new Movie("Avengers: Infinity War", R.drawable.infinity_war));
        movieList.add(new Movie("Avengers: Endgame", R.drawable.endgame));

        movieAdapter = new MovieAdapter(this, movieList);
        recyclerView.setAdapter(movieAdapter);
    }
}
