package com.example.gaurav.imdb_rating;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.widget.Toast;

import com.example.gaurav.imdb_rating.APICalls.MovieDb;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<IMDbModel> imDbModels;
    ListAdapter adapter;

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.rv1);
        searchView = (SearchView) findViewById(R.id.searchView);
        //Picasso.with(this).load("http://i.imgur.com/DvpvklR.png").into(imgview);
        imDbModels = new ArrayList<>();

//        imDbModels.add(new IMDbModel());
//        imDbModels.add(new IMDbModel());
//        imDbModels.add(new IMDbModel());
        Gson gson = new Gson();

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://api.themoviedb.org/3/").
                addConverterFactory(GsonConverterFactory.create(gson)).build();

        MovieDb movieDb = retrofit.create(MovieDb.class);

        Call<ResultModel> result = movieDb.getMovieList("be9ba58d65fc6d732dd9c4cdd56ef295");
        Callback<ResultModel> callback = new Callback<ResultModel>() {
            @Override
            public void onResponse(Call<ResultModel> call, Response<ResultModel> response) {
                imDbModels = response.body().getResults();
                adapter.update(imDbModels);
            }

            @Override
            public void onFailure(Call<ResultModel> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Failure", Toast.LENGTH_SHORT).show();
            }
        };
        result.enqueue(callback);
        adapter = new ListAdapter(this, imDbModels);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                adapter.getFilter().filter(newText);
                return false;
            }
        });
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                //imgview.setVisibility(View.GONE);
            }
        });


    }
}
