package com.lambtoncollege.buildmypc.utilities;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.lambtoncollege.buildmypc.model.BuildDesktop;
import com.lambtoncollege.buildmypc.model.BuildLaptop;

import java.util.ArrayList;
import java.util.List;

public class BuildLaptopDatabase {

    public static final String DB_Name="buildLaptop.db";
    public static final int DB_Ver=2;
    public static final String DB_Table="Build_Laptop";
    public static final String ScreenSize ="Screen_size";
    public static final String Display="Display";
    public static final String ScreenType="Screen_Type";
    public static final String Processor="Processor";
    public static final String ProcessorGen="Processor_Gen";
    public static final String RAM="RAM";
    public static final String Storage="Storage";
    public static final String GraphicCard="Graphic_Card";
    public static final String Price = "Price";
    public static final String KEY_ID="id";


    //Query to create table

    public static final String Q_Create=
            "CREATE TABLE "+DB_Table+"("+KEY_ID+" INTEGER PRIMARY KEY  AUTOINCREMENT,"+ScreenSize+" TEXT,"+Display+" TEXT,"+ScreenType+" TEXT,"+Processor+" TEXT, "+ProcessorGen+" TEXT, "+RAM+" TEXT, "+Storage+" TEXT, "+GraphicCard+" TEXT, "+Price+" TEXT)";

    Context c;
    private BuildLaptopDatabase.DBHelper dbHelper;
    private SQLiteDatabase database;

    //all database operation coded here
    public BuildLaptopDatabase(Context context){
        c = context;

    }

    public BuildLaptopDatabase open() {

        dbHelper=new BuildLaptopDatabase.DBHelper(c);

        database=dbHelper.getWritableDatabase();

        return this;
    }

    public void save(String screenSize,String display,String screenType,
                     String processor, String processorGen,String ram,
                     String storage,String graphicCard, int price) {

        ContentValues cv= new ContentValues();

        cv.put(ScreenSize,screenSize);
        cv.put(Display,display);
        cv.put(ScreenType,screenType);
        cv.put(Processor,processor);
        cv.put(ProcessorGen,processorGen);
        cv.put(RAM,ram);
        cv.put(Storage,storage);
        cv.put(GraphicCard,graphicCard);
        cv.put(Price,price);
        database.insert(DB_Table,null,cv);
    }

    public void close() {
        database.close();
    }

    public List<BuildLaptop> getBuildLaptopData()
    {
        List<BuildLaptop> data= new ArrayList<>();
        String[] columns={KEY_ID,ScreenSize,Display,ScreenType,Processor,ProcessorGen,RAM,Storage,GraphicCard,Price};
        Cursor cursor=database.query(DB_Table,columns,null,null,null,null,null);

        int ip=cursor.getColumnIndex(Processor);
        int ipgen=cursor.getColumnIndex(ProcessorGen);
        int iram=cursor.getColumnIndex(RAM);
        int istorage=cursor.getColumnIndex(Storage);
        int igraphic=cursor.getColumnIndex(GraphicCard);
        int ibDeskId=cursor.getColumnIndex(KEY_ID);
        int issize=cursor.getColumnIndex(ScreenSize);
        int idisplay=cursor.getColumnIndex(Display);
        int istype=cursor.getColumnIndex(ScreenType);
        int iprice = cursor.getColumnIndex(Price);

        for(cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
            BuildLaptop desktop = new BuildLaptop();
            desktop.setProcessor(cursor.getString(ip));
            desktop.setProcessorGen(cursor.getString(ipgen));
            desktop.setRam(cursor.getString(iram));
            desktop.setStorageType(cursor.getString(istorage));
            desktop.setGraphicCard(cursor.getString(igraphic));
            desktop.setBuildLaptopID(cursor.getString(ibDeskId));
            desktop.setScreenSize(cursor.getString(issize));
            desktop.setDisplay(cursor.getString(idisplay));
            desktop.setScreenType(cursor.getString(istype));
            desktop.setPrice(cursor.getInt(iprice));

            data.add(desktop);
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

