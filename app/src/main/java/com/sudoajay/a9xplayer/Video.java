package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * A simple {@link Fragment} subclass.
 */
public class Video extends Fragment {

    // Global variable
    private TabLayout music_Tab_Layout;
    private ViewPager music_View_Pager;
    private Tab_Page_Adapter tab_page_adapter;
    private Music_Video_Song_Page songVideo_page = new Music_Video_Song_Page();
    private Music_Video_Playlist_Page music_Video_playlist_page = new Music_Video_Playlist_Page();
    private Main_Navigation_Activity main_navigation_activity;
    private ArrayList<String> array_Music_Artist_Name,array_Music_Timing, array_Music_Album_Name;
    private ArrayList<Long>   array_Music_id;
    private HashMap<Integer , String> array_Music_Title;

    public Video() {
        // Required empty public constructor
    }
    public Video createInstance(Main_Navigation_Activity main_navigation_activity, ArrayList<String> array_Music_Artist_Name,
                               ArrayList<Long>   array_Music_id, ArrayList<String> array_Music_Timing, HashMap<Integer ,
            String> array_Music_Title, ArrayList<String> array_Music_Album_Name) {
        this.main_navigation_activity = main_navigation_activity;
        this.array_Music_Timing = array_Music_Timing ;
        this.array_Music_Artist_Name = array_Music_Artist_Name;
        this.array_Music_id = array_Music_id;
        this.array_Music_Title = array_Music_Title;
        this.array_Music_Album_Name = array_Music_Album_Name;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_video, container, false);
        music_Tab_Layout =view.findViewById(R.id.video_Tab_Layout);
        music_View_Pager = view.findViewById(R.id.video_View_Pager);

        // fragments Page Adapter
        tab_page_adapter = new Tab_Page_Adapter(getChildFragmentManager());

        //add fragments
        Set_Fragemts();

        // add viewpager to fragmentss
        music_View_Pager.setAdapter(tab_page_adapter);

        // tablayout connect with viewpager
        music_Tab_Layout.setupWithViewPager(music_View_Pager);

        return view;

    }
    public void Set_Fragemts(){
        tab_page_adapter.addFragment("Video" , songVideo_page.createInstance(main_navigation_activity,array_Music_Artist_Name,array_Music_id,
                array_Music_Timing,array_Music_Title));
        tab_page_adapter.addFragment("Playlist" , music_Video_playlist_page.createInstance(main_navigation_activity) );

    }

}
