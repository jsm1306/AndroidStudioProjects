package com.example.listviews;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private int[] images = {
            R.drawable.apple, R.drawable.banana, R.drawable.cherry, R.drawable.date,
            R.drawable.elderberry, R.drawable.fig, R.drawable.grape, R.drawable.honeydew,
            R.drawable.indian_fig, R.drawable.jackfruit
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to the ListView and ImageView
        ListView listView = findViewById(R.id.listView);
        imageView = findViewById(R.id.imageView);

        // Sample data to display in the ListView
        String[] items = new String[] {
                "Apple", "Banana", "Cherry", "Date", "Elderberry",
                "Fig", "Grape", "Honeydew", "Indian Fig", "Jackfruit"
        };

        // Convert the array to a list
        ArrayList<String> itemList = new ArrayList<>(Arrays.asList(items));

        // Create an ArrayAdapter using the item list and a default ListView layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                itemList
        );

        // Set the adapter to the ListView
        listView.setAdapter(adapter);

        // Set an item click listener to display the corresponding image
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Set the image in the ImageView based on the clicked item
                imageView.setImageResource(images[position]);
            }
        });


    }
}