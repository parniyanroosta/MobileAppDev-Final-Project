package com.example.finalproject_parniyanroosta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Category_Painting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_painting);

        //to receive the intent from the main activity
        Intent intent = getIntent();
    }
}