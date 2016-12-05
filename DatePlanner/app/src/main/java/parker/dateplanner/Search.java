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

public class Search {
    public void start(TextView dinner, TextView movie, boolean gps) {
        String place, search;
        if (gps) {
            place = GPS.locate();
        } else {
            TextView location = (TextView) findViewById(R.id.locationText);
            place += location.getText();
        }
        search += dinner.getText() + " and " + movie.getText() + " showing near " + place;
    }
}
