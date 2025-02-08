package com.jovanovic.stefan.sqlitetutorial;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private Activity activity;
    private ArrayList pengeluaran_id, pengeluaran_nama, pengeluaran_deskripsi, pengeluaran_harga;

    CustomAdapter(Activity activity, Context context, ArrayList pengeluaran_id, ArrayList pengeluaran_nama, ArrayList pengeluaran_deskripsi,
                  ArrayList pengeluaran_harga) {
        this.activity = activity;
        this.context = context;
        this.pengeluaran_id = pengeluaran_id;
        this.pengeluaran_nama = pengeluaran_nama;
        this.pengeluaran_deskripsi = pengeluaran_deskripsi;
        this.pengeluaran_harga = pengeluaran_harga;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, int position) {
        // Set data untuk setiap item
        holder.pengeluaran_id_txt.setText(String.valueOf(pengeluaran_id.get(position)));
        holder.pengeluaran_nama_txt.setText(String.valueOf(pengeluaran_nama.get(position)));
        holder.pengeluaran_deskripsi_txt.setText(String.valueOf(pengeluaran_deskripsi.get(position)));
        holder.pengeluaran_harga_txt.setText(String.valueOf(pengeluaran_harga.get(position)));
        // RecyclerView onClickListener
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int currentPosition = holder.getAdapterPosition(); // Ambil posisi dinamis
                if (currentPosition != RecyclerView.NO_POSITION) { // Pastikan posisi valid
                    Intent intent = new Intent(context, UpdateActivity.class);
                    intent.putExtra("id", String.valueOf(pengeluaran_id.get(currentPosition)));
                    intent.putExtra("pengeluaran", String.valueOf(pengeluaran_nama.get(currentPosition)));
                    intent.putExtra("deskripsi", String.valueOf(pengeluaran_deskripsi.get(currentPosition)));
                    intent.putExtra("harga", String.valueOf(pengeluaran_harga.get(currentPosition)));
                    activity.startActivityForResult(intent, 1);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return pengeluaran_id.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView pengeluaran_id_txt, pengeluaran_nama_txt, pengeluaran_deskripsi_txt, pengeluaran_harga_txt;
        LinearLayout mainLayout;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            pengeluaran_id_txt = itemView.findViewById(R.id.pengeluaran_id_txt);
            pengeluaran_nama_txt = itemView.findViewById(R.id.pengeluaran_nama_txt);
            pengeluaran_deskripsi_txt = itemView.findViewById(R.id.pengeluaran_deskripsi_txt);
            pengeluaran_harga_txt = itemView.findViewById(R.id.pengeluaran_harga_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);

            // Animate RecyclerView
            Animation translate_anim = AnimationUtils.loadAnimation(context, R.anim.translate_anim);
            mainLayout.setAnimation(translate_anim);
        }
    }
}
