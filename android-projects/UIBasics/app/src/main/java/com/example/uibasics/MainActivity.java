package com.example.uibasics;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView txtHello;
    private EditText edtTxtName;

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnHello:
                Toast.makeText(this, "Hello Button Clicked", Toast.LENGTH_SHORT).show();
                txtHello.setText("Hello " + edtTxtName.getText().toString());
                break;
            default:
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(this);

        txtHello = findViewById(R.id.txtHello);
        edtTxtName = findViewById(R.id.edtTxtName);
    }


}