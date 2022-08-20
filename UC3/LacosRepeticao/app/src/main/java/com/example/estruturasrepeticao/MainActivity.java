package com.example.estruturasrepeticao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Integer> itens = Arrays.asList(11,10,20,50,85);


        for (Integer item : itens) {
            if(item == 50){
                Log.i("saida", "Item encontrado " + item);
            }
        }

//        int i =0;
//        do {
//            Log.i("saida", "O valor atual é: " + i);
//            i++;
//        }while (i<=10);
//        while(i<=5){
//            Log.i("saida", "O valor atual é: " + i);
//            i++;
//        }
//        for(int i = 0; i<=10;i++){
//        }
//             Log.i("saida", "O valor atual é: " + i);
    }
}