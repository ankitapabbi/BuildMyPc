package com.lambtoncollege.buildmypc.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lambtoncollege.buildmypc.model.BrandPc;
import com.lambtoncollege.buildmypc.model.BuildDesktop;

import java.util.ArrayList;
import java.util.List;

public class BrandPcDatabase {

    public static final String DB_Name="brandpc.db";
    public static final int DB_Ver=2;
    public static final String DB_Table="Brand_Pc";
    public static final String Name="Name";
    public static final String Screen_Size="Screen_Size";
    public static final String Processor="Processor";
    public static final String RAM="RAM";
    public static final String ROM="ROM";
    public static final String GraphicCard="Graphic_Card";
    public static final String Warranty="Warranty";
    public static final String Price="Price";
    public static final String KEY_ID="id";


    //Query to create table

    public static final String Q_Create=
            "CREATE TABLE "+DB_Table+"("+KEY_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+Name+" TEXT,"+Screen_Size+" TEXT, "+Processor+" TEXT, "+RAM+" TEXT, "+ROM+" TEXT, "+GraphicCard+" TEXT,"+Warranty+" TEXT,"+Price+" TEXT)";

    Context c;
    private BrandPcDatabase.DBHelper dbHelper;
    private SQLiteDatabase database;

    //all database operation coded here
    public BrandPcDatabase(Context context){
        c = context;

    }

    public BrandPcDatabase open() {

        dbHelper=new BrandPcDatabase.DBHelper(c);

        database=dbHelper.getWritableDatabase();

        return this;
    }

    public void save(String name,String screensize,String processor, String ram,
                     String rom,String graphicCard,String warranty, int price) {

        ContentValues cv= new ContentValues();
        cv.put(Name,name);
        cv.put(Screen_Size,screensize);
        cv.put(Processor,processor);
        cv.put(RAM,ram);
        cv.put(ROM,rom);
        cv.put(GraphicCard,graphicCard);
        cv.put(Warranty,warranty);
        cv.put(Price,price);
        database.insert(DB_Table,null,cv);
    }

    public void close() {
        database.close();
    }

    public List<BrandPc> getBrandPcData()
    {
        List<BrandPc> data= new ArrayList<>();
        String[] columns={KEY_ID,Name,Screen_Size,Processor,RAM,ROM,GraphicCard,Warranty,Price};
        Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);

        int iname = cursor.getColumnIndex(Name);
        int iscreen = cursor.getColumnIndex(Screen_Size);
        int ip=cursor.getColumnIndex(Processor);
        int iram=cursor.getColumnIndex(RAM);
        int irom=cursor.getColumnIndex(ROM);
        int igraphic=cursor.getColumnIndex(GraphicCard);
        int ibandId=cursor.getColumnIndex(KEY_ID);
        int iwarranty=cursor.getColumnIndex(Warranty);
        int iprice=cursor.getColumnIndex(Price);


        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            BrandPc brand = new BrandPc();
            brand.setName(cursor.getString(iname));
            brand.setScreenSize(cursor.getString(iscreen));
            brand.setProcessor(cursor.getString(ip));
            brand.setRam(cursor.getString(iram));
            brand.setRom(cursor.getString(irom));
            brand.setGraphics(cursor.getString(igraphic));
            brand.setBrandPcID(cursor.getString(ibandId));
            brand.setWarranty(cursor.getString(iwarranty));
            brand.setPrice(cursor.getInt(iprice));

            data.add(brand);
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

