package com.example.acer.kapil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;


public class ProductsDatabase extends SQLiteOpenHelper implements TableProducts {


    public static final String DATABASE_NAME="products.db";
    public static final int VERSION=1;

    public ProductsDatabase(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DATABASE_NAME, factory, VERSION);
    }
    public ProductsDatabase(Context context)
    {
        super(context, DATABASE_NAME, null, VERSION);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLM= CREATE+ TABLEM_NAME+ LBR+ COLUMN_ID+ INT_PK_AUTOIC+
                COMMA+ COLUMN_NAME + TYPE_TEXT+ COMMA+ COLUMN_TYPE+ TYPE_TEXT+COMMA+COLUMN_COSTPRICE+TYPE_REAL
                + COMMA+COLUMN_SELLINGPRICE+TYPE_REAL+COMMA+COLUMN_PIECES+TYPE_INTEGER+RBR+ TERMINATE;
        String CREATE_TABLD=CREATE+ TABLED_NAME+ LBR+ COLUMN_ID+ INT_PK_AUTOIC+
                COMMA+ COLUMN_NAME + TYPE_TEXT+ COMMA+ COLUMN_TYPE+ TYPE_TEXT+COMMA+COLUMN_COSTPRICE+TYPE_REAL
                + COMMA+COLUMN_SELLINGPRICE+TYPE_REAL+COMMA+COLUMN_PIECES+TYPE_INTEGER+RBR+ TERMINATE;
        String CREATE_TABLG=CREATE+ TABLEG_NAME+ LBR+ COLUMN_ID+ INT_PK_AUTOIC+
                COMMA+ COLUMN_NAME + TYPE_TEXT+ COMMA+ COLUMN_TYPE+ TYPE_TEXT+COMMA+COLUMN_COSTPRICE+TYPE_REAL
                + COMMA+COLUMN_SELLINGPRICE+TYPE_REAL+COMMA+COLUMN_PIECES+TYPE_INTEGER+RBR+ TERMINATE;
        db.execSQL(CREATE_TABLM);
        db.execSQL(CREATE_TABLD);
        db.execSQL(CREATE_TABLG);}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void insertMedicine(MedicineList medicine)
    {
        SQLiteDatabase sqlDb=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,medicine.getName());
        cv.put(COLUMN_TYPE,medicine.getType());
        cv.put(COLUMN_COSTPRICE,medicine.getCostprice());
        cv.put(COLUMN_SELLINGPRICE,medicine.getSellingprice());
        cv.put(COLUMN_PIECES,medicine.getPieces());

        sqlDb.insert(TABLEM_NAME,null,cv);


    }
    public void insertDisposables(DisposableList disposable)
    {
        SQLiteDatabase sqlDb=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,disposable.getName());
        cv.put(COLUMN_TYPE,disposable.getType());
        cv.put(COLUMN_COSTPRICE,disposable.getCostprice());
        cv.put(COLUMN_SELLINGPRICE,disposable.getSellingprice());
        cv.put(COLUMN_PIECES,disposable.getPieces());
        sqlDb.insert(TABLED_NAME,null,cv);


    }

    public void insertGrocery(GroceryList grocery)
    {
        SQLiteDatabase sqlDb=getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(COLUMN_NAME,grocery.getName());
        cv.put(COLUMN_TYPE,grocery.getType());
        cv.put(COLUMN_COSTPRICE,grocery.getCostprice());
        cv.put(COLUMN_SELLINGPRICE,grocery.getSellingprice());
        cv.put(COLUMN_PIECES,grocery.getPieces());

        sqlDb.insert(TABLEG_NAME,null,cv);


    }


    public ArrayList<MedicineList> getAllMedicines()
    {
        SQLiteDatabase database=getReadableDatabase();
        Log.e("Databaseeeeee",database.toString());
        Cursor c= database.query(TABLEM_NAME,null,null,null,null,null,COLUMN_NAME+" ASC ");
        ArrayList<MedicineList> medicines=new ArrayList<>();
        while(c.moveToNext())
        {

            String name;
            int id;
            String type;
           Float cost;
            Float sell;
            int pieces;
            int namecolumn= c.getColumnIndex(COLUMN_NAME);
            int typecolumn =c.getColumnIndex(COLUMN_TYPE);
            int costcolumn=c.getColumnIndex(COLUMN_COSTPRICE);
            int sellcolumn=c.getColumnIndex(COLUMN_SELLINGPRICE);
            int piececolumn=c.getColumnIndex(COLUMN_PIECES);

            name=c.getString(namecolumn);
            type= c.getString(typecolumn);
            cost= (c.getFloat(costcolumn)) ;
            sell=c.getFloat(sellcolumn);
            pieces=c.getInt(piececolumn);
            medicines.add(new MedicineList(name,type,cost,sell,pieces));
        }
        c.close();
        return medicines;

    }

    public ArrayList<DisposableList> getAllDisposables()
    {
        SQLiteDatabase database=getReadableDatabase();
        Log.e("Databaseeeeee",database.toString());
        Cursor c= database.query(TABLED_NAME,null,null,null,null,null,COLUMN_NAME+" ASC ");
        ArrayList<DisposableList> disposables=new ArrayList<>();
        while(c.moveToNext())
        {

            String name;
            int id;
            String type;
            Float cost;
            Float sell;
            int pieces;
            int namecolumn= c.getColumnIndex(COLUMN_NAME);
            int typecolumn =c.getColumnIndex(COLUMN_TYPE);
            int costcolumn=c.getColumnIndex(COLUMN_COSTPRICE);
            int sellcolumn=c.getColumnIndex(COLUMN_SELLINGPRICE);
            int piececolumn=c.getColumnIndex(COLUMN_PIECES);

            name=c.getString(namecolumn);
            type= c.getString(typecolumn);
            cost= (c.getFloat(costcolumn)) ;
            sell=c.getFloat(sellcolumn);
            pieces=c.getInt(piececolumn);
            disposables.add(new DisposableList(name,type,cost,sell,pieces));
        }
        c.close();
        return disposables;

    }

    public ArrayList<GroceryList> getAllGrocery()
    {
        SQLiteDatabase database=getReadableDatabase();
        Log.e("Databaseeeeee",database.toString());
        Cursor c= database.query(TABLEG_NAME,null,null,null,null,null,COLUMN_NAME+" ASC ");
        ArrayList<GroceryList> grocery=new ArrayList<>();
        while(c.moveToNext())
        {

            String name;
            int id;
            String type;
            Float cost;
            Float sell;
            int pieces;
            int namecolumn= c.getColumnIndex(COLUMN_NAME);
            int typecolumn =c.getColumnIndex(COLUMN_TYPE);
            int costcolumn=c.getColumnIndex(COLUMN_COSTPRICE);
            int sellcolumn=c.getColumnIndex(COLUMN_SELLINGPRICE);
            int piececolumn=c.getColumnIndex(COLUMN_PIECES);

            name=c.getString(namecolumn);
            type= c.getString(typecolumn);
            cost= (c.getFloat(costcolumn)) ;
            sell=c.getFloat(sellcolumn);
            pieces=c.getInt(piececolumn);
            grocery.add(new GroceryList(name,type,cost,sell,pieces));
        }
        c.close();
        return grocery;

    }

}
