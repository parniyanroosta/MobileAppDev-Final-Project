package com.example.finalproject_parniyanroosta;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        String message = intent.getStringExtra(DetailActivity.EXTRA_MESSAGE);
        TextView textView = findViewById(R.id.txtOrder);
        textView.setText(message);
    }
}