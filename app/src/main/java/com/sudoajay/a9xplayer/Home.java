package com.sudoajay.a9xplayer;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class Home extends Fragment {

    private View view;
    private GridView grid_View2,grid_View3;
    private Main_Navigation_Activity main_navigation_activity;
    private NestedScrollView inside_Nested_Scroll_View;
    String[] title = {
            "Ajay",
            "Vijay",
            "Maxo"} ;
    String[] artist = {
            "Ajayas",
            "Vijayasd",
            "Maxoasd"} ;
    int[] coverId = {
            R.drawable.cover1,
            R.drawable.cover2,
            R.drawable.cover1,
    };

    public Home() {
        // Required empty public constructor
    }

    public Home createInstance(Main_Navigation_Activity main_navigation_activity  ) {
        this.main_navigation_activity = main_navigation_activity;
        return this;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment




        // making notification bar transparent

        view = inflater.inflate(R.layout.activity_home, container, false);
        changeStatusBarColor();
        inside_Nested_Scroll_View = view.findViewById(R.id.inside_Nested_Scroll_View);
        inside_Nested_Scroll_View.setNestedScrollingEnabled(false);

        Custom_Grid_View_Box adapter = new Custom_Grid_View_Box(main_navigation_activity
        , title,artist,coverId);
        grid_View2 = view.findViewById(R.id.grid_View2);
        grid_View2.setAdapter(adapter);
        grid_View2.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(main_navigation_activity, "You Clicked at " + position, Toast.LENGTH_SHORT).show();

            }
        });
        Custom_Grid_View_Box adapters = new Custom_Grid_View_Box(main_navigation_activity
                , title,artist,coverId);
        grid_View3 = view.findViewById(R.id.grid_View3);
        grid_View3.setAdapter(adapters);
        grid_View3.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                Toast.makeText(main_navigation_activity, "You Clicked at " + position, Toast.LENGTH_SHORT).show();

            }
        });

        return view;
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = main_navigation_activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }
}