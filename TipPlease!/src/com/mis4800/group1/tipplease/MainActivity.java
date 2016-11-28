package com.mis4800.group1.tipplease;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends Activity implements OnClickListener {

	EditText txtItem, txtTotal, txtTip, txtPrice, txtParties;
	Button btn_splitback, btnEnter, btnEnter2, btnMainMenu;
	Spinner billoption; 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Grab the text fields 
		txtItem = (EditText) findViewById(R.id.txtItem);
		txtTotal = (EditText) findViewById(R.id.txtTotal);
		txtTip = (EditText) findViewById(R.id.txtTip);
		txtPrice = (EditText) findViewById(R.id.txtPrice);
		txtParties = (EditText) findViewById(R.id.txtParties);
		
		// Grab the buttons 
		
		btn_splitback = (Button) findViewById(R.id.btn_splitback);
		btnEnter = (Button) findViewById(R.id.btnEnter);
		btnEnter2 = (Button) findViewById(R.id.btnMainMenu);
		
		// Grab spinner button 
		
		billoption = (Spinner) findViewById(R.id.billoption); 
		

		// Set up something to happen when the button is clicked
		btnEnter.setOnClickListener(this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);

	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btnEnter) {
		} else if (v.getId() == R.id.btnEnter2) {
			Intent mainIntent = new Intent(this, PartiesActivity.class);
			startActivity(mainIntent);
		}
	}

}
