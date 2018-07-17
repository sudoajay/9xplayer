package com.sudoajay.a9xplayer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Custom_Grid_View_Box extends BaseAdapter{
    private Context mContext;
    private final String[] web;
    private final int[] Imageid;

    public Custom_Grid_View_Box(Context c,String[] web,int[] Imageid ) {
        mContext = c;
        this.Imageid = Imageid;
        this.web = web;
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return web.length;
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
            grid = inflater.inflate(R.layout.custom_home_box, null);
            TextView grid_Title_Name =  grid.findViewById(R.id.grid_Title_Name);
            TextView grid_Artist_Name = grid.findViewById(R.id.grid_Artist_Name);
            ImageView grid_Cover = grid.findViewById(R.id.grid_Cover);
            ImageView grid_More = grid.findViewById(R.id.grid_More);


        } else {
            grid = (View) convertView;
        }

        return grid;
    }
}