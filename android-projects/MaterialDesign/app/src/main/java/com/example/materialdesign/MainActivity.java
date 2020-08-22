package com.example.materialdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.card.MaterialCardView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private ConstraintLayout parent;
    private Button btnShowSnackBar;
    private MaterialCardView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parent = findViewById(R.id.parent);
        btnShowSnackBar = findViewById(R.id.button);
        btnShowSnackBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showSnackBar();
            }
        });
        cardView = findViewById(R.id.cardView);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "card has been clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showSnackBar() {
        Snackbar.make(parent, "This is a snackbar", Snackbar.LENGTH_INDEFINITE)
                .setAction("Retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Retry Clicked", Toast.LENGTH_SHORT).show();
                    }
                })
                .setActionTextColor(Color.YELLOW)
                .show();
    }
}