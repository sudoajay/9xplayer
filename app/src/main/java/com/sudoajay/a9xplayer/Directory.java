package com.sudoajay.a9xplayer;


import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;


/**
 * A simple {@link Fragment} subclass.
 */
public class Directory extends Fragment {
    private TabLayout directory_Tab_Layout;
    private ViewPager directory_View_Pager;
    private Tab_Page_Adapter tab_page_adapter;
    private Directory_Music_Video_Page directory_Music_Page = new Directory_Music_Video_Page();
    private Directory_Music_Video_Page directory_Video_Page =new Directory_Music_Video_Page();


    public Directory() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        // clone the inflater using the ContextThemeWrapper
        View view = inflater.inflate(R.layout.activity_directory, container, false);

        directory_Tab_Layout =view.findViewById(R.id.directory_Tab_Layout);
        directory_View_Pager = view.findViewById(R.id.directory_View_Pager);

        // fragments Page Adapter
        tab_page_adapter = new Tab_Page_Adapter(getChildFragmentManager());

        //add fragments
        Set_Fragemts();

        // add viewpager to fragmentss
        directory_View_Pager.setAdapter(tab_page_adapter);

        // tablayout connect with viewpager
        directory_Tab_Layout.setupWithViewPager(directory_View_Pager);



        return view;


    }
    public void Set_Fragemts(){
        tab_page_adapter.addFragment("Music" ,directory_Music_Page);
        tab_page_adapter.addFragment("Video" , directory_Video_Page);


    }
}
