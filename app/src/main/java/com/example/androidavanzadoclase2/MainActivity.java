package com.example.androidavanzadoclase2;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new CalculadoraTask().execute(9);
    }

    private class  CalculadoraTask extends AsyncTask<Integer, Void, Integer>{

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            Toast.makeText(MainActivity.this, "La tarea comienza aquí", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected Integer doInBackground(Integer... integers) {
            Integer resultado = 0;
            Integer valor = integers[0];
            for (int i=0; i<valor; i++){
                for (int j=0; j<valor; j++){
                    resultado += i+i*i*i*j;
                }
            }
            return resultado;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            super.onPostExecute(integer);
            Toast.makeText(MainActivity.this, String.valueOf(integer), Toast.LENGTH_SHORT).show();
        }
    }
}
