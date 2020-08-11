package com.lambtoncollege.buildmypc.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lambtoncollege.buildmypc.model.UserData;

import java.util.ArrayList;
import java.util.List;

public class UserDatabase {

    public static final String DB_Name="userdata.db";
    public static final int DB_Ver=2;
    public static final String DB_Table="User_Data";
    public static final String Name="Name";
    public static final String Email="Email";
    public static final String Phone="Phone";
    public static final String Postal="Postal";
    public static final String Address="Address";
    public static final String Password="Password";
    public static final String KEY_ID="id";


    //Query to create table

    public static final String Q_Create=
            "CREATE TABLE "+DB_Table+"("+KEY_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+Name+" TEXT,"+Email+" TEXT, "+Phone+" TEXT, "+Postal+" TEXT, "+Address+" TEXT, "+Password+" TEXT)";

    Context c;
    private UserDatabase.DBHelper dbHelper;
    private SQLiteDatabase database;

    //all database operation coded here
    public UserDatabase(Context context){
        c = context;

    }

    public UserDatabase open() {

        dbHelper=new UserDatabase.DBHelper(c);

        database=dbHelper.getWritableDatabase();

        return this;
    }

    public void save(String name,String email,String phone, String postal,
                     String address,String password) {

        ContentValues cv= new ContentValues();
        cv.put(Name,name);
        cv.put(Email,email);
        cv.put(Phone,phone);
        cv.put(Postal,postal);
        cv.put(Address,address);
        cv.put(Password,password);
        database.insert(DB_Table,null,cv);
    }

    public void close() {
        database.close();
    }

    public List<UserData> getUserData()
    {
        List<UserData> data= new ArrayList<>();
        String[] columns={KEY_ID,Name,Email,Phone,Postal,Address,Password};
        Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);

        int iname = cursor.getColumnIndex(Name);
        int iemail = cursor.getColumnIndex(Email);
        int iphone=cursor.getColumnIndex(Phone);
        int ipostal=cursor.getColumnIndex(Postal);
        int iaddress=cursor.getColumnIndex(Address);
        int ipassword=cursor.getColumnIndex(Password);
        int iuserId=cursor.getColumnIndex(KEY_ID);


        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            UserData user = new UserData();
            user.setUserName(cursor.getString(iname));
            user.setUserEmail(cursor.getString(iemail));
            user.setUserPhone(cursor.getString(iphone));
            user.setUserPostal(cursor.getString(ipostal));
            user.setUserAddress(cursor.getString(iaddress));
            user.setUserPassword(cursor.getString(ipassword));
            user.setUserId(cursor.getString(iuserId));

            data.add(user);
        }
        return data;
    }


    public List<UserData> getUserByEmailPassword(String email,String password)
        {

            String whereQuery = "SELECT  * FROM " + DB_Table+" WHERE "+Email+" = '"+email+"' AND "+Password+" = '"+password+"'";
            Cursor cursor = database.rawQuery(whereQuery, null);
            List<UserData> data= new ArrayList<>();
            // String[] columns={KEY_ID,BookName,AuhtorName,BookDecs,BookUrl,BookCategory};
            // Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);

            int iname = cursor.getColumnIndex(Name);
            int iemail = cursor.getColumnIndex(Email);
            int iphone=cursor.getColumnIndex(Phone);
            int ipostal=cursor.getColumnIndex(Postal);
            int iaddress=cursor.getColumnIndex(Address);
            int ipassword=cursor.getColumnIndex(Password);
            int iuserId=cursor.getColumnIndex(KEY_ID);


            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                UserData user = new UserData();
                user.setUserName(cursor.getString(iname));
                user.setUserEmail(cursor.getString(iemail));
                user.setUserPhone(cursor.getString(iphone));
                user.setUserPostal(cursor.getString(ipostal));
                user.setUserAddress(cursor.getString(iaddress));
                user.setUserPassword(cursor.getString(ipassword));
                user.setUserId(cursor.getString(iuserId));

                data.add(user);
            }
            return data;
        }
    public void delete(String id) {
        database.delete(DB_Table, KEY_ID+"="+id, null);
    }

    public void deleteWithoutId() {
        database.delete(DB_Table, null, null);
    }

    public int getProfilesCount() {
        String countQuery = "SELECT  * FROM " + DB_Table;

        Cursor cursor = database.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        return count;
    }
    private class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            super(context, DB_Name, null, DB_Ver);
        }

        @Override
        public void onCreate(SQLiteDatabase sqLiteDatabase) {

            sqLiteDatabase.execSQL(Q_Create);////////////////////

        }

        @Override
        public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

        }
    }
}

