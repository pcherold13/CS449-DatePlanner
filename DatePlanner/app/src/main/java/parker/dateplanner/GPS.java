package parker.dateplanner;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.util.Log;
import android.widget.Toast;


public class GPS {
    public String locate(){
        String place = "";
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        try {
            // Example of how to query GPS location.
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
// Returns null if location isn't available
            if (location != null) {
                place = location.getLongitude() + " " + location.getLatitude();
            }
            else {
                Log.i(TAG, "location was null");
                Toast.makeText(getApplicationContext(),
                        "Location not available", Toast.LENGTH_LONG).show();
            }
        }
        catch(SecurityException e) {
            Log.i(TAG, "Problem getting location: " + e);
        }
        return place;
    }
}
