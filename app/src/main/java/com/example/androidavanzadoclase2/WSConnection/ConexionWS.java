package com.example.androidavanzadoclase2.WSConnection;


import android.util.Log;

import com.example.androidavanzadoclase2.Api;
import com.example.androidavanzadoclase2.Users.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConexionWS {
    private static List<User> userList;
    private static ConexionWS connWs;
    private static Retrofit retrofit;

    public static ConexionWS conexion(){
        if(connWs==null){
            connWs = new ConexionWS();
            userList = new ArrayList<>();
        }
        if(retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return connWs;
    }

    public void getUsuarios(){
        Api api = retrofit.create(Api.class);
        api.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()) {
                    userList.addAll(response.body());

                } else if (response.code() == 400 && response.code() < 500) {
                    Log.e("REQUEST ERROR", "ERROR EN LA LLAMADA");
                } else if (response.code() >= 500) {
                    Log.e("SERVER ERROR", "ERROR DEL LADO DEL SERVER");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                String d = t.getMessage();
                Log.e("FAILURE SERVER", d);
            }

            @Override
            protected void finalize() throws Throwable {
                super.finalize();
            }

        });
    }
}
