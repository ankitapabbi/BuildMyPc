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
import com.lambtoncollege.buildmypc.interfaces.AdapterToDelete;
import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.model.ModifyBrandPc;

import java.util.ArrayList;
import java.util.List;

public class AdapterToDeleteModifiedBrandPc extends RecyclerView.Adapter<AdapterToDeleteModifiedBrandPc.MyViewHolder> {

    List<ModifyBrandPc> listData = new ArrayList<>();
    private Context context;
    AdapterToDelete clickedd;

    public AdapterToDeleteModifiedBrandPc(List<ModifyBrandPc> listData, Context context, AdapterToDelete clickedd) {
        this.listData = listData;
        this.context = context;
        this.clickedd = clickedd;
    }

    @NonNull
    @Override
    public AdapterToDeleteModifiedBrandPc.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_to_delete_brandpc,parent,
                false);
        return new AdapterToDeleteModifiedBrandPc.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterToDeleteModifiedBrandPc.MyViewHolder holder, int position) {
        final int pos=position;
        final ModifyBrandPc dataProvider=listData.get(position);
        holder.name.setText(dataProvider.getName());
        holder.screen.setText(dataProvider.getScreenSize());
        holder.processor.setText(dataProvider.getProcessor());
        holder.ram.setText(dataProvider.getRam());
        holder.rom.setText(dataProvider.getRom());
        holder.graphic.setText(dataProvider.getGraphics());
        holder.warranty.setText(dataProvider.getWarranty());
        holder.price.setText("\u0024 "+dataProvider.getPrice());

        holder.deletePc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clickedd.clickForModifiedBrands(pos);
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
        LinearLayout deletePc;

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
            deletePc = (LinearLayout)itemView.findViewById(R.id.deletePc);
        }
    }
}
