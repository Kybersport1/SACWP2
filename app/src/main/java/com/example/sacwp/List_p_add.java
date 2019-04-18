package com.example.sacwp;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sacwp.recycler_p_list.RecyclerAdapter_p;
import com.example.sacwp.recycler_p_list.RecyclerItem_p;

import java.util.List;

public class List_p_add extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private ConstraintLayout view;
    public String isCityActive;
    private Button go;
    private EditText editCom;
    private EditText editTextCity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_p_add);
        view = findViewById(R.id.cons_drive);
        view.setBackgroundResource(R.drawable.drive);
        go = findViewById(R.id.button_drive);
        editCom = findViewById(R.id.editText_drive);
        editTextCity = findViewById(R.id.city);


//        Spinner spinner = (Spinner) findViewById(R.id.spinner);
//        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,R.array.cities_array, android.R.layout.simple_spinner_item);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//        spinner.setAdapter(adapter);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                List<RecyclerItem_p> list = App.getList();
//                list.add(new RecyclerItem_p(isCityActive, editCom.getText().toString()));
//                App.setList(list);
                App.getList().add(new RecyclerItem_p(editTextCity.getText().toString(), editCom.getText().toString()));

                finish();
            }
        });

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//        String text = parent.getItemAtPosition(position).toString();
//        if(text.equals("Винница")){
//            isCityActive = "Винница";
//            //Do it
//        }else if(text.equals("Киев")){
//            isCityActive = "Киев";
//            //Do it
//        }else if(text.equals("Херсон")){
//            isCityActive = "Херсон";
//            //Do it
//        }else if(text.equals("Миколаїв")){
//            isCityActive = "Миколаїв";
//            //Do it
//        }
//    }
    }
}
