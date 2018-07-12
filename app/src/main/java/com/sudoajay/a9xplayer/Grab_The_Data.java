package com.sudoajay.a9xplayer;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Grab_The_Data {
    private Activity activity;
    private ArrayList<String> array_Music_Artist,array_Music_Path
            ,array_Music_Timing;
    private ArrayList<Long>   array_Music_id;
    private HashMap<Integer , String> array_Music_Title;
    public Grab_The_Data(Activity activity){
        this.activity=activity;

        // array instantiate
        Array_Instantiate();

        // Grab The Data And Stored in Array
        Get_Music();
    }

    private void Get_Music() {
        int count=0;
        ContentResolver content_Resolver = activity.getContentResolver();
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        Cursor cursor = content_Resolver.query(uri, null, null, null, MediaStore.Audio.Media.DISPLAY_NAME + " ASC" );

        if (cursor != null && cursor.moveToFirst()) {
            int song_Title = cursor.getColumnIndex(MediaStore.Audio.Media.TITLE);
            int song_Artist = cursor.getColumnIndex(MediaStore.Audio.Media.ARTIST);
            long song_Timing = cursor.getColumnIndex(MediaStore.Audio.Media.DURATION);
            int song_Path = cursor.getColumnIndex(MediaStore.Audio.Media.DATA);
            int song_Id = cursor.getColumnIndex(MediaStore.Audio.Media.ALBUM_ID);

            do {

                String current_Title = cursor.getString(song_Title);
                String current_Artist = cursor.getString(song_Artist);
                long current_Timing = cursor.getLong((int) song_Timing);
                String current_Path = cursor.getString(song_Path);
                long album_id = cursor.getLong(song_Id);
                int current_Count=count;

                array_Music_id.add(album_id);
                array_Music_Title.put(current_Count,current_Title);
                array_Music_Artist.add(current_Artist);
                array_Music_Timing.add(convertDuration(current_Timing));
                array_Music_Path.add(current_Path);

                count++;
            } while (cursor.moveToNext());


            // this code Reverse Soo The Latest One Come First in Array
//            Collections.reverse(array_Music_Title);
//            Collections.reverse(array_Music_id);
//            Collections.reverse(array_Music_Artist);
//            Collections.reverse(array_Music_Timing);
//            Collections.reverse(array_Music_Path);

            //sorting in alpha

            Sorting_Array();
        }

    }
    private String convertDuration(long duration) {
        String out = null;
        long hours = 0;
        try {
            hours = (duration / 3600000);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return out;
        }
        long remaining_minutes = (duration - (hours * 3600000)) / 60000;
        String minutes = String.valueOf(remaining_minutes);
        if (minutes.equals(0)) {
            minutes = "00";
        }
        long remaining_seconds = (duration - (hours * 3600000) - (remaining_minutes * 60000));
        String seconds = String.valueOf(remaining_seconds);
        if (seconds.length() < 2) {
            seconds = "00";
        } else {
            seconds = seconds.substring(0, 2);
        }

        if (hours > 0) {
            out = hours + ":" + minutes + ":" + seconds;
        } else {
            out = minutes + ":" + seconds;
        }

        return out;

    }

    public HashMap<Integer, String> getArray_Music_Title() {
        return array_Music_Title;
    }

    public ArrayList<String> getArray_Music_Artist() {
        return array_Music_Artist;
    }

    public ArrayList<String> getArray_Music_Path() {
        return array_Music_Path;
    }

    public ArrayList<String> getArray_Music_Timing() {
        return array_Music_Timing;
    }

    public ArrayList<Long> getArray_Music_id() {
        return array_Music_id;
    }
    // array instantiate
    private void Array_Instantiate(){
        array_Music_Title = new HashMap<>();
        array_Music_Artist = new ArrayList<>();
        array_Music_Path =new ArrayList<>();
        array_Music_Timing = new ArrayList<>();
        array_Music_id = new ArrayList<>();

    }

    //sort all array in alpha
    private void Sorting_Array(){
        String temp;
        long tem;
        int count =0;
        array_Music_Title = sortHashMapByValues(array_Music_Title);
        Iterator it = array_Music_Title.entrySet().iterator();
        while( it.hasNext()){
        Map.Entry pair = (Map.Entry)it.next();

            temp = array_Music_Artist.get(count);
            array_Music_Artist.set(count , array_Music_Artist.get((int)pair.getKey()));
            array_Music_Artist.set((int)pair.getKey(), temp);

            temp = array_Music_Path.get(count);
            array_Music_Path.set(count , array_Music_Path.get((int)pair.getKey()));
            array_Music_Path.set((int)pair.getKey(), temp);

            temp = array_Music_Timing.get(count);
            array_Music_Timing.set(count , array_Music_Timing.get((int)pair.getKey()));
            array_Music_Timing.set((int)pair.getKey(), temp);

            tem = array_Music_id.get(count);
            array_Music_id.set(count , array_Music_id.get((int)pair.getKey()));
            array_Music_id.set((int)pair.getKey(), tem);
            it.remove();
            count++;
            Log.i("throw" ,   "key - " + pair.getKey() + " value - " + pair.getValue() + " patjh - " +array_Music_Path.get(count) );
        }
    }
    //sort the array
    private static HashMap sortHashMapByValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
        // Defined Custom Comparator here
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue())
                        .compareTo(((Map.Entry) (o2)).getValue());
            }
        });

        // Here I am copying the sorted list in HashMap
        // using LinkedHashMap to preserve the insertion order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }


}
