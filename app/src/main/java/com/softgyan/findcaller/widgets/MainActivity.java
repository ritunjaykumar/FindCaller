package com.softgyan.findcaller.widgets;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.softgyan.findcaller.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.block:
                Toast.makeText(this, "block", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.edit:
                Toast.makeText(this, "Edit", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.share:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copy_number:
                Toast.makeText(this, "copy number", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.copy_name:
                Toast.makeText(this, "copy name", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove_contact:
                Toast.makeText(this, "remove contact", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.add_favorite:
                Toast.makeText(this, "add to favorite", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.remove_favorite:
                Toast.makeText(this, "remove to favorite", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(this, "default message", Toast.LENGTH_SHORT).show();

        }
        return super.onOptionsItemSelected(item);
    }
}