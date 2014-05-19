package edu.tongji.bus;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

	private TextView nameTextView;
	private TextView numberTexView;
	private TextView startStationTextView;
	private TextView endStationTextView;
	private EditText dateTimeTextView;
	private TextView typeTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// set up all text view
		this.nameTextView = (TextView) findViewById(R.id.name);
		this.numberTexView = (TextView) findViewById(R.id.number);
		this.startStationTextView = (TextView) findViewById(R.id.start_station);
		this.endStationTextView = (TextView) findViewById(R.id.end_station);
		this.dateTimeTextView = (EditText) findViewById(R.id.time);
		this.typeTextView = (TextView) findViewById(R.id.type);

		this.dateTimeTextView.setOnClickListener(new DatetimeOnClick());

		Button submit = (Button) findViewById(R.id.submit);
		submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ticketIntent = new Intent();
				// Get parameters from view
				if (checkIntergrity()) {

					ticketIntent.putExtra("name", nameTextView.getText());
					ticketIntent.putExtra("number", numberTexView.getText());
					ticketIntent.putExtra("startStation",
							startStationTextView.getText());
					ticketIntent.putExtra("endStation",
							endStationTextView.getText());
					ticketIntent.putExtra("dateTime",
							dateTimeTextView.getText());
					ticketIntent.putExtra("type", typeTextView.getText());

					ticketIntent.setClass(MainActivity.this,
							TicketActivity.class);
					startActivity(ticketIntent);
				} else {

				}
			}
		});
	}

	private final class DatetimeOnClick implements OnClickListener {
		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			DateTimePickerDialog dateTimePicKDialog = new DateTimePickerDialog(
					MainActivity.this);
			dateTimePicKDialog.dateTimePicKDialog(dateTimeTextView, 0);
		}
	}

	private boolean checkIntergrity() {
		boolean flag = true;
		if (nameTextView.getText().toString().equals("")) {
			flag = false;
			dialog();
		}
		if (numberTexView.getText().toString().equals("")) {
			flag = false;
		}
		return flag;
	}

	protected void dialog() {
		AlertDialog.Builder builder = new Builder(MainActivity.this);
		builder.setMessage("确认退出吗？");
		builder.setTitle("提示");
//		builder.setPositiveButton("取消", new OnClickListener() {
//			public void onClick(DialogInterface dialog, int width) {
//				// TODO Auto-generated method stub
//				dialog.dismiss();
//			}
//
//			@Override
//			public void onClick(View arg0) {
//				// TODO Auto-generated method stub
//				
//			}
//		});
		builder.show();
	}
}
