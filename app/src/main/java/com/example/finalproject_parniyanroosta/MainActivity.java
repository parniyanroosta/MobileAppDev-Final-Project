package com.example.finalproject_parniyanroosta;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    ImageView imgViewPainting, imgViewPottery, imgViewKnitting, imgViewEmbroidery;
    TextView txtAppTitle, txtHomePage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgViewPainting = findViewById(R.id.imageViewPainting);
        imgViewPainting.setOnClickListener(v -> StartPaintingActivity(v));

        imgViewKnitting = findViewById(R.id.imageViewKnitting);
        imgViewKnitting.setOnClickListener(v -> StartKnittingActivity(v));

        imgViewPottery = findViewById(R.id.imageViewPottery);
        imgViewPottery.setOnClickListener(v -> StartPotteryActivity(v));

        imgViewEmbroidery = findViewById(R.id.imageViewEmbroidery);
        imgViewEmbroidery.setOnClickListener(v -> StartEmbroideryActivity(v));

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu, this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // The action bar will automatically handle clicks
        switch (item.getItemId()) {
            case R.id.action_about:
                Intent intent = new Intent(this, AboutMe.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Intent intent2 = new Intent(this, ContactPage.class);
                startActivity(intent2);
                return true;
            case R.id.action_login:
                Intent intent3 = new Intent(this, LoginPage.class);
                startActivity(intent3);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}