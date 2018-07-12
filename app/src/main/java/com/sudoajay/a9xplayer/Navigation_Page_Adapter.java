package com.sudoajay.a9xplayer;

import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class Navigation_Page_Adapter extends FragmentPagerAdapter {
    private Home home = new Home();
    private Music music = new Music();
    private Video video = new Video();
    private Folder folder = new Folder();
    private Playlist playlist = new Playlist();
    private Bundle bundle ,bundles;

    public Navigation_Page_Adapter(FragmentManager fm){
        super(fm);

    }
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return home;
            case 1:
                return music;
            case 2:
                return video;
            case 3:
                return folder;
            case 4 :
                return playlist;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 5;
    }
    public CharSequence getPageTitle(int position){
        switch (position){
            case 0:
                return "Home";
            case 1:
                return "Music";
            case 2:
                return "Video";
            case 3:
                return "Folder";
            case 4:
                return "Playlist";
        }
        return null;
    }
}

