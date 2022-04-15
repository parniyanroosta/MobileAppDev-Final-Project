package com.example.finalproject_parniyanroosta;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

//this page is launched when an item is clicked, it shows more info about the item

public class DetailActivity extends AppCompatActivity {

    // Filling in the data from the Intent.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_of_item);

        // Initialize the views.
        ImageView itemImage = findViewById(R.id.artImageDetail);
        TextView itemTitle = findViewById(R.id.titleDetail);
        TextView itemDescription = findViewById(R.id.descriptionDetail);

        // Set the text from the Intent extra.
        itemTitle.setText(getIntent().getStringExtra("title"));
        itemDescription.setText(getIntent().getStringExtra("description"));     //----------------------------------------------not set yet

        // Load the image using the Glide library and the Intent extra.
        Glide.with(this).load(getIntent().getIntExtra("image_resource",0))
                .into(itemImage);
    }
}
