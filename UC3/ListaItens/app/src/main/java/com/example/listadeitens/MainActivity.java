package com.example.listadeitens;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> lista = new ArrayList<String>();

        Aluno a = new Aluno("Thiago", " Programação para disp. móveis, Nota:", 7);
        Aluno b = new Aluno("\n" + "Alice", " Programação Php, Nota:", 8);
        Aluno c = new Aluno("\n" + "Julia", " Ux design, Nota:", 9);
        lista.add((a.getNome() + a.getCurso() + a.getNota()));
        lista.add((b.getNome() + b.getCurso() + b.getNota()));
        lista.add((c.getNome() + c.getCurso() + c.getNota()));
        Log.i("saida","Informações do aluno : " + lista);
//    lista.add("Thiago");
//        lista.add("Lucas");
//        lista.add("Luis");
//        lista.add("Kelliton");


//        int [][] array1 = new int[][] {{1,2,3,},{4,5,6}};
//        int [][] array2 = new int[][] {{1,2,3,},{3},{4,5,6}};
//        int i, j;
//        for (i = 0; i < array2.length; i++) {
//            for (j = 0; j < array2[i].length; j++) {
//                Log.i("message", "O valor atual é: " + array2[i][j]);
//            }
//        }
         // String[] nomes = {"Thiago", "Rafael","Caio","Lucas"};
//
//       if(nomes.length >3){
//        Log.i("saida", "Tamanho do array maior que três");
//        }else{
//            Log.i("saida", "Tamanho do array menor que três");
//        }
//        String total =null;
//        for (String n: nomes) {
//
//            total += n;
//            Log.i("saida", "Total: " + n);
//            if(n.equals("Thiago")){
//                Log.i("saida","Thiago encontrado: " + n);
//            }
//        }

//       for (int i=0; i<nomes.length;i++){
//           Log.i("saida","O valor é: " + i + " " + nomes[i]);
//       }

//        String[] a = new String[4];
//        a[0] = "Caua";
//        a[1] = "Lucas";
//        a[2] = "Luis";
//        a[3] = "Kelliton";
//        Log.i("tamanho ", "array " + nomes[3]);
    }
}