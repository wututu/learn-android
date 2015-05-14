package com.leochin.bitmapshaderdemo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StreamAdapter adapter = new StreamAdapter(this);
        ((ListView) findViewById(R.id.main_list)).setAdapter(adapter);

        adapter.add(new StreamItem(this, R.drawable.photo1, "Tufa at night", "Mono Lake, CA"));
        adapter.add(new StreamItem(this, R.drawable.photo2, "Starry night", "Lake Powell, AZ"));
        adapter.add(new StreamItem(this, R.drawable.photo3, "Racetrack playa", "Death Valley, CA"));
        adapter.add(new StreamItem(this, R.drawable.photo4, "Napali coast", "Kauai, HI"));
        adapter.add(new StreamItem(this, R.drawable.photo5, "Delicate Arch", "Arches, UT"));
        adapter.add(new StreamItem(this, R.drawable.photo6, "Sierra sunset", "Lone Pine, CA"));
        adapter.add(new StreamItem(this, R.drawable.photo7, "Majestic", "Grand Teton, WY"));
    }
}
