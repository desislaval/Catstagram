package com.example.android.catstagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private FactsAdapter factsAdapter;
    private List<Facts> data;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        data = new ArrayList<>();

        recyclerView = findViewById(R.id.rec_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        factsAdapter = new FactsAdapter(getApplicationContext(), data);
        recyclerView.setAdapter(factsAdapter);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://cat-fact.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TumblrService service = retrofit.create(TumblrService.class);
        Call<List<Facts>> call = service.getFacts();
        call.enqueue(new Callback<List<Facts>>() {
            @Override
            public void onResponse(Call<List<Facts>> call, Response<List<Facts>> response) {
                data = response.body();
                factsAdapter.setFactsArrayList(data);
            }

            @Override
            public void onFailure(Call<List<Facts>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });


    }
}
