package com.example.code;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;

public class MainActivity extends AppCompatActivity {
BottomNavigationView bnView;
    FirebaseAuth auth;
    FirebaseDatabase database;
    ImageView img123;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setStatusBarColor(ContextCompat.getColor(MainActivity.this,R.color.black));
        bnView=findViewById(R.id.bnView);
        database=FirebaseDatabase.getInstance();
        auth = FirebaseAuth.getInstance();
        DatabaseReference reference = database.getReference().child("user");
        img123=findViewById(R.id.img123);
        img123.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this, login.class);
                startActivity(in);

            }
        });

        bnView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id=item.getItemId();
                if(id == R.id.nav_home){

                    FragmentManager fm=getSupportFragmentManager();
                    FragmentTransaction ft=fm.beginTransaction();
                    ft.add(R.id.container,new Frag_dash());
                    ft.commit();


                }
                else if (id==R.id.nav_feed){
                    loadfrag(new frag_feed());
                }
                else if(id==R.id.nav_emergeny){
                    loadfrag(new frag_emergency());

                }
                else if (id==R.id.nav_devices){
                    loadfrag((new frag_devices()));

                }
                else{
                    loadfrag(new frag_routines());

                }
                return true;
            }
        });
        bnView.setSelectedItemId(R.id.nav_home);
    }

    public void loadfrag(Fragment Frag){

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction ft=fm.beginTransaction();
        ft.replace(R.id.container,Frag);
        ft.commit();

    }

}