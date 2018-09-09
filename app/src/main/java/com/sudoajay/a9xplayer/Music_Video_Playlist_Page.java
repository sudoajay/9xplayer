package com.sudoajay.a9xplayer;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.sudoajay.a9xplayer.Custom_List_Adapter.Custom_List_Adapter_For_Music;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Video_Playlist_Page extends Fragment {


    // global variable
    private Context mContext;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    private ArrayList<String> array_Playlist;

    public Music_Video_Playlist_Page() {
        // Required empty public constructor
    }

    public Music_Video_Playlist_Page createInstance(Context mContext) {

        this.mContext= mContext;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_music_playlist, container, false);

        array_Playlist = new ArrayList();
        array_Playlist.add("Favorites");
        array_Playlist.add("Recently Played");
        array_Playlist.add("Recently Played");
        array_Playlist.add("Most Played" );
        array_Playlist.add("Newly Added");

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,null,null,
                null,null,null,R.layout.style_music_song_list,array_Playlist);

        final FastScrollRecyclerView fastScrollRecyclerView = view.findViewById(R.id.fastScrollRecyclerView);
        fastScrollRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        fastScrollRecyclerView.setAdapter(custom_list_adapter_for_music);
        fastScrollRecyclerView.setHasFixedSize(true);
        return view;


    }

}
