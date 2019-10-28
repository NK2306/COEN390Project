package com.example.elec390finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.net.URL;

public class MainActivity extends AppCompatActivity {

    private static  final String TAG = MainActivity.class.getSimpleName();
    private FetchWeatherDetails WeatherDetails;
    private TextView suggestion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        suggestion = findViewById(R.id.suggestion);

        URL weatherURL = NetworkUltility.buildURLForWeather();
        Log.i(TAG, "OnCreate: WeatherUrl: " + weatherURL);

        WeatherDetails = new FetchWeatherDetails();
        WeatherDetails.execute(weatherURL);
        try {
            //set time in mili
            Thread.sleep(3000);

        }catch (Exception e){
            e.printStackTrace();
        }
        WeatherForecastInformation TestObject =  WeatherDetails.parseJSON();
        Log.i(TAG, "TestWeatherObject: " + TestObject.toString());

        suggestion.setText(TestObject.makeClothingSuggestion());
    }
}
