package com.sudoajay.a9xplayer;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.l4digital.fastscroll.FastScroller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


/**
 * Created by sudoajay on 12/23/17.
 */

public class Custom_List_Adapter_For_Music  extends RecyclerView.Adapter<Custom_List_Adapter_For_Music.ViewHolder> implements FastScroller.SectionIndexer {

    // private globall variable
    private ArrayList<String> array_Music_Artist,array_Music_Timing;
    private HashMap<Integer , String> array_Music_Title;
    private Grab_The_Cover grab_the_cover;
    private Context mContext;
    private ArrayList<Long>   array_Music_id;


    // Provide a suitable constructor (depends on the kind of dataset)
    public Custom_List_Adapter_For_Music(Context mContext, ArrayList<String> array_Music_Artist,ArrayList<Long> array_Music_id,
                                         ArrayList<String> array_Music_Timing, HashMap<Integer , String> array_Music_Title) {
        this.array_Music_Artist = array_Music_Artist;
        this.mContext =mContext;
        this.array_Music_id = array_Music_id;
        this.array_Music_Timing =array_Music_Timing;
        this.array_Music_Title = array_Music_Title;
    }

    @Override
    public String getSectionText(int position) {

        return null;
    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        private TextView text_Title,text_Artist,text_Timing,text;
        private ImageView cover;

        ViewHolder(View itemView) {
            super(itemView);
            text_Title =  itemView.findViewById(R.id.text_Title);
            text_Artist =  itemView.findViewById(R.id.text_Artist);
            text_Timing = itemView.findViewById(R.id.text_Timing);
            cover = itemView.findViewById(R.id.cover);
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
                inflater.inflate(R.layout.music_list_style, parent, false);
        // set the view's size, margins, paddings and layout parameters
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        grab_the_cover = new Grab_The_Cover(mContext);
        holder.text_Title.setText(array_Music_Title.get(position));
        Glide.with(mContext)
                .asBitmap()
                .load(grab_the_cover.Get_Audio_Album_Image_ContentUri
                        (array_Music_id.get(position)))
                .into(holder.cover);
        holder.text_Artist.setText(array_Music_Artist.get(position));
        holder.text_Timing.setText(array_Music_Timing.get(position));

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return array_Music_Artist.size();
    }

}
