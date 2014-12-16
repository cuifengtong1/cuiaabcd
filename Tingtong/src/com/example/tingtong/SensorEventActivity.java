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
/**
 * 播放应用的原始资源文件(assets)
1) 通过Context.getAssets()方法获得AssetManager对象
2) 通过AssetManager对象的openFd(String name)方法打开指定的原生资源文件夹，返回一个AssetFileDescriptor对象
3) 通过AssetFileDescriptor的getFileDescriptor()得到一个FileDescriptor对象
4) 通过public void setDataSource (FileDescriptor fd, long offset, long length)来创建MediaPlayer对象
5) 调用MediaPlayer.prepare()方法准备音频
6) 调用MediaPlayer的start()、pause()、stop()等方法控制
 
AssetFileDescriptor fileDescriptor = assetManager.openFd("a2.mp3");
mediaPlayer = new MediaPlayer();
    mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),
                              fileDescriptor.getStartOffset(),
                              fileDescriptor.getLength());
    mediaPlayer.prepare();
mediaPlayer.start();
 * @author Administrator
 */
public class SensorEventActivity extends Activity implements SensorEventListener,OnClickListener {
	private Button normal,receiver;
	protected AudioManager audioManager;
	protected SensorManager sensorManager;
	protected Sensor sensor;
	protected AssetManager assetManager;
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
//		normal.setOnClickListener(this);
//		receiver.setOnClickListener(this);
		try {
//			FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
//			mPlayer.reset();
//			mPlayer.setDataSource(file.getFD());
//			AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//			mPlayer.setDataSource(afd.getFileDescriptor(),
//									afd.getStartOffset(),
//									afd.getLength());
//			mPlayer.prepare();
//			mPlayer.start();
			AssetManager assetMg= this.getApplicationContext().getAssets();
	        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
	        MediaPlayer mediaPlayer = new MediaPlayer();  
	        mediaPlayer.reset();
	        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
	        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
	        mediaPlayer.prepare();
	        mediaPlayer.start();
//			FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
//			mPlayer1.reset();
//			mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//			mPlayer1.prepare();
//			mPlayer1.start();
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
//		try {
//			AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//			mPlayer.setDataSource(afd.getFileDescriptor(),
//					afd.getStartOffset(),
//					afd.getLength());
//			mPlayer.prepare();
//			mPlayer.start();
//		} catch (IllegalStateException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		init();
	}
	
	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		float range = event.values[0];

		if(range == sensor.getMaximumRange()) {
			Toast.makeText(this, "正常模式", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_NORMAL);
//			
//			try {
////				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
////				mPlayer.reset();
////				mPlayer.setDataSource(file.getFD());
////				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
////				mPlayer.setDataSource(afd.getFileDescriptor(),
////										afd.getStartOffset(),
////										afd.getLength());
////				mPlayer.prepare();
////				mPlayer.start();
//				AssetManager assetMg= this.getApplicationContext().getAssets();
//		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
//		        MediaPlayer mediaPlayer = new MediaPlayer();  
//		        mediaPlayer.reset();
//		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
//		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
//		        mediaPlayer.prepare();
//		        mediaPlayer.start();
////				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
////				mPlayer1.reset();
////				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
////				mPlayer1.prepare();
////				mPlayer1.start();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
//			}
		} else {
			Toast.makeText(this, "听筒模式", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			
//			try {
////				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
////				mPlayer.reset();
////				mPlayer.setDataSource(file.getFD());
////				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
////				mPlayer.setDataSource(afd.getFileDescriptor(),
////										afd.getStartOffset(),
////										afd.getLength());
////				mPlayer.prepare();
////				mPlayer.start();
//				AssetManager assetMg= this.getApplicationContext().getAssets();
//		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
//		        MediaPlayer mediaPlayer = new MediaPlayer();  
//		        mediaPlayer.reset();
//		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
//		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
//		        mediaPlayer.prepare();
//		        mediaPlayer.start();
////				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
////				mPlayer1.reset();
////				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
////				mPlayer1.prepare();
////				mPlayer1.start();
//			} catch (Exception e) {
//				e.printStackTrace();
//				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
//			}
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		sensorManager.registerListener(SensorEventActivity.this, sensor,
				SensorManager.SENSOR_DELAY_NORMAL);
		super.onResume();
	}
	
	@Override
	protected void onPause() {
		// TODO Auto-generated method stub
		sensorManager.unregisterListener(this);
		super.onPause();
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.normal:
			Toast.makeText(this, "正常模式", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_NORMAL);
			try {
//				FileInputStream file = (FileInputStream) assetManager.open("music/huluwan.mp3");
//				mPlayer.reset();
//				mPlayer.setDataSource(file.getFD());
//				AssetFileDescriptor afd = assetManager.openFd("huluwan.mp3");
//				mPlayer.setDataSource(afd.getFileDescriptor(),
//										afd.getStartOffset(),
//										afd.getLength());
//				mPlayer.prepare();
//				mPlayer.start();
				AssetManager assetMg= this.getApplicationContext().getAssets();
		        AssetFileDescriptor fileDescriptor = assetMg.openFd("huluwan.mp3");  
		        MediaPlayer mediaPlayer = new MediaPlayer();  
		        mediaPlayer.reset();
		        mediaPlayer.setDataSource(fileDescriptor.getFileDescriptor(),  
		        fileDescriptor.getStartOffset(), fileDescriptor.getLength()); 
		        mediaPlayer.prepare();
		        mediaPlayer.start();
//				FileInputStream file = (FileInputStream) assetManager.open("huluwan.mp3");
//				mPlayer1.reset();
//				mPlayer1.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//				mPlayer1.prepare();
//				mPlayer1.start();
			} catch (Exception e) {
				e.printStackTrace();
				Log.e(SensorEventActivity.class.getSimpleName(), ""+e.getMessage());
			}
			break;
		case R.id.receiver:
			Toast.makeText(this, "听筒模式", Toast.LENGTH_SHORT).show();
			audioManager.setMode(AudioManager.MODE_IN_CALL);
			try {
//				mPlayer.reset();
//				mPlayer.setDataSource(new FileInputStream("android_assets/huluwan.mp3").getFD());
//				mPlayer.prepare();
//				mPlayer.start();
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
			break;
		}
	}

}
