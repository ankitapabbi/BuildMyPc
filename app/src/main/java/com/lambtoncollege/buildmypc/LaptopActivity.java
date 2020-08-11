package com.lambtoncollege.buildmypc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatRadioButton;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.lambtoncollege.buildmypc.utilities.BuildLaptopDatabase;

public class LaptopActivity extends AppCompatActivity {

    AppCompatRadioButton screenRadio1,screenRadio2,screenRadio3,stypeRadio1,stypeRadio2;
    RadioButton displayRadio1,displayRadio2,displayRadio3,
            proRadio1,proRadio2,proRadio3,progenRadio1,progenRadio2,ramRadio1,ramRadio2,ramRadio3,
            storage1,storage2,storage3,storage4,graphic1,graphic2,graphic3,graphic4,graphic5,graphic6;
    TextView storageTypeText;
    int cost = 0,cost1,cost2,cost3,cost4,cost5,cost6,cost7,cost8;

    RadioGroup rscreen,rdisplay,rstype,rprocessor,rprocessorgen,rram,storages,grapgics;
    Button ssd,hdd,dual,nvidia,amd,clear,totalcost,cart,wishlist;

    String screenSize,display,screenType,processor,processorgen,ram,storage,graphic;
    BuildLaptopDatabase bld;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laptop);
        bld = new BuildLaptopDatabase(getApplicationContext());

        storageTypeText = (TextView)findViewById(R.id.storageTypeText);
        totalcost = (Button)findViewById(R.id.totalcost);
        cart = (Button)findViewById(R.id.cart);
        wishlist = (Button)findViewById(R.id.wishlist);

        rscreen = (RadioGroup)findViewById(R.id.rscreen);
        rdisplay = (RadioGroup)findViewById(R.id.rdisplay);
        rstype = (RadioGroup)findViewById(R.id.rstype);
        rprocessor = (RadioGroup)findViewById(R.id.rprocessor);
        rprocessorgen = (RadioGroup)findViewById(R.id.rprocessorgen);
        rram = (RadioGroup)findViewById(R.id.rram);
        storages = (RadioGroup)findViewById(R.id.storages);
        grapgics = (RadioGroup)findViewById(R.id.grapgics);

        screenRadio1 = (AppCompatRadioButton)findViewById(R.id.screenRadio1);
        screenRadio2 = (AppCompatRadioButton)findViewById(R.id.screenRadio2);
        screenRadio3 = (AppCompatRadioButton)findViewById(R.id.screenRadio3);
        displayRadio1 = (RadioButton) findViewById(R.id.displayRadio1);
        displayRadio2 = (RadioButton)findViewById(R.id.displayRadio2);
        displayRadio3 = (RadioButton)findViewById(R.id.displayRadio3);
        stypeRadio1 = (AppCompatRadioButton)findViewById(R.id.stypeRadio1);
        stypeRadio2 = (AppCompatRadioButton)findViewById(R.id.stypeRadio2);
        proRadio1 = (RadioButton)findViewById(R.id.proRadio1);
        proRadio2 = (RadioButton)findViewById(R.id.proRadio2);
        proRadio3 = (RadioButton)findViewById(R.id.proRadio3);
        progenRadio1 = (RadioButton)findViewById(R.id.progenRadio1);
        progenRadio2 = (RadioButton)findViewById(R.id.progenRadio2);
        ramRadio1 = (RadioButton)findViewById(R.id.ramRadio1);
        ramRadio2 = (RadioButton)findViewById(R.id.ramRadio2);
        ramRadio3 = (RadioButton)findViewById(R.id.ramRadio3);
        storage1= (RadioButton)findViewById(R.id.storage1);
        storage2= (RadioButton)findViewById(R.id.storage2);
        storage3= (RadioButton)findViewById(R.id.storage3);
        storage4= (RadioButton)findViewById(R.id.storage4);
        graphic1 = (RadioButton)findViewById(R.id.graphic1);
        graphic2 = (RadioButton)findViewById(R.id.graphic2);
        graphic3 = (RadioButton)findViewById(R.id.graphic3);
        graphic4 = (RadioButton)findViewById(R.id.graphic4);
        graphic5 = (RadioButton)findViewById(R.id.graphic5);
        graphic6 = (RadioButton)findViewById(R.id.graphic6);

        ssd = (Button)findViewById(R.id.ssd);
        hdd = (Button)findViewById(R.id.hdd);
        dual = (Button)findViewById(R.id.dual);
        nvidia = (Button)findViewById(R.id.nvidia);
        amd = (Button)findViewById(R.id.amd);
        clear = (Button)findViewById(R.id.clear);

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                cost=0;
                screenRadio1.setChecked(false);
                screenRadio2.setChecked(false);
                screenRadio3.setChecked(false);
                screenRadio1.setTextColor(Color.parseColor("#2E86C1"));
                screenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                screenRadio2.setTextColor(Color.parseColor("#2E86C1"));
                screenRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                screenRadio3.setTextColor(Color.parseColor("#2E86C1"));
                screenRadio3.setBackgroundResource(R.drawable.radio_unchecked);

                displayRadio1.setChecked(false);
                displayRadio2.setChecked(false);
                displayRadio3.setChecked(false);
                displayRadio1.setTextColor(Color.parseColor("#2E86C1"));
               // displayRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                displayRadio2.setTextColor(Color.parseColor("#2E86C1"));
               // displayRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                displayRadio3.setTextColor(Color.parseColor("#2E86C1"));
               // displayRadio3.setBackgroundResource(R.drawable.radio_unchecked);

                stypeRadio1.setChecked(false);
                stypeRadio2.setChecked(false);
                stypeRadio1.setTextColor(Color.parseColor("#2E86C1"));
                stypeRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                stypeRadio2.setTextColor(Color.parseColor("#2E86C1"));
                stypeRadio2.setBackgroundResource(R.drawable.radio_unchecked);

                proRadio1.setChecked(false);
                proRadio2.setChecked(false);
                proRadio3.setChecked(false);
                proRadio1.setTextColor(Color.parseColor("#2E86C1"));
               // proRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                proRadio2.setTextColor(Color.parseColor("#2E86C1"));
               // proRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                proRadio3.setTextColor(Color.parseColor("#2E86C1"));
              //  proRadio3.setBackgroundResource(R.drawable.radio_unchecked);

                progenRadio1.setChecked(false);
                progenRadio2 .setChecked(false);
                progenRadio1.setTextColor(Color.parseColor("#2E86C1"));
               // progenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                progenRadio2.setTextColor(Color.parseColor("#2E86C1"));
               // progenRadio2.setBackgroundResource(R.drawable.radio_unchecked);

                ramRadio1.setChecked(false);
                ramRadio2.setChecked(false);
                ramRadio3.setChecked(false);
                ramRadio1.setTextColor(Color.parseColor("#2E86C1"));
              //  ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                ramRadio2.setTextColor(Color.parseColor("#2E86C1"));
              //  ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                ramRadio3.setTextColor(Color.parseColor("#2E86C1"));
              //  ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);

                storage1.setChecked(false);
                storage2.setChecked(false);
                storage3.setChecked(false);
                storage4.setChecked(false);
                graphic1.setChecked(false);
                graphic2.setChecked(false);
                graphic3.setChecked(false);
                graphic4.setChecked(false);
                graphic5.setChecked(false);
                graphic6.setChecked(false);
                ssd.setTextColor(Color.parseColor("#2E86C1"));
                ssd.setBackgroundResource(R.drawable.radio_unchecked);

                hdd.setTextColor(Color.parseColor("#2E86C1"));
                hdd.setBackgroundResource(R.drawable.radio_unchecked);

                dual.setTextColor(Color.parseColor("#2E86C1"));
                dual.setBackgroundResource(R.drawable.radio_unchecked);

                nvidia.setTextColor(Color.parseColor("#2E86C1"));
                nvidia.setBackgroundResource(R.drawable.radio_unchecked);

                amd.setTextColor(Color.parseColor("#2E86C1"));
                amd.setBackgroundResource(R.drawable.radio_unchecked);
            }
        });
        totalcost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(validationCheck()) {
                    cost = cost1 + cost2 + cost3 + cost4 + cost5 + cost6 + cost7 + cost8;
                    final Dialog dialog = new Dialog(LaptopActivity.this);
                    dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                    dialog.setCancelable(false);
                    dialog.setContentView(R.layout.popup_window_totalcost);

                    TextView text = (TextView) dialog.findViewById(R.id.amount);
                    String valuetoshow;
                    valuetoshow = String.valueOf(cost);
                    text.setText("$" + valuetoshow);


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

        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add to cart code
                if(validationCheck()) {
                    cost = cost1 + cost2 + cost3 + cost4 + cost5 + cost6 + cost7 + cost8;
                    bld.open();
                    bld.save(screenSize,display,screenType,processor, processorgen, ram, storage, graphic,cost);
                    bld.close();
                    allClear();
                    //Toast.makeText(getApplicationContext(),"Added",Toast.LENGTH_LONG).show();
                    final Dialog dialog = new Dialog(LaptopActivity.this);
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
        wishlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        rscreen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.screenRadio1:
                        subcost = 0;
                        subcost = 0;
                        screenSize = screenRadio1.getText().toString();
                        break;
                    case R.id.screenRadio2:
                        subcost = 0;
                        subcost = 0;
                        screenSize = screenRadio2.getText().toString();
                        break;
                    case R.id.screenRadio3:
                        subcost = 0;
                        subcost = 0;
                        screenSize = screenRadio3.getText().toString();
                        break;
                }
                cost1 =+ subcost;
            }
        });
        rdisplay.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.displayRadio1:
                        subcost = 0;
                        subcost = 0;
                        display = displayRadio1.getText().toString();
                        break;
                    case R.id.displayRadio2:
                        subcost = 0;
                        subcost = 0;
                        display = displayRadio2.getText().toString();
                        break;
                    case R.id.displayRadio3:
                        subcost = 0;
                        subcost = 100;
                        display = displayRadio3.getText().toString();
                        break;
                }
                cost1 =+ subcost;
            }
        });

        rstype.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.stypeRadio1:
                        subcost = 0;
                        subcost = 150;
                        screenType = stypeRadio1.getText().toString();
                        break;
                    case R.id.stypeRadio2:
                        subcost = 0;
                        subcost = 0;
                        screenType = stypeRadio2.getText().toString();
                        break;

                }
                cost1 =+ subcost;
            }
        });

        rprocessor.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.proRadio1:
                        subcost = 0;
                        subcost = 250;
                        processor = proRadio1.getText().toString();
                        break;
                    case R.id.proRadio2:
                        subcost = 0;
                        subcost  = 300;
                        processor = proRadio2.getText().toString();
                        break;
                    case R.id.proRadio3:
                        subcost = 0;
                        subcost = 320;
                        processor = proRadio3.getText().toString();
                        break;
                }

                cost1 =+ subcost;
            }
        });

        rprocessorgen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int subcost = 0;
                switch (i) {
                    case R.id.progenRadio1:
                        subcost = 0;
                        subcost = 0;
                        processorgen = progenRadio1.getText().toString();
                        break;
                    case R.id.progenRadio2:
                        subcost = 0;
                        subcost =0;
                        processorgen = progenRadio2.getText().toString();
                        break;
                }

                cost2 =+ subcost;

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
                        ram = ramRadio1.getText().toString();
                        break;
                    case R.id.ramRadio2:
                        subcost = 0;
                        subcost  = 140;
                        ram = ramRadio2.getText().toString();
                        break;
                    case R.id.ramRadio3:
                        subcost = 0;
                        subcost = 220;
                        ram = ramRadio3.getText().toString();
                        break;
                }

                cost3 =+ subcost;

            }
        });

