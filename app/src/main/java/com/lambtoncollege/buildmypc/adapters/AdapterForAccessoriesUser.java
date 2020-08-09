package com.lambtoncollege.buildmypc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.interfaces.AdapterForAccessories;
import com.lambtoncollege.buildmypc.interfaces.AdapterForBrands;
import com.lambtoncollege.buildmypc.model.Accessories;

import java.util.ArrayList;
import java.util.List;

public class AdapterForAccessoriesUser extends RecyclerView.Adapter<AdapterForAccessoriesUser.MyViewHolder> {

    List<Accessories> listData = new ArrayList<>();
    private Context context;
    AdapterForAccessories clickedd;

    public AdapterForAccessoriesUser(List<Accessories> listData, Context context, AdapterForAccessories clickedd) {
        this.listData = listData;
        this.context = context;
        this.clickedd = clickedd;
    }

    @NonNull
    @Override
    public AdapterForAccessoriesUser.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_to_view_user_acc,parent,
                false);
        return new AdapterForAccessoriesUser.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForAccessoriesUser.MyViewHolder holder, int position) {
        final int pos=position;
        final Accessories dataProvider=listData.get(position);
        holder.name.setText(dataProvider.getAccName());
        holder.brand.setText(dataProvider.getAccBrand());
        holder.colour.setText(dataProvider.getAccColour());
        holder.ashort.setText(dataProvider.getAccShortDesc());
        holder.along.setText(dataProvider.getAccLongDesc());
        holder.price.setText("\u0024 "+dataProvider.getAccPrice());

        holder.addToWishlish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            clickedd.getData(pos,dataProvider.getAccName(),dataProvider.getAccBrand(),dataProvider.getAccColour(),
                    dataProvider.getAccShortDesc(),dataProvider.getAccLongDesc(),dataProvider.getAccPrice());
            }
        });

        //  Toast.makeText(context, ""+dataProvider.getBookUrl(), Toast.LENGTH_SHORT).show();
        // Glide.with(context).load("https://codeoptimizer.000webhostapp.com/"+dataProvider.getBookUrl()+".png").into(holder.bookImg);


    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView name,brand,colour,ashort,along,price;
        LinearLayout addToWishlish,addToCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.aname);
            brand=(TextView)itemView.findViewById(R.id.abrand);
            colour=(TextView)itemView.findViewById(R.id.acolour);
            ashort=(TextView)itemView.findViewById(R.id.ashort);
            along=(TextView)itemView.findViewById(R.id.along);
            price = (TextView)itemView.findViewById(R.id.acost);
            addToWishlish = (LinearLayout)itemView.findViewById(R.id.addToWishlish);
            addToCart = (LinearLayout)itemView.findViewById(R.id.addToCart);
        }
    }
}
