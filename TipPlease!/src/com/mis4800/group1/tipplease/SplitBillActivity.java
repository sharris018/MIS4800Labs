package com.mis4800.group1.tipplease;

import com.mis4800.group1.tipplease.R;
import com.mis4800.group1.tipplease.R.id;
import com.mis4800.group1.tipplease.R.layout;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class SplitBillActivity extends Activity implements OnClickListener {
	EditText txtItem, txtTotal, txtTip, txtPrice, txtParties;
	Button btn_splitback,btnEnter, btnEnter2, btnMainMenu;
	

	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// Grab the text fields and button in variables
		txtItem = (EditText) findViewById(R.id.txtItem);
		txtTotal = (EditText) findViewById(R.id.txtTotal);
		txtTip = (EditText) findViewById(R.id.txtTip);
		txtPrice = (EditText) findViewById(R.id.txtPrice);
		txtParties = (EditText) findViewById(R.id.txtParties);
		

		btnEnter = (Button) findViewById(R.id.btnEnter);
		btn_splitback = (Button) findViewById(R.id.btn_splitback);
		btnEnter2 = (Button) findViewById(R.id.btnEnter2);
		btnMainMenu = (Button) findViewById(R.id.btnMainMenu);
		

		// Set up something to happen when the button is clicked
		btnEnter.setOnClickListener(this);
		btn_splitback.setOnClickListener(this);
		btnEnter2.setOnClickListener(this);
		btnMainMenu.setOnClickListener(this);
	

	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}
}