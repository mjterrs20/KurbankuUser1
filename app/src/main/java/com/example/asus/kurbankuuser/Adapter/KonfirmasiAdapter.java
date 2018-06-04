package com.example.asus.kurbankuuser.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.asus.kurbankuuser.Depan;
import com.example.asus.kurbankuuser.Model.Bayar;
import com.example.asus.kurbankuuser.Model.Upload;
import com.example.asus.kurbankuuser.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class KonfirmasiAdapter extends RecyclerView.Adapter<KonfirmasiAdapter.KonfirmasiViewHolder>{
    private Context mContext;
    private List<Bayar> mUploads;

    public KonfirmasiAdapter(Context context, List<Bayar> bayar) {
        mContext = context;
        mUploads = bayar;
    }
    @NonNull
    @Override
    public KonfirmasiViewHolder onCreateViewHolder(@NonNull ViewGroup parent , int viewType) {
        View v = LayoutInflater.from ( mContext ).inflate ( R.layout.view_konfirmasi , parent , false );
        final KonfirmasiViewHolder viewHolder = new KonfirmasiViewHolder ( v );
        viewHolder.view_container.setOnClickListener ( new View.OnClickListener ( ){
            @Override
            public void onClick(View v) {
                Intent i = new Intent ( mContext,Depan.class );
                mContext.startActivity ( i );
            }
        } );

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull KonfirmasiAdapter.KonfirmasiViewHolder holder , int position) {
        Bayar uploadCurrent = mUploads.get(position);
        holder.textViewNama.setText("Nama : "+uploadCurrent.getNama());
        holder.textViewNorek.setText("No Rek : "+uploadCurrent.getJumlah ());
        holder.textViewJumlah.setText("Jumlah Uang Transfer : "+uploadCurrent.getTransfer ());
        Picasso.with(mContext)
                .load(uploadCurrent.getNorek ())
                .placeholder(R.mipmap.ic_launcher)
                .fit()
                .centerCrop()
                .into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return mUploads.size();
    }

    public class KonfirmasiViewHolder extends RecyclerView.ViewHolder{
        public TextView textViewNama;
        public ImageView imageView;
        public TextView textViewNorek;
        public TextView textViewJumlah;
        public LinearLayout view_container;
        public KonfirmasiViewHolder(View itemView) {
            super ( itemView );

            view_container = itemView.findViewById(R.id.kontener);
            textViewNama = itemView.findViewById(R.id.text_view_nama);
            imageView = itemView.findViewById(R.id.image_view_upload);
            textViewNorek = itemView.findViewById (R.id.text_view_norek);
            textViewJumlah = itemView.findViewById (R.id.text_view_jumlah);


        }


    }
}
