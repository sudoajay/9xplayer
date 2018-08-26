package com.sudoajay.a9xplayer.Custom_List_Adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.graphics.Palette;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.sudoajay.a9xplayer.GlideApp;
import com.sudoajay.a9xplayer.R;


public class Custom_Grid_View_Box extends BaseAdapter{
    private Context mContext;
    private String[] title,artist;
    private int[] coverId;

    public Custom_Grid_View_Box(Context c , String[] title , String[] artist ,int[] coverId ) {
        mContext = c;
        this.title = title;
        this.artist=artist;
        this.coverId =coverId;

    }


    @Override
    public int getCount() {
        return title.length;
    }

    @Override
    public Object getItem(int position) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public long getItemId(int position) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        View grid;
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {

            grid = new View(mContext);
            grid = inflater.inflate(R.layout.album_list_style, null);
            TextView grid_Title_Name =  grid.findViewById(R.id.grid_Title_Name);
            TextView grid_Artist_Name = grid.findViewById(R.id.grid_Artist_Name);
            ImageView grid_Cover = grid.findViewById(R.id.grid_Cover);
            ImageView grid_More = grid.findViewById(R.id.grid_More);
            final ImageView blur_Image_View = grid.findViewById(R.id.blur_Image_View);


            grid_Title_Name.setText(title[position]);
            grid_Artist_Name.setText(artist[position]);

           GlideApp.with(mContext).asBitmap().load(coverId[position]).into(grid_Cover);

            Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
                public void onGenerated(Palette palette) {
                    // access palette colors here

                    Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                    if(swatch != null)
                    blur_Image_View.setBackgroundColor(swatch.getRgb());

                }
            };

            Bitmap myBitmap = BitmapFactory.decodeResource(mContext.getResources(), coverId[position]);
            if (myBitmap != null && !myBitmap.isRecycled()) {
                Palette.from(myBitmap).generate(paletteListener);
            }


        } else {
            grid =  convertView;
        }

        return grid;
    }
}