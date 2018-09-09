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


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Playlist extends Fragment {


    // global variable
    private Context mContext;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;


    public Music_Playlist() {
        // Required empty public constructor
    }

    public Music_Playlist createInstance(Context mContext) {

        this.mContext= mContext;
        return this;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_music_playlist, container, false);

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,null,null,
                null,null,null,R.layout.style_music_song_list,null);

        final FastScrollRecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(custom_list_adapter_for_music);
        recyclerView.setHasFixedSize(true);
        return view;


    }

}
