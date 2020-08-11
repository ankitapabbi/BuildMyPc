package com.lambtoncollege.buildmypc.ui.Brand;

import android.app.Dialog;
import android.content.Intent;
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
import com.lambtoncollege.buildmypc.adapters.AdapterForBrandPc;
import com.lambtoncollege.buildmypc.adapters.AdapterForBrandPcUser;
import com.lambtoncollege.buildmypc.interfaces.AdapterForBrands;
import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.utilities.BrandPcDataForCart;
import com.lambtoncollege.buildmypc.utilities.BrandPcDatabase;

import java.util.ArrayList;
import java.util.List;

public class BrandFragment extends Fragment implements AdapterForBrands {

    private BrandViewModel sendViewModel;
    RecyclerView recyclerUserBrand;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    List<BrandPc> listData = new ArrayList<>();
    BrandPcDatabase bpd;
    BrandPcDataForCart bpdc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        sendViewModel =
                ViewModelProviders.of(this).get(BrandViewModel.class);
        View root = inflater.inflate(R.layout.fragment_brand, container, false);

        recyclerUserBrand = (RecyclerView)root.findViewById(R.id.recyclerUserBrand);
        bpd = new BrandPcDatabase(getContext());
        bpdc = new BrandPcDataForCart(getContext());

        recyclerUserBrand.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerUserBrand.setNestedScrollingEnabled(false);
        adapter=new AdapterForBrandPcUser(listData,getContext(),this);
        recyclerUserBrand.setAdapter(adapter);

        bpd.open();
        listData.addAll(bpd.getBrandPcData());
        BrandPc bData = new BrandPc();
        for (int i = 0; i<bpd.getBrandPcData().size();i++){
            bData.setName(bpd.getBrandPcData().get(i).getName());
            bData.setScreenSize(bpd.getBrandPcData().get(i).getScreenSize());
            bData.setProcessor(bpd.getBrandPcData().get(i).getProcessor());
            bData.setRam(bpd.getBrandPcData().get(i).getRam());
            bData.setRom(bpd.getBrandPcData().get(i).getRom());
            bData.setGraphics(bpd.getBrandPcData().get(i).getGraphics());
            bData.setWarranty(bpd.getBrandPcData().get(i).getWarranty());
            bData.setPrice(bpd.getBrandPcData().get(i).getPrice());

        }
        adapter.notifyDataSetChanged();
        bpd.close();

        sendViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void toManage(int position, String name, String screen, String processor, String ram, String rom, String graphic, String warranty, int price) {
        // to manage brand pc

        Intent intent = new Intent(getContext(),ManageBrands.class);
        intent.putExtra("name",name);
        intent.putExtra("screen",screen);
        intent.putExtra("processor",processor);
        intent.putExtra("ram",ram);
        intent.putExtra("rom",rom);
        intent.putExtra("graphic",graphic);
        intent.putExtra("warranty",warranty);
        intent.putExtra("price",price);
        startActivity(intent);


    }

    @Override
    public void getData(int position, String name, String screen, String processor, String ram, String rom, String graphic, String warranty, int price) {
        // to add data to cart

        bpdc.open();
        bpdc.save(name, screen, processor, ram, rom, graphic, warranty,price);
        bpdc.close();
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
}