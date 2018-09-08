package com.sudoajay.a9xplayer.Custom_List_Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.TextView;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.l4digital.fastscroll.FastScroller;
import com.sudoajay.a9xplayer.Album_Page;

import com.sudoajay.a9xplayer.GlideApp;
import com.sudoajay.a9xplayer.Grab_The_Cover;
import com.sudoajay.a9xplayer.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by sudoajay on 12/23/17.
 */

public class Custom_List_Adapter_For_Music extends RecyclerView.Adapter<Custom_List_Adapter_For_Music.ViewHolder> implements FastScroller.SectionIndexer {

    // private globall variable
    private ArrayList<String> array_Music_Artist, array_Music_Timing,array_Music_Album_Name;
    private HashMap<Integer, String> array_Music_Title ;
    private Grab_The_Cover grab_the_cover;
    private Context mContext;
    private ArrayList<Long> array_Music_id;
    private List<String> list;
    private int layout_Style;

    // Provide a suitable constructor (depends on the kind of dataset)
    public Custom_List_Adapter_For_Music(Context mContext, ArrayList<String> array_Music_Artist, ArrayList<Long> array_Music_id,
                                         ArrayList<String> array_Music_Timing, HashMap<Integer, String> array_Music_Title,
                                             ArrayList<String> array_Music_Album_Name, int layout_Style) {
        this.mContext = mContext;
        this.layout_Style = layout_Style;
        this.array_Music_id = array_Music_id;
        if(layout_Style == R.layout.style_music_song_list) {
            this.array_Music_Artist = array_Music_Artist;
            this.array_Music_Title = array_Music_Title;
            this.array_Music_Timing = array_Music_Timing;
            if (array_Music_Title != null) list = new ArrayList<>(array_Music_Title.values());
        }else {
            this.array_Music_Album_Name = array_Music_Album_Name;
        }
    }

    @Override
    public String getSectionText(int position) {

        return First_Text(list.get(position).substring(0, 1));
    }

    // getSelectionText
    //First Digit Cheeck
    private String First_Text(String first_Text) {
        // if is it Alpha Then Go Below Code
        if (first_Text.matches("[a-zA-Z]"))
            return String.valueOf(Character.toUpperCase(first_Text.charAt(0)));
        // if Thats Not Alpha
        return "#";
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView text_Title, text_Artist, text_Timing, grid_Album_Name,grid_Count_Album_Songs;
        private ImageView cover,grid_Cover,grid_More,blur_Image_View;

        ViewHolder(View itemView) {
            super(itemView);
            if(layout_Style == R.layout.style_music_song_list) {
                text_Title = itemView.findViewById(R.id.text_Title);
                text_Artist = itemView.findViewById(R.id.text_Artist);
                text_Timing = itemView.findViewById(R.id.text_Timing);
                cover = itemView.findViewById(R.id.cover);
            }else{
                 grid_Album_Name =  itemView.findViewById(R.id.grid_Title_Name);
                grid_Count_Album_Songs = itemView.findViewById(R.id.grid_Artist_Name);
                 grid_Cover = itemView.findViewById(R.id.grid_Cover);
                 grid_More = itemView.findViewById(R.id.grid_More);
                 blur_Image_View = itemView.findViewById(R.id.blur_Image_View);
            }
        }
    }

    public void add(int position, String item) {
        array_Music_Artist.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        array_Music_Artist.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)


    // Create new views (invoked by the layout manager)
    @Override
    public Custom_List_Adapter_For_Music.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        // create a new view
        LayoutInflater inflater = LayoutInflater.from(
                parent.getContext());
        View v =
                inflater.inflate(layout_Style, parent, false);
        // set the view's size, margins, paddings and layout parameters

        return new ViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @SuppressLint("StaticFieldLeak")
    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element


