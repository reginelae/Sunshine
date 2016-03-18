package com.example.android.sunshine.activities;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.android.sunshine.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @SuppressLint("NewApi")
    public static class PlaceholderFragment extends Fragment {

        private ArrayAdapter<String> mForecastAdapter;

        public PlaceholderFragment(){
        }

        public View onCreateView(LayoutInflater inflater, ViewGroup contain,
                                 Bundle savedInstanceState){
            View rootView = inflater.inflate(R.layout.fragment_main, contain);


            String[] forecastArray = {

                    "Today - Sunny - 88/63",
                    "Tomorrow - Foggy - 70/40",
                    "Wednesday - Cloudy - 72/63",
                    "Thursday - Asteroid - 65/56",
                    "Friday - Heavy Rain - 88/63",
                    "Saturday - Sunny - 90/63",
                    "Sunday - Foggy - 88/63"
            };


            List<String> weekForecast = new ArrayList<>(
                    Arrays.asList(forecastArray));


            mForecastAdapter = new ArrayAdapter<>(
                    getActivity(),
                    R.layout.list_item_forecast,
                    R.id.list_item_forecast_textview,
                    weekForecast);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_Forecast);

            listView.setAdapter(mForecastAdapter);

            return rootView;
        }
    }

}
