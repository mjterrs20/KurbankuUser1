package com.example.asus.kurbankuuser;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asus.kurbankuuser.Adapter.HewanAdapter;
import com.example.asus.kurbankuuser.Model.Upload;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Depan extends AppCompatActivity {
    private Button cariHewan,pesanan,tambah,konfirmasi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_depan );

        cariHewan = findViewById(R.id.dp_hewan);
        pesanan = findViewById(R.id.dp_pesan);
        tambah = findViewById(R.id.dp_tambah);
        konfirmasi = findViewById ( R.id.dp_konfirmasi );


        cariHewan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Depan.this, DaftarHewan.class);
                startActivity(i);
            }
        });

        pesanan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a = new Intent(Depan.this, Pesanan.class);
                startActivity(a);
            }
        });

        tambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Depan.this, TambahKurban.class);
                startActivity(j);
            }
        });
        konfirmasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent j = new Intent(Depan.this, Konfirmasi.class);
                startActivity(j);
            }
        });

    }


}
