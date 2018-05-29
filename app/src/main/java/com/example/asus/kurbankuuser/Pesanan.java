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
    public double r = 0;
    public double hitung = 0;
    public double hasil = 0;

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

                TextView name = v.findViewById ( R.id.view1Nama );
                TextView ktp = v.findViewById ( R.id.view1Noktp );
                TextView jumlah = v.findViewById ( R.id.view1Jumlah );
                TextView hasil = v.findViewById ( R.id.view1Hasil );
                TextView norek = v.findViewById ( R.id.view1Norek );

                Pemesan pemesan = (Pemesan) model;
                r = Double.parseDouble (pemesan.getJumlah ().toString());
                hitung = ( r * 0.1) + r ;
                String h = String.valueOf ( hitung );

                name.setText ( "Name: "+pemesan.getName ().toString ());
                ktp.setText ( "No KTP : "+pemesan.getNoktp ().toString () );
                jumlah.setText ( "Modal  : "+pemesan.getJumlah ().toString ());
                hasil.setText ( "Hasil : "+ h);
                norek.setText ( "Silahkan Melakukan Pembayaran ke Rekening : 101.00.98300.997 (Mandiri) " );
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
