package com.sudoajay.a9xplayer;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.sudoajay.a9xplayer.Custom_List_Adapter.Custom_Grid_View_Box;


public class Main_Navigation_Activity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView_Tittle;
    private Android_Permission_Required android_permission_required;
    private Grab_The_Data grab_the_music;
    private Fragment fragment;
    private AppBarLayout main_AppbarLayout;
    private Toolbar main_toolbar;
    private CollapsingToolbarLayout main_collapsing;
    private ImageView main_Back_Image;
    private NestedScrollView nested_Scroll_View;
    private Button more_Button;
    private TextView text_Heading;
    private RecyclerView grid_View;
    private ConstraintLayout inside_Constraint_layout;
    String[] title = {
            "Selfie",
            "Vijay",
            "Maxo"} ;
    String[] artist = {
            "Chainssmok3",
            "Vijayasd",
            "Maxoasd"} ;
    int[] coverId = {
            R.drawable.cover1,
            R.drawable.cover2,
            R.drawable.cover1,

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Checking for first time launch - before calling setContentView()


        setContentView(R.layout.activity_main_navigation_);


        // making notification bar transparent
        changeStatusBarColor();



        main_toolbar = findViewById(R.id.main_toolbar);
        setSupportActionBar(main_toolbar);


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                Main_Navigation_Activity.this, drawer, main_toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //Get the storage permission
        Storage_Permission();

        // all reference
        reference();



       //  Default Fragment
        Home home = new Home();
        fragment =home.createInstance(Main_Navigation_Activity.this);
        Replace_Fragments();

           // Detect When the CollapsingToolbar is collapsed
        AppBarLayout appBarLayout = findViewById(R.id.main_appbar);
                appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if (Math.abs(verticalOffset) == appBarLayout.getTotalScrollRange()) {
                    // Collapsed

                    ViewGroup.LayoutParams params = main_toolbar.getLayoutParams();
                    CollapsingToolbarLayout.LayoutParams newParams;
                    if (params instanceof CollapsingToolbarLayout.LayoutParams) {
                        newParams = (CollapsingToolbarLayout.LayoutParams)params;
                    } else {
                        newParams = new CollapsingToolbarLayout.LayoutParams(params);
                    }
                    newParams.setCollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PIN);
                    main_toolbar.setLayoutParams(newParams);
                    main_toolbar.requestLayout();
                    main_collapsing.setContentScrimColor(getResources().getColor(R.color.colorPrimary));
                } else if (verticalOffset == 0) {
                    // Expanded

                    ViewGroup.LayoutParams params = main_toolbar.getLayoutParams();
                    CollapsingToolbarLayout.LayoutParams newParams;
                    if (params instanceof CollapsingToolbarLayout.LayoutParams) {
                        newParams = (CollapsingToolbarLayout.LayoutParams)params;
                    } else {
                        newParams = new CollapsingToolbarLayout.LayoutParams(params);
                    }
                    newParams.setCollapseMode(CollapsingToolbarLayout.LayoutParams.COLLAPSE_MODE_PARALLAX);
                    main_toolbar.setLayoutParams(newParams);
                    main_toolbar.requestLayout();
                    main_collapsing.setContentScrimColor(Color.TRANSPARENT);
                } else {
                    // Somewhere in between and far

                }
            }
        });

        // create Grid view soo boxes appear in grid view
        Create_Grid_View();

    }


    /**
     * Making notification bar transparent
     */
    private void changeStatusBarColor() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
        }
    }


        public void onBackPressed() {
            DrawerLayout drawer =   findViewById(R.id.drawer_layout);
            if (drawer.isDrawerOpen(GravityCompat.START)) {
                drawer.closeDrawer(GravityCompat.START);
            } else {
                super.onBackPressed();
            }
        }


        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.main__navigation_, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            return super.onOptionsItemSelected(item);
        }
        private void reference() {
            textView_Tittle = findViewById(R.id.textView_Title);
            main_collapsing =findViewById(R.id.main_collapsing);
            main_AppbarLayout = findViewById(R.id.main_appbar);
            main_Back_Image = findViewById(R.id.main_Back_Image);
            nested_Scroll_View=findViewById(R.id.nested_Scroll_View);
            grid_View =findViewById(R.id.grid_View);
            more_Button = findViewById(R.id.more_Button);
            text_Heading=findViewById(R.id.text_Heading);
            inside_Constraint_layout = findViewById(R.id.inside_Constraint_layout);


            // grab The Data
            if(android_permission_required.isExternalStorageWritable())
            grab_the_music = new Grab_The_Data(this);

        }
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_Home) {
            textView_Tittle.setText(R.string.home_title);
            Home home = new Home();
            fragment =home.createInstance(Main_Navigation_Activity.this);
            Turn_Of_On(true);
            main_toolbar.setBackgroundColor(Color.TRANSPARENT);
            nested_Scroll_View.setNestedScrollingEnabled(true);
        } else if (id == R.id.nav_Music) {
               textView_Tittle.setText(R.string.music_title);
               Music music = new Music();
               Turn_Of_On(false);
               fragment = music.createInstance(Main_Navigation_Activity.this,
                       grab_the_music.getArray_Music_Artist(), grab_the_music.getArray_Music_id(),
                       grab_the_music.getArray_Music_Timing(), grab_the_music.getArray_Music_Title(),
                       grab_the_music.getArray_Music_Album_Name());
               main_toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
               nested_Scroll_View.setNestedScrollingEnabled(false);
        } else if (id == R.id.nav_Video) {
                textView_Tittle.setText(R.string.video_title);
                fragment = new Video();
                Turn_Of_On(false);
                main_toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
                nested_Scroll_View.setNestedScrollingEnabled(false);
        } else if (id == R.id.nav_Folder) {
                textView_Tittle.setText(R.string.directories_title);
                fragment=new Folder();
        } else if (id == R.id.nav_Playlists) {
                fragment = new Music_Video_Playlist_Page();

        } else if (id == R.id.nav_Setting) {

        }else if (id == R.id.nav_Rate_Us) {

        }


        Replace_Fragments();
        DrawerLayout drawer =  findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
    public void Storage_Permission(){

        // permission object created
        android_permission_required = new Android_Permission_Required(this, this);
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


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public void Create_Grid_View(){


        grid_View.setHasFixedSize(true);
        int spacingInPixels = 5;
        grid_View.addItemDecoration(new Spaces_Item_Decoration_Glide(spacingInPixels));

        GridLayoutManager layoutManager = new GridLayoutManager(this, 3);
        grid_View.setLayoutManager(layoutManager);
        Custom_Grid_View_Box custom_gridViewBox = new Custom_Grid_View_Box(this
                , title,artist,coverId);
        grid_View.setAdapter(custom_gridViewBox);
    }
    // turn off and on all element of Collopslayout
    private void Turn_Of_On(boolean visible){
        if(visible){
            main_Back_Image.setVisibility(View.VISIBLE);
            grid_View.setVisibility(View.VISIBLE);
            text_Heading.setVisibility(View.VISIBLE);
            more_Button.setVisibility(View.VISIBLE);
            inside_Constraint_layout.setVisibility(View.VISIBLE);
        }else{
            main_Back_Image.setVisibility(View.GONE);
            grid_View.setVisibility(View.GONE);
            text_Heading.setVisibility(View.GONE);
            more_Button.setVisibility(View.GONE);
            inside_Constraint_layout.setVisibility(View.GONE);
        }
    }


}