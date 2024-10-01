package com.example.myfragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
public class DetailFragment extends Fragment {
    private static final String ARG_ITEM = "item";
    public static DetailFragment newInstance(String item) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putString(ARG_ITEM, item);
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
    ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_detail,
                container, false);
        TextView detailTextView = view.findViewById(R.id.detailTextView);
        if (getArguments() != null) {
            String item = getArguments().getString(ARG_ITEM);
            detailTextView.setText(item);
        }
        return view;
    }
}