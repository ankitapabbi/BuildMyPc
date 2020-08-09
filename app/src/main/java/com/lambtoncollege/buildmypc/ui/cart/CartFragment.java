package com.lambtoncollege.buildmypc.ui.cart;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.adapters.AdapterForBuildDesktop;
import com.lambtoncollege.buildmypc.adapters.AdapterForBuildLaptop;
import com.lambtoncollege.buildmypc.adapters.AdapterRoDeleteBrandPc;
import com.lambtoncollege.buildmypc.adapters.AdapterToDeleteAccessories;
import com.lambtoncollege.buildmypc.interfaces.AdapterToDelete;
import com.lambtoncollege.buildmypc.model.Accessories;
import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.model.BuildDesktop;
import com.lambtoncollege.buildmypc.model.BuildLaptop;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabase;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabaseForCart;
import com.lambtoncollege.buildmypc.utilities.BrandPcDataForCart;
import com.lambtoncollege.buildmypc.utilities.BrandPcDatabase;
import com.lambtoncollege.buildmypc.utilities.BuildDesktopDatabase;
import com.lambtoncollege.buildmypc.utilities.BuildLaptopDatabase;

import java.util.ArrayList;
import java.util.List;

public class CartFragment extends Fragment implements AdapterToDelete {

    private CartViewModel shareViewModel;
    RecyclerView buildDesktopRecyler,buildLaptopRecyler,brandsRecyler,accRecyler;
    RecyclerView.Adapter adapter;
    RecyclerView.Adapter adapter1,adapter2,adapter3;
    RecyclerView.LayoutManager layoutManager, layoutManager1;
    List<BuildDesktop> listData = new ArrayList<>();
    List<BuildLaptop> listData1 = new ArrayList<>();
    List<BrandPc> listData2 = new ArrayList<>();
    List<Accessories> listData3 = new ArrayList<>();
    BuildDesktopDatabase bdd;
    BuildLaptopDatabase bld;
    BrandPcDataForCart bpdc;
    AccessoriesDatabaseForCart adc;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        shareViewModel =
                ViewModelProviders.of(this).get(CartViewModel.class);
        View root = inflater.inflate(R.layout.fragment_cart, container, false);
        final TextView textView = root.findViewById(R.id.text_share);
        shareViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        // code here
        buildDesktopRecyler = (RecyclerView)root.findViewById(R.id.buildDesktopRecyler);
        buildLaptopRecyler = (RecyclerView)root.findViewById(R.id.buildLaptopRecyler);
        brandsRecyler = (RecyclerView)root.findViewById(R.id.brandsRecyler);
        accRecyler = (RecyclerView)root.findViewById(R.id.accRecyler);

        bdd = new BuildDesktopDatabase(getContext());
        bld = new BuildLaptopDatabase(getContext());
        bpdc = new BrandPcDataForCart(getContext());
        adc = new AccessoriesDatabaseForCart(getContext());

        buildDesktopRecyler.setLayoutManager(new LinearLayoutManager(getContext()));

        buildDesktopRecyler.setNestedScrollingEnabled(false);
        adapter=new AdapterForBuildDesktop(listData,getContext(),this);
        buildDesktopRecyler.setAdapter(adapter);

        bdd.open();
        listData.addAll(bdd.getBuildDesktopData());
        BuildDesktop bookData = new BuildDesktop();
        for (int i = 0; i<bdd.getBuildDesktopData().size();i++){
            bookData.setProcessor(bdd.getBuildDesktopData().get(i).getProcessor());
            bookData.setProcessorGen(bdd.getBuildDesktopData().get(i).getProcessorGen());
            bookData.setRam(bdd.getBuildDesktopData().get(i).getRam());
            bookData.setStorageType(bdd.getBuildDesktopData().get(i).getStorageType());
            bookData.setGraphicCard(bdd.getBuildDesktopData().get(i).getGraphicCard());
            bookData.setPowerSupply(bdd.getBuildDesktopData().get(i).getPowerSupply());
            bookData.setNetworkCard(bdd.getBuildDesktopData().get(i).getNetworkCard());
            bookData.setCabinet(bdd.getBuildDesktopData().get(i).getCabinet());
//            Double P =Double.valueOf(bdd.getBookData().get(i).getBookPrice());
//            total += P;

        }
       // totalPrice.setText(String.valueOf(total));

        adapter.notifyDataSetChanged();
        bdd.close();


        buildLaptopRecyler.setLayoutManager(new LinearLayoutManager(getContext()));

        buildLaptopRecyler.setNestedScrollingEnabled(false);
        adapter1=new AdapterForBuildLaptop(listData1,getContext(),this);
        buildLaptopRecyler.setAdapter(adapter1);

        bld.open();
        listData1.addAll(bld.getBuildLaptopData());
        BuildLaptop laptop = new BuildLaptop();
        for (int i = 0; i<bld.getBuildLaptopData().size();i++){
            laptop.setProcessor(bld.getBuildLaptopData().get(i).getProcessor());
            laptop.setProcessorGen(bld.getBuildLaptopData().get(i).getProcessorGen());
            laptop.setRam(bld.getBuildLaptopData().get(i).getRam());
            laptop.setStorageType(bld.getBuildLaptopData().get(i).getStorageType());
            laptop.setGraphicCard(bld.getBuildLaptopData().get(i).getGraphicCard());
            laptop.setScreenSize(bld.getBuildLaptopData().get(i).getScreenSize());
            laptop.setDisplay(bld.getBuildLaptopData().get(i).getDisplay());
            laptop.setScreenType(bld.getBuildLaptopData().get(i).getScreenType());
//            Double P =Double.valueOf(bdd.getBookData().get(i).getBookPrice());
//            total += P;

        }
        // totalPrice.setText(String.valueOf(total));

