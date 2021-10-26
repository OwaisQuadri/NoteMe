package com.example.noteme;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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
                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext()) {
                    buffer.append("Title: " + res.getString(0) + "\n");
                    buffer.append("Subtitle: " + res.getString(1) + "\n");
                    buffer.append("Body: " + res.getString(2) + "\n");
                    buffer.append("Color: " + res.getString(3) + "\n\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setCancelable(true);
                builder.setTitle("Notes");
                builder.setMessage(buffer.toString());
                builder.show();
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