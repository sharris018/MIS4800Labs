package com.mis4800.group1.checkbook_android;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mis4800.group1.checkbook.model.Checkbook;
import com.mis4800.group1.checkbook.model.Transaction;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener, OnItemClickListener {
	Button btnAdd, btnDelete;
	TextView tvBalance;
	ListView lstTransactions;
	EditText txtAmount;
	// The Adapter is an adapter for Transactions, not Double
	ArrayAdapter<Transaction> adapter;
	// Create an array of transactions
	// With Objects, we don't need an array or arraylist, but just a checkbook.
	Checkbook mycheckbook; 
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // connect controller to the view 
		mycheckbook = new Checkbook("U1CU", "Group 1");

		tvBalance = (TextView) findViewById(R.id.tvBalance);
		txtAmount = (EditText) findViewById(R.id.txtAmount);

		btnAdd = (Button) findViewById(R.id.btnAdd);
		btnDelete = (Button) findViewById(R.id.btnDelete);
		btnAdd.setOnClickListener(this);
		btnDelete.setOnClickListener(this);

		lstTransactions = (ListView) findViewById(R.id.lstTransactions);

		adapter = new ArrayAdapter<Transaction>(this,
				android.R.layout.simple_list_item_1,
				mycheckbook.getTransactions());

		lstTransactions.setAdapter(adapter);
		lstTransactions.setOnItemClickListener(this);

	}

	private int positionToUpdate = -1;


	

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
		switch (v.getId()) {
		case R.id.btnAdd:
			double amount = Double.parseDouble(txtAmount.getText().toString());
			
			// First we need to create an instance of the transaction object from stuff the user has put in
			// Since we only have the amount, lets put some default values for now.
			// new Date() returns today's date.
			Transaction newtransaction = new Transaction(new Date(), "blank", amount, "memo");
			// Check the text on the button - if Add, perform the Add function
			if (btnAdd.getText().equals("Add")) {
				// Add the amount to the array
				// With the objects, we don't add a double to the arraylist, 
				// but we add a transaction to the checkbook, exactly what you would expect
				mycheckbook.addTransaction(newtransaction);
			} else {  // Otherwise perform the update function
				if(positionToUpdate < 0) return;
				// Update the transaction using the saved positionToUpdate
				// With objects, you call the updateTransaction method.
				mycheckbook.updateTransaction(positionToUpdate, newtransaction);
				// Turn back the text of the button
				btnDelete.setVisibility(View.GONE);
				btnAdd.setText("Add");
				
			}

			adapter.notifyDataSetChanged();
			// Update the balance
			tvBalance.setText("Current Balance is: " + mycheckbook.balance());
			break;

		case R.id.btnDelete:
			// Create switch and if-statement to make delete button invisible
			// until clicked.
			// Once item in lstTransaction is selected delete button appears.
			// Change the visibility of the Delete Button.
			switch (v.getId()) {
			case R.id.btnDelete:
				if (btnDelete.getVisibility() == View.VISIBLE) {
					btnDelete.setVisibility(View.GONE);
				} else {
					btnDelete.setVisibility(View.VISIBLE);
					
				}
				break;
				}
			
			// Remove the amount from the array
			// Call array position and make sure position to update is -1.
			if (positionToUpdate < 0)
				return;
			mycheckbook.deleteTransaction(positionToUpdate);
			btnAdd.setText("Add");
			break;

		}
		// editText clears out after each enter, update or deletion.
		txtAmount.setText("");

		// Tell the adapter the data set has changed
		adapter.notifyDataSetChanged();
		positionToUpdate = -1;

		// Update the balance
		tvBalance.setText("Current Balance is: " + mycheckbook.balance());
	}

	@Override
	public void onItemClick(AdapterView<?> listview, View itemview, int itemposition, long itemId) {
		// Copy the data from the current position to the EditText
		// Lets get the transaction from the current position from the list of transactions in the checkbook.
		// Another option would have been to create a getTransaction(position) method in the CheckBook class
		Transaction curt = mycheckbook.getTransactions().get(itemposition);
		btnDelete.setVisibility(View.VISIBLE); 
		// Using getFormattedAmount would cause a problem parsing the $ symbol out, so lets stay with Doubles
		// to put in the Amount field.
		txtAmount.setText(curt.getAmount().toString());
		// Change the button so the user knows we are updating
		btnAdd.setText("Update");
		// Save the itemposition so update can work
		positionToUpdate = itemposition;
		listview.isSelected();
		
	}
}
