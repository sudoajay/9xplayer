package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.io.File;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Songs_Page extends Fragment {


    public Music_Songs_Page() {
        // Required empty public constructor
    }
    //
    public  Music_Songs_Page createInstance() {

        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.activity_music__songs__page, container, false);
    }

}
