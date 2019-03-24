package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;
//class that shows the story to the user and gives the user the opportunity to make another story
public class StoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);
        Intent intent = getIntent();
        Story retrievedStory = (Story) intent.getSerializableExtra("story");
        TextView tale = findViewById(R.id.story);
        //show story with bold letters for the filled in words
        tale.setText(Html.fromHtml(retrievedStory.toString(), 0));
    }

    //go back to the story settings menu
    public void newStoryClicked(View view) {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent);
        finish();
    }
}
