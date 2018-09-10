package com.sudoajay.a9xplayer.Playlist;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.sudoajay.a9xplayer.Directory.Directory_Music_Video_Page;
import com.sudoajay.a9xplayer.Directory.Directory_Page;
import com.sudoajay.a9xplayer.Main_Navigation_Activity;
import com.sudoajay.a9xplayer.R;
import com.sudoajay.a9xplayer.Tab_Page_Adapter;


/**
 * A simple {@link Fragment} subclass.
 */
public class Playlist_Page extends Fragment {
    private TabLayout playlist_Tab_Layout;
    private ViewPager playlist_View_Pager;
    private Tab_Page_Adapter tab_page_adapter;
    private Playlist_Music_Video_Page playlist_Music_Page = new Playlist_Music_Video_Page();
    private Playlist_Music_Video_Page playlidt_Video_Page =new Playlist_Music_Video_Page();
    private Main_Navigation_Activity main_navigation_activity;


    public Playlist_Page() {
        // Required empty public constructor
    }

    public Playlist_Page createInstance(Main_Navigation_Activity main_navigation_activity) {
        this.main_navigation_activity = main_navigation_activity;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = main_navigation_activity.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimary));
        }
        // clone the inflater using the ContextThemeWrapper
        View view = inflater.inflate(R.layout.activity_playlist_page, container, false);

        playlist_Tab_Layout =view.findViewById(R.id.playlist_Tab_Layout);
        playlist_View_Pager = view.findViewById(R.id.playlist_View_Pager);

        // fragments Page Adapter
        tab_page_adapter = new Tab_Page_Adapter(getChildFragmentManager());

        //add fragments
        Set_Fragemts();

        // add viewpager to fragmentss
        playlist_View_Pager.setAdapter(tab_page_adapter);

        // tablayout connect with viewpager
        playlist_Tab_Layout.setupWithViewPager(playlist_View_Pager);



        return view;


    }
    public void Set_Fragemts(){
        tab_page_adapter.addFragment("Music" ,playlist_Music_Page);
        tab_page_adapter.addFragment("Video" , playlidt_Video_Page);


    }
}
