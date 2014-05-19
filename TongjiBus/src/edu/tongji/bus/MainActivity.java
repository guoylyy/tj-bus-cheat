package edu.tongji.bus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button submit = (Button)findViewById(R.id.submit);
        submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent ticketIntent = new Intent();
				//Get parameters from view
				TextView nameView =  (TextView) findViewById(R.id.name);
				nameView.getText();
				ticketIntent.putExtra("name", nameView.getText());
				ticketIntent.setClass(MainActivity.this, TicketActivity.class);
				startActivity(ticketIntent);
			}
		});
        
    }
}
