package com.example.vuatxoa_recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder>{
    private List<userObject> mUserObjects;

    public void setdata(List<userObject> list){
        this.mUserObjects=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_object,parent,false);
        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        userObject object=mUserObjects.get(position);

        if(mUserObjects==null){
            return;
        }
        holder.txtname.setText(object.getName());

    }

    @Override
    public int getItemCount() {
        if(mUserObjects!=null){
            return mUserObjects.size();
        }
        return 0;
    }

    public class userViewHolder extends RecyclerView.ViewHolder{
        private TextView txtname;
        public userViewHolder(@NonNull View itemView) {

            super(itemView);
        txtname=(TextView) itemView.findViewById(R.id.txtname);
        }
    }
}
