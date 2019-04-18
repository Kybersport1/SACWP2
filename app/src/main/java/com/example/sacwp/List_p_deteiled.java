package com.example.sacwp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.sacwp.recycler_p_list.RecyclerItem_p;

import java.util.List;

public class List_p_deteiled extends AppCompatActivity {

    private TextView coments, city;
    private Button delete_btn;
    private List<RecyclerItem_p> list;

    public static final String ITEM_POSITION_KEY = "Item position key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_p_deteiled);

        list = App.getList();
        RecyclerItem_p item_p = list.get(getIntent().getIntExtra(ITEM_POSITION_KEY, -1));


        city = findViewById(R.id.city_text_view);
        coments = findViewById(R.id.coments_text_view);
        delete_btn = findViewById(R.id.delete_btn);

        city.setText(item_p.getCity());
        coments.setText(item_p.getComent());
        delete_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.getList().remove(getIntent().getIntExtra(ITEM_POSITION_KEY, -1));
                finish();
            }
        });

    }
}
