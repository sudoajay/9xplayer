package com.sudoajay.a9xplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Album_Page extends AppCompatActivity {

    private Long long_Bitmap =null;
    private Grab_The_Cover grab_the_cover;
    private ImageView main_backdrop_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_page);

        // Transfer Data
        if(getIntent().getExtras().get("Cover_Send") != null)
            long_Bitmap= getIntent().getExtras().getLong("Cover_Send");

        // refrence
        Refrence();

        main_backdrop_image.setImageBitmap(grab_the_cover.Get_Audio_Album_Image_ContentUri(long_Bitmap , 500));


    }
    private void Refrence(){
        main_backdrop_image = findViewById(R.id.main_backdrop_image);


        grab_the_cover = new Grab_The_Cover(this);
    }
}
