package com.sudoajay.a9xplayer;


import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
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
    private GridView grid,grid2;
    private Main_Navigation_Activity main_navigation_activity;
    String[] title = {
            "Ajay",
            "Vijay",
            "Maxo","Ajay",
            "Vijay",
            "Maxo","Ajay",
            "Vijay",
            "Maxo","Ajay",
            "Vijay",
            "Maxo","Ajay",
            "Vijay",
            "Maxo"} ;
    String[] artist = {
            "Ajayas",
            "Vijayasd",
            "Maxoasd","Ajayas",
            "Vijayasd",
            "Maxoasd","Ajayas",
            "Vijayasd",
            "Maxoasd","Ajayas",
            "Vijayasd",
            "Maxoasd","Ajayas",
            "Vijayasd",
            "Maxoasd"} ;
    int[] coverId = {
            R.drawable.click_something,
            R.drawable.home,
            R.drawable.folder,
            R.drawable.click_something,
            R.drawable.home,
            R.drawable.folder,
            R.drawable.click_something,
            R.drawable.home,
            R.drawable.folder,
            R.drawable.click_something,
            R.drawable.home,
            R.drawable.folder,
            R.drawable.click_something,
            R.drawable.home,
            R.drawable.folder
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
        if (Build.VERSION.SDK_INT >= 21) {
            main_navigation_activity.getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }



        // making notification bar transparent
        changeStatusBarColor();
        view = inflater.inflate(R.layout.activity_home, container, false);

        Custom_Grid_View_Box adapter = new Custom_Grid_View_Box(main_navigation_activity
        , title,artist,coverId);
//        grid = view.findViewById(R.id.grid);
//        grid.setAdapter(adapter);
//        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view,
//                                    int position, long id) {
//                Toast.makeText(main_navigation_activity, "You Clicked at " + position, Toast.LENGTH_SHORT).show();
//
//            }
//        });


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