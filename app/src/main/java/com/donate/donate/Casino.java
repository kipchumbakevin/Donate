package com.donate.donate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Casino extends AppCompatActivity {

    int degree = 0,degree_old = 0;
    Random r;
    Button start;
    TextView textView;
    ImageView selected,imageRoul;
    Spinner spinner;
    private static final float FACTOR = 4.86f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_casino);
        start = findViewById(R.id.start);
        imageRoul = findViewById(R.id.roul);
        textView = findViewById(R.id.textview);
        selected = findViewById(R.id.nav);
        spinner = findViewById(R.id.spinner);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,R.array.numbers,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        r = new Random();

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                degree_old = degree % 360;
                degree = r.nextInt(3600) + 720;
                RotateAnimation rotate = new RotateAnimation(degree_old,degree,
                        RotateAnimation.RELATIVE_TO_SELF,0.5f,RotateAnimation.RELATIVE_TO_SELF,0.5f);
                rotate.setDuration(3600);
                rotate.setFillAfter(true);
                rotate.setInterpolator(new DecelerateInterpolator());
                rotate.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        textView.setText("");
                        start.setVisibility(View.GONE);
                        spinner.setEnabled(false);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        textView.setText(currentNumber(360-(degree % 360)));
                        start.setVisibility(View.VISIBLE);
                        spinner.setEnabled(true);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imageRoul.startAnimation(rotate);
            }
        });

    }
    private String currentNumber(int degrees){
        String text = "";
        if (degrees >=(FACTOR * 1)&& degrees < (FACTOR * 3)){
            text = "32 Red";
        }
        if (degrees >=(FACTOR * 3)&& degrees < (FACTOR * 5)){
            text = "15 Black";
        }
        if (degrees >=(FACTOR * 5)&& degrees < (FACTOR * 7)){
            text = "19 Red";
        }
        if (degrees >=(FACTOR * 7)&& degrees < (FACTOR * 9)){
            text = "4 Black";
        }
        if (degrees >=(FACTOR * 9)&& degrees < (FACTOR * 11)){
            text = "21 Red";
        }
        if (degrees >=(FACTOR * 11)&& degrees < (FACTOR * 13)){
            text = "2 Black";
        }
        if (degrees >=(FACTOR * 13)&& degrees < (FACTOR * 15)){
            text = "25 Red";
        }
        if (degrees >=(FACTOR * 15)&& degrees < (FACTOR * 17)){
            text = "17 Black";
        }
        if (degrees >=(FACTOR * 17)&& degrees < (FACTOR * 19)){
            text = "34 Red";
        }
        if (degrees >=(FACTOR * 19)&& degrees < (FACTOR * 21)){
            text = "6 Black";
        }
        if (degrees >=(FACTOR * 21)&& degrees < (FACTOR * 23)){
            text = "27 Red";
        }
        if (degrees >=(FACTOR * 23)&& degrees < (FACTOR * 25)){
            text = "13 Black";
        }
        if (degrees >=(FACTOR * 25)&& degrees < (FACTOR * 27)){
            text = "36 Red";
        }
        if (degrees >=(FACTOR * 27)&& degrees < (FACTOR * 29)){
            text = "11 Black";
        }
        if (degrees >=(FACTOR * 29)&& degrees < (FACTOR * 31)){
            text = "30 Red";
        }
        if (degrees >=(FACTOR * 31)&& degrees < (FACTOR * 33)){
            text = "8 Black";
        }
        if (degrees >=(FACTOR * 33)&& degrees < (FACTOR * 35)){
            text = "23 Red";
        }
        if (degrees >=(FACTOR * 35)&& degrees < (FACTOR * 37)){
            text = "10 Black";
        }
        if (degrees >=(FACTOR * 37)&& degrees < (FACTOR * 39)){
            text = "5 Red";
        }
        if (degrees >=(FACTOR * 39)&& degrees < (FACTOR * 41)){
            text = "24 Black";
        }
        if (degrees >=(FACTOR * 41)&& degrees < (FACTOR * 43)){
            text = "16 Red";
        }
        if (degrees >=(FACTOR * 43)&& degrees < (FACTOR * 45)){
            text = "33 Black";
        }
        if (degrees >=(FACTOR * 45)&& degrees < (FACTOR * 47)){
            text = "1 Red";
        }
        if (degrees >=(FACTOR * 47)&& degrees < (FACTOR * 49)){
            text = "20 Black";
        }
        if (degrees >=(FACTOR * 49)&& degrees < (FACTOR * 51)){
            text = "14 Red";
        }
        if (degrees >=(FACTOR * 51)&& degrees < (FACTOR * 53)){
            text = "31 Black";
        }
        if (degrees >=(FACTOR * 53)&& degrees < (FACTOR * 55)){
            text = "9 Red";
        }
        if (degrees >=(FACTOR * 55)&& degrees < (FACTOR * 57)){
            text = "22 Black";
        }
        if (degrees >=(FACTOR * 57)&& degrees < (FACTOR * 59)){
            text = "18 Red";
        }
        if (degrees >=(FACTOR * 59)&& degrees < (FACTOR * 61)){
            text = "29 Black";
        }
        if (degrees >=(FACTOR * 61)&& degrees < (FACTOR * 63)){
            text = "7 Red";
        }
        if (degrees >=(FACTOR * 63)&& degrees < (FACTOR * 65)){
            text = "28 Black";
        }
        if (degrees >=(FACTOR * 65)&& degrees < (FACTOR * 67)){
            text = "12 Red";
        }
        if (degrees >=(FACTOR * 67)&& degrees < (FACTOR * 69)){
            text = "35 Black";
        }
        if (degrees >=(FACTOR * 69)&& degrees < (FACTOR * 71)){
            text = "3 Red";
        }
        if (degrees >=(FACTOR * 71)&& degrees < (FACTOR * 73)){
            text = "26 Black";
        }
        if ((degrees >= (FACTOR * 73) && degrees<360) || (degrees>=0 && degrees<(FACTOR * 1))){
            text = "0";
        }

        return text;
    }
}
