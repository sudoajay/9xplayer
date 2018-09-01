package com.sudoajay.a9xplayer.Custom_List_Adapter;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sudoajay.a9xplayer.GlideApp;
import com.sudoajay.a9xplayer.Grab_The_Cover;
import com.sudoajay.a9xplayer.R;

public class Custom_Grid_View_Box extends RecyclerView.Adapter<Custom_Grid_View_Box.ViewHolder> {
    private Activity activity;
    private String[] title, artist;
    private int[] coverId;

public Custom_Grid_View_Box(Activity activity, String[] title, String[] artist, int[] coverId) {
        this.activity = activity;
        this.title = title;
        this.artist = artist;
        this.coverId = coverId;
        }

@Override
public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.style_home_glide, viewGroup, false);

        return new ViewHolder(view);
        }

@Override
public void onBindViewHolder(@NonNull final Custom_Grid_View_Box.ViewHolder viewHolder, int position) {

    Grab_The_Cover grab_the_cover = new Grab_The_Cover(activity);

    viewHolder.grid_Title_Name.setText(title[position]);
    viewHolder.grid_Artist_Name.setText(artist[position]);


    Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
        public void onGenerated(Palette palette) {
            // access palette colors here

            Palette.Swatch swatch = palette.getVibrantSwatch();
            if (swatch != null)
                viewHolder.blur_Image_View.setBackgroundColor(swatch.getRgb());

        }
    };

    Bitmap myBitmap = BitmapFactory.decodeResource(activity.getResources(), coverId[position]);
    if (myBitmap != null && !myBitmap.isRecycled()) {
        Palette.from(myBitmap).generate(paletteListener);
    }

    // Here is glide Working
    GlideApp.with(activity).asBitmap().load(grab_the_cover.getResizedBitmap(myBitmap, 500)).into(viewHolder.grid_Cover);
        }

@Override
public int getItemCount() {
        return title.length;
        }

/**
 * View holder to display each RecylerView item
 */
protected class ViewHolder extends RecyclerView.ViewHolder {
     TextView grid_Title_Name,grid_Artist_Name;
     ImageView grid_Cover,grid_More,blur_Image_View;
    public ViewHolder(View grid) {
        super(grid);
         grid_Title_Name = grid.findViewById(R.id.grid_Title_Name);
         grid_Artist_Name = grid.findViewById(R.id.grid_Artist_Name);
         grid_Cover = grid.findViewById(R.id.grid_Cover);
         grid_More = grid.findViewById(R.id.grid_More);
          blur_Image_View = grid.findViewById(R.id.blur_Image_View);
    }
}
}
