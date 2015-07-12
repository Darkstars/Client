package com.zhang.post;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.zhang.client.android.history.DBHelper;

public class GetData {
	  private static final int DB_VERSION = 5;  //���ݿ�汾
	  private static final String DB_NAME = "barcode_scanner_history.db";   //���ݿ���
	  static final String TABLE_NAME = "history";     //���ݱ���
	  static final String ID_COL = "id";     //�ֶ�id
	  static final String TEXT_COL = "text";   //����
	  static final String FORMAT_COL = "format";   //��ʽ
	  static final String DISPLAY_COL = "display";  //չʾ
	  static final String TIMESTAMP_COL = "timestamp";   //int
	  static final String DETAILS_COL = "details";   //��ϸ
	  private static final String[] COLUMNS = {
		  GetData.TEXT_COL,
		  GetData.DISPLAY_COL,
		  GetData.FORMAT_COL,
		  GetData.TIMESTAMP_COL,
		  GetData.DETAILS_COL,
	  };
	  
	  public static List<String> getData(Context context){
		  SQLiteOpenHelper helper = new DBHelper(context);
		  SQLiteDatabase db = null;
		  Cursor cursor = null;
		  List<String> li = new ArrayList<String>();
		  try {
		      db = helper.getReadableDatabase();
		      cursor = db.query(GetData.TABLE_NAME, COLUMNS, null, null, null, null, GetData.TIMESTAMP_COL + " DESC");
		      while (cursor.moveToNext()) {
		        String text = cursor.getString(0);
		        String display = cursor.getString(1);
		        String format = cursor.getString(2);
		        long timestamp = cursor.getLong(3);
		        String details = cursor.getString(4);
		        li.add(text);
		      }
		    } finally {
		    close(cursor, db);
		    }
		  return li;
	  }
	  
	  
	  private static void close(Cursor cursor, SQLiteDatabase database) {
		    if (cursor != null) {
		      cursor.close();
		    }
		    if (database != null) {
		      database.close();
		    }
		  }
	  
}