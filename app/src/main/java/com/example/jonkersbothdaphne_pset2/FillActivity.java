package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FillActivity extends AppCompatActivity {
    Story retrievedStory;
    EditText word;
    TextView neededWord, wordsLeft;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill);

        Intent intent = getIntent();
        retrievedStory = (Story) intent.getSerializableExtra("story");
        updateScreen();
    }

    public void onClick(View view) {
        retrievedStory.fillInPlaceholder(word.getText().toString());
        if(retrievedStory.getPlaceholderRemainingCount() == 0){ //last placeholder is filled in
            Intent intent = new Intent(this, StoryActivity.class);
            intent.putExtra("story", retrievedStory);
            startActivity(intent);
            finish();
        }
        else{
            word.setText("");
            neededWord.setText("");
            wordsLeft.setText("");
            updateScreen();
        }
    }

    public void updateScreen() {

        neededWord = findViewById(R.id.neededWord);
        neededWord.setText("please type a/an " + retrievedStory.getNextPlaceholder().toLowerCase());

        wordsLeft = findViewById(R.id.wordsLeft);
        wordsLeft.setText(retrievedStory.getPlaceholderRemainingCount() +" word(s) left");

        word = findViewById(R.id.word);
        word.setHint(retrievedStory.getNextPlaceholder().toLowerCase());
    }
}
