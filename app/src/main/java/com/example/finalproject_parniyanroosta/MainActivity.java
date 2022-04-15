package com.example.finalproject_parniyanroosta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

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

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //TODO
        // to save the page info when the device is rotated-------@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu, this adds items to the action bar if it is present
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks here. The action bar will automatically handle clicks
        // on the home/up button so long as a parent activity is specified in AndroidManifest.xml
        switch ( item.getItemId()){
            case R.id.action_about:
                Intent intent = new Intent(this, AboutMe.class);
                startActivity(intent);
                return true;
            case R.id.action_contact:
                Intent intent2 = new Intent(this, ContactPage.class);
                startActivity(intent2);
                return true;
            case R.id.action_login:
                //@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}