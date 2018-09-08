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
import java.util.HashMap;


public class Music_Artist_page  extends Fragment {
    private ArrayList<String> array_Music_Artist;
    private Context mContext;
    private ArrayList<Long>  array_Music_id;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    public Music_Artist_page() {
        // Required empty public constructor
    }
    //
    public Music_Artist_page createInstance(Context mContext, ArrayList<String> array_Music_Artist , ArrayList<Long>  array_Music_id) {
        this.array_Music_Artist = array_Music_Artist;
        this.array_Music_id = array_Music_id;
        this.mContext= mContext;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.activity_music_songs_page, container, false);

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,array_Music_Artist,array_Music_id,
                null,null,null,R.layout.style_music_song_list);

        FastScrollRecyclerView recyclerView = rootView.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(custom_list_adapter_for_music);
        recyclerView.setHasFixedSize(true);
        return rootView;    }
}