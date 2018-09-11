package com.nurliah.sg_app1.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.nurliah.sg_app1.R;
import com.nurliah.sg_app1.model.USer;

import java.util.ArrayList;

public class ListUserAdapter extends RecyclerView.Adapter<ListUserVH>
{
    private ArrayList<USer> mData;

    public ListUserAdapter(ArrayList<USer> mData) {
        this.mData = mData;
    }


    @NonNull
    @Override
    public ListUserVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.cv_user, parent, false);
        return new ListUserVH(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListUserVH holder, int position) {
        holder.tv_nama.setText(mData.get(position).nama);
        holder.tv_umur.setText(Integer.toString(mData.get(position).umur));
        holder.tv_gender.setText(mData.get(position).gender);

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}

class ListUserVH extends RecyclerView.ViewHolder{

    TextView tv_nama, tv_umur, tv_gender;

    public ListUserVH(View itemView){
        super(itemView);
        tv_nama = itemView.findViewById(R.id.tv_nama);
        tv_umur = itemView.findViewById(R.id.tv_umur);
        tv_gender = itemView.findViewById(R.id.tv_gender);
    }
}
