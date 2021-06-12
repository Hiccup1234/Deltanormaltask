package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity2 extends AppCompatActivity {
    int date,month,year,firsttwo,lasttwo,keywordf,day,randomnumberforanswer,i,rnd;
    public static int score=0;
    String month2;
    int year2;
    ArrayList<Integer> array=new ArrayList<>();
    String[] options={"Option1","Option2","Option3","Option4"};
    Random random= new Random();
    String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
    String[] month1={"January","February","March","April","May","June","July","August","September","October","November","December"};


    public void Question() {
        year = random.nextInt(400)+1800;
        month= random.nextInt(12)+1;
        if((month==1)|| (month==3)||(month==5)||(month==7)||(month==8)||(month==10)||(month==12))
            date= random.nextInt(31)+1;
        else if((month==4)||(month==6)||(month==9)||(month==11))
            date= random.nextInt(30)+1;
        else {
            if (leap(year))
                date = random.nextInt(29) + 1;
            else
                date = random.nextInt(28) + 1;
        }
        month2=month1[month-1];
        if(month>2) {
            month -= 2;
            year2 = year;
        }
        else
        {
            month+=10;
            year2=year;
            year--;
        }
        lasttwo=year2%100;
        firsttwo=year2/100;
        keywordf=(int)(date+Math.floor(((13*month-1)/5))+lasttwo+Math.floor(lasttwo/4)+Math.floor(firsttwo/4)-(2*firsttwo));
        day=answer(keywordf);
        array.add(day);
    }


    public static boolean leap(int n)
    {
        if((n%4)==0)
        {
            if((n%400)==0)
                return true;
            else
            {
                if((n%100)==0)
                    return false;
                else
                    return true;
            }
        }
        else
            return false;
    }



    public int answer(int n)
    {
        if(n>=0)
            return n%7;
        else if((n%7)==0)
            return 0;
        else
            return 7+(n%7);
    }

    public void Options(){
        randomnumberforanswer =random.nextInt(4);
        options[randomnumberforanswer]=days[day];
        int test,a=0;
        if(randomnumberforanswer==0)
            test=1;
        else
            test=0;
        while(a<=2){
            for(i=0;i<7;i++){
                rnd=random.nextInt(2);
                if((rnd==1)&&(!array.contains(i))&&(test!=randomnumberforanswer)&&(test<4)){
                    options[test]=days[i];
                    test++;
                    if(test==randomnumberforanswer)
                        test++;
                    a++;
                    array.add(i);
                    if(a>2)
                        break;
                }
            }
        }
        a=0;
        array.clear();

    }


    public void setScreen(TextView ques, TextView[] opt){
        Question();
        Options();
        ques.setText(date+" "+month2+" "+year2);
        for(int i=0;i<4;i++)
        {
            opt[i].setText(options[i]);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        score=0;
        TextView ques=findViewById(R.id.question);
        TextView[] opt={findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4)};
        setScreen(ques,opt);


    }



    public void clicked1(View view){
        TextView currentscore=findViewById(R.id.score);
        if(randomnumberforanswer==0){
            score++;
            currentscore.setText("Your Current Score is:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
    }
    public void clicked2(View view){
        TextView currentscore=findViewById(R.id.score);
        if(randomnumberforanswer==1){
            score++;
            currentscore.setText("Your Current Score is:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
    }
    public void clicked3(View view){
        TextView currentscore=findViewById(R.id.score);
        if(randomnumberforanswer==2){
            score++;

            currentscore.setText("Your Current Score is:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
    }
    public void clicked4(View view){
        TextView currentscore=findViewById(R.id.score);
        if(randomnumberforanswer==3){
            score++;
            currentscore.setText("Your Current Score is:"+score);
            TextView ques=findViewById(R.id.question);
            TextView[] opt={findViewById(R.id.button1),findViewById(R.id.button2),findViewById(R.id.button3),findViewById(R.id.button4)};
            setScreen(ques,opt);
        }
        else {
            Intent intent=new Intent(MainActivity2.this,MainActivity3.class);
            startActivity(intent);
        }
    }

    public int getScore() {
        return score;
    }


}