//        storages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//                switch (i) {
//                    case R.id.storage1:
//                       break;
//                    case R.id.storage2:
//                        break;
//                    case R.id.storage3:
//                        break;
//                    case R.id.storage4:
//                        break;
//                }
//
//            }
//        });
//        grapgics.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup radioGroup, int i) {
//
//            }
//        });

        ssd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage1.setChecked(false);
                storage2.setChecked(false);
                storage3.setChecked(false);
                storage4.setChecked(false);

                ssd.setTextColor(Color.parseColor("#ffffff"));
                hdd.setTextColor(Color.parseColor("#2E86C1"));
                dual.setTextColor(Color.parseColor("#2E86C1"));

                ssd.setBackgroundResource(R.drawable.radio_checked);
                hdd.setBackgroundResource(R.drawable.radio_unchecked);
                dual.setBackgroundResource(R.drawable.radio_unchecked);

                storageTypeText.setVisibility(View.VISIBLE);
                storage1.setVisibility(View.VISIBLE);
                storage2.setVisibility(View.VISIBLE);
                storage3.setVisibility(View.VISIBLE);
                storage4.setVisibility(View.VISIBLE);

                storageTypeText.setText("Solid state Drive");
                storage1.setText("256 GB $80");
                storage2.setText("512 GB $120");
                storage3.setText("1 TB $200");
                storage4.setText("2TB $300");
                storages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int subcost = 0;
                        switch (i) {
                            case R.id.storage1:
                                subcost = 0;
                                subcost = 80;
                                storage = storage1.getText().toString();
                                break;
                            case R.id.storage2:
                                subcost = 0;
                                subcost  = 120;
                                storage = storage2.getText().toString();
                                break;
                            case R.id.storage3:
                                subcost = 0;
                                subcost = 200;
                                storage = storage3.getText().toString();
                                break;
                            case R.id.storage4:
                                subcost = 0;
                                subcost = 300;
                                storage = storage4.getText().toString();
                                break;
                        }

                        cost7 =+ subcost;
                        Log.d("ssd cost", String.valueOf(cost));
                    }
                });

            }
        });
        hdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                storage1.setChecked(false);
                storage2.setChecked(false);
                storage3.setChecked(false);
                storage4.setChecked(false);

                ssd.setTextColor(Color.parseColor("#2E86C1"));
                hdd.setTextColor(Color.parseColor("#ffffff"));
                dual.setTextColor(Color.parseColor("#2E86C1"));

                ssd.setBackgroundResource(R.drawable.radio_unchecked);
                hdd.setBackgroundResource(R.drawable.radio_checked);
                dual.setBackgroundResource(R.drawable.radio_unchecked);

                storageTypeText.setVisibility(View.VISIBLE);
                storage1.setVisibility(View.VISIBLE);
                storage2.setVisibility(View.VISIBLE);
                storage3.setVisibility(View.VISIBLE);
                storage4.setVisibility(View.VISIBLE);

                storageTypeText.setText("Hard Disk Drive");
                storage1.setText("256 GB $60");
                storage2.setText("512 GB $100");
                storage3.setText("1 TB $150");
                storage4.setText("2TB $200");

                storages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int subcost = 0;
                        switch (i) {
                            case R.id.storage1:
                                subcost = 0;
                                subcost = 60;
                                storage = storage1.getText().toString();
                                break;
                            case R.id.storage2:
                                subcost = 0;
                                subcost  = 100;
                                storage = storage2.getText().toString();
                                break;
                            case R.id.storage3:
                                subcost = 0;
                                subcost = 150;
                                storage = storage3.getText().toString();
                                break;
                            case R.id.storage4:
                                subcost = 0;
                                subcost = 200;
                                storage = storage4.getText().toString();
                                break;
                        }

                        cost7 =+ subcost;
                        Log.d("hdd cost", String.valueOf(cost));
                    }
                });

            }
        });
        dual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                storage1.setChecked(false);
                storage2.setChecked(false);
                storage3.setChecked(false);
                storage4.setChecked(false);

                ssd.setTextColor(Color.parseColor("#2E86C1"));
                hdd.setTextColor(Color.parseColor("#2E86C1"));
                dual.setTextColor(Color.parseColor("#ffffff"));

                ssd.setBackgroundResource(R.drawable.radio_unchecked);
                hdd.setBackgroundResource(R.drawable.radio_unchecked);
                dual.setBackgroundResource(R.drawable.radio_checked);

                storageTypeText.setVisibility(View.VISIBLE);
                storage1.setVisibility(View.VISIBLE);
                storage2.setVisibility(View.VISIBLE);
                storage3.setVisibility(View.VISIBLE);
                storage4.setVisibility(View.VISIBLE);

                storageTypeText.setText("Dual Drive");
                storage1.setText("256 + 256 GB $150");
                storage2.setText("512 + 1TB $200");
                storage3.setText("1 TB + 1TB $250");
                storage4.setText("2 TB + 2TB $400");

                storages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        int subcost = 0;
                        switch (i) {
                            case R.id.storage1:
                                subcost = 0;
                                subcost = 150;
                                storage = storage1.getText().toString();
                                break;
                            case R.id.storage2:
                                subcost = 0;
                                subcost  = 200;
                                storage = storage2.getText().toString();
                                break;
                            case R.id.storage3:
                                subcost = 0;
                                subcost = 250;
                                storage = storage3.getText().toString();
                                break;
                            case R.id.storage4:
                                subcost = 0;
                                subcost = 400;
                                storage = storage4.getText().toString();
                                break;
                        }

                        cost7 =+ subcost;
                        Log.d("dual cost", String.valueOf(cost));
                    }
                });


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
                                graphic = graphic1.getText().toString();
                                break;
                            case R.id.graphic2:
                                subcost = 0;
                                subcost  = 320;
                                graphic = graphic2.getText().toString();
                                break;
                            case R.id.graphic3:
                                subcost = 0;
                                subcost = 330;
                                graphic = graphic3.getText().toString();
                                break;
                            case R.id.graphic4:
                                subcost = 0;
                                subcost = 340;
                                graphic = graphic4.getText().toString();
                                break;
                            case R.id.graphic5:
                                subcost = 0;
                                subcost = 350;
                                graphic = graphic5.getText().toString();
                                break;
                            case R.id.graphic6:
                                subcost = 0;
                                subcost = 360;
                                graphic = graphic6.getText().toString();
                                break;
                        }

                        cost8 =+ subcost;
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
                                graphic = graphic1.getText().toString();
                                break;
                            case R.id.graphic2:
                                subcost = 0;
                                subcost  = 320;
                                graphic = graphic2.getText().toString();
                                break;
                            case R.id.graphic3:
                                subcost = 0;
                                subcost = 330;
                                graphic = graphic3.getText().toString();
                                break;
                            case R.id.graphic4:
                                subcost = 0;
                                subcost = 340;
                                graphic = graphic4.getText().toString();
                                break;
                            case R.id.graphic5:
                                subcost = 0;
                                subcost = 350;
                                graphic = graphic5.getText().toString();
                                break;
                            case R.id.graphic6:
                                subcost = 0;
                                subcost = 360;
                                graphic = graphic6.getText().toString();
                                break;
                        }

                        cost8 =+ subcost;
                        Log.d("amd cost", String.valueOf(cost));
                    }
                });
            }
        });

    }
