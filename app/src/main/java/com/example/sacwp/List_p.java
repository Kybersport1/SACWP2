package com.example.sacwp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.sacwp.recycler_p_list.RecyclerAdapter_p;
import com.example.sacwp.recycler_p_list.RecyclerItem_p;

import java.util.List;

public class List_p extends AppCompatActivity implements RecyclerAdapter_p.ItemClicked {

    RecyclerAdapter_p adapter;
    RecyclerView recyclerView;
    private static List<RecyclerItem_p> list;

    public static final String ITEM_POSITION_KEY = "Item position key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_p);

        list = SecondActivity.getList();

        recyclerView = findViewById(R.id.p_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter_p(list, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intent = new Intent(this, List_p_deteiled.class);
        intent.putExtra(ITEM_POSITION_KEY, itemPosition);
        startActivity(intent);
    }
}
