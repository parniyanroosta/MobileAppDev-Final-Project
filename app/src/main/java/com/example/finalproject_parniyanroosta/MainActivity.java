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


//later, when creating the onclick event on the images
//    public void StartSecondActivity(View view) {
//
//        String msg = textMessage.getText().toString();
//        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
//        intent.putExtra(MESSAGE_KEY, msg);
//        startActivity(intent);
//    }
}