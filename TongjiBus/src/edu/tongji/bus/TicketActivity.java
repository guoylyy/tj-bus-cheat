package edu.tongji.bus;

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
		nameView.setText(name);
	}
	
	private String getStreamNumber(){
		return "";
	}
}
