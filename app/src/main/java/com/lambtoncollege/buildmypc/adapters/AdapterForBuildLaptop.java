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
import com.lambtoncollege.buildmypc.model.BuildLaptop;

import java.util.ArrayList;
import java.util.List;

public class AdapterForBuildLaptop extends RecyclerView.Adapter<AdapterForBuildLaptop.MyViewHolder>{

    List<BuildLaptop> listData = new ArrayList<>();
    private Context context;
    AdapterToDelete clickedd;

    public AdapterForBuildLaptop(List<BuildLaptop> listData, Context context, AdapterToDelete clickedd) {
        this.listData = listData;
        this.context = context;
        this.clickedd = clickedd;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_for_build_laptop,parent,
                false);
        return new AdapterForBuildLaptop.MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final int pos=position;
        final BuildLaptop dataProvider=listData.get(position);
        holder.processorName.setText(dataProvider.getProcessor());
        holder.genName.setText(dataProvider.getProcessorGen());
        holder.ramName.setText(dataProvider.getRam());
        holder.storageName.setText(dataProvider.getStorageType());
        holder.graphicName.setText(dataProvider.getGraphicCard());
        holder.screenSize.setText(dataProvider.getScreenSize());
        holder.display.setText(dataProvider.getDisplay());
        holder.screentype.setText(dataProvider.getScreenType());
        // holder.price.setText("\u0024 "+dataProvider.getBookPrice());


//        Glide.with(context).load("https://codeoptimizer.000webhostapp.com/"+dataProvider.getBookUrl()+".png").into(holder.bookImg);
//

        holder.deleteBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickedd.clickForLaptop(pos);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView screenSize, display, screentype,processorName,genName,ramName,storageName,graphicName;
        ImageView desktopImg;
        LinearLayout deleteBook;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            processorName = (TextView)itemView.findViewById(R.id.processorName);
            genName = (TextView)itemView.findViewById(R.id.genName);
            ramName = (TextView)itemView.findViewById(R.id.ramName);
            storageName = (TextView)itemView.findViewById(R.id.storageName);
            graphicName = (TextView)itemView.findViewById(R.id.graphicName);
            screenSize = (TextView)itemView.findViewById(R.id.screenSize);
            display = (TextView)itemView.findViewById(R.id.display);
            screentype = (TextView)itemView.findViewById(R.id.screenType);
            desktopImg=(ImageView)itemView.findViewById(R.id.desktopImg);
            deleteBook = (LinearLayout)itemView.findViewById(R.id.deleteBook);

        }
    }
}

