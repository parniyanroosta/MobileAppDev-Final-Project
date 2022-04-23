package com.example.finalproject_parniyanroosta;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

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
                SendMeMessage(view);
            }
        });
    }

    public void SendMeMessage(View view) {
        Toast.makeText(this, "This functionality is not set yet!", Toast.LENGTH_SHORT).show();
    }

}