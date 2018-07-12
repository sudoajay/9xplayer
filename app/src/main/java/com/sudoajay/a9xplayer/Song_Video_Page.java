package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Song_Video_Page extends Fragment {


    public Song_Video_Page() {
        // Required empty public constructor
    }
    //
    public Song_Video_Page createInstance() {

        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_music__songs__page, container, false);
    }

}
