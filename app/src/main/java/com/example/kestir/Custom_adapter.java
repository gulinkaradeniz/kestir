package com.example.kestir;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Custom_adapter extends RecyclerView.Adapter<Custom_adapter.MyViewHolder> {

    private Context context;
    private ArrayList islem,tarih,saat,telno,ad_soyad,_id2;

    Custom_adapter(Context context,ArrayList islem,ArrayList tarih,ArrayList saat,ArrayList telno,ArrayList ad_soyad,ArrayList _id2){
        this.context=context;
        this._id2 =_id2;
        this.islem =islem;
        this.tarih =tarih;
        this.saat =saat;
        this.telno =telno;
        this.ad_soyad =ad_soyad;



    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(context);
        View view=inflater.inflate(R.layout.satir,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textView13.setText(String.valueOf(ad_soyad.get(position)));
        holder.textView14.setText(String.valueOf(telno.get(position)));
        holder.textView15.setText(String.valueOf(islem.get(position)));
        holder.textView16.setText(String.valueOf(tarih.get(position)));
        holder.textView17.setText(String.valueOf(saat.get(position)));

    }

    @Override
    public int getItemCount() {
        return _id2.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textView13,textView14,textView15,textView16,textView17;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView13=itemView.findViewById(R.id.textView13);
            textView14=itemView.findViewById(R.id.textView14);
            textView15=itemView.findViewById(R.id.textView15);
            textView16=itemView.findViewById(R.id.textView16);
            textView17=itemView.findViewById(R.id.textView17);
        }
    }
}
