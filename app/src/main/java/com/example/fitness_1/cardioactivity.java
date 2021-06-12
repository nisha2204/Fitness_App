package com.example.fitness_1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cardioactivity extends AppCompatActivity {
    List<com.example.fitness_1.fetchdata1> fetchdata1;
    RecyclerView recyclerView;
    HeperAdapter1 heperAdapter1;
    DatabaseReference rdbs;
    String uid;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cardioactivity);
        recyclerView=findViewById(R.id.recycle);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fetchdata1= new ArrayList<>();
        rdbs= FirebaseDatabase.getInstance().getReference("cardio");
        uid= FirebaseAuth.getInstance().getCurrentUser().getUid();
       

        rdbs.child(uid).addListenerForSingleValueEvent(new ValueEventListener() {
            

            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot dataSnapshot:snapshot.getChildren()){
                    fetchdata1 data=dataSnapshot.getValue(fetchdata1.class);
                    fetchdata1.add(data);

                }
                heperAdapter1=new HeperAdapter1(fetchdata1);
                recyclerView.setAdapter(heperAdapter1);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }

}
