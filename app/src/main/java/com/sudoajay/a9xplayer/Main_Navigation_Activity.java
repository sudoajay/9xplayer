package com.sudoajay.a9xplayer;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Main_Navigation_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView_Tittle ;
    private Android_Permission_Required android_permission_required;
    private Grab_The_Data grab_the_music ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__navigation_);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab =  findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView =  findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        // all reference
        reference();

        //Get the storage permission
        Storage_Permission();

    }
    private void reference(){
        textView_Tittle = findViewById(R.id.textView_Title);

        // permission object created
        android_permission_required = new Android_Permission_Required(this,this);

        // grab The Data
        grab_the_music = new Grab_The_Data(this);




    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__navigation_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {

        // fragment institate
        Fragment fragment =new Music();

        // Handle navigation view item clicks here.
        int id = item.getItemId();
        setTitle("");
        if (id == R.id.nav_Home) {
            textView_Tittle.setText(R.string.home_title);
            fragment = new Home();
        } else if (id == R.id.nav_Music) {
            textView_Tittle.setText(R.string.music_title);
            fragment = new Music();
        } else if (id == R.id.nav_Video) {
            textView_Tittle.setText(R.string.video_title);
            fragment = new Video();
        } else if (id == R.id.nav_Folder) {
            textView_Tittle.setText(R.string.folder_title);
            fragment=new Folder();
        } else if (id == R.id.nav_Playlists) {
            textView_Tittle.setText(R.string.playlist_title);
            fragment = new Playlist();
        } else if (id == R.id.nav_Setting) {

        }else if (id == R.id.nav_Rate_Us) {

        }


        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_Layout, fragment);
            ft.commit();
        }

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Storage_Permission(){
        // storage permission check
        if(!android_permission_required.isExternalStorageWritable())
            android_permission_required.call_Thread();
    }
}
