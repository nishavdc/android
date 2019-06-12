package com.example.android.menu;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void printToLogs(View view) {
        // Find first menu item TextView and print the text to the logs
        TextView textViewitem1 = (TextView) findViewById(R.id.menu_item_1);
        String menuitem1 = textViewitem1.getText().toString();
        Log.v("MainActivity",menuitem1);
        // Find second menu item TextView and print the text to the logs
        TextView textViewitem2 = (TextView) findViewById(R.id.menu_item_2);
        String menuitem2 = textViewitem2.getText().toString();
        Log.v("MainActivity",menuitem2);
        // Find third menu item TextView and print the text to the logs
        TextView textViewitem3 = (TextView) findViewById(R.id.menu_item_3);
        String menuitem3 = textViewitem3.getText().toString();
        Log.v("MainActivity",menuitem3);
    }
}