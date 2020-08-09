package com.lambtoncollege.buildmypc.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lambtoncollege.buildmypc.model.Accessories;
import com.lambtoncollege.buildmypc.model.BrandPc;

import java.util.ArrayList;
import java.util.List;

public class AccessoriesDatabase {

    public static final String DB_Name="accessories.db";
    public static final int DB_Ver=2;
    public static final String DB_Table="Accessories_Data";
    public static final String Acc_Name="Name";
    public static final String Acc_Brand="Acc_Brand";
    public static final String Acc_Colour="Acc_Colour";
    public static final String Acc_Short_Desc="Acc_Short_Desc";
    public static final String Acc_Long_Desc="Acc_Long_Desc";
    public static final String Acc_Price="Price";
    public static final String KEY_ID="id";


    //Query to create table

    public static final String Q_Create=
            "CREATE TABLE "+DB_Table+"("+KEY_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+Acc_Name+" TEXT,"+Acc_Brand+" TEXT, "+Acc_Colour+" TEXT, "+Acc_Short_Desc+" TEXT, "+Acc_Long_Desc+" TEXT, "+Acc_Price+" TEXT)";

    Context c;
    private AccessoriesDatabase.DBHelper dbHelper;
    private SQLiteDatabase database;

    //all database operation coded here
    public AccessoriesDatabase(Context context){
        c = context;

    }

    public AccessoriesDatabase open() {

        dbHelper=new AccessoriesDatabase.DBHelper(c);

        database=dbHelper.getWritableDatabase();

        return this;
    }

    public void save(String acc_name,String acc_brand,String acc_colour, String acc_short,
                     String acc_long,int price) {

        ContentValues cv= new ContentValues();
        cv.put(Acc_Name,acc_name);
        cv.put(Acc_Brand,acc_brand);
        cv.put(Acc_Colour,acc_colour);
        cv.put(Acc_Short_Desc,acc_short);
        cv.put(Acc_Long_Desc,acc_long);
        cv.put(Acc_Price,price);
        database.insert(DB_Table,null,cv);
    }

    public void close() {
        database.close();
    }

    public List<Accessories> getAccessoriesData()
    {
        List<Accessories> data= new ArrayList<>();
        String[] columns={KEY_ID,Acc_Name,Acc_Brand,Acc_Colour,Acc_Short_Desc,Acc_Long_Desc,Acc_Price};
        Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);

        int iname = cursor.getColumnIndex(Acc_Name);
        int ibrand = cursor.getColumnIndex(Acc_Brand);
        int icolour=cursor.getColumnIndex(Acc_Colour);
        int ishort=cursor.getColumnIndex(Acc_Short_Desc);
        int ilong=cursor.getColumnIndex(Acc_Long_Desc);
        int iaccId=cursor.getColumnIndex(KEY_ID);
        int iprice=cursor.getColumnIndex(Acc_Price);


        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            Accessories acc = new Accessories();
            acc.setAccName(cursor.getString(iname));
            acc.setAccBrand(cursor.getString(ibrand));
            acc.setAccColour(cursor.getString(icolour));
            acc.setAccShortDesc(cursor.getString(ishort));
            acc.setAccLongDesc(cursor.getString(ilong));
            acc.setAccID(cursor.getString(iaccId));
            acc.setAccPrice(cursor.getInt(iprice));

            data.add(acc);
        }
        return data;
    }
    //        public List<BuildDesktop> getBookDataByCategory(String category)
//        {
//
//            String whereQuery = "SELECT  * FROM " + DB_Table+" WHERE "+BookCategory+" = '"+category+"'";
//            Cursor cursor = database.rawQuery(whereQuery, null);
//            List<BuildDesktop> data= new ArrayList<>();
//            // String[] columns={KEY_ID,BookName,AuhtorName,BookDecs,BookUrl,BookCategory};
//            // Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);
//
//            int iName=cursor.getColumnIndex(BookName);
//            int iAuthor=cursor.getColumnIndex(AuhtorName);
//            int iDesc=cursor.getColumnIndex(BookDecs);
//            int iUrl=cursor.getColumnIndex(BookUrl);
//            int iCat=cursor.getColumnIndex(BookCategory);
//            int iId=cursor.getColumnIndex(KEY_ID);
//            int iPrice=cursor.getColumnIndex(BookPrice);
//
//            for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
//                BuildDesktop book = new BuildDesktop();
//                book.setBookName(cursor.getString(iName));
//                book.setBookAuthor(cursor.getString(iAuthor));
//                book.setBookDesc(cursor.getString(iDesc));
//                book.setBookUrl(cursor.getString(iUrl));
//                book.setBookCategory(cursor.getString(iCat));
//                book.setBookId(cursor.getString(iId));
//                book.setBookPrice(cursor.getString(iPrice));
//
//                data.add(book);
//            }
//            return data;
//        }
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

