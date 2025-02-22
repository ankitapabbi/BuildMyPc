package com.lambtoncollege.buildmypc;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.lambtoncollege.buildmypc.ui.assembled.AssembledFragment;
import com.lambtoncollege.buildmypc.ui.contactUs.ContacUsFragment;
import com.lambtoncollege.buildmypc.ui.home.HomeFragment;
import com.lambtoncollege.buildmypc.ui.logout.LogoutFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity implements LogoutFragment.OnFragmentInteractionListener,
        ContacUsFragment.OnFragmentInteractionListener {

    TextView username,useremail;
    String name,email;

    private AppBarConfiguration mAppBarConfiguration;
NavigationView navigationView;
    DrawerLayout drawer;
    NavController navController;
    Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Intent intent = getIntent();
       name=  intent.getStringExtra("name");
        email = intent.getStringExtra("email");

//        FloatingActionButton fab = findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
       drawer = findViewById(R.id.drawer_layout);
       navigationView = findViewById(R.id.nav_view);


        View header = navigationView.getHeaderView(0);
        username = (TextView)header.findViewById(R.id.username);
        useremail = (TextView)header.findViewById(R.id.useremail);
        if(!name.equalsIgnoreCase("") && !email.equalsIgnoreCase("")) {
            username.setText(name);
            useremail.setText(email);
        }



        // Passing each menu ID as radio_checked set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_assembled, R.id.nav_brandlist,
                R.id.nav_cart, R.id.nav_wishlist, R.id.nav_aboutUs, R.id.nav_logout)
                .setDrawerLayout(drawer)
                .build();

//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//                int id=menuItem.getItemId();
//                //it's possible to do more actions on several items, if there is a large amount of items I prefer switch(){case} instead of if()
//                if (id==R.id.nav_logout){
//                    Toast.makeText(getApplicationContext(), "Logout", Toast.LENGTH_SHORT).show();
//                }
//                //This is for maintaining the behavior of the Navigation view
//                //NavigationUI.onNavDestinationSelected(menuItem,navController);
//                //This is for closing the drawer after acting on it
//                //drawer.closeDrawer(GravityCompat.START);
//                return true;
//            }
//        });

        navController = Navigation.findNavController(HomeActivity.this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(HomeActivity.this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);





//        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
//
//                boolean handled = NavigationUI.onNavDestinationSelected(menuItem, navController);
//
//                if (!handled) {
//                    switch (menuItem.getItemId()) {
//
//                        case R.id.nav_home: {
////                            Toast.makeText(HomeActivity.this, "home", Toast.LENGTH_SHORT).show();
////                            fragment = new HomeFragment();
////                            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
////                            ft.replace(R.id.nav_host_fragment, fragment);
////                            ft.addToBackStack(null);
////                            ft.commit();
//                            break;
//                        }
//                        case R.id.nav_assembled: {
////                            Toast.makeText(HomeActivity.this, "Assembled", Toast.LENGTH_SHORT).show();
////                            fragment = new AssembledFragment();
////                            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
////                            ft.replace(R.id.nav_host_fragment, fragment);
////                            ft.addToBackStack(null);
////                            ft.commit();
//                            break;
//                        }
//                        case R.id.nav_brandlist: {
//                           // Toast.makeText(HomeActivity.this, "brand", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        case R.id.nav_cart: {
//                           // Toast.makeText(HomeActivity.this, "cart", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        case R.id.nav_wishlist: {
//                            //Toast.makeText(HomeActivity.this, "wishlist", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                        case R.id.nav_aboutUs: {
//                           // Toast.makeText(HomeActivity.this, "about us", Toast.LENGTH_SHORT).show();
//                            break;
//                        }
//                    }
//                }
//
//                //drawer.closeDrawer(GravityCompat.START);
//                return handled;
//            }
//        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
