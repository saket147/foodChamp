package com.example.saket.foodchamp;


 import android.database.SQLException;
 import android.database.sqlite.SQLiteDatabase;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.Hashtable;
 import java.util.jar.Attributes;

 import android.content.ContentValues;
 import android.content.Context;
 import android.database.Cursor;
 import android.database.DatabaseUtils;
 import android.database.sqlite.SQLiteOpenHelper;
 import android.database.sqlite.SQLiteDatabase;

 public class DBHelper extends SQLiteOpenHelper {

 public static final String DATABASE_NAME = "MyDBName.db";
 public static final String DATABASE_TABLE_NAME = "contacts";
 public static final String CONTACTS_COLUMN_ID = "id";
 public static final String CONTACTS_COLUMN_RESTAURENT_NAME = "restaurent_name";
 public static final String CONTACTS_COLUMN_BRANCH = "branch_name";
 /*public static final String CONTACTS_COLUMN_NAME = "name";
 public static final String CONTACTS_COLUMN_NAME = "name";*/
public static final String CONTACTS_COLUMN_NAME = "name";
public static final String CONTACTS_COLUMN_PASSWORD = "password";
public static final String CONTACTS_COLUMN_EMAIL = "email";
public static final String CONTACTS_COLUMN_ADDRESS = "address";
public static final String CONTACTS_COLUMN_CITY = "place";
public static final String CONTACTS_COLUMN_PHONE = "phone";
private String CONTACTS_COLUMN_CHK_VALUES = "checkbox_value";
//private HashMap hp;

public DBHelper(Context context)
        {

        super(context, DATABASE_NAME , null, 1);
        }

@Override
public void onCreate(SQLiteDatabase db) {
        db.execSQL(
        "create table "+DATABASE_TABLE_NAME +
        "(" + ""+CONTACTS_COLUMN_ID+" integer primary key," +
        ""+CONTACTS_COLUMN_RESTAURENT_NAME+" text," +
        ""+CONTACTS_COLUMN_BRANCH +"text," +
        ""+CONTACTS_COLUMN_NAME+" text," +
        ""+CONTACTS_COLUMN_PHONE+" text," +
        ""+CONTACTS_COLUMN_EMAIL+" text," +
        ""+CONTACTS_COLUMN_ADDRESS+" text," +
        ""+CONTACTS_COLUMN_CITY+" text," +
        ""+CONTACTS_COLUMN_PASSWORD+" text" +
        "" +CONTACTS_COLUMN_CHK_VALUES+"TEXT_NOT_NULL" +
        ")"
        );
        }
public void deleteTable(){
        SQLiteDatabase db = this.getWritableDatabase();

        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_NAME);
        db.execSQL(
        "create table "+DATABASE_TABLE_NAME +
        "("+CONTACTS_COLUMN_ID+" integer primary key,"+CONTACTS_COLUMN_NAME+" text,"+CONTACTS_COLUMN_PHONE+" text,"+CONTACTS_COLUMN_EMAIL+" text,"+CONTACTS_COLUMN_ADDRESS+" text,"+CONTACTS_COLUMN_CITY+" text,"+CONTACTS_COLUMN_PASSWORD+" text)"
        );

        }
@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS contacts");
        onCreate(db);
        }

public boolean insertContact  (String name,String password)
        {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password",password);

        db.insert("contacts", null, contentValues);
        return true;
        }
public boolean insertDetails(String restaurent_name,String description,String branch,String address,String email)
        {

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();

        contentValues.put("restaurent_name",restaurent_name);
        contentValues.put("description",description);
        contentValues.put("branch",branch);
        contentValues.put("address",address);
        contentValues.put("email",email);
        db.insert("contacts",null,contentValues);
        return true;
        }

public Cursor getData(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from contacts where id="+id+"", null );
        return res;
        }

public boolean updateContact (Integer id, String restaurent_name,String branch,String name, String password,String phone, String email, String street,String place)
        {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("restaurent_name",restaurent_name);
        contentValues.put("branch",branch);
        contentValues.put("name", name);
        contentValues.put("password",password);
        contentValues.put("phone", phone);
        contentValues.put("email", email);
        contentValues.put("place", place);
        db.update("contacts", contentValues, "id = ? ", new String[] { Integer.toString(id) } );
        return true;
        }

public Integer deleteContact (Integer id)
        {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("contacts",
        "id = ? ",
        new String[] { Integer.toString(id) });
        }

public ArrayList<String>  getAllCotacts()
        {
        ArrayList<String> array_list = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+DATABASE_TABLE_NAME, null );
        res.moveToFirst();

        while(res.isAfterLast() == false){
        array_list.add(res.getString(res.getColumnIndex(CONTACTS_COLUMN_NAME)));
        res.moveToNext();
        }
        return array_list;
        }
        }

