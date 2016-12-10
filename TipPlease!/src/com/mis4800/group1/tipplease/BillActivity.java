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
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author Shonelle S. Harris
 *
 */

public class BillActivity extends Activity implements OnClickListener {

	Button btnEnter2;
	EditText txtItem, txtTotal, txtTip, txtPrice;
	TextView tvTip, tvTotal;
	Spinner tipoption;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singlebill);

		// Grab the buttons

		btnEnter2 = (Button) findViewById(R.id.btnEnter2);

		// Grab spinner button

		tipoption = (Spinner) findViewById(R.id.tipoption);

		// Set up something to happen when the button is clicked

		btnEnter2.setOnClickListener(this);

		// Grab the text field
		txtTip = (EditText) findViewById(R.id.txtTip);
		txtPrice = (EditText) findViewById(R.id.txtPrice);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onCreateOptionsMenu(android.view.Menu)
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.btnEnter2) {
			double[] tips = { 0, 10.0, 15.0, 18.0, 20.0, 25.0 }; // Change this
			// to what
			// you have
			// in your
			// tipoption
			// spinner

			int selectedPosition = tipoption.getSelectedItemPosition();
			switch (selectedPosition) {
			case 0:
				Toast.makeText(this, "Please select a tip percentage", Toast.LENGTH_LONG).show();

				break;
			default:
				double tipused = tips[selectedPosition];
				double price = 0;
				price = Double.parseDouble(txtPrice.getText().toString());
				double tip = (price * tipused) / 100;
				txtTip.setText(String.format("%1$.2f", tip));

			}

		}

	}
}
