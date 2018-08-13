package com.sudoajay.a9xplayer;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Video_Song_Page extends Fragment {

    // private global variable
    private RecyclerView recycler_View;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;


    ArrayList<String> places = new ArrayList<>(Arrays.asList("Buenos Aires", "Córdoba", "La Plata"));

    ArrayList<String> places1 = new ArrayList<>(Arrays.asList("Buenos asdasd", "Cóasdasdrdoba", "Lasda Plata"));
    ArrayList<String> places2 = new ArrayList<>(Arrays.asList("125", "25", "352"));
    Bitmap largeIcon = BitmapFactory.decodeResource(getResources(), R.drawable.cover1);


    ArrayList<Bitmap> places3 = new ArrayList<>(Arrays.asList(largeIcon, largeIcon, largeIcon));

    int[] coverId = {
            R.drawable.cover1,
            R.drawable.cover2,
            R.drawable.cover1,
    };

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
        recycler_View = view.findViewById(R.id.recycler_View);

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(places,places1,places2,places3);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recycler_View.setLayoutManager(mLayoutManager);
        recycler_View.setItemAnimator(new DefaultItemAnimator());
        recycler_View.setAdapter(custom_list_adapter_for_music);
        


        return view;
    }

}
