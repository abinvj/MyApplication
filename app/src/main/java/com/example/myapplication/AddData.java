package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.solver.widgets.Snapshot;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class AddData extends AppCompatActivity {

    EditText worldsData;
    EditText indiasData;
    EditText keralasData;
    EditText maharashtrasData;
    Button addData;
    TextView showWorldData;
    TextView showIndiasData;
    TextView showKeralasData;
    TextView showMaharashtrasData;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_data);

        worldsData = findViewById(R.id.dataWorld);
        indiasData= findViewById(R.id.dataIndia);
        keralasData = findViewById(R.id.dataKerala);
        maharashtrasData = findViewById(R.id.dataMaharashtra);
        addData = findViewById(R.id.addData);
        showWorldData = findViewById(R.id. showWorldData);
        showIndiasData = findViewById(R.id.showIndiasData);
        showKeralasData = findViewById(R.id. showKeralasData);
        showMaharashtrasData = findViewById(R.id.showMaharashtraData);
        listView = findViewById(R.id.listView);

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt_worldData = worldsData.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("World").child("Name").setValue(txt_worldData);
                String txt_indiaData = indiasData.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("India").child("Name").setValue(txt_indiaData);
                String txt_keralaData = keralasData.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("Kerala").child("Name").setValue(txt_keralaData);
                String txt_mahaData = maharashtrasData.getText().toString();
                FirebaseDatabase.getInstance().getReference().child("Maharashtra").child("Name").setValue(txt_mahaData);
            }
        });

        final ArrayList<String> list = new ArrayList<>();
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.list_item, list);
        listView.setAdapter(adapter);

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child("World");
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    showWorldData.setText(snapshot.getValue().toString());
                    list.add(snapshot.getValue().toString());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference reference1 = FirebaseDatabase.getInstance().getReference().child("India");
        reference1.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    showIndiasData.setText(snapshot.getValue().toString());
                    list.add(snapshot.getValue().toString());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference reference2 = FirebaseDatabase.getInstance().getReference().child("Kerala");
        reference2.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    showKeralasData.setText(snapshot.getValue().toString());
                    list.add(snapshot.getValue().toString());

                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        DatabaseReference reference3 = FirebaseDatabase.getInstance().getReference().child("Maharashtra");
        reference3.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                    showMaharashtrasData.setText(snapshot.getValue().toString());
                    list.add(snapshot.getValue().toString());
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
    public void openSignInActivity(View view){
        startActivity(new Intent(AddData.this, MainActivity.class));
        finish();
    }
}