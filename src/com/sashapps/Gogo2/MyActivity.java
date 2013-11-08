package com.sashapps.Gogo2;

import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;

public class MyActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    ArrayList<View> sections;
    final int EXPANDED_SIZE_DPS=80;
    final int SMALL_SIZE_DPS=48;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        /* Add all search parameter sections to array in order to handle visibility when clicked */
        sections = new ArrayList<View>();
        sections.add(findViewById(R.id.layout_my_details));
        sections.add(findViewById(R.id.layout_location));
        sections.add(findViewById(R.id.layout_date));
        sections.add(findViewById(R.id.layout_activity_types));
        sections.add(findViewById(R.id.layout_activity_people));

        for (View v : sections){
            v.setOnClickListener(setSectionVisibility);
        }


        /*ListView l = (ListView)findViewById(R.id.ListViewResults);
        ArrayList<HashMap<String,String>> arr = new ArrayList<HashMap<String,String>>();
        HashMap<String,String> d = new HashMap<String, String>();
        d.put("test","bla");

        arr.add(d);
        d = new HashMap<String, String>();
        d.put("test2","bla2");
        arr.add(d);
        arr.add(d);
        arr.add(d);
        arr.add(d);
        ActivitiesListViewAdapter a = new ActivitiesListViewAdapter(this,arr);
        l.setAdapter(a);
        //l.setDividerHeight(10);*/

    }

    private View.OnClickListener setSectionVisibility = new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            /* Decide whether the section needs to be collapsed or expanded */
            int a = view.getLayoutParams().height == convertDpsToPixels(EXPANDED_SIZE_DPS) ? convertDpsToPixels(SMALL_SIZE_DPS) : convertDpsToPixels(EXPANDED_SIZE_DPS);
            view.getLayoutParams().height=a;

            /* Vanish all other sections */
            for (View v : sections){
                if (! v.equals(view)){
                    if (v.getVisibility()==View.GONE){
                        v.setVisibility(View.VISIBLE);
                    }
                    else{
                        v.setVisibility(View.GONE);
                    }
                }
            }
        }
    };

    public int convertDpsToPixels(int pixels){
        final float scale = getBaseContext().getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }
}
