package com.example.sensores;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

public class TratamentoEvento implements SensorEventListener {

    Context context;
    public TratamentoEvento(Context c) {
        context=c;
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        Log.d("Sensor: ", Float.toString(sensorEvent.values[0]));
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }
}
