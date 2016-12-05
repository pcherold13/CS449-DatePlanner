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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
   
    public void onClick(View v){
        switch(v.getID()){
            case R.id.button:
                    String place;
                    TextView dinner = (TextView) findViewById(R.id.dinnerText);
                    TextView movie = (TextView) findViewById(R.id.movieText);
                    Boolean gps = ((CheckBox) findViewById(R.id.currentPos)).isChecked();
                    Search.start(dinner, movie, gps);
            default:
                //do nothing
    }

    

    
       
