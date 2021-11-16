package com.example.opengltest1;

import androidx.appcompat.app.AppCompatActivity;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;

import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class MainActivity extends AppCompatActivity implements SensorEventListener {
    private OpenGLView openGLView;
    private final static int SCALE = 4;
    private final static int OVERFLOW_LIMIT = 20;
    private float[][] movingAverage = new float[3][OVERFLOW_LIMIT];
    private int overflow = 0;

    private Sensor acc;
    private SensorManager mSensorManager;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openGLView = findViewById(R.id.openGLView);

        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        acc = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        initListeners();
    }

    public void initListeners(){
        mSensorManager.registerListener(this, acc, SensorManager.SENSOR_DELAY_FASTEST);
    }

    @Override
    protected void onResume(){
        super.onResume();
        openGLView.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
        openGLView.onPause();
    }

    private float calculateAverage(float[] input){
        DoubleStream io = IntStream.range(0, input.length)
                .mapToDouble(i->input[i]);
        float sum = (float)io.sum();

        return sum/OVERFLOW_LIMIT;
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture){

    }

    @Override
    public void onSensorChanged(SensorEvent event){
        if(event.sensor.getType()== Sensor.TYPE_ACCELEROMETER){
            float x = Math.round(event.values[0] * 100.0) / 100f;
            float y = Math.round(event.values[1] * 100.0) / 100f;

            movingAverage[0][overflow] = x;
            movingAverage[1][overflow] = y;

            float s1 = calculateAverage(movingAverage[0]);
            float s2 = calculateAverage(movingAverage[1]);


            if(openGLView.renderer.objectsReady){
                openGLView.renderer.getCircle().calPoints(s1/SCALE, s2/SCALE, 0.1f, 55);
                openGLView.requestRender();
            }
        }

        openGLView.requestRender();

        overflow += 1;
        if(overflow >= OVERFLOW_LIMIT){
            overflow=0;
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy){

    }
}