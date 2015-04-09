package com.example.sirrat.gpslocationshare;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.location.LocationManager;
import android.location.Location;
import android.location.LocationListener;


public class ShareLocation extends ActionBarActivity {
    GPSTracker gps;
    double latitude;
    double longitude;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_location);
    }

    public void displayLocation(View view){
        gps = new GPSTracker(ShareLocation.this);
        if(gps.canGetLocation){
            latitude=gps.getLatitude();
            longitude=gps.getLongitude();
            TextView textView = (TextView) findViewById(R.id.locationDisplay);
            textView.setText(latitude+" "+longitude);
        }else{
           gps.showSettingsAlerts();
        }

    }
}


