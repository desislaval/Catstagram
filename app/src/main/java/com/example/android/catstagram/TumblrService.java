package com.example.android.catstagram;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface TumblrService {

    @GET("/facts/random?animal_type=cat&amount=10")
    Call<List<Facts>> getFacts();

}
