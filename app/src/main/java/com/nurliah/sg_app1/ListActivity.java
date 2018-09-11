package com.nurliah.sg_app1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.nurliah.sg_app1.adapter.ListUserAdapter;
import com.nurliah.sg_app1.model.USer;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    static ArrayList<USer> listUser = new ArrayList<>();
    RecyclerView rv_user;
    ListUserAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        rv_user = findViewById(R.id.rv_user);

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ListUserAdapter(listUser);
        rv_user.setAdapter(adapter);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(mLayoutManager);


        Bundle extras = getIntent().getExtras();
        USer uSer = new USer();
        if (extras != null) {
            uSer.nama = extras.getString("nama");
            uSer.umur = extras.getInt("umur");
            uSer.gender = extras.getString("gender");
            listUser.add(uSer);
        }

    }
}
