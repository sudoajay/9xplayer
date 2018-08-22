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
public class Music_Album_Page extends Fragment {
    private Context mContext;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    public Music_Album_Page() {
        // Required empty public constructor
    }
    public Music_Album_Page createInstance(Context mContext) {

        this.mContext= mContext;

        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.activtiy_music__album__page, container, false);
        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music();

        FastScrollRecyclerView recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        recyclerView.setAdapter(custom_list_adapter_for_music);
        recyclerView.setHasFixedSize(true);
        return view;
    }

}
