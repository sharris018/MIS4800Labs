package com.mis4800.group1.tipplease;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class Multibillrowadapter extends ArrayAdapter<Party> {

	public Multibillrowadapter(Context context, int resource, List<Party> objects) {
		super(context, resource, objects);
	
	}

	/* (non-Javadoc)
	 * @see android.widget.ArrayAdapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// here we will make changed to the convert view
		View v = convertView;
		if (v == null) {
			LayoutInflater vi;
			vi = LayoutInflater.from(getContext());
			v = vi.inflate(R.layout.multibillrow, null);
		}
		
		TextView tvParty = (TextView) v.findViewById(R.id.tvParty);
		TextView tvBillAmount = (TextView) v.findViewById(R.id.tvBillAmount);
		TextView tvTipAmount = (TextView) v.findViewById(R.id.tvTipAmount);
		TextView tvTotalAmount = (TextView) v.findViewById(R.id.tvTotalAmount);
		
		Party currentParty = getItem(position);
		tvParty.setText(currentParty.getPartyname());
		tvBillAmount.setText(currentParty.getBillAmount().toString());
		tvTipAmount.setText(currentParty.getTipAmount().toString());
		tvTotalAmount.setText(currentParty.getTotalAmount().toString());
		
		return v;
		
	}
	
	

}
