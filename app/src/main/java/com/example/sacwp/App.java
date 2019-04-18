package com.example.sacwp;

import android.app.Application;

import com.example.sacwp.recycler_p_list.RecyclerItem_p;

import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private static List<RecyclerItem_p> list = new ArrayList<>();

    public static List<RecyclerItem_p> getList() {
        return list;
    }
}
