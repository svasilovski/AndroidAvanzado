package com.example.androidavanzadoclase2;

import com.example.androidavanzadoclase2.Users.User;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("users")
    Call<List<User>> getUsers();

    @GET("users")
    Call<List<User>> getUserById(@Query("id") String id);
}
