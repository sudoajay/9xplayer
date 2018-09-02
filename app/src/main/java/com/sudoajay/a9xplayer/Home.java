package com.sudoajay.a9xplayer;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.sudoajay.a9xplayer.Custom_List_Adapter.Custom_Grid_View_Box;

public class Home extends Fragment {

    private View view;
    private RecyclerView grid_View2,grid_View3;
    private Main_Navigation_Activity main_navigation_activity;
    private NestedScrollView inside_Nested_Scroll_View;
    private int spacingInPixels = 5;
    String[] title = {
            "Ajay",
            "Vijay",
            "Maxo",
            "Ajay",
            "Vijay",
            "Maxo"} ;
    String[] artist = {
            "Ajayas",
            "Vijayasd",
            "Maxoasd","Ajayas",
            "Vijayasd",
            "Maxoasd"} ;
    int[] coverId = {
            R.drawable.cover1,
            R.drawable.cover2,
            R.drawable.cover1,
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
        inside_Nested_Scroll_View.setNestedScrollingEnabled(true);

        grid_View2 =  view.findViewById(R.id.grid_View2);
        grid_View2.setHasFixedSize(true);
        grid_View2.setNestedScrollingEnabled(false);
        grid_View2.addItemDecoration(new Spaces_Item_Decoration_Glide(spacingInPixels));

        GridLayoutManager layoutManager = new GridLayoutManager(main_navigation_activity, 3);
        grid_View2.setLayoutManager(layoutManager);
        Custom_Grid_View_Box custom_gridViewBox = new Custom_Grid_View_Box(main_navigation_activity
                , title,artist,coverId);
        grid_View2.setAdapter(custom_gridViewBox);


        grid_View3 =  view.findViewById(R.id.grid_View3);
        grid_View3.setHasFixedSize(true);
        grid_View3.setNestedScrollingEnabled(false);
        grid_View3.addItemDecoration(new Spaces_Item_Decoration_Glide(spacingInPixels));
        GridLayoutManager layoutManager2 = new GridLayoutManager(main_navigation_activity, 3);
        grid_View3.setLayoutManager(layoutManager2);
        Custom_Grid_View_Box custom_gridViewBox2 = new Custom_Grid_View_Box(main_navigation_activity
                , title,artist,coverId);
        grid_View3.setAdapter(custom_gridViewBox2);

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