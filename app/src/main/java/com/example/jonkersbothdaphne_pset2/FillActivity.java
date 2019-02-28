package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class FillActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        Story retrievedStory = (Story) intent.getSerializableExtra("story");
        System.out.println("testje " + retrievedStory.getNextPlaceholder());

    }
}
