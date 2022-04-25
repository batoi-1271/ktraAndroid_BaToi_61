package com.example.batoi_61;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class batoi_dataBase extends SQLiteOpenHelper{
    private static final String  DATABASE_NAME =  "QLVANTAI.db";
    private static final String TABLE_NAME = "tb_vantai";
    private static final String ID = "mavantai";
    private static final String BKS = "bks";
    private static final String NAMECX = "tenchuxe";
    private static final String HANGXE = "hangxe";
    private static final String TRONGTAI = "trongtai";
    private static final String HTKINHDOANH = "htkinhdoanh";
    private static int VERSION = 1;
    private Context context;

    public batoi_dataBase(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
        this.context = context;
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql = "create table "+TABLE_NAME+"("
                +ID+" integer primary key autoincrement,"
                +BKS+" Text,"
                +NAMECX+" Text,"
                +HANGXE+" Text,"
                +TRONGTAI+" Text,"
                +HTKINHDOANH+" Text)";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+DATABASE_NAME);
        onCreate(sqLiteDatabase);
    }
    public void insert(batoi_vanTai vanTai){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BKS, vanTai.getBks());
        values.put(NAMECX, vanTai.getTenchuxe());
        values.put(HANGXE, vanTai.getHangxe());
        values.put(TRONGTAI, vanTai.getTrongtai());
        values.put(HTKINHDOANH, vanTai.getHtkinhdoanh());

        sqLiteDatabase.insert(TABLE_NAME,null,values);
        sqLiteDatabase.close();

    }
    public int update (batoi_vanTai vanTai){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BKS, vanTai.getBks());
        values.put(NAMECX, vanTai.getTenchuxe());
        values.put(HANGXE, vanTai.getHangxe());
        values.put(TRONGTAI, vanTai.getTrongtai());
        values.put(HTKINHDOANH, vanTai.getHtkinhdoanh());

        int result = sqLiteDatabase.update(TABLE_NAME,values,ID +"=?",new String[]{String.valueOf(vanTai.getId())});
        sqLiteDatabase.close();
        return result;
    }
    public int delete (int id){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        int result = sqLiteDatabase.delete(TABLE_NAME,ID+"=?",new String[]{String.valueOf(id)});
        sqLiteDatabase.close();
        return result;
    }
    public List<batoi_vanTai> getAll(){
        List<batoi_vanTai> vatTaiList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String sql = "select * from "+TABLE_NAME;

        Cursor cursor = sqLiteDatabase.rawQuery(sql,null);

        if(cursor.moveToFirst()){
            do {
                batoi_vanTai vatTai = new batoi_vanTai();
                vatTai.setId(cursor.getInt(0));
                vatTai.setBks(cursor.getString(1));
                vatTai.setTenchuxe(cursor.getString(2));
                vatTai.setHangxe(cursor.getString(3));
                vatTai.setTrongtai(cursor.getString(4));
                vatTai.setHtkinhdoanh(cursor.getString(5));

                vatTaiList.add(vatTai);
            } while (cursor.moveToNext());
        }

        return vatTaiList;
    }
    public batoi_vanTai findById(int id){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        Cursor cursor = sqLiteDatabase.query(TABLE_NAME,new String[]{ID,BKS, NAMECX, HANGXE, TRONGTAI, HTKINHDOANH },
                ID+"=?",new String[]{
                        String.valueOf(id)
                },null,null,null,null);

        if(cursor!=null){
            try {
                cursor.moveToFirst();
                batoi_vanTai vatTai = new batoi_vanTai();
                vatTai.setId(cursor.getInt(0));
                vatTai.setBks(cursor.getString(1));
                vatTai.setTenchuxe(cursor.getString(2));
                vatTai.setHangxe(cursor.getString(3));
                vatTai.setTrongtai(cursor.getString(4));
                vatTai.setHtkinhdoanh(cursor.getString(5));
                cursor.close();
                sqLiteDatabase.close();
                return vatTai;
            }
            catch (Exception e){
                return null;
            }
        }
        return null;
    }
}
