package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NewNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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
        //find button
        Button doneButton = (Button) findViewById(R.id.doneButton);
        //set onclick
        doneButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //done onclick
                //save note
                //go back
                Intent i = new Intent(NewNote.this, MainActivity.class);
                finish();//delete current session
                startActivity(i);
            }
        });
    }
}