package parker.dateplanner;

public class Search{
  public void start(TextView dinner, TextView movie, boolean gps)
      String place; -       
 -    if(gps){
 -        place = GPS.locate();                        
 -    }
 -    else{
 -        TextView location = (TextView) findViewById(R.id.locationText);
 -        place = location.getText();
 -    }
 -    search += dinner.getText() + " and " + movie.getText() + " showing near " + place;
}
