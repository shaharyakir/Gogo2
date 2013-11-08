package com.sashapps.Gogo2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class ActivitiesListViewAdapter extends BaseAdapter {

    private static LayoutInflater inflater=null;
    private Activity activity;
    private ArrayList<HashMap<String,String>> data;


    public ActivitiesListViewAdapter(Activity a, ArrayList<HashMap<String,String>> d){

        activity = a;
        data = d;
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        View vi=convertView;
        if(convertView==null)

            vi = inflater.inflate(R.layout.list_view_item, null);

        //TextView title = (TextView)vi.findViewById(R.id.txt); // title

        // Setting all values in listview
        //title.setText("shahar");
        return vi;
    }
}
