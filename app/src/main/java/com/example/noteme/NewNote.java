package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class NewNote extends AppCompatActivity {
    int colourInt = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Editable title;
        TextInputLayout titleInput;
        RadioGroup radioGroup;


        setContentView(R.layout.activity_new_note);
        //find button
        Button backButton = (Button) findViewById(R.id.backButton);
        //set onclick
        backButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //back onclick
                //go back
                Intent i = new Intent(NewNote.this, MainActivity.class);

                finish();//delete current session
                startActivity(i);
            }
        });

        titleInput = findViewById(R.id.titleInput);
        title = titleInput.getEditText().getText();
        //find button
        Button doneButton = (Button) findViewById(R.id.doneButton);
        //set onclick
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check to make sure title is filled in
                if (title.length() == 0){
                    Toast.makeText(getApplicationContext(),"Error: Input Title",Toast.LENGTH_SHORT).show();
                }

                else {
                    //done onclick
                    //save note
                    //go back
                    Intent i = new Intent(NewNote.this, MainActivity.class);
                    finish();//delete current session
                    startActivity(i);
                }
            }
        });


        //
        //
        //check colour buttons
        //
        //

        ConstraintLayout layout1 = findViewById(R.id.layout1);
        Button blueButton = (Button) findViewById(R.id.blueButton);
        blueButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check to make sure title is filled in
                colourInt = 3;
                layout1.setBackgroundColor(getResources().getColor(R.color.blue));
            }
        });

        Button redButton = (Button) findViewById(R.id.redButton);
        redButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check to make sure title is filled in
                colourInt = 2;
                layout1.setBackgroundResource(R.color.red);
            }
        });

        Button greenButton = (Button) findViewById(R.id.greenButton);
        greenButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check to make sure title is filled in

                colourInt = 1;
                layout1.setBackgroundResource(R.color.green);
            }
        });
        
    }
}