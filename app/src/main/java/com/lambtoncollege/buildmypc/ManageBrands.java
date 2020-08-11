package com.lambtoncollege.buildmypc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lambtoncollege.buildmypc.utilities.ModifiedBrandPcDatabaseForCart;

public class ManageBrands extends AppCompatActivity {

    String name,screen,processor,ram,rom,graphic,warranty;
    String sprocessor,sram,srom,sgraphic;
    int price;
    TextView mname, screemSize, mwarranty;

    RadioButton proRadio1, proRadio2, proRadio3, ramRadio1, ramRadio2, ramRadio3,
            romRadio1,romRadio2,romRadio3,graphic1, graphic2, graphic3, graphic4, graphic5, graphic6;
    RadioGroup rprocessor, rram, rrom, grapgics;
    Button  nvidia, amd;
    int cost = 0,cost1,cost2,cost3,cost4;
    LinearLayout cart;
    ModifiedBrandPcDatabaseForCart mbpdc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manage_brands);
        mbpdc = new ModifiedBrandPcDatabaseForCart(getApplicationContext());

        mname = (TextView)findViewById(R.id.pcName);
        screemSize = (TextView)findViewById(R.id.mscreen);
        mwarranty = (TextView)findViewById(R.id.mwarranty);

        rprocessor = (RadioGroup)findViewById(R.id.rprocessor);
        rram = (RadioGroup)findViewById(R.id.rram);
        rrom = (RadioGroup)findViewById(R.id.rrom);
        grapgics = (RadioGroup)findViewById(R.id.grapgics);

        proRadio1 = (RadioButton)findViewById(R.id.proRadio1);
        proRadio2 = (RadioButton)findViewById(R.id.proRadio2);
        proRadio3 = (RadioButton)findViewById(R.id.proRadio3);
        ramRadio1 = (RadioButton)findViewById(R.id.ramRadio1);
        ramRadio2 = (RadioButton)findViewById(R.id.ramRadio2);
        ramRadio3 = (RadioButton)findViewById(R.id.ramRadio3);
        romRadio1 = (RadioButton)findViewById(R.id.romRadio1);
        romRadio2 = (RadioButton)findViewById(R.id.romRadio2);
        romRadio3 = (RadioButton)findViewById(R.id.romRadio3);
        graphic1 = (RadioButton)findViewById(R.id.graphic1);
        graphic2 = (RadioButton)findViewById(R.id.graphic2);
        graphic3 = (RadioButton)findViewById(R.id.graphic3);
        graphic4 = (RadioButton)findViewById(R.id.graphic4);
        graphic5 = (RadioButton)findViewById(R.id.graphic5);
        graphic6 = (RadioButton)findViewById(R.id.graphic6);

        nvidia = (Button)findViewById(R.id.nvidia);
        amd = (Button)findViewById(R.id.amd);
        cart = (LinearLayout) findViewById(R.id.addToCart);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        screen = intent.getStringExtra("screen");
        processor = intent.getStringExtra("processor");
        ram = intent.getStringExtra("ram");
        rom = intent.getStringExtra("rom");
        graphic = intent.getStringExtra("graphic");
        warranty = intent.getStringExtra("warranty");
        price = intent.getIntExtra("price", 0);

        mname.setText(name);
        screemSize.setText(screen);
        mwarranty.setText(warranty);

        rprocessor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.proRadio1:
                        subcost = 0;
                        subcost = 250;
                        sprocessor = proRadio1.getText().toString();
                        break;
                    case R.id.proRadio2:
                        subcost = 0;
                        subcost  = 300;
                        sprocessor = proRadio2.getText().toString();
                        break;
                    case R.id.proRadio3:
                        subcost = 0;
                        subcost = 320;
                        sprocessor = proRadio3.getText().toString();
                        break;
                }

                cost1 =+ subcost;
                Log.d("Processor cost", String.valueOf(cost));
            }
        });

        rram.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int subcost = 0;
                switch (i) {
                    case R.id.ramRadio1:
                        subcost = 0;
                        subcost = 80;
                        sram = ramRadio1.getText().toString();
                        break;
                    case R.id.ramRadio2:
                        subcost = 0;
                        subcost  = 140;
                        sram = ramRadio2.getText().toString();
                        break;
                    case R.id.ramRadio3:
                        subcost = 0;
                        subcost = 220;
                        sram = ramRadio3.getText().toString();
                        break;
                }

                cost3 =+ subcost;
                Log.d("ram cost", String.valueOf(cost));
            }
        });

        rrom.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                int subcost = 0;
                switch (i) {
                    case R.id.romRadio1:
                        subcost = 0;
                        subcost = 80;
                        srom = romRadio1.getText().toString();
                        break;
                    case R.id.romRadio2:
                        subcost = 0;
                        subcost  = 140;
                        srom = romRadio2.getText().toString();
                        break;
                    case R.id.romRadio3:
                        subcost = 0;
                        subcost = 220;
                        srom = romRadio3.getText().toString();
                        break;
                }

                cost2 =+ subcost;
                Log.d("ram cost", String.valueOf(cost));
            }
        });

        nvidia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                graphic1.setChecked(false);
                graphic2.setChecked(false);
                graphic3.setChecked(false);
                graphic4.setChecked(false);
                graphic5.setChecked(false);
                graphic6.setChecked(false);

                nvidia.setTextColor(Color.parseColor("#ffffff"));
                amd.setTextColor(Color.parseColor("#2E86C1"));

                nvidia.setBackgroundResource(R.drawable.radio_checked);
                amd.setBackgroundResource(R.drawable.radio_unchecked);


                graphic1.setVisibility(View.VISIBLE);
                graphic2.setVisibility(View.VISIBLE);
                graphic3.setVisibility(View.VISIBLE);
                graphic4.setVisibility(View.VISIBLE);
                graphic5.setVisibility(View.VISIBLE);
                graphic6.setVisibility(View.VISIBLE);


                graphic1.setText("NVIDIA GeForce GTX 1660Ti $300");
                graphic2.setText("NVIDIA️ GeForce️ RTX️ 2060 $320");
                graphic3.setText("NVIDIA️ GeForce️ RTX️ 2070 $330");
                graphic4.setText("NVIDIA️ GeForce️ RTX️ 2080 $340");
                graphic5.setText("NVIDIA️ GeForce️ RTX️ 2070 8GB GDDR6 with Max-Q Design $350");
                graphic6.setText("NVIDIA️ GeForce️ RTX️ 2080 8GB GDDR6 with Max-Q Design $360");

                grapgics.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int subcost = 0;
                        switch (i) {
                            case R.id.graphic1:
                                subcost = 0;
                                subcost = 300;
                                sgraphic = graphic1.getText().toString();
                                break;
                            case R.id.graphic2:
                                subcost = 0;
                                subcost  = 320;
                                sgraphic = graphic2.getText().toString();
                                break;
                            case R.id.graphic3:
                                subcost = 0;
                                subcost = 330;
                                sgraphic = graphic3.getText().toString();
                                break;
                            case R.id.graphic4:
                                subcost = 0;
                                subcost = 340;
                                sgraphic = graphic4.getText().toString();
                                break;
                            case R.id.graphic5:
                                subcost = 0;
                                subcost = 350;
                                sgraphic = graphic5.getText().toString();
                                break;
                            case R.id.graphic6:
                                subcost = 0;
                                subcost = 360;
                                sgraphic = graphic6.getText().toString();
                                break;
                        }

                        cost4 =+ subcost;
                        Log.d("nvidia cost", String.valueOf(cost));
                    }
                });
            }
        });
        amd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                graphic1.setChecked(false);
                graphic2.setChecked(false);
                graphic3.setChecked(false);
                graphic4.setChecked(false);
                graphic5.setChecked(false);
                graphic6.setChecked(false);

                nvidia.setTextColor(Color.parseColor("#2E86C1"));
                amd.setTextColor(Color.parseColor("#ffffff"));

                nvidia.setBackgroundResource(R.drawable.radio_unchecked);
                amd.setBackgroundResource(R.drawable.radio_checked);


                graphic1.setVisibility(View.VISIBLE);
                graphic2.setVisibility(View.VISIBLE);
                graphic3.setVisibility(View.VISIBLE);
                graphic4.setVisibility(View.VISIBLE);
                graphic5.setVisibility(View.VISIBLE);
                graphic6.setVisibility(View.VISIBLE);


                graphic1.setText("AMD Radeon RX 480 (4GB and 8GB) $300");
                graphic2.setText("AMD Radeon RX 580 (4GB and 8GB) $320");
                graphic3.setText("AMD Radeon RX 560 $330");
                graphic4.setText("AMD Radeon RX 570 (4GB and 8GB) $340");
                graphic5.setText("AMD Ryzen 3 2200G $350");
                graphic6.setText("AMD Radeon RX Vega 56 $360");

                grapgics.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int subcost = 0;
                        switch (i) {
                            case R.id.graphic1:
                                subcost = 0;
                                subcost = 300;
                                sgraphic = graphic1.getText().toString();
                                break;
                            case R.id.graphic2:
                                subcost = 0;
                                subcost  = 320;
                                sgraphic = graphic2.getText().toString();
                                break;
                            case R.id.graphic3:
                                subcost = 0;
                                subcost = 330;
                                sgraphic = graphic3.getText().toString();
                                break;
                            case R.id.graphic4:
                                subcost = 0;
                                subcost = 340;
                                sgraphic = graphic4.getText().toString();
                                break;
                            case R.id.graphic5:
                                subcost = 0;
                                subcost = 350;
                                sgraphic = graphic5.getText().toString();
                                break;
                            case R.id.graphic6:
                                subcost = 0;
                                subcost = 360;
                                sgraphic = graphic6.getText().toString();
                                break;
                        }

                        cost4 =+ subcost;
                        Log.d("amd cost", String.valueOf(cost));
                    }
                });


            }
        });

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationCheck()) {
                    cost = cost1+cost2+cost3+cost4;
                    mbpdc.open();
                    mbpdc.save(name,screen,sprocessor,sram,srom,sgraphic,warranty,cost);
                    mbpdc.close();
                    allClear();
                    //Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                    final Dialog dialog = new Dialog(ManageBrands.this);
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
        });

    }
    public boolean validationCheck(){
        if (rprocessor.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
        }

        else if(rram.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(rrom.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(grapgics.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else {
            return true;
        }
    }

    public void allClear(){
//        cost = 0;
        proRadio1.setChecked(false);
        proRadio2.setChecked(false);
        proRadio3.setChecked(false);
        proRadio1.setTextColor(Color.parseColor("#2E86C1"));
        //  proRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        proRadio2.setTextColor(Color.parseColor("#2E86C1"));
        //  proRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        proRadio3.setTextColor(Color.parseColor("#2E86C1"));
        // proRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        ramRadio1.setChecked(false);
        ramRadio2.setChecked(false);
        ramRadio3.setChecked(false);
        ramRadio1.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        ramRadio2.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        ramRadio3.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        romRadio1.setChecked(false);
        romRadio2.setChecked(false);
        romRadio3.setChecked(false);
        romRadio1.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        romRadio2.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        romRadio3.setTextColor(Color.parseColor("#2E86C1"));
        // ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        graphic1.setChecked(false);
        graphic2.setChecked(false);
        graphic3.setChecked(false);
        graphic4.setChecked(false);
        graphic5.setChecked(false);
        graphic6.setChecked(false);

        nvidia.setTextColor(Color.parseColor("#2E86C1"));
        nvidia.setBackgroundResource(R.drawable.radio_unchecked);

        amd.setTextColor(Color.parseColor("#2E86C1"));
        amd.setBackgroundResource(R.drawable.radio_unchecked);
    }
}
