package com.utn.segundoparcial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.utn.segundoparcial.Adapters.AdapterReclamos;
import com.utn.segundoparcial.Classes.Reclamo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView rvReclamos;
    List<Reclamo> Reclamos;
    AdapterReclamos adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvReclamos = findViewById(R.id.rvReclamos);

        rvReclamos.setLayoutManager(new LinearLayoutManager(this));
        Reclamos = new ArrayList<>();

        FirebaseDatabase db = FirebaseDatabase.getInstance();

        adapter = new AdapterReclamos(Reclamos);

        adapter.ImageGalleryAdapter(this);

        rvReclamos.setAdapter(adapter);

        db.getReference().getRoot().addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Reclamos.removeAll(Reclamos);
                for (DataSnapshot snapshot:
                dataSnapshot.getChildren()) {
                    Reclamo reclamo = snapshot.getValue(Reclamo.class);
                    Reclamos.add(reclamo);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
