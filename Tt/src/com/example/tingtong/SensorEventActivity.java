package com.example.tingtong;

import java.io.FileInputStream;
import java.io.IOException;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.AssetManager;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SensorEventActivity extends Activity implements OnClickListener {
	private Button normal,receiver;
	protected AudioManager audioManager;
	protected SensorManager sensorManager;
	protected Sensor sensor;
	protected AssetManager assetManager;
	private int can;
	MediaPlayer mPlayer = new MediaPlayer();
	MediaPlayer mPlayer1 = new MediaPlayer();
	
	
	protected void init() {
		// TODO Auto-generated method stub
		audioManager = (AudioManager) this.getSystemService(Context.AUDIO_SERVICE);
		sensorManager = (SensorManager) this.getSystemService(Context.SENSOR_SERVICE);
		sensor = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
		assetManager = SensorEventActivity.this.getAssets();
		System.out.println(assetManager.toString());
		normal = (Button) findViewById(R.id.normal);
		receiver = (Button) findViewById(R.id.receiver);

		normal.setOnClickListener(this);
		receiver.setOnClickListener(this);
		
		audioManager.setMode(AudioManager.MODE_NORMAL);
		try {
			AssetManager assetMg= this.getApplicationContext().getAssets();
	        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
	        MediaPlayer mediaPlayer = new MediaPlayer();  
	        mediaPlayer.reset();
	        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
	        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
	        mediaPlayer.prepare();
	        mediaPlayer.start();
		} catch (Exception e) {
			e.printStackTrace();
			Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		init();
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.normal:
			Toast.makeText(this, "��ģʽ", Toast.LENGTH_SHORT).show();
			can  = 1;
			audioManager.setMode(AudioManager.MODE_NORMAL);
			break;
			
		case R.id.receiver:
			Toast.makeText(this, "��Ͳģʽ", Toast.LENGTH_SHORT).show();
			can = 2;
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			break;
		}
	}

}