        grab_the_cover = new Grab_The_Cover(mContext);
        if(layout_Style == R.layout.style_music_song_list) {

            holder.text_Title.setText(list.get(position));
            holder.text_Artist.setText(array_Music_Artist.get(position));
            holder.text_Timing.setText(array_Music_Timing.get(position));
            new AsyncTask<ViewHolder, Void, Bitmap>() {
                private ViewHolder holder;

                @Override
                protected Bitmap doInBackground(ViewHolder... params) {
                    holder = params[0];

                    return grab_the_cover.Get_Audio_Album_Image_ContentUri
                            (array_Music_id.get(position),100);
                }

                @Override
                protected void onPostExecute(Bitmap result) {
                    super.onPostExecute(result);
                    // If this item hasn't been recycled already, hide the
                    // progress and set and show the image
                    GlideApp.with(mContext)
                            .asBitmap()
                            .load(doInBackground(holder))
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .fallback(R.drawable.default_song_cover_small)
                            .error(R.drawable.default_song_cover_small)
                            .into(holder.cover);
                }
            }.execute(holder);
        }else{

            holder.grid_Album_Name.setText(array_Music_Album_Name.get(position));
            holder.grid_Count_Album_Songs.setText("2 Song");

            new AsyncTask<ViewHolder, Void, Bitmap>() {
                private ViewHolder holder;

                @Override
                protected Bitmap doInBackground(ViewHolder... params) {
                    holder = params[0];

                    return grab_the_cover.Get_Audio_Album_Image_ContentUri
                            (array_Music_id.get(position), 300);
                }

                @Override
                protected void onPostExecute(Bitmap result) {
                    super.onPostExecute(result);
                    // If this item hasn't been recycled already, hide the
                    // progress and set and show the image

                    GlideApp.with(mContext)
                            .asBitmap()
                            .load(doInBackground(holder))
                            .skipMemoryCache(true)
                            .diskCacheStrategy(DiskCacheStrategy.NONE)
                            .fallback(R.drawable.default_song_cover_large)
                            .into(holder.grid_Cover);
                }
            }.execute(holder);

            Palette.PaletteAsyncListener paletteListener = new Palette.PaletteAsyncListener() {
                public void onGenerated(Palette palette) {
                    // access palette colors here

                    Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                    if(swatch != null)
                        holder.blur_Image_View.setBackgroundColor(swatch.getRgb());

                }
            };

            Bitmap myBitmap =  grab_the_cover.Get_Audio_Album_Image_ContentUri(array_Music_id.get(position),100);
            // bitmap fown mean cover is there
            if (myBitmap != null && !myBitmap.isRecycled()) {
                Palette.from(myBitmap).generate(paletteListener);
            }else{
             // bitmap not faound default cover
                myBitmap = BitmapFactory.decodeResource(mContext.getResources(),R.drawable.default_song_cover_large);
                myBitmap= grab_the_cover.getResizedBitmap(myBitmap,100);
                Palette.from(myBitmap).generate(paletteListener);
            }

            holder.grid_Cover.setOnClickListener(new On_Click(position));
            holder.grid_Album_Name.setOnClickListener(new On_Click(position));
            holder.grid_Count_Album_Songs.setOnClickListener(new On_Click(position));
            holder.blur_Image_View.setOnClickListener(new On_Click(position));
        }
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return array_Music_id.size();

    }

    private  class On_Click implements View.OnClickListener{
        private int position;
        public On_Click(int position){
            this.position=position;
        }
        @Override
        public void onClick(View view) {
            switch(view.getId()){
                case R.id.grid_Title_Name:
                case R.id.grid_Artist_Name:
                case R.id.grid_Cover:
                case R.id.blur_Image_View:
                    Intent intent = new Intent(mContext,Album_Page.class);
                     intent.putExtra("Cover_Send",array_Music_id.get(position));
                    intent.putExtra("Album_Name_Send" , array_Music_Album_Name.get(position));
                     mContext.startActivity(intent);
                    break;

            }

        }
    }
}



