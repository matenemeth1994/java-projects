package com.example.mylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class BookActivity extends AppCompatActivity {

    public static final String BOOK_ID_KEY = "bookId";

    private TextView txtBookName, txtAuthor, txtPages, txtDescription;
    private Button btnAddToWanToRead, btnAddToAlreadyRead, btnAddToCurrentlyReading, btnAddToFavorite;
    private ImageView bookImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        initViews();

//        String longDescription = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id malesuada sapien, eu facilisis nunc. Nunc gravida magna sed arcu tincidunt rhoncus. Vivamus ultricies non metus sed mollis. Suspendisse egestas eros at congue vulputate. Praesent pharetra velit a nisl ornare, vitae rutrum lorem accumsan. Mauris pretium a justo non finibus. Praesent augue odio, feugiat et luctus vitae, pharetra vel tellus. Duis nisl sapien, imperdiet eu aliquam quis, volutpat ac mi. Cras eget nunc metus. Duis at tellus semper, faucibus risus sit amet, blandit augue. Aliquam quis tortor volutpat, varius nulla in, rutrum mi. Aliquam lacinia vestibulum velit et tincidunt. Duis convallis, metus at sodales elementum, dolor purus efficitur tortor, laoreet viverra lacus ex quis est."
//                + "\n" +
//                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce id malesuada sapien, eu facilisis nunc. Nunc gravida magna sed arcu tincidunt rhoncus. Vivamus ultricies non metus sed mollis. Suspendisse egestas eros at congue vulputate. Praesent pharetra velit a nisl ornare, vitae rutrum lorem accumsan. Mauris pretium a justo non finibus. Praesent augue odio, feugiat et luctus vitae, pharetra vel tellus. Duis nisl sapien, imperdiet eu aliquam quis, volutpat ac mi. Cras eget nunc metus. Duis at tellus semper, faucibus risus sit amet, blandit augue. Aliquam quis tortor volutpat, varius nulla in, rutrum mi. Aliquam lacinia vestibulum velit et tincidunt. Duis convallis, metus at sodales elementum, dolor purus efficitur tortor, laoreet viverra lacus ex quis est.";
//
//
//        // TODO: Get the data from recycler view in here:
//        Book book = new Book(1, "1Q84", "Haruki Murakami", 1350, "https://jameskennedymonash.files.wordpress.com/2013/01/1q84-cover.jpg",
//                "A work of maddening brilliance", longDescription);

        Intent intent = getIntent();
        if (null != intent) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            if (bookId != -1) {
                Book incomingBook = Utils.getInstance().getBookById(bookId);
                if (null != incomingBook) {
                    setData(incomingBook);

                    handleAlreadyRead(incomingBook);
                }
            }
        }
    }

    private void handleAlreadyRead(final Book book) {
        ArrayList<Book> alreadyReadBooks = Utils.getInstance().getAlreadyReadBooks();

        boolean existInAlreadyReadBooks = false;

        for (Book b : alreadyReadBooks) {
            if (b.getId() == book.getId()) {
                existInAlreadyReadBooks = true;
            }
        }

        if (existInAlreadyReadBooks) {
            btnAddToAlreadyRead.setEnabled(false);
        } else {
            btnAddToAlreadyRead.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (Utils.getInstance().addToAlreadyRead(book)) {
                        Toast.makeText(BookActivity.this, "Book Added", Toast.LENGTH_SHORT).show();
                        // TODO: Navigate the user
                    } else {
                        Toast.makeText(BookActivity.this, "Something wrong happened, try it one more time", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void setData(Book book) {
        txtBookName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
        txtPages.setText(String.valueOf(book.getPages()));
        txtDescription.setText(book.getLongDesc());
        Glide.with(this)
                .asBitmap().load(book.getImageUrl())
                .into(bookImage);
    }

    private void initViews() {
        txtBookName = findViewById(R.id.txtBookName);
        txtAuthor = findViewById(R.id.txtAuthor);
        txtPages = findViewById(R.id.txtPages);
        txtDescription = findViewById(R.id.txtDescription);

        btnAddToAlreadyRead = findViewById(R.id.btnAlreadyRead);
        btnAddToWanToRead = findViewById(R.id.btnAddToWantToReadList);
        btnAddToCurrentlyReading = findViewById(R.id.btnAddToCurrentlyReading);
        btnAddToFavorite = findViewById(R.id.btnAddToFavorites);

        bookImage = findViewById(R.id.bookImage);
    }
}