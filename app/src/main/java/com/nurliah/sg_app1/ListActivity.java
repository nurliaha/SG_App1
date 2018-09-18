package com.nurliah.sg_app1;

import android.os.Bundle;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;

import com.nurliah.sg_app1.adapter.ListUserAdapter;
import com.nurliah.sg_app1.database.UserRepo;
import com.nurliah.sg_app1.model.USer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListActivity extends AppCompatActivity {
    @BindView(R.id.rv_user)
    RecyclerView rv_user;

    ArrayList<USer> listUser = new ArrayList<>();
    ListUserAdapter adapter;
    UserRepo repo = new UserRepo(this);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);

        ButterKnife.bind(this);

//        rv_user = findViewById(R.id.rv_user);



        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            USer uSer = extras.getParcelable("user");
            repo.insert(uSer);
            listUser = repo.getUserList();
        }
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        adapter = new ListUserAdapter(listUser);
        rv_user.setAdapter(adapter);
        rv_user.setHasFixedSize(true);
        rv_user.setLayoutManager(mLayoutManager);

    }
}
