package com.sudoajay.a9xplayer;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
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
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

public class Main_Navigation_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView_Tittle ;
    private Android_Permission_Required android_permission_required;
    private Grab_The_Data grab_the_music ;
    private Fragment fragment ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (Build.VERSION.SDK_INT >= 21) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
        }
        setContentView(R.layout.activity_main__navigation_);
        changeStatusBarColor();
        Toolbar toolbar =  findViewById(R.id.main_toolbar);
        setSupportActionBar(toolbar);



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

        // Default Fragment
        Home home = new Home();
        fragment =home.createInstance(this);
        Replace_Fragments();

    }

    private void reference(){
     //   textView_Tittle = findViewById(R.id.textView_Title);

        // permission object created
        android_permission_required = new Android_Permission_Required(this,this);

        // grab The Data
        grab_the_music = new Grab_The_Data(this);
    }

    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
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



        // Handle navigation view item clicks here.
        int id = item.getItemId();
        setTitle("");
        if (id == R.id.nav_Home) {
   //         textView_Tittle.setText(R.string.home_title);
           Home home = new Home();
            fragment =home.createInstance(this);
        } else if (id == R.id.nav_Music) {
   //         textView_Tittle.setText(R.string.music_title);
            fragment = new Music();
        } else if (id == R.id.nav_Video) {
   //         textView_Tittle.setText(R.string.video_title);
            fragment = new Video();
        } else if (id == R.id.nav_Folder) {
   //         textView_Tittle.setText(R.string.directories_title);
            fragment=new Folder();
        } else if (id == R.id.nav_Playlists) {
   //         textView_Tittle.setText(R.string.playlist_title);
            fragment = new Playlist();
        } else if (id == R.id.nav_Setting) {

        }else if (id == R.id.nav_Rate_Us) {

        }


        Replace_Fragments();

        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Storage_Permission(){
        // storage permission check
        if(!android_permission_required.isExternalStorageWritable())
            android_permission_required.call_Thread();
    }

    // Replace Fragments
    public void Replace_Fragments(){

        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.frame_Layout, fragment);
            ft.commit();
        }
    }
}
