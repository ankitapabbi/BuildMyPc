package com.lambtoncollege.buildmypc.ui.logout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.SignUp;
import com.lambtoncollege.buildmypc.model.UserData;
import com.lambtoncollege.buildmypc.utilities.UserDatabase;

import java.util.List;

import static android.content.Context.MODE_PRIVATE;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LogoutFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LogoutFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LogoutFragment extends Fragment {
    Button logout;
    SharedPreferences sharedPreferences;
    UserDatabase udb;
    TextView name,email,phone,postal,address;
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public LogoutFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LogoutFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LogoutFragment newInstance(String param1, String param2) {
        LogoutFragment fragment = new LogoutFragment();
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
        View view =  inflater.inflate(R.layout.fragment_logout, container, false);
        udb = new UserDatabase(getContext());

        name = (TextView)view.findViewById(R.id.name);
        email = (TextView)view.findViewById(R.id.email);
        phone = (TextView)view.findViewById(R.id.phone);
        postal = (TextView)view.findViewById(R.id.postal);
        address = (TextView)view.findViewById(R.id.address);
        logout = (Button)view.findViewById(R.id.myLogout);
        sharedPreferences = getActivity().getSharedPreferences("login",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedPreferences.edit();

        String userEmail = sharedPreferences.getString("userEmail","");
        String userPassword =sharedPreferences.getString("userPassword","");
        udb.open();
        List<UserData> data = udb.getUserByEmailPassword(userEmail, userPassword);
        name.setText(data.get(0).getUserName());
        email.setText(data.get(0).getUserEmail());
        phone.setText(data.get(0).getUserPhone());
        postal.setText(data.get(0).getUserPostal());
        address.setText(data.get(0).getUserAddress());
        udb.close();


        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                editor.remove("userEmail");
                editor.remove("userPassword");
                editor.apply();
                Intent intent = new Intent(getContext(), SignUp.class);
                startActivity(intent);
                getActivity().finish();
            }
        });


        return  view;
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
