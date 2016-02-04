package com.projects.sunshine.sunshine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.*;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        public PlaceholderFragment() {
            System.out.println("Here");
        }
        ArrayAdapter<String> adapter;
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            String[] sampleData = new String[] {
                    "Today -- Sunny 86/66",
                    "Tomorrow -- Cloudy 70/65",
                    "Wed -- Partly Cloudy 80/76",
                    "Thurs -- Heavy Rain 65/55",
                    "Fri -- Sunny 85/70",
                    "Sat -- Sunny 89/70",
                    "Sun -- Sunny 87/75"};
            ArrayList<String> forecast = new ArrayList<String>(Arrays.asList(sampleData));
            // register adapter with context, list view, list item text box, data
            adapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_forecast, R.id.list_item_forecast_textView, forecast);
            // Initialize the listView
            ListView listView = (ListView) rootView.findViewById(R.id.listview_forecast);
            // connect adapter to the ListView
            listView.setAdapter(adapter);
            return rootView;
        }
    }
}
