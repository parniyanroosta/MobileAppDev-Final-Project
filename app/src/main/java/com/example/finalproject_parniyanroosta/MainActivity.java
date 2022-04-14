package com.example.finalproject_parniyanroosta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

public void StartPaintingActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Category_Painting.class);
        startActivity(intent);
}

    public void StartPotteryActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Category_Pottery.class);
        startActivity(intent);
    }

    public void StartKnittingActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Category_Knitting.class);
        startActivity(intent);
    }

    public void StartEmbroideryActivity(View view) {
        Intent intent = new Intent(MainActivity.this, Category_Embroidery.class);
        startActivity(intent);
    }
}