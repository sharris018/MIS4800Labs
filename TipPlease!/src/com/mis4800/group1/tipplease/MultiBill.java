package com.mis4800.group1.tipplease;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

public class MultiBill extends Activity implements OnClickListener {

	Button btnCalculate;
	EditText txtBillPrice, txtParty;
	Spinner tipoption1;
	ListView partylistview;
	
	Multibillrowadapter adapter;
	List<Party> myParties;


	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.multibill);
		// Grab the buttons 
		btnCalculate = (Button) findViewById(R.id.btnCalculate);
		// Grab spinner button 
		tipoption1 = (Spinner) findViewById(R.id.tipoption1); 
		// Set up something to happen when the button is clicked
		btnCalculate.setOnClickListener(this);
		// Grab the text field
		txtBillPrice = (EditText)findViewById(R.id.txtBillPrice);
		txtParty = (EditText)findViewById(R.id.txtParty);
		// Grab the list view
		partylistview = (ListView) findViewById(R.id.partylistview);
		myParties = new ArrayList<Party>();
		adapter = new Multibillrowadapter(this,
				R.layout.multibillrow,
				myParties);
		partylistview.setAdapter(adapter);
		
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	/* (non-Javadoc)
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
		if (v.getId() == R.id.btnCalculate) {
			double[] tips = {0, 10.0, 15.0, 18.0, 20.0, 25.0}; // Change this to what you have in your tipoption1 spinner

			int selectedPosition = tipoption1.getSelectedItemPosition();
			switch (selectedPosition) {
			case 0:
				Toast.makeText(this, "Please select a tip percentage", Toast.LENGTH_LONG).show(); 

				break;
			default:
				double tipused = tips[selectedPosition];
				double billprice = Double.parseDouble(txtBillPrice.getText().toString());
				String name = txtParty.getText().toString();
				Party myparty = new Party(name, billprice, tipused);
				myParties.add(myparty);
				adapter.notifyDataSetChanged();
			}
		}
		
	}
}	
