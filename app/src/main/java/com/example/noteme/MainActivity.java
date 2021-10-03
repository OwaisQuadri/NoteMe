package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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