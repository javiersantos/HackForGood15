package com.socialplans.socialplans;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.melnykov.fab.FloatingActionButton;

public class DetailActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Más detalles");
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        FloatingActionButton fabJoin = (FloatingActionButton) findViewById(R.id.fabJoin);

    }

    public void shareIntent() {
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "¿Te apuntas al evento \"¿Un trago?\" usando SocialPlans?";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Usando SocialPlans para organizar mis planes.");
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    public void joinPlan(View v) {
        Toast toast1 = Toast.makeText(getApplicationContext(), "¡Te acabas de unir al plan!", Toast.LENGTH_SHORT);
        toast1.show();
    }

    public void goChat(View v){
        startActivity(new Intent(getApplicationContext(),ChatActivity.class));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_share) {
            shareIntent();
        }
        if (id==R.id.action_map){
            String geoUri = "https://www.google.es/maps/place/Mercado+Provenzal+Reina+Mercedes/@37.36147,-5.985952,17z/data=!3m1!4b1!4m7!1m4!3m3!1s0xd126c2b0091f64b:0x5ca945334655b689!2sMercado+Provenzal+Reina+Mercedes!3b1!3m1!1s0xd126c2b0091f64b:0x5ca945334655b689";
            Intent intent = new Intent(android.content.Intent.ACTION_VIEW, Uri.parse(geoUri));
            startActivity(intent);
        }



        return super.onOptionsItemSelected(item);
    }
}
