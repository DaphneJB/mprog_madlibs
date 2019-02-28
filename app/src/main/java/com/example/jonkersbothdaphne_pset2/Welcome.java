package com.example.jonkersbothdaphne_pset2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Welcome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void buttonClick(View view) {
        RadioGroup buttons = findViewById(R.id.radioGroup);
        int selected = buttons.getCheckedRadioButtonId();
        RadioButton selectedButton = findViewById(selected);
        Toast.makeText(getApplicationContext(), selectedButton.getText().toString()+" is selected", Toast.LENGTH_SHORT).show();
    }
}
