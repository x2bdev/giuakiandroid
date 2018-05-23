package com.example.baobao.thigiuakicustomlistview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference reference = database.getReference();
    DatabaseReference reference_sinhvien = reference.child("sinhvien");

    ListView lv_custom;
    ArrayList<SinhVien> arrayListSinhVien;
    Adapter_SinhVien adapter;
    Button btnThem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhXa();
        addEvents();

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText edit_hoten = (EditText) findViewById(R.id.editTextHoTen);
                EditText edit_sdt = (EditText) findViewById(R.id.editTextSdt);
                EditText edit_diachi = (EditText) findViewById(R.id.editTextDiaChi);

                String ten = edit_hoten.getText().toString();
                String sdt = edit_sdt.getText().toString();
                String diachi = edit_diachi.getText().toString();

                String key = reference.child("sinhvien").push().getKey();
                SinhVien sv = new SinhVien(key,ten,sdt,diachi);

                reference.child("sinhvien").child(key).setValue(sv);
            }
        });
    }



    protected void anhXa(){
        lv_custom = findViewById(R.id.list_view_custom);
        arrayListSinhVien = new ArrayList<SinhVien>();

        btnThem = findViewById(R.id.btnThem);
        adapter = new Adapter_SinhVien(MainActivity.this,R.layout.layout_row,arrayListSinhVien);

        lv_custom.setAdapter(adapter);

    }

    protected void addEvents(){
        reference_sinhvien.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                SinhVien sv = dataSnapshot.getValue(SinhVien.class);
                arrayListSinhVien.add(sv);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                arrayListSinhVien.clear();
                reference_sinhvien.removeEventListener((ChildEventListener)this);
                reference_sinhvien.addChildEventListener(this);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {
                arrayListSinhVien.clear();
                reference_sinhvien.removeEventListener((ChildEventListener)this);
                reference_sinhvien.addChildEventListener(this);
            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
