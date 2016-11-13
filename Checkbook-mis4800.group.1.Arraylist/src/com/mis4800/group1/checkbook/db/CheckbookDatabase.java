/**
 * 
 */
package com.mis4800.group1.checkbook.db;

import java.util.Date;

import com.mis4800.group1.checkbook.model.Checkbook;
import com.mis4800.group1.checkbook.model.Transaction;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author shone
 *
 */
public class CheckbookDatabase extends SQLiteOpenHelper {
	
	public static final String DBNAME = "Checkbook";
	public static final int version = 1;
	
	private SQLiteDatabase mydatabase;
	
	private final String CREATESQL = "create table checkbook(_id integer primary key, tdate date, payee varchar(100), amount double, memo varchar(100));";
	
	/**
	 * @param context
	 */
	public CheckbookDatabase(Context context) {
		
		// TODO Auto-generated constructor stub
		super(context, DBNAME, null, version);
		mydatabase = getWritableDatabase();
	}

	public void save(Checkbook mycheckbook) {
		mydatabase.delete("checkbook", null, null); // Delete everything in the checkbook
		
		for(Transaction t :  mycheckbook.getTransactions()) {
			ContentValues c = new ContentValues();
			
			c.put("tdate", t.getDateString());
			c.put("payee", t.getPayee());
			c.put("amount", t.getAmount());
			c.put("memo", t.getMemo());
			
			mydatabase.insert("checkbook", null, c);
		}
		
	}
	
	public void retrieve(Checkbook mycheckbook) {
		mycheckbook.getTransactions().clear();
		
		Cursor c = mydatabase.rawQuery("select * from checkbook", null);
		
		while(c.moveToNext()) {
            mycheckbook.addTransaction(new Transaction(new Date(c.getString(1)),
                            c.getString(2), c.getDouble(3), c.getString(4
)));
		}
		c.close();
	}
	
	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onCreate(android.database.sqlite.SQLiteDatabase)
	 */
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATESQL);
	}

	/* (non-Javadoc)
	 * @see android.database.sqlite.SQLiteOpenHelper#onUpgrade(android.database.sqlite.SQLiteDatabase, int, int)
	 */
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}