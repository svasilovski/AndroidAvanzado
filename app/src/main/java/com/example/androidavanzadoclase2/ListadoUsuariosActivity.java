package com.example.androidavanzadoclase2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.example.androidavanzadoclase2.Adapters.Adapter;
import com.example.androidavanzadoclase2.Users.User;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListadoUsuariosActivity extends AppCompatActivity {
    List<User> userLisr;
    Adapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listado_usuarios);

        /*Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        Api api = retrofit.create(Api.class);
        api.getUsers().enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){

                    userLisr.addAll(response.body());
                    adapter.notifyDataSetChanged();

                }else if (response.code()==400 && response.code() < 500){
                    Log.e("REQUEST ERROR", "ERROR EN LA LLAMADA");
                }else if (response.code() >= 500){
                    Log.e("SERVER ERROR", "ERROR DEL LADO DEL SERVER");
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                String d = t.getMessage();
            }
        });*/

        userLisr = new ArrayList<>();

        ListView l = findViewById(R.id.lista);
        adapter = new Adapter(userLisr);

        l.setAdapter(adapter);

        MyService ms = new MyService("User", adapter);
        ms.onCreate();
    }
}
