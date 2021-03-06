package com.example.jonkersbothdaphne_pset2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.io.InputStream;
//Represents a setting menu where the user can choose the kind of story
public class Welcome extends AppCompatActivity {
    int[][] selectedStory = {{R.id.tarzan, R.raw.madlib_tarzan}, {R.id.clothes, R.raw.madlib_clothes},
            {R.id.dance, R.raw.madlib_dance}, {R.id.simple, R.raw.madlib_simple}, {R.id.university,
            R.raw.madlib_university}};
    int selected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void buttonClick(View view) {
        RadioGroup buttons = findViewById(R.id.radioGroup);
        selected = buttons.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selected);
        //show which story is selected
        Toast.makeText(getApplicationContext(), selectedButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();
    }

    //start the game with the selected story
    public void applyClicked(View view) {
        Story story = makeStory(selected);
        Intent intent = new Intent(this, FillActivity.class);
        intent.putExtra("story", story);
        startActivity(intent);
        finish();
    }

    public Story makeStory(int buttonSelect){
        int i;
        //get the selected story
        for(i =0; i<selectedStory.length; i++) {
            if (buttonSelect == selectedStory[i][0]) {
                break;
            }
        }
        InputStream tale = getResources().openRawResource(selectedStory[i][1]);
        Story story = new Story(tale);
        return story;
    }
}
