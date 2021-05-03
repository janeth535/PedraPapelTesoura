package com.example.meujogoppt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class Tela2 extends AppCompatActivity {
    Random escolhaCompt = new Random();

    //1-papel; 2-Pedra; 3-tesoura
    //j(1) c(2)= -1 Usuario
    //j(1) C(3)= -2 Computador
    //j(2) c(1)= 1 Computador
    //j(2) C(3)= -1 Usuario
    //j(3) c(1)= 2 Usuario
    //j(3) C(2)= Computador

    int escolhaUsua;
    int escolhaCompu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
    }
    public void papel(View view){
        escolhaUsua= 1;
        compuEscolhe();
        verifiq();
    }
    public void pedra(View view) {
        escolhaUsua = 2;
        compuEscolhe();
        verifiq();
    }
    public void tesoura(View view) {
        escolhaUsua = 3;
        compuEscolhe();
        verifiq();
    }

    public void verifiq(){
        TextView textview3 = findViewById(R.id.textView3);
        if (escolhaCompu == escolhaUsua){
            textview3.setText("Empate");
        }
        else if(escolhaUsua - escolhaCompu == -1 || escolhaUsua - escolhaCompu == 2) {
            textview3.setText("Você Ganhou");
        }
        else {
            textview3.setText("Você Perdeu");
        }
    }
    public void compuEscolhe(){
        ImageView resultado = findViewById(R.id.resultado);
        escolhaCompu = escolhaCompt.nextInt(3) + 1;
        if(escolhaCompu == 1)resultado.setImageResource(R.drawable.papel);
        else if (escolhaCompu == 2)resultado.setImageResource(R.drawable.pedra);
        else if (escolhaCompu == 3)resultado.setImageResource(R.drawable.tesoura);

    }

    public void voltar(View view){
        Intent intent = new Intent(getApplicationContext(),Tela2.class);
        startActivity(intent);
    }
    public void sair(View view){
        Intent intent = new Intent(getApplicationContext(),Tela3.class);
        startActivity(intent);
    }
}
