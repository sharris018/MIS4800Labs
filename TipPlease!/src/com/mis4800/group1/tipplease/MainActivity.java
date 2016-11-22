package com.mis4800.group1.tipplease;

import com.mis4800.group1.tipplease.model.BillActivity;
import com.mis4800.group1.tipplease.model.PartiesActivity;

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

	EditText txtItem, txtTotal, txtTip, txtPrice, txtParties, txtParty;
	Button btn_splitbill, btn_splitback, btnEnter, btnEnter2, btnMainMenu;
	Spinner billoption;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Intent sourceIntent = getIntent();
		// Grab the text fields and button in variables
		btnEnter = (Button) findViewById(R.id.btnEnter);

		billoption = (Spinner) findViewById(R.id.billoption);

		// Set up something to happen when the button is clicked

		btnEnter.setOnClickListener(this);

	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



}
