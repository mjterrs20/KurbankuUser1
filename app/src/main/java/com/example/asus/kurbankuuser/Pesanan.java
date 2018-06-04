package com.example.asus.kurbankuuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.asus.kurbankuuser.Model.Pemesan;
import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

public class Pesanan extends AppCompatActivity {

    ListView lv;
    FirebaseListAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.pesanan );

        lv = findViewById ( R.id.listView );
        Query query = FirebaseDatabase.getInstance ().getReference ().child ( "Pemesan" );
        FirebaseListOptions<Pemesan> options = new FirebaseListOptions.Builder<Pemesan> ()
                .setLayout ( R.layout.view_pesan )
                .setQuery ( query,Pemesan.class )
                .build();
        adapter = new FirebaseListAdapter (options ) {
            @Override
            protected void populateView(View v, Object model, int position) {

                TextView Jenis = v.findViewById ( R.id.viewJenis );
                TextView Harga = v.findViewById ( R.id.viewHarga );
                TextView name = v.findViewById ( R.id.viewName );
                TextView jumlah = v.findViewById ( R.id.viewJumlah );
                TextView nohp = v.findViewById ( R.id.viewNohp );
                TextView alamat = v.findViewById ( R.id.viewAlamat );
                TextView norek = v.findViewById ( R.id.viewNorek );

                Pemesan pemesan = (Pemesan) model;
                Jenis.setText ( "Name: "+pemesan.getJenis ().toString ());
                Harga.setText ( "Harga : "+pemesan.getHarga ().toString () );
                name.setText ( "Nama : "+pemesan.getName ().toString () );
                jumlah.setText ( "Jumlah Pesan : "+pemesan.getJumlah ().toString () );
                nohp.setText ( "No Hp : "+pemesan.getNohp ().toString () );
                alamat.setText ( "Alamat : "+pemesan.getDaerah ().toString () );
            }
        };
        lv.setAdapter(adapter);
    }

    protected void onStart() {
        super.onStart ( );
        adapter.startListening ();
    }

    @Override
    protected void onStop() {
        super.onStop ( );
        adapter.stopListening ();
    }
}
