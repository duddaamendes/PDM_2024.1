package com.example.sensores;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener{

    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SensorManager sm = (SensorManager) getSystemService(SENSOR_SERVICE);

        //referencia do sensor de luz do aparelho
        Sensor sensor = sm.getDefaultSensor(Sensor.TYPE_LIGHT);

        sm.registerListener(this,sensor, SensorManager.SENSOR_DELAY_FASTEST);
        textView=findViewById(R.id.tv);
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("Sensor: ", Float.toString(sensorEvent.values[0]));
        textView.setText(Float.toString(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}