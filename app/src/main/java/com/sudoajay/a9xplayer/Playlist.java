package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.l4digital.fastscroll.FastScrollRecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Playlist extends Fragment {


    // global variable
    private FastScrollRecyclerView fastScrollRecyclerView ;


    public Playlist() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_playlist, container, false);

        return view;


    }

}
