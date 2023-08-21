package com.example.vuatxoa_recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rcvitem;
    private List<userObject> mList;
    private userAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rcvitem=(RecyclerView) findViewById(R.id.rcvitem);

        mAdapter=new userAdapter();

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
        rcvitem.setLayoutManager(linearLayoutManager);

        mList=getdata();
        mAdapter.setdata(mList);
        rcvitem.setAdapter(mAdapter);

        RecyclerView.ItemDecoration itemDecoration=new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
        rcvitem.addItemDecoration(itemDecoration);


        ItemTouchHelper helper=new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

                int position= viewHolder.getAdapterPosition();
                mList.remove(position);
                mAdapter.notifyDataSetChanged();

            }
        });
        helper.attachToRecyclerView(rcvitem);

    }

    private List<userObject> getdata() {

        List<userObject> list=new ArrayList<>();

        for(int i=0;i<=10;i++){
            list.add(new userObject("item"+i));

        }
        return list;
    }
}