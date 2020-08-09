package com.lambtoncollege.buildmypc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lambtoncollege.buildmypc.R;
import com.lambtoncollege.buildmypc.interfaces.AdapterForBrands;
import com.lambtoncollege.buildmypc.model.BrandPc;

import java.util.ArrayList;
import java.util.List;

public class AdapterForBrandPcUser extends RecyclerView.Adapter<AdapterForBrandPcUser.MyViewHolder> {

    List<BrandPc> listData = new ArrayList<>();
    private Context context;
    AdapterForBrands getData;

    public AdapterForBrandPcUser(List<BrandPc> listData, Context context, AdapterForBrands getData) {
        this.listData = listData;
        this.context = context;
        this.getData = getData;
    }

    @NonNull
    @Override
    public AdapterForBrandPcUser.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_to_view_user_brandpc,parent,
                false);
        return new AdapterForBrandPcUser.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterForBrandPcUser.MyViewHolder holder, int position) {
        final int pos=position;
        final BrandPc dataProvider=listData.get(position);
        holder.name.setText(dataProvider.getName());
        holder.screen.setText(dataProvider.getScreenSize());
        holder.processor.setText(dataProvider.getProcessor());
        holder.ram.setText(dataProvider.getRam());
        holder.rom.setText(dataProvider.getRom());
        holder.graphic.setText(dataProvider.getGraphics());
        holder.warranty.setText(dataProvider.getWarranty());
        holder.price.setText("\u0024 "+dataProvider.getPrice());

        holder.goToManage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData.toManage(pos,dataProvider.getName(),dataProvider.getScreenSize(),dataProvider.getProcessor(),
                        dataProvider.getRam(),dataProvider.getRom(),dataProvider.getGraphics(),dataProvider.getWarranty()
                ,dataProvider.getPrice());
            }
        });

        holder.addToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                getData.getData(pos,dataProvider.getName(),dataProvider.getScreenSize(),dataProvider.getProcessor(),
                        dataProvider.getRam(),dataProvider.getRom(),dataProvider.getGraphics(),dataProvider.getWarranty()
                        ,dataProvider.getPrice());
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

        TextView name,screen,processor,ram,rom,graphic,warranty,price;
        ImageView bookImg;
        LinearLayout goToManage,addToCart;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=(TextView)itemView.findViewById(R.id.nameOfPc);
            screen=(TextView)itemView.findViewById(R.id.screenSize);
            processor=(TextView)itemView.findViewById(R.id.processorName);
            ram=(TextView)itemView.findViewById(R.id.ramName);
            rom=(TextView)itemView.findViewById(R.id.romName);
            graphic=(TextView)itemView.findViewById(R.id.graphicName);
            warranty=(TextView)itemView.findViewById(R.id.warrantyName);
            price = (TextView)itemView.findViewById(R.id.costbrand);
            goToManage = (LinearLayout)itemView.findViewById(R.id.goToManage);
            addToCart = (LinearLayout)itemView.findViewById(R.id.addToCart);
        }
    }
}
