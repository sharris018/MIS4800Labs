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
import android.widget.TextView;

/**
 * @author shone
 *
 */
public class BillActivity extends Activity implements OnClickListener {
	
	Button btnEnter2; 
	EditText txtItem, txtPrice, txtTotal, txtTip; 
	TextView tvTip, tvTotal;
	Spinner tipoption;
	
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singlebill);
		
		// Grab the buttons 
		
		btnEnter2 = (Button) findViewById(R.id.btnEnter);
		
		
		// Grab spinner button 
		
		tipoption = (Spinner) findViewById(R.id.billoption); 
		
		// Set up something to happen when the button is clicked
		btnEnter2.setOnClickListener(this);
		

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
	 * @see android.app.Activity#onOptionsItemSelected(android.view.MenuItem)
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		
	} 
	
	
	
	
	

}
