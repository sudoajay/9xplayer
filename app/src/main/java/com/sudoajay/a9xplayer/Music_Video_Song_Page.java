package com.sudoajay.a9xplayer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Video_Song_Page extends Fragment {

    private NestedScrollView inside_Nested_Scroll_View;


    public Music_Video_Song_Page() {
        // Required empty public constructor
    }
    //
    public Music_Video_Song_Page createInstance() {

        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_music__songs__page, container, false);
        inside_Nested_Scroll_View = view.findViewById(R.id.inside_Nested_Scroll_View);
        


        return view;
    }

}
