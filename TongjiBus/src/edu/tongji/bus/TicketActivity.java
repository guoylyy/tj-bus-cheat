package edu.tongji.bus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class TicketActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.ticket);
		Intent ticketIntent = getIntent();
		String name = ticketIntent.getExtras().get("name").toString();
		TextView nameView = (TextView) findViewById(R.id.nameText);

		TextView streamNumberView = (TextView) findViewById(R.id.streamNumber);
		streamNumberView.setText(this.getStreamNumber());

		nameView.setText(name);
	}

	@SuppressLint("SimpleDateFormat")
	private String getStreamNumber() {
		Date date = new Date();
		String number = new Random().nextInt(900000) + 10000000 +"";
		
		return "流水号："
				+ (new SimpleDateFormat("yyyyMMddhhmmss")).format(date)
						.toString()+ number;
	}
}
