package com.lambtoncollege.buildmypc.adminfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.utilities.AccessoriesDatabase;
import com.lambtoncollege.buildmypc.utilities.BrandPcDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link AddFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends Fragment {
    EditText name, screen,proccesor,ram,rom,graphics,warranty,price;
    EditText assName, assBrand,assColor,assShort,assLong,assPrice;
    Button addPc;
    Spinner whatItem;
    BrandPcDatabase bpd;
    AccessoriesDatabase ad;
    LinearLayout pcs,ass;
    String itemname;
    String[] itemNames = {"Select The Type","Personal Computers","Accessories"};

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public AddFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AddFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AddFragment newInstance(String param1, String param2) {
        AddFragment fragment = new AddFragment();
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
        View v =  inflater.inflate(R.layout.fragment_add, container, false);
        name = (EditText)v.findViewById(R.id.adName);
        screen = (EditText)v.findViewById(R.id.adScreen);
        proccesor = (EditText)v.findViewById(R.id.adProcessor);
        ram = (EditText)v.findViewById(R.id.adRam);
        rom = (EditText)v.findViewById(R.id.adRom);
        graphics = (EditText)v.findViewById(R.id.adGraphic);
        warranty = (EditText)v.findViewById(R.id.adWarranty);
        price = (EditText)v.findViewById(R.id.adPrice);
        pcs = (LinearLayout)v.findViewById(R.id.Pcs);
        ass = (LinearLayout)v.findViewById(R.id.ass);

        assName = (EditText)v.findViewById(R.id.assName);
        assBrand = (EditText)v.findViewById(R.id.assBrand);
        assColor = (EditText)v.findViewById(R.id.assColor);
        assShort = (EditText)v.findViewById(R.id.assShort);
        assLong = (EditText)v.findViewById(R.id.assLong);
        assPrice = (EditText)v.findViewById(R.id.assPrice);

        addPc = (Button)v.findViewById(R.id.addPc);
        whatItem = (Spinner)v.findViewById(R.id.whatitem);
         bpd = new BrandPcDatabase(getContext());
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

                    pcs.setVisibility(View.INVISIBLE);
                    ass.setVisibility(View.VISIBLE);
                    addPc.setText("Add Accessories");

                }else if (itemname.equalsIgnoreCase("Personal Computers")){
                    ass.setVisibility(View.INVISIBLE);
                    pcs.setVisibility(View.VISIBLE);
                    addPc.setText("Add PC");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        addPc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (addPc.getText().toString().equalsIgnoreCase("Add PC")) {
                    String bname = name.getText().toString().trim();
                    String bscreen = screen.getText().toString().trim();
                    String bprocessor = proccesor.getText().toString().trim();
                    String bram = ram.getText().toString().trim();
                    String brom = rom.getText().toString().trim();
                    String bgraphic = graphics.getText().toString().trim();
                    String bwarranty = warranty.getText().toString().trim();
                    String bprice = price.getText().toString().trim();

                    bpd.open();
                    if (!itemname.equalsIgnoreCase("Select Book Category")) {
                        if (!bname.equalsIgnoreCase("") && !bscreen.equalsIgnoreCase("") &&
                                !bprocessor.equalsIgnoreCase("") && !bram.equalsIgnoreCase("") &&
                                !brom.equalsIgnoreCase("") && !bgraphic.equalsIgnoreCase("") &&
                                !bwarranty.equalsIgnoreCase("") && !bprice.equalsIgnoreCase("")) {
                            bpd.save(bname, bscreen, bprocessor, bram, brom, bgraphic, bwarranty, Integer.parseInt(bprice));
                            bpd.close();
                            name.setText("");
                            screen.setText("");
                            proccesor.setText("");
                            ram.setText("");
                            rom.setText("");
                            graphics.setText("");
                            warranty.setText("");
                            price.setText("");
                            Toast.makeText(getContext(), "PC Added", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Fill all the Details", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Select a Valid Type", Toast.LENGTH_SHORT).show();
                    }


                }else if(addPc.getText().toString().equalsIgnoreCase("Add Accessories")){
                    // adding accessories

                    String aname = assName.getText().toString().trim();
                    String abrand = assBrand.getText().toString().trim();
                    String acolor = assColor.getText().toString().trim();
                    String ashort = assShort.getText().toString().trim();
                    String along = assLong.getText().toString().trim();
                    String aprice = assPrice.getText().toString().trim();

                    ad.open();
                    if (!itemname.equalsIgnoreCase("Select Book Category")) {
                        if (!aname.equalsIgnoreCase("") && !abrand.equalsIgnoreCase("") &&
                                !acolor.equalsIgnoreCase("") && !ashort.equalsIgnoreCase("") &&
                                !along.equalsIgnoreCase("") && !aprice.equalsIgnoreCase("")) {
                            ad.save(aname, abrand, acolor, ashort, along, Integer.parseInt(aprice));
                            ad.close();
                            assName.setText("");
                            assBrand.setText("");
                            assColor.setText("");
                            assShort.setText("");
                            assLong.setText("");
                            assPrice.setText("");
                            Toast.makeText(getContext(), "Accessories Added", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getContext(), "Fill all the Details", Toast.LENGTH_LONG).show();
                        }
                    } else {
                        Toast.makeText(getContext(), "Select a Valid Type", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        });

        return v;
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
