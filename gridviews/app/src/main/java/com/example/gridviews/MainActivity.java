package com.example.gridviews;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    private int[] imageIds = {
            R.drawable.apple, R.drawable.banana, R.drawable.cherry,
            R.drawable.date, R.drawable.elderberry, R.drawable.fig,
            R.drawable.grape, R.drawable.honeydew, R.drawable.indian_fig
    };
    private String[] descriptions = {
            "Apple: A sweet, edible fruit produced by an apple tree.",
            "Banana: An elongated, edible fruit produced by several kinds of large herbaceous flowering plants.",
            "Cherry: A small, round stone fruit that is typically bright or dark red.",
            "Date: The fruit of the date palm, a sweet, chewy fruit with a pit in the middle.",
            "Elderberry: A fruit of the elder tree, often used to make syrups and jams.",
            "Fig: A soft fruit with a thin skin that can be eaten ripe or dried.",
            "Grape: A small, round fruit, typically green or purple, used to make wine.",
            "Honeydew: A type of melon with sweet, juicy, pale green flesh.",
            "Indian Fig: Also known as prickly pear, a fruit of a cactus plant with a sweet, edible flesh."
    };
    private ImageView selectedImage;
    private TextView descriptionText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridView gridView = findViewById(R.id.gridView);
        selectedImage = findViewById(R.id.selectedImage);
        descriptionText = findViewById(R.id.descriptionText);
        ImageAdapter adapter = new ImageAdapter(this, imageIds);
        gridView.setAdapter(adapter);
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
// selectedImage.setImageResource(imageIds[position]);
                descriptionText.setText(descriptions[position]);
            }
        });
    }
}