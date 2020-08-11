package com.lambtoncollege.buildmypc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.percentlayout.widget.PercentLayoutHelper;
import androidx.percentlayout.widget.PercentRelativeLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.lambtoncollege.buildmypc.model.UserData;
import com.lambtoncollege.buildmypc.utilities.UserDatabase;

import java.util.List;

public class SignUp extends AppCompatActivity implements View.OnClickListener {


    private boolean isSigninScreen = true;
    private TextView tvSignupInvoker;
    private LinearLayout llSignup;
    private TextView tvSigninInvoker;
    private LinearLayout llSignin;
    private Button btnSignup;
    private Button btnSignin;
    LinearLayout llsignin,llsignup;

    UserDatabase udb;

    EditText lemail,lpassword,rname,remail,rphone,rpostal,raddress,rpassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        udb = new UserDatabase(getApplicationContext());

        llSignin = (LinearLayout) findViewById(R.id.llSignin);
        llSignin.setOnClickListener(this);
        //LinearLayout singnin =(LinearLayout)findViewById(R.id.signin);
        llsignup =(LinearLayout)findViewById(R.id.llSignup);
        llsignup.setOnClickListener(this);
        tvSignupInvoker = (TextView) findViewById(R.id.tvSignupInvoker);
        tvSigninInvoker = (TextView) findViewById(R.id.tvSigninInvoker);

        btnSignup= (Button) findViewById(R.id.btnSignup);
        btnSignin= (Button) findViewById(R.id.btnSignin);

        llSignup = (LinearLayout) findViewById(R.id.llSignup);
        llSignin = (LinearLayout) findViewById(R.id.llSignin);

        lemail = (EditText)findViewById(R.id.lemail);
        lpassword = (EditText)findViewById(R.id.lpassword);
        rname= (EditText)findViewById(R.id.rname);
        remail = (EditText)findViewById(R.id.remail);
        rphone = (EditText)findViewById(R.id.rphone);
        rpostal = (EditText)findViewById(R.id.rpostal);
        raddress = (EditText)findViewById(R.id.raddress);
        rpassword = (EditText)findViewById(R.id.rpassword);

        tvSignupInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSigninScreen = false;
                showSignupForm();
            }
        });

        tvSigninInvoker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isSigninScreen = true;
                showSigninForm();
            }
        });
        showSigninForm();

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
                if(isSigninScreen)
                    btnSignup.startAnimation(clockwise);

                String name = rname.getText().toString().trim();
                String email = remail.getText().toString().trim();
                String phone = rphone.getText().toString().trim();
                String postal = rpostal.getText().toString().trim();
                String address = raddress.getText().toString().trim();
                String password = rpassword.getText().toString().trim();

                // logic here.......

                    udb.open();
                    if(!name.equalsIgnoreCase("") && !email.equalsIgnoreCase("") && !phone.equalsIgnoreCase("")
                    &&!postal.equalsIgnoreCase("") && !address.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
                        udb.save(name, email, phone, postal, address, password);
                        Intent intent = new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("name",name);
                        intent.putExtra("email",email);
                        startActivity(intent);
                        finish();
                    }else {
                        Toast.makeText(getApplicationContext(),"Fill All Details",Toast.LENGTH_LONG).show();
                    }
                    udb.close();


            }
        });
        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // logic here.......

                String email = lemail.getText().toString().trim();
                String password = lpassword.getText().toString().trim();

                if(email.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {

                    Intent intent = new Intent(getApplicationContext(),HomeScreenForAdmin.class);
                    startActivity(intent);
                    finish();

                }else {
                    udb.open();
                    if (!email.equalsIgnoreCase("") && !password.equalsIgnoreCase("")) {
                        List<UserData> data = udb.getUserByEmailPassword(email, password);
                        if (data.isEmpty()) {
                            Toast.makeText(getApplicationContext(), "Email Or Password Wrong", Toast.LENGTH_LONG).show();
                        } else {
                            //  Toast.makeText(getApplicationContext(), data.get(0).getUserEmail(), Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            intent.putExtra("name", data.get(0).getUserName());
                            intent.putExtra("email", data.get(0).getUserEmail());
                            startActivity(intent);
                            finish();
                        }
                    } else {
                        Toast.makeText(getApplicationContext(), "Fill All Details", Toast.LENGTH_LONG).show();
                    }
                    udb.close();
                }


            }
        });
    }
    private void showSignupForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.15f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.85f;
        llSignup.requestLayout();

        tvSignupInvoker.setVisibility(View.GONE);
        tvSigninInvoker.setVisibility(View.VISIBLE);
        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_right_to_left);
        llSignup.startAnimation(translate);

        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_right_to_left);
        btnSignup.startAnimation(clockwise);

    }

    private void showSigninForm() {
        PercentRelativeLayout.LayoutParams paramsLogin = (PercentRelativeLayout.LayoutParams) llSignin.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoLogin = paramsLogin.getPercentLayoutInfo();
        infoLogin.widthPercent = 0.85f;
        llSignin.requestLayout();


        PercentRelativeLayout.LayoutParams paramsSignup = (PercentRelativeLayout.LayoutParams) llSignup.getLayoutParams();
        PercentLayoutHelper.PercentLayoutInfo infoSignup = paramsSignup.getPercentLayoutInfo();
        infoSignup.widthPercent = 0.15f;
        llSignup.requestLayout();

        Animation translate= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.translate_left_to_right);
        llSignin.startAnimation(translate);

        tvSignupInvoker.setVisibility(View.VISIBLE);
        tvSigninInvoker.setVisibility(View.GONE);
        Animation clockwise= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate_left_to_right);
        btnSignin.startAnimation(clockwise);
    }
    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.llSignin || v.getId() ==R.id.llSignup){
            // Toast.makeText(this, "clicked", Toast.LENGTH_SHORT).show();
            InputMethodManager methodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            //methodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);

        }

    }
    public void rvalidation(){

    }
}
