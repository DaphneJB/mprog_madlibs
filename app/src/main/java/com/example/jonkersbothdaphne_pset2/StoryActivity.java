package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
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
        tale.setText(retrievedStory.toString()); //show story
    }
    @Override
    public void onBackPressed() {

        Intent intent = new Intent(this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent); //go back to the home screen
    }

    public void newStoryClicked(View view) {
        Intent intent = new Intent(this, Welcome.class);
        startActivity(intent); //go back to the story chooser menu
    }
}
