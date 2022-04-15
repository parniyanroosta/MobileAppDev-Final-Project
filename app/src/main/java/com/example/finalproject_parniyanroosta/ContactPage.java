package com.example.finalproject_parniyanroosta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ContactPage extends AppCompatActivity {

    Button sendButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        sendButton = findViewById(R.id.btnSend);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SendMeMessage();
            }
        });

    }

    public void SendMeMessage() {
        Toast.makeText(this, "This functionality is not set yet!", Toast.LENGTH_SHORT).show();
    }
}