//    public void processorRadio(View view) {
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.proRadio1:
//                if (isSelected) {
//                    proRadio1.setTextColor(Color.WHITE);
//                    proRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    proRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    proRadio1.setBackgroundResource(R.drawable.radio_checked);
//                    proRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    proRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//
//                }
//                break;
//            case R.id.proRadio2:
//                if (isSelected) {
//                    proRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    proRadio2.setTextColor(Color.WHITE);
//                    proRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    proRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    proRadio2.setBackgroundResource(R.drawable.radio_checked);
//                    proRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//                }
//                break;
//            case R.id.proRadio3:
//                if (isSelected) {
//                    proRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    proRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    proRadio3.setTextColor(Color.WHITE);
//
//                    proRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    proRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    proRadio3.setBackgroundResource(R.drawable.radio_checked);
//
//
//                }
//                break;
//
//        }
//
//    }
//
    public void screenRadio(View view) {
        boolean isSelected = ((AppCompatRadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.screenRadio1:
                if (isSelected) {
                    screenRadio1.setTextColor(Color.WHITE);
                    screenRadio2.setTextColor(Color.parseColor("#2E86C1"));
                    screenRadio3.setTextColor(Color.parseColor("#2E86C1"));

                    screenRadio1.setBackgroundResource(R.drawable.radio_checked);
                    screenRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                    screenRadio3.setBackgroundResource(R.drawable.radio_unchecked);


                }
                break;
            case R.id.screenRadio2:
                if (isSelected) {
                    screenRadio1.setTextColor(Color.parseColor("#2E86C1"));
                    screenRadio2.setTextColor(Color.WHITE);
                    screenRadio3.setTextColor(Color.parseColor("#2E86C1"));

                    screenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                    screenRadio2.setBackgroundResource(R.drawable.radio_checked);
                    screenRadio3.setBackgroundResource(R.drawable.radio_unchecked);


                }
                break;
            case R.id.screenRadio3:
                if (isSelected) {
                    screenRadio1.setTextColor(Color.parseColor("#2E86C1"));
                    screenRadio2.setTextColor(Color.parseColor("#2E86C1"));
                    screenRadio3.setTextColor(Color.WHITE);

                    screenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                    screenRadio2.setBackgroundResource(R.drawable.radio_unchecked);
                    screenRadio3.setBackgroundResource(R.drawable.radio_checked);

                }
                break;

        }

    }
//
//    public void displayRadio(View view) {
//
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.displayRadio1:
//                if (isSelected) {
//                    displayRadio1.setTextColor(Color.WHITE);
//                    displayRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    displayRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    displayRadio1.setBackgroundResource(R.drawable.radio_checked);
//                    displayRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    displayRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//                }
//                break;
//            case R.id.displayRadio2:
//                if (isSelected) {
//                    displayRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    displayRadio2.setTextColor(Color.WHITE);
//                    displayRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    displayRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    displayRadio2.setBackgroundResource(R.drawable.radio_checked);
//                    displayRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//                }
//                break;
//            case R.id.displayRadio3:
//                if (isSelected) {
//                    displayRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    displayRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    displayRadio3.setTextColor(Color.WHITE);
//
//                    displayRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    displayRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    displayRadio3.setBackgroundResource(R.drawable.radio_checked);
//
//
//                }
//                break;
//
//        }
//
//    }
//
    public void stypeRadio(View view) {

        boolean isSelected = ((AppCompatRadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.stypeRadio1:
                if (isSelected) {
                    stypeRadio1.setTextColor(Color.WHITE);
                    stypeRadio2.setTextColor(Color.parseColor("#2E86C1"));

                    stypeRadio1.setBackgroundResource(R.drawable.radio_checked);
                    stypeRadio2.setBackgroundResource(R.drawable.radio_unchecked);


                }
                break;
            case R.id.stypeRadio2:
                if (isSelected) {
                    stypeRadio1.setTextColor(Color.parseColor("#2E86C1"));
                    stypeRadio2.setTextColor(Color.WHITE);

                    stypeRadio1.setBackgroundResource(R.drawable.radio_unchecked);
                    stypeRadio2.setBackgroundResource(R.drawable.radio_checked);

                }
                break;


        }

    }

    public boolean validationCheck(){
        if (rprocessor.getCheckedRadioButtonId() == -1)
        {
            // no radio buttons are checked
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
        }
        else if(rprocessorgen.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(rram.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(rscreen.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(rdisplay.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(rstype.getCheckedRadioButtonId() == -1)
        {
            Toast.makeText(getApplicationContext(),"Please Complete All Steps",Toast.LENGTH_LONG).show();
            return false;
            // one of the radio buttons is checked
        }
        else if(storages.getCheckedRadioButtonId() == -1)
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

//
//    public void processorGenRadio(View view) {
//
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//
//        switch (view.getId()) {
//            case R.id.progenRadio1:
//                if (isSelected) {
//                    progenRadio1.setTextColor(Color.WHITE);
//                    progenRadio2.setTextColor(Color.parseColor("#2E86C1"));
//
//                    progenRadio1.setBackgroundResource(R.drawable.radio_checked);
//                    progenRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//
//                }
//                break;
//            case R.id.progenRadio2:
//                if (isSelected) {
//                    progenRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    progenRadio2.setTextColor(Color.WHITE);
//
//                    progenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    progenRadio2.setBackgroundResource(R.drawable.radio_checked);
//
//                }
//                break;
//
//
//        }
//
//    }
//
//    public void ramRadio(View view) {
//
//        boolean isSelected = ((AppCompatRadioButton) view).isChecked();
//        switch (view.getId()) {
//            case R.id.ramRadio1:
//                if (isSelected) {
//                    ramRadio1.setTextColor(Color.WHITE);
//                    ramRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    ramRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    ramRadio1.setBackgroundResource(R.drawable.radio_checked);
//                    ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//                }
//                break;
//            case R.id.ramRadio2:
//                if (isSelected) {
//                    ramRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    ramRadio2.setTextColor(Color.WHITE);
//                    ramRadio3.setTextColor(Color.parseColor("#2E86C1"));
//
//                    ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    ramRadio2.setBackgroundResource(R.drawable.radio_checked);
//                    ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);
//
//
//                }
//                break;
//            case R.id.ramRadio3:
//                if (isSelected) {
//                    ramRadio1.setTextColor(Color.parseColor("#2E86C1"));
//                    ramRadio2.setTextColor(Color.parseColor("#2E86C1"));
//                    ramRadio3.setTextColor(Color.WHITE);
//
//                    ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
//                    ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
//                    ramRadio3.setBackgroundResource(R.drawable.radio_checked);
//
//
//                }
//                break;
//
//
//        }
//
//    }

    public void allClear(){

        cost=0;
        screenRadio1.setChecked(false);
        screenRadio2.setChecked(false);
        screenRadio3.setChecked(false);
        screenRadio1.setTextColor(Color.parseColor("#2E86C1"));
        screenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        screenRadio2.setTextColor(Color.parseColor("#2E86C1"));
        screenRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        screenRadio3.setTextColor(Color.parseColor("#2E86C1"));
        screenRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        displayRadio1.setChecked(false);
        displayRadio2.setChecked(false);
        displayRadio3.setChecked(false);
        displayRadio1.setTextColor(Color.parseColor("#2E86C1"));
        // displayRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        displayRadio2.setTextColor(Color.parseColor("#2E86C1"));
        // displayRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        displayRadio3.setTextColor(Color.parseColor("#2E86C1"));
        // displayRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        stypeRadio1.setChecked(false);
        stypeRadio2.setChecked(false);
        stypeRadio1.setTextColor(Color.parseColor("#2E86C1"));
        stypeRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        stypeRadio2.setTextColor(Color.parseColor("#2E86C1"));
        stypeRadio2.setBackgroundResource(R.drawable.radio_unchecked);

        proRadio1.setChecked(false);
        proRadio2.setChecked(false);
        proRadio3.setChecked(false);
        proRadio1.setTextColor(Color.parseColor("#2E86C1"));
        // proRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        proRadio2.setTextColor(Color.parseColor("#2E86C1"));
        // proRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        proRadio3.setTextColor(Color.parseColor("#2E86C1"));
        //  proRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        progenRadio1.setChecked(false);
        progenRadio2 .setChecked(false);
        progenRadio1.setTextColor(Color.parseColor("#2E86C1"));
        // progenRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        progenRadio2.setTextColor(Color.parseColor("#2E86C1"));
        // progenRadio2.setBackgroundResource(R.drawable.radio_unchecked);

        ramRadio1.setChecked(false);
        ramRadio2.setChecked(false);
        ramRadio3.setChecked(false);
        ramRadio1.setTextColor(Color.parseColor("#2E86C1"));
        //  ramRadio1.setBackgroundResource(R.drawable.radio_unchecked);
        ramRadio2.setTextColor(Color.parseColor("#2E86C1"));
        //  ramRadio2.setBackgroundResource(R.drawable.radio_unchecked);
        ramRadio3.setTextColor(Color.parseColor("#2E86C1"));
        //  ramRadio3.setBackgroundResource(R.drawable.radio_unchecked);

        storage1.setChecked(false);
        storage2.setChecked(false);
        storage3.setChecked(false);
        storage4.setChecked(false);
        graphic1.setChecked(false);
        graphic2.setChecked(false);
        graphic3.setChecked(false);
        graphic4.setChecked(false);
        graphic5.setChecked(false);
        graphic6.setChecked(false);
        ssd.setTextColor(Color.parseColor("#2E86C1"));
        ssd.setBackgroundResource(R.drawable.radio_unchecked);

        hdd.setTextColor(Color.parseColor("#2E86C1"));
        hdd.setBackgroundResource(R.drawable.radio_unchecked);

        dual.setTextColor(Color.parseColor("#2E86C1"));
        dual.setBackgroundResource(R.drawable.radio_unchecked);

        nvidia.setTextColor(Color.parseColor("#2E86C1"));
        nvidia.setBackgroundResource(R.drawable.radio_unchecked);

        amd.setTextColor(Color.parseColor("#2E86C1"));
        amd.setBackgroundResource(R.drawable.radio_unchecked);
    }

}
