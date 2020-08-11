package com.lambtoncollege.buildmypc.ui.assembled;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lambtoncollege.buildmypc.ManageBrands;
import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.adapters.AdapterForAccessoriesUser;
import com.lambtoncollege.buildmypc.adapters.AdapterForBrandPcUser;
import com.lambtoncollege.buildmypc.interfaces.AdapterForAccessories;
import com.lambtoncollege.buildmypc.interfaces.AdapterForBrands;
import com.lambtoncollege.buildmypc.model.Accessories;
import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabase;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabaseForCart;
import com.lambtoncollege.buildmypc.utilities.BrandPcDataForCart;
import com.lambtoncollege.buildmypc.utilities.BrandPcDatabase;

import java.util.ArrayList;
import java.util.List;

public class AssembledFragment extends Fragment implements AdapterForAccessories {

    private AssembledViewModel galleryViewModel;
    RecyclerView recyclerUserAccessories;

    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<Accessories> listData = new ArrayList<>();
    AccessoriesDatabase ad;
    AccessoriesDatabaseForCart adc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(AssembledViewModel.class);
        View root = inflater.inflate(R.layout.fragment_assembled, container, false);

        recyclerUserAccessories = (RecyclerView)root.findViewById(R.id.recyclerUserAccessories);
        ad = new AccessoriesDatabase(getContext());
        adc = new AccessoriesDatabaseForCart(getContext());;

        recyclerUserAccessories.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerUserAccessories.setNestedScrollingEnabled(false);
        adapter=new AdapterForAccessoriesUser(listData,getContext(),this);
        recyclerUserAccessories.setAdapter(adapter);

        ad.open();
        listData.addAll(ad.getAccessoriesData());
        Accessories acc = new Accessories();
        for (int i = 0; i<ad.getAccessoriesData().size();i++){
            acc.setAccName(ad.getAccessoriesData().get(i).getAccName());
            acc.setAccBrand(ad.getAccessoriesData().get(i).getAccBrand());
            acc.setAccColour(ad.getAccessoriesData().get(i).getAccColour());
            acc.setAccShortDesc(ad.getAccessoriesData().get(i).getAccShortDesc());
            acc.setAccLongDesc(ad.getAccessoriesData().get(i).getAccLongDesc());
            acc.setAccPrice(ad.getAccessoriesData().get(i).getAccPrice());

        }
        adapter.notifyDataSetChanged();
        ad.close();

        galleryViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void getData(int position, String name, String brand, String colour, String shortd, String longd, int price) {
       // for cart...

        adc.open();
        adc.save(name, brand, colour, shortd, longd, price);
        adc.close();
        final Dialog dialog = new Dialog(getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCancelable(false);
        dialog.setContentView(R.layout.popup_window_addtocart);


        Button dialogButton = (Button) dialog.findViewById(R.id.btn_dialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }

    @Override
    public void getForWish(int position, String name, String brand, String colour, String shortd, String longd, int price) {

    }
}