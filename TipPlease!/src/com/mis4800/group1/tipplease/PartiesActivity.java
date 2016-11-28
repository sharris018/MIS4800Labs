/**
 * 
 */
package com.mis4800.group1.tipplease;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

/**
 * @author shone
 *
 */
public class PartiesActivity extends Activity implements OnClickListener {
	EditText txtItem, txtTotal, txtTip, txtPrice, txtParties, txtParty;
	Button btn_splitback, btnEnter, btnEnter2, btnMainMenu;
	Spinner billoption; 
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
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
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	/* (non-Javadoc)
	 * @see android.app.Activity#onMenuItemSelected(int, android.view.MenuItem)
	 */
	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		// TODO Auto-generated method stub
		return super.onMenuItemSelected(featureId, item);
	}



}
