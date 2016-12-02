/**
 * 
 */
package com.mis4800.group1.tipplease;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * @author shone
 *
 */
public class BillActivity extends Activity {
	
	Button btnEnter2; 
	EditText txtItem, txtPrice, txtTotal, txtTip; 
	TextView tvTip, tvTotal;
	/* (non-Javadoc)
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_singlebill);

	} 
	
	
	
	
	

}
