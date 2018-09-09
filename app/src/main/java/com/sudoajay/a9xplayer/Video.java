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
public class Video extends Fragment {

    // Global variable
    private TabLayout music_Tab_Layout;
    private ViewPager music_View_Pager;
    private Tab_Page_Adapter tab_page_adapter;
    private Music_Video_Song_Page songVideo_page = new Music_Video_Song_Page();
    private Playlist_Page music_playlist_page = new Playlist_Page();

    public Video() {
        // Required empty public constructor
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
        tab_page_adapter.addFragment("Video" , songVideo_page);
        tab_page_adapter.addFragment("Music_Playlist" , music_playlist_page);

    }

}
