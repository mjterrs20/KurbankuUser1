package com.example.asus.kurbankuuser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.asus.kurbankuuser.Adapter.HewanAdapter;
import com.example.asus.kurbankuuser.Adapter.KonfirmasiAdapter;
import com.example.asus.kurbankuuser.Model.Bayar;
import com.example.asus.kurbankuuser.Model.Upload;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class Konfirmasi extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private KonfirmasiAdapter mAdapter;

    private ProgressBar mProgressCircle;

    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;

    private List<Bayar> mUploads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_konfirmasi );

        mRecyclerView = findViewById(R.id.recycler_view1);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager (this));

        mProgressCircle = findViewById(R.id.progress_circle1);

        mUploads = new ArrayList<> ();

        mAdapter = new KonfirmasiAdapter (Konfirmasi.this, mUploads);

        mRecyclerView.setAdapter(mAdapter);



        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("pembayaran");

        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mUploads.clear();

                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                    Bayar bayar = postSnapshot.getValue(Bayar.class);
                    bayar.setmKey(postSnapshot.getKey());
                    mUploads.add(bayar);
                }

                mAdapter.notifyDataSetChanged();

                mProgressCircle.setVisibility( View.INVISIBLE);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(Konfirmasi.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressCircle.setVisibility(View.INVISIBLE);
            }
        });
    }

    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }
}
