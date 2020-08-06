package com.lambtoncollege.buildmypc.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.lambtoncollege.buildmypc.DesktopActivity;
import com.lambtoncollege.buildmypc.LaptopActivity;
import com.lambtoncollege.buildmypc.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    CardView laptop,desktop;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        laptop = (CardView)root.findViewById(R.id.cardLaptop);
        desktop = (CardView)root.findViewById(R.id.cardDesktop);

        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });

        laptop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Laptop",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), LaptopActivity.class);
                startActivity(intent);

            }
        });
        desktop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getContext(),"Desktop",Toast.LENGTH_LONG).show();
                Intent intent = new Intent(getContext(), DesktopActivity.class);
                startActivity(intent);
            }
        });



        return root;


    }
}