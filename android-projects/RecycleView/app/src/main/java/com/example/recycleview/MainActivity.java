package com.example.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView contactsRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactsRecView = findViewById(R.id.contactsRecView);

        ArrayList<Contact> contacts = new ArrayList<>();
        contacts.add(new Contact("Margot Robbie", "margot@gmail.com", "https://upload.wikimedia.org/wikipedia/commons/f/f0/Mops_oct09_cropped2.jpg"));
        contacts.add(new Contact("Cillian Murhpy", "cillian@gmail.com", "https://cdn3-www.dogtime.com/assets/uploads/2011/01/file_23124_pug.jpg"));
        contacts.add(new Contact("Saoirse Ronan", "saoirse@gmail.com", "https://www.purelypetsinsurance.co.uk/media/1272/gettyimages-892790542.jpg"));
        contacts.add(new Contact("Emma Watson", "emma@gmail.com", "https://img.dog-learn.com/dog-breeds/pug/pug-puppy-i14-sz6.jpg"));
        contacts.add(new Contact("Christian Bale", "christian@gmail.com", "https://m.dw.com/image/47715732_101.jpg"));

        ContactsRecViewAdapter adapter = new ContactsRecViewAdapter(this);
        adapter.setContacts(contacts);

        contactsRecView.setAdapter(adapter);
        contactsRecView.setLayoutManager(new GridLayoutManager(this, 2));
    }
}