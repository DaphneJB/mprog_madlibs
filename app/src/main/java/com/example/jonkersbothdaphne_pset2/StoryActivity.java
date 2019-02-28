package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        Intent intent = getIntent();
        Story retrievedStory = (Story) intent.getSerializableExtra("story");
        TextView tale = findViewById(R.id.story);
        tale.setText(retrievedStory.toString());
    }
}
