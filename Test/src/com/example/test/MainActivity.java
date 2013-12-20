package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText mText;
	Button mStart;
	Button mStop;
	int count = 1000;
	TimerTask timerTask;	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mText = (EditText) findViewById(R.id.edit_text);
		mStart = (Button) findViewById(R.id.start_btn);
		mStop = (Button) findViewById(R.id.stop_btn);

		mStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				doTimerTask();
			}
		});

		mStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				stopTask();
			}
		});

	}
	public void doTimerTask(){
		final Handler handler = new Handler();
		timerTask = new TimerTask() {
    	        public void run() {
    	                handler.post(new Runnable() {
    	                        public void run() {
    	                        	if (count == 0) {
    	    							cancel();
    	    						} else {
    	    						mText.setText(String.valueOf(count));
    	    						count--;
    	                        }
    	                        }
    	               });
    	        }};
    	        Timer t = new Timer();
    	    t.schedule(timerTask, 0, 1000);
 
    	 }
	  public void stopTask(){
		  
   	   if(timerTask!=null){
   	      mText.setText(String.valueOf(count));
   	      timerTask.cancel();
   	 }
}
}