package com.example.registrationform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onRegisterBtnClick(View view) {
        TextView txtFirst = findViewById(R.id.txtFirst);
        TextView txtLast = findViewById(R.id.txtLast);
        TextView txtEmail = findViewById(R.id.txtEmail);

        EditText editTxtFirst = findViewById(R.id.editTxtFirst);
        EditText editTxtLast = findViewById(R.id.editTxtLast);
        EditText editTxtEmail = findViewById(R.id.editTxtEmail);

        txtFirst.setText("First Name: " + editTxtFirst.getText().toString());
        txtLast.setText("Last Name: " + editTxtLast.getText().toString());
        txtEmail.setText("Email: " + editTxtEmail.getText().toString());



    }
}