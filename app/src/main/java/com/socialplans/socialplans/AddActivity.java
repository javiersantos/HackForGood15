package com.socialplans.socialplans;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

public class AddActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Añadir plan");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        AutoCompleteTextView title = (AutoCompleteTextView) findViewById(R.id.autocomplete_title);
        AutoCompleteTextView place = (AutoCompleteTextView) findViewById(R.id.autocomplete_place);

        String[] titleArray = getResources().getStringArray(R.array.title_array);
        ArrayAdapter<String> adapterTitle = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, titleArray);
        title.setAdapter(adapterTitle);

        String[] placeArray = getResources().getStringArray(R.array.places_array);
        ArrayAdapter<String> adapterPlace = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, placeArray);
        place.setAdapter(adapterPlace);

    }

    public void saveEvent(View v) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "¡Has creado el plan correctamente!", Toast.LENGTH_SHORT);
        toast1.show();
        startActivity(new Intent(this, MainActivity.class));
    }

}
