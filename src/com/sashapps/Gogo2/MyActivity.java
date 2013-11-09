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
    final String SEARCH_SECTION_STRING = "search_section";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        /* Add all search parameter sections to array in order to handle visibility when clicked */
        sections = getViewsByTag(((ViewGroup)findViewById(R.id.layout_main_activity)),SEARCH_SECTION_STRING);

        /*sections.add(findViewById(R.id.layout_my_details));
        sections.add(findViewById(R.id.layout_location));
        sections.add(findViewById(R.id.layout_date));
        sections.add(findViewById(R.id.layout_activity_types));
        sections.add(findViewById(R.id.layout_activity_people));*/

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
            int newHeight = view.getLayoutParams().height ==
                            dpsToPixels(EXPANDED_SIZE_DPS) ? dpsToPixels(SMALL_SIZE_DPS) : dpsToPixels(EXPANDED_SIZE_DPS);
            view.getLayoutParams().height=newHeight;

            /* Vanish all other sections */
            for (View v : sections){
                if (! v.equals(view)){
                    int newVisibilty = v.getVisibility() == View.GONE ? View.VISIBLE : View.GONE;
                    v.setVisibility(newVisibilty);
                }
            }


        }
    };

    /* =====
       Utils
       ===== */
    public int dpsToPixels(int pixels){
        final float scale = getBaseContext().getResources().getDisplayMetrics().density;
        return (int) (pixels * scale + 0.5f);
    }

    private static ArrayList<View> getViewsByTag(ViewGroup root, String tag){
        ArrayList<View> views = new ArrayList<View>();
        final int childCount = root.getChildCount();
        for (int i = 0; i < childCount; i++) {
            final View child = root.getChildAt(i);
            if (child instanceof ViewGroup) {
                views.addAll(getViewsByTag((ViewGroup) child, tag));
            }

            final Object tagObj = child.getTag();
            if (tagObj != null && tagObj.equals(tag)) {
                views.add(child);
            }

        }
        return views;
    }
}
