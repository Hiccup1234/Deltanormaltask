package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {
    MainActivity2 main = new MainActivity2();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        TextView SCORE=(TextView) findViewById(R.id.finalscore);
        int showscore;
        showscore = main.getScore();
        SCORE.setText("You Scored: "+showscore);
    }


    public void again(View view){

        Intent intent=new Intent(MainActivity3.this,MainActivity2.class);
        startActivity(intent);
    }
    public void exitGame(View view){
        this.finishAffinity();
    }
}