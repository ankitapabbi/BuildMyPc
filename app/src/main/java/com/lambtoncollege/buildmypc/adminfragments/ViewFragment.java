package com.lambtoncollege.buildmypc.adminfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.adapters.AdapterForAccessories;
import com.lambtoncollege.buildmypc.adapters.AdapterForBrandPc;
import com.lambtoncollege.buildmypc.model.Accessories;
import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabase;
import com.lambtoncollege.buildmypc.utilities.BrandPcDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ViewFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ViewFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewFragment extends Fragment {

    RecyclerView recyclerViewPc,recyclerViewAcc;
    RecyclerView.Adapter adapter,adapter1;
    RecyclerView.LayoutManager layoutManager;
    List<BrandPc> listData = new ArrayList<>();
    List<Accessories> listData1 = new ArrayList<>();
    BrandPcDatabase bpd;
    AccessoriesDatabase ad;
    String itemname;
    String[] itemNames = {"Select The Type","Personal Computers","Accessories"};
    Spinner whatItem;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public ViewFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ViewFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewFragment newInstance(String param1, String param2) {
        ViewFragment fragment = new ViewFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout =  inflater.inflate(R.layout.fragment_view, container, false);

        recyclerViewPc = (RecyclerView)layout.findViewById(R.id.recyclerViewPc);
        recyclerViewAcc = (RecyclerView)layout.findViewById(R.id.recyclerViewAcc);

        bpd = new BrandPcDatabase(getContext());

        whatItem = (Spinner)layout.findViewById(R.id.whatitem);
        ad = new AccessoriesDatabase(getContext());

        ArrayAdapter aa = new ArrayAdapter(getContext(),android.R.layout.simple_spinner_item,itemNames);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        whatItem.setAdapter(aa);

        whatItem.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //Toast.makeText(getContext(),bookCat[position] , Toast.LENGTH_LONG).show();
                itemname = itemNames[position];
                if(itemname.equalsIgnoreCase("Accessories")){

                    recyclerViewPc.setVisibility(View.INVISIBLE);
                    recyclerViewAcc.setVisibility(View.VISIBLE);


                }else if (itemname.equalsIgnoreCase("Personal Computers")){
                    recyclerViewAcc.setVisibility(View.INVISIBLE);
                    recyclerViewPc.setVisibility(View.VISIBLE);

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        recyclerViewAcc.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewAcc.setNestedScrollingEnabled(false);
        adapter1=new AdapterForAccessories(listData1,getContext());
        recyclerViewAcc.setAdapter(adapter1);

        ad.open();
        listData1.addAll(ad.getAccessoriesData());
        Accessories acc = new Accessories();
        for (int i = 0; i<ad.getAccessoriesData().size();i++){
            acc.setAccName(ad.getAccessoriesData().get(i).getAccName());
            acc.setAccBrand(ad.getAccessoriesData().get(i).getAccBrand());
            acc.setAccColour(ad.getAccessoriesData().get(i).getAccColour());
            acc.setAccShortDesc(ad.getAccessoriesData().get(i).getAccShortDesc());
            acc.setAccLongDesc(ad.getAccessoriesData().get(i).getAccLongDesc());
            acc.setAccPrice(ad.getAccessoriesData().get(i).getAccPrice());

        }
        adapter1.notifyDataSetChanged();
        ad.close();
        ///--------------------------------------------------------------------
        recyclerViewPc.setLayoutManager(new LinearLayoutManager(getContext()));

        recyclerViewPc.setNestedScrollingEnabled(false);
        adapter=new AdapterForBrandPc(listData,getContext());
        recyclerViewPc.setAdapter(adapter);

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


        return layout;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
