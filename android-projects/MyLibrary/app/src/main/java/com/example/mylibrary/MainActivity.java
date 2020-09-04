package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnWantToRead, btnAllBooks, btnCurrentlyReading, btnAlreadyRead, btnAbout, btnFavorites;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        btnAllBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, AllBooksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        btnWantToRead = findViewById(R.id.btnWantToRead);
        btnAllBooks = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrentlyReading);
        btnAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAbout = findViewById(R.id.btnAbout);
        btnFavorites = findViewById(R.id.btnFavorites);
    }
}