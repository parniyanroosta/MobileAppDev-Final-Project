package com.example.finalproject_parniyanroosta;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {

    private SharedPreferences mPreference;
    private String SharedPreferenceFileName = "com.example.finalproject_parniyanroosta";
    private EditText user, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        user = findViewById(R.id.editTextUserName);
        pass = findViewById(R.id.editTextPassword);
    }

    public void UserLogin(View view) {
        mPreference = getSharedPreferences(SharedPreferenceFileName, MODE_PRIVATE);
        String password = mPreference.getString(user.getText().toString(), "");
        if ( password.equals(pass.getText().toString()))
        {
            //call the api
            Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginPage.this, ProfilePage.class);
            startActivity(intent);

        } else {
            Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show();
        }

    }

    public void AddNewUser(View view) {
        mPreference = getSharedPreferences(SharedPreferenceFileName, MODE_PRIVATE);
        SharedPreferences.Editor preferenceEditor = mPreference.edit();
        preferenceEditor.putString(user.getText().toString(), pass.getText().toString());
        preferenceEditor.apply();
        Toast.makeText(this, "User added successfully!", Toast.LENGTH_SHORT).show();
    }
}