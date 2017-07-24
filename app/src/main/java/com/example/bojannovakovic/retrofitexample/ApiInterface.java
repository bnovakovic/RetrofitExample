package com.example.bojannovakovic.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiInterface {

    // gets user info
    @GET("myInfo.txt")
    Call<UserData> getUser();

    //gets buddy info
    @GET("buddyInfo.txt")
    Call<BuddyData> getBuddy();

}
