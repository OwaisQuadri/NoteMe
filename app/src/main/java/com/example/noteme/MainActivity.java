package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button reload;
    DBHelper DB = new DBHelper(this);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reload = findViewById(R.id.reload);

        reload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor res = DB.getNotes();
                if (res.getCount() == 0) {
                    Toast.makeText(MainActivity.this, "No Entry Exists", Toast.LENGTH_SHORT).show();
                    return;
                }
                LinearLayout linearLayout = new LinearLayout(getApplicationContext());
                setContentView(linearLayout);
                linearLayout.setOrientation(LinearLayout.VERTICAL);

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    String text = "";
                    text += ("Title: " + res.getString(0) + "\n");
                    text += ("Subtitle: " + res.getString(1) + "\n");
                    text += ("Body: " + res.getString(2) + "\n");

                    String colour = res.getString(3);

                    TextView textView = new TextView(getApplicationContext());
                    textView.setText(text);
                    textView.setTextColor(Color.parseColor(colour));
                    textView.setGravity(Gravity.CENTER);
                    linearLayout.addView(textView);
                }
            }
        });
    }

    //newnote onclick
    public void newNote(){
        Intent i = new Intent(MainActivity.this, NewNote.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.searchbar, menu);
        MenuItem menuItem1 = menu.findItem(R.id.search_bar);
        android.widget.SearchView searchView = (android.widget.SearchView) menuItem1.getActionView();
        searchView.setQueryHint("Search Bar");

        getMenuInflater().inflate(R.menu.addnote, menu);
        MenuItem menuItem = menu.findItem(R.id.add_note);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.add_note:
                newNote();
                return true;
            case R.id.search_bar:
                //do something
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}