package com.example.androidavanzadoclase2;

import android.app.Service;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.androidavanzadoclase2.Adapters.Adapter;
import com.example.androidavanzadoclase2.Users.User;
import com.example.androidavanzadoclase2.WSConnection.ConexionWS;

import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyService extends Service {
    private Retrofit retrofit;
    private List<User> userLisr;
    private String seccion;

    public MyService(String seccion, Adapter adapter){
        this.seccion=seccion;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        LlamarServicio ls = new LlamarServicio();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    private class  LlamarServicio extends AsyncTask<Void,Void,Integer> {
        public LlamarServicio(){
            ConexionWS conn = ConexionWS.conexion();
            if(seccion.equals("User")) {
                conn.getUsuarios();
            }
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            return null;
        }
    }
}
