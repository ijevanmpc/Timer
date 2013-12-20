package com.example.timer;

import java.util.Timer;
import java.util.TimerTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	EditText mText;
	Button mStart;
	Button mStop;
	int count = 1000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mText = (EditText) findViewById(R.id.edit_text);
		mStart = (Button) findViewById(R.id.start_btn);
		mStop = (Button) findViewById(R.id.stop_btn);

		final TimerTask Task = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (count == 0) {
							cancel();
						}
						mText.setText(String.valueOf(count));
						count--;
					}
				});
			}
		};

		Timer countdown = new Timer();
		countdown.schedule(Task, 0, 1000);

		mStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				
					Task.run();
			}
		});

		mStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Task.cancel();
			}
		});

	}
}