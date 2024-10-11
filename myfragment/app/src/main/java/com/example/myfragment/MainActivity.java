package com.example.myfragment;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
public class MainActivity extends AppCompatActivity implements ListFragment.OnItemSelectedListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            ListFragment listFragment = new ListFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.list_fragment_container, listFragment)
                    .commit();
        }
    }
    @Override
    public void onItemSelected(String item) {
        DetailFragment detailFragment =
                DetailFragment.newInstance(item);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail_fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }
}