        adapter1.notifyDataSetChanged();
        bld.close();


        //----------------------------------
        brandsRecyler.setLayoutManager(new LinearLayoutManager(getContext()));

        brandsRecyler.setNestedScrollingEnabled(false);
        adapter2=new AdapterRoDeleteBrandPc(listData2,getContext(),this);
        brandsRecyler.setAdapter(adapter2);

        bpdc.open();
        listData2.addAll(bpdc.getBrandPcData());
        BrandPc bData = new BrandPc();
        for (int i = 0; i<bpdc.getBrandPcData().size();i++){
            bData.setName(bpdc.getBrandPcData().get(i).getName());
            bData.setScreenSize(bpdc.getBrandPcData().get(i).getScreenSize());
            bData.setProcessor(bpdc.getBrandPcData().get(i).getProcessor());
            bData.setRam(bpdc.getBrandPcData().get(i).getRam());
            bData.setRom(bpdc.getBrandPcData().get(i).getRom());
            bData.setGraphics(bpdc.getBrandPcData().get(i).getGraphics());
            bData.setWarranty(bpdc.getBrandPcData().get(i).getWarranty());
            bData.setPrice(bpdc.getBrandPcData().get(i).getPrice());

        }
        adapter2.notifyDataSetChanged();
        bpdc.close();

        //---------------------------------------------------
        accRecyler.setLayoutManager(new LinearLayoutManager(getContext()));

        accRecyler.setNestedScrollingEnabled(false);
        adapter3=new AdapterToDeleteAccessories(listData3,getContext(),this);
        accRecyler.setAdapter(adapter3);

        adc.open();
        listData3.addAll(adc.getAccessoriesData());
        Accessories acc = new Accessories();
        for (int i = 0; i<adc.getAccessoriesData().size();i++){
            acc.setAccName(adc.getAccessoriesData().get(i).getAccName());
            acc.setAccBrand(adc.getAccessoriesData().get(i).getAccBrand());
            acc.setAccColour(adc.getAccessoriesData().get(i).getAccColour());
            acc.setAccShortDesc(adc.getAccessoriesData().get(i).getAccShortDesc());
            acc.setAccLongDesc(adc.getAccessoriesData().get(i).getAccLongDesc());
            acc.setAccPrice(adc.getAccessoriesData().get(i).getAccPrice());

        }
        adapter3.notifyDataSetChanged();
        adc.close();
        return root;
    }

    @Override
    public void clicked(int position) {
        // code here......to delete
        bdd.open();
        String in = bdd.getBuildDesktopData().get(position).getBuildDesktopID();
        bdd.delete(in);
        listData.clear();
        listData.addAll(bdd.getBuildDesktopData());
//        total=0;
//        for (int i = 0; i<cdb.getBookData().size();i++){
//            Double P =Double.valueOf(cdb.getBookData().get(i).getBookPrice());
//            total += P;
//        }
//        totalPrice.setText(String.valueOf(total));
        adapter.notifyDataSetChanged();
        bdd.close();

    }

    @Override
    public void clickForLaptop(int position) {
        // code here......to delete
        bld.open();
        String in = bld.getBuildLaptopData().get(position).getBuildLaptopID();
        bld.delete(in);
        listData1.clear();
        listData1.addAll(bld.getBuildLaptopData());
//        total=0;
//        for (int i = 0; i<cdb.getBookData().size();i++){
//            Double P =Double.valueOf(cdb.getBookData().get(i).getBookPrice());
//            total += P;
//        }
//        totalPrice.setText(String.valueOf(total));
        adapter1.notifyDataSetChanged();
        bld.close();
    }

    @Override
    public void clickForBrands(int position) {
        // code here......to delete
        bpdc.open();
        String in = bpdc.getBrandPcData().get(position).getBrandPcID();
        bpdc.delete(in);
        listData2.clear();
        listData2.addAll(bpdc.getBrandPcData());
//        total=0;
//        for (int i = 0; i<cdb.getBookData().size();i++){
//            Double P =Double.valueOf(cdb.getBookData().get(i).getBookPrice());
//            total += P;
//        }
//        totalPrice.setText(String.valueOf(total));
        adapter2.notifyDataSetChanged();
        bpdc.close();

    }

    @Override
    public void clickForAccessories(int position) {
// to delete accessories
        adc.open();
        String in = adc.getAccessoriesData().get(position).getAccID();
        adc.delete(in);
        listData3.clear();
        listData3.addAll(adc.getAccessoriesData());
//        total=0;
//        for (int i = 0; i<cdb.getBookData().size();i++){
//            Double P =Double.valueOf(cdb.getBookData().get(i).getBookPrice());
//            total += P;
//        }
//        totalPrice.setText(String.valueOf(total));
        adapter3.notifyDataSetChanged();
        adc.close();
    }
}