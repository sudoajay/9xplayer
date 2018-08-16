package com.sudoajay.a9xplayer;


import android.app.ListActivity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.simplecityapps.recyclerview_fastscroll.views.FastScrollRecyclerView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Music_Video_Song_Page extends Fragment {

    // private global variable
    private RecyclerView recycler_View;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    private ArrayList<String> array_Music_Artist,array_Music_Timing;
    private HashMap<Integer , String> array_Music_Title;
    private ArrayList<Long>   array_Music_id;
    private Context mContext;


    public Music_Video_Song_Page() {
        // Required empty public constructor
    }
    //
    public Music_Video_Song_Page createInstance(Context mContext,ArrayList<String> array_Music_Artist,ArrayList<Long>  array_Music_id,
                                                ArrayList<String> array_Music_Timing, HashMap<Integer , String> array_Music_Title) {
        this.array_Music_Artist = array_Music_Artist;
        this.mContext= mContext;
        this.array_Music_id = array_Music_id;
        this.array_Music_Timing =array_Music_Timing;
        this.array_Music_Title = array_Music_Title;
        return this;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.activity_music__songs__page, container, false);

        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,array_Music_Artist,array_Music_id,
                array_Music_Timing,array_Music_Title);

        FastScrollRecyclerView recyclerView = view.findViewById(R.id.recycler_View);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(custom_list_adapter_for_music);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(getResources().getDrawable(R.drawable.recycler_list_view_divider));
        recyclerView.addItemDecoration(itemDecoration);


        return view;
    }

}
