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
import com.lambtoncollege.buildmypc.model.BuildDesktop;

import java.util.ArrayList;
import java.util.List;

public class AdapterForBuildDesktop extends RecyclerView.Adapter<AdapterForBuildDesktop.MyViewHolder>{

    List<BuildDesktop> listData = new ArrayList<>();
    private Context context;
    AdapterToDelete clickedd;

    public AdapterForBuildDesktop(List<BuildDesktop> listData, Context context, AdapterToDelete clickedd) {
        this.listData = listData;
        this.context = context;
        this.clickedd = clickedd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_build_desktop,parent,
                false);
        return new AdapterForBuildDesktop.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final int pos=position;
        final BuildDesktop dataProvider=listData.get(position);
        holder.processorName.setText(dataProvider.getProcessor());
        holder.genName.setText(dataProvider.getProcessorGen());
        holder.ramName.setText(dataProvider.getRam());
        holder.storageName.setText(dataProvider.getStorageType());
        holder.graphicName.setText(dataProvider.getGraphicCard());
        holder.powerName.setText(dataProvider.getPowerSupply());
        holder.networkName.setText(dataProvider.getNetworkCard());
        holder.cabinetName.setText(dataProvider.getCabinet());
       // holder.price.setText("\u0024 "+dataProvider.getBookPrice());


//        Glide.with(context).load("https://codeoptimizer.000webhostapp.com/"+dataProvider.getBookUrl()+".png").into(holder.bookImg);
//

        holder.deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedd.clicked(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView processorName,genName,ramName,storageName,graphicName,powerName,networkName,cabinetName;
        ImageView desktopImg;
        LinearLayout deleteBook;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            processorName = (TextView)itemView.findViewById(R.id.processorName);
            genName = (TextView)itemView.findViewById(R.id.genName);
            ramName = (TextView)itemView.findViewById(R.id.ramName);
            storageName = (TextView)itemView.findViewById(R.id.storageName);
            graphicName = (TextView)itemView.findViewById(R.id.graphicName);
            powerName = (TextView)itemView.findViewById(R.id.powerName);
            networkName = (TextView)itemView.findViewById(R.id.networkName);
            cabinetName = (TextView)itemView.findViewById(R.id.cabinetName);
            desktopImg=(ImageView)itemView.findViewById(R.id.desktopImg);
            deleteBook = (LinearLayout)itemView.findViewById(R.id.deleteBook);

        }
    }
}

