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

        Editable title, subtitle, body;
        TextInputLayout titleInput, subtitleInput, bodyInput;
        RadioGroup radioGroup;
        DBHelper DB;

        DB = new DBHelper(this);


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

        // COLOURED BUTTONS
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

        titleInput = findViewById(R.id.titleInput);
        title = titleInput.getEditText().getText();

        subtitleInput = findViewById(R.id.subtitleInput);
        subtitle = subtitleInput.getEditText().getText();

        bodyInput = findViewById(R.id.bodyInput);
        body = bodyInput.getEditText().getText();

        Button doneButton = (Button) findViewById(R.id.doneButton);
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //check to make sure title is filled in
                if (title.length() == 0 || colourInt == 0){
                    Toast.makeText(getApplicationContext(),"Error: Input Incomplete",Toast.LENGTH_SHORT).show();
                }

                else {
                    //done onclick
                    //save note
                    //go back

                    String titleTXT = title.toString();
                    String subtitleTXT = subtitle.toString();
                    String bodyTXT = body.toString();
                    String colourTXT;

                    if (colourInt == 1) { colourTXT = "Green"; }
                    else if (colourInt == 2) { colourTXT = "Red"; }
                    else { colourTXT = "Blue"; }

                    Boolean checkinsertdata = DB.insertNote(titleTXT, subtitleTXT, bodyTXT, colourTXT);

                    if(checkinsertdata == true)
                        Toast.makeText(getApplicationContext(), "New Entry Inserted", Toast.LENGTH_SHORT).show();
                    else
                        Toast.makeText(getApplicationContext(), "New Entry Not Inserted", Toast.LENGTH_SHORT).show();

                    Intent i = new Intent(NewNote.this, MainActivity.class);
                    finish();//delete current session
                    startActivity(i);
                }
            }
        });
    }
}