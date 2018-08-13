package com.sudoajay.a9xplayer;

import android.graphics.Bitmap;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sudoajay on 12/23/17.
 */

public class Custom_List_Adapter_For_Music extends RecyclerView.Adapter<Custom_List_Adapter_For_Music.ViewHolder> {

    // private global variable
    private List<String> values;
    private  ArrayList<String> item_Title, item_Artist,item_Timing;
    private ArrayList<Bitmap>  image_Cover;
    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
       private TextView text_Title,text_Artist,text_Timing;
       private ImageView cover;
        public View layout;

        public ViewHolder(View v) {
            super(v);
            layout = v;
            text_Title =  v.findViewById(R.id.text_Title);
            text_Artist =  v.findViewById(R.id.text_Artist);
            text_Timing = v.findViewById(R.id.text_Timing);
            cover = v.findViewById(R.id.cover);
        }
    }

    public void add(int position, String item) {
        values.add(position, item);
        notifyItemInserted(position);
    }

    public void remove(int position) {
        values.remove(position);
        notifyItemRemoved(position);
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public Custom_List_Adapter_For_Music(ArrayList<String> item_Title, ArrayList<String> item_Artist,
                                         ArrayList<String> item_Timing,ArrayList<Bitmap>  image_Cover) {
        this.item_Artist = item_Artist;
        this.item_Title = item_Title;
        this.item_Timing = item_Timing;
        this.image_Cover = image_Cover;
    }

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
        final String name = values.get(position);
//        holder.txtHeader.setText(name);
//        holder.txtHeader.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                remove(position);
//            }
//        });

        holder.text_Title.setText(item_Title.get(position));
        holder.cover.setImageBitmap(image_Cover.get(position));
        holder.text_Artist.setText(" by-: "+item_Artist.get(position));
        holder.text_Timing.setText(item_Timing.get(position)+"");
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return values.size();
    }

}

//    // privbate global varible
//    private Context context;
//    private  ArrayList<String> item_Title, item_Artist,item_Timing;
//    private ArrayList<Bitmap>  image_Cover;
//
//    public Custom_List_Adapter_For_Music(View view,Context context, @Nullable AttributeSet attrs,ArrayList<String> item_Title
//            , ArrayList<String> item_Artist, ArrayList<String> item_Timing,ArrayList<Bitmap>  image_Cover) {
//        super(view);
//        this.context = context;
//        this.item_Artist = item_Artist;
//        this.item_Title = item_Title;
//        this.item_Timing = item_Timing;
//        this.image_Cover = image_Cover;
//    }
//
//
//
//    @SuppressLint("SetTextI18n")
//    public View getView(final int position, View convertView, ViewGroup parent) {
//        TextView text_Title,text_Artist,text_Timing;
//        ImageView cover;
//
//        if (convertView == null) {
//
//            LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//
//            assert vi != null;
//            convertView = vi.inflate(R.layout.music_list_style, parent, false);
//
//            text_Title =  convertView.findViewById(R.id.text_Title);
//            text_Artist = convertView.findViewById(R.id.text_Artist);
//            text_Timing = convertView.findViewById(R.id.text_Timing);
//            cover =  convertView.findViewById(R.id.cover);
//
//            text_Title.setText(item_Title.get(position));
//            cover.setImageBitmap(image_Cover.get(position));
//            text_Artist.setText(" by-: "+item_Artist.get(position));
//            text_Timing.setText(item_Timing.get(position)+"");
//
//        }
//        return convertView;
//    }



