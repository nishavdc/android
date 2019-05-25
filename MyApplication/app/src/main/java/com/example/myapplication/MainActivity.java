package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.graphics.Color.MAGENTA;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textview = new TextView(this);
        textview.setText("Hey We use it where we, we signal, you know the word signal is used both as a noun and as a verb.\n" +
                "It's used as a noun to denote essentially a function of an independent variable.");
        textview.setTextSize(40);
        textview.setTextColor(Color.RED);
        textview.setMaxLines(2);
        setContentView(textview);
    }
}
