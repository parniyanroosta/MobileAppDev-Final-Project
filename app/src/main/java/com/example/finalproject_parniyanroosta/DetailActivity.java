package com.example.finalproject_parniyanroosta;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

//this page is launched when an item is clicked, it shows more info about the item

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.finalproject_parniyanroosta.MESSAGE";
    public static String mOrderMessage="Your shopping cart is empty!";
    // Filling in the data from the Intent.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_item);

        // Initialize the views.
        ImageView itemImage = findViewById(R.id.artImageDetail);
        TextView itemTitle = findViewById(R.id.titleDetail);
        TextView itemDescription = findViewById(R.id.descriptionDetail);
        TextView itemPrice = findViewById(R.id.txtViewPrice);

        // Set the text from the Intent extra.
        itemTitle.setText(getIntent().getStringExtra("title"));
        itemDescription.setText(getIntent().getStringExtra("description"));
        itemPrice.setText(getIntent().getStringExtra("price"));

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(itemImage);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(DetailActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSAGE, mOrderMessage);
                startActivity(intent);
            }
        });





    }
}
