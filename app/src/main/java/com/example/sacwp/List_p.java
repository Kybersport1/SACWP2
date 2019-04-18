package com.example.sacwp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.sacwp.recycler_p_list.RecyclerAdapter_p;
import com.example.sacwp.recycler_p_list.RecyclerItem_p;

import java.util.List;

public class List_p extends AppCompatActivity implements RecyclerAdapter_p.ItemClicked {

    private RecyclerAdapter_p adapter;
    private RecyclerView recyclerView;

    public static final String ITEM_POSITION_KEY = "Item position key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_p);

        if (App.getList().isEmpty()){
            Intent inten = new Intent(this, List_p_add.class);
            startActivity(inten);
        }

        List<RecyclerItem_p> list = App.getList();
        recyclerView = findViewById(R.id.p_list_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecyclerAdapter_p(list, this);
        recyclerView.setAdapter(adapter);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(List_p.this, List_p_add.class);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.setList(App.getList());
    }

    @Override
    public void itemClickedCallback(int itemPosition) {
        Intent intent = new Intent(this, List_p_deteiled.class);
        intent.putExtra(ITEM_POSITION_KEY, itemPosition);
        startActivity(intent);
    }
}
