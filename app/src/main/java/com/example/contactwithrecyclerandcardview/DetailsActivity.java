package com.example.contactwithrecyclerandcardview;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    TextView title,number;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ActionBar actionBar = getSupportActionBar();

        title = findViewById(R.id.dtlTextViewId);
        number = findViewById(R.id.dtlNumberTextId);
        img = findViewById(R.id.dtalImageId);


        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mNumber = intent.getStringExtra("iNumber");
        byte[] mbytes = intent.getByteArrayExtra("img");

        Bitmap bitmap = BitmapFactory.decodeByteArray(mbytes,0,mbytes.length);

        actionBar.setTitle(mTitle);

        title.setText(mTitle);
        number.setText(mNumber);
        img.setImageBitmap(bitmap);



    }
}
