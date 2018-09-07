package com.sudoajay.a9xplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.ImageView;

import com.l4digital.fastscroll.FastScrollRecyclerView;
import com.sudoajay.a9xplayer.Custom_List_Adapter.Custom_List_Adapter_For_Music;

import java.util.Objects;

public class Album_Page extends AppCompatActivity {

    private Long long_Bitmap =null;
    private Grab_The_Cover grab_the_cover;
    private ImageView main_backdrop_image;
    private Custom_List_Adapter_For_Music custom_list_adapter_for_music;
    private String album_Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_page);

        // Transfer Data
        if(Objects.requireNonNull(getIntent().getExtras()).getLong("Cover_Send") != 0 &&
                getIntent().getExtras().getString("Album_Name_Send") != null) {
            long_Bitmap = getIntent().getExtras().getLong("Cover_Send");
            album_Name = getIntent().getExtras().getString("Album_Name_Send");
        }
        // refrence
      //  Refrence();

        // set image bitmap in at background of app
        main_backdrop_image.setImageBitmap(grab_the_cover.Get_Audio_Album_Image_ContentUri(long_Bitmap , 700));


    }
    private void Refrence(){
        main_backdrop_image = findViewById(R.id.main_backdrop_image);

        grab_the_cover = new Grab_The_Cover(this);
//
//        custom_list_adapter_for_music = new Custom_List_Adapter_For_Music(mContext,array_Music_Artist,array_Music_id,
//                array_Music_Timing,array_Music_Title,R.layout.style_music_song_list);
//
//        FastScrollRecyclerView recyclerView = findViewById(R.id.recycler_view);
//        recyclerView.setLayoutManager(new LinearLayoutManager(mContext));
//        recyclerView.setAdapter(custom_list_adapter_for_music);
//        recyclerView.setHasFixedSize(true);
    }
}
