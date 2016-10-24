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


public class MainActivity extends AppCompatActivity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.reset:
                String blank = "";
                TextView dinner = (TextView) findViewById(R.id.dinnerText);
                TextView movie = (TextView) findViewById(R.id.movieText);
                TextView location = (TextView) findViewById(R.id.locationText);
                dinner.setText(blank);
                movie.setText(blank);
                location.setText(blank);
                return true;
            case R.id.about:
                Intent about = new Intent(this, AboutActivity.class);
                startActivity(about);
                return true;
            case R.id.settings:
                Intent settings = new Intent(this, SettingsActivity.class);
                startActivity(settings);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    String search = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    private void search (){
        String place;
        TextView dinner = (TextView) findViewById(R.id.dinnerText);
        TextView movie = (TextView) findViewById(R.id.movieText);
        if(gps){
            place = locate();                        
        }
        else{
            TextView location = (TextView) findViewById(R.id.locationText);
            place = location.getText();
        }
        search += dinner.getText() + " and " + movie.getText() + " showing near " + place;
    }
}

    //@TargetApi(23)
    private String locate() {
        String place = "";
         locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            try {
            // Example of how to query GPS location.
            LocationManager lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
// Returns null if location isn't available
// In emulator, you need to send your location (via android / tools)
//   before getLostKnownLocation() will return a location.
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

