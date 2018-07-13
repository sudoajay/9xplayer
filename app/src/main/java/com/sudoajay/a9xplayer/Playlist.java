package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Playlist extends Fragment {


    // global variable
    private TabLayout music_Tab_Layout;
    private ViewPager music_View_Pager;
    private Tab_Page_Adapter tab_page_adapter;
    private Playlist_Page music_playlist_page = new Playlist_Page();
    private Playlist_Page video_playlist_page = new Playlist_Page();


    public Playlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_music_, container, false);
        music_Tab_Layout =view.findViewById(R.id.music_Tab_Layout);
        music_View_Pager = view.findViewById(R.id.music_View_Pager);

        // fragments Page Adapter
        tab_page_adapter = new Tab_Page_Adapter(getChildFragmentManager());

        //add fragments
        Set_Fragemts();

        // add viewpager to fragments
        music_View_Pager.setAdapter(tab_page_adapter);

        // tablayout connect with viewpager
        music_Tab_Layout.setupWithViewPager(music_View_Pager);

        return view;


    }
    public void Set_Fragemts(){
        tab_page_adapter.addFragment("Song Playlist" , music_playlist_page);
        tab_page_adapter.addFragment("video Playlist" , video_playlist_page);

    }
}
