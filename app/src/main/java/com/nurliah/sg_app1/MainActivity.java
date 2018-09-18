package com.nurliah.sg_app1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.nurliah.sg_app1.model.USer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity{

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.til_nama)
    TextInputLayout til_nama;

    @BindView(R.id.et_umur)
    EditText et_umur;

    @BindView(R.id.spinner_gender)
    Spinner spinner_gender;


    @BindView(R.id.btn_process)
    Button btn_process;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        til_nama = findViewById(R.id.til_nama);
//        et_umur = findViewById(R.id.et_umur);
//        spinner_gender = findViewById(R.id.spinner_gender);
//        btn_process = findViewById(R.id.btn_process);
        }

    @OnClick(R.id.btn_process)
    void validateData(){
        if (til_nama.getEditText() !=null){
            if(!til_nama.getEditText().getText().toString().equals("")&& !et_umur.getText().toString().equals("")){
                USer uSer = new USer();
                uSer.nama = til_nama.getEditText().getText().toString();
                uSer.umur = Integer.parseInt(et_umur.getText().toString());
                uSer.gender = spinner_gender.getSelectedItem().toString();

                processData(uSer);
            }else{
                Toast.makeText(this, "Data tidak boleh kososng", Toast.LENGTH_SHORT).show();
            }
        }
    }
    private void processData(USer uSer){
        Intent intent = new Intent(this,ListActivity.class);
        intent.putExtra("user", uSer);
        startActivity(intent);
    }
}


