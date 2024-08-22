package com.example.intermediateandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class Database_class extends SQLiteOpenHelper {

    private static final String db_name = "db_contacts";
    private static final int db_version = 1;
    private static final String table_name_phone = "contact_number";
    private static final String contact_id = "contact_id";
    private static final String contact_name = "contact_name";
    private static final String contact_number = "contact_number";

    public Database_class(Context context) {
        super(context, db_name, null, db_version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table if not exists "+table_name_phone+"(" +
                contact_id+" integer primary key autoincrement," +
                contact_name+" text," +
                contact_number+" text"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists "+table_name_phone);
        onCreate(db);
    }

    public void add_contact(String name,String number)
    {
        SQLiteDatabase database = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(contact_name,name);
        values.put(contact_number,number);

        database.insert(table_name_phone,null,values);
        database.close();
    }

    public ArrayList<contact_model> get_contact_number()
    {
        SQLiteDatabase database = Database_class.this.getReadableDatabase();
        Cursor cursor = database.rawQuery("select * from "+table_name_phone,null);
        ArrayList<contact_model> all_contact = new ArrayList<>();
        while(cursor.moveToNext())
        {
            contact_model model = new contact_model();
            model.id = cursor.getInt(0);
            model.name = cursor.getString(1);
            model.number = cursor.getString(2);
            all_contact.add(model);
        }
        return all_contact;
    }

    public void update_data(contact_model model)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(contact_number,model.number);
        database.update(table_name_phone,values,contact_id+" = "+model.id,null);
        database.close();
    }

    public void delete_data(int id)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.delete(table_name_phone,contact_id+" = ? ",new String[]{Integer.toString(id)});
        database.close();
    }
    public void manual_sql(String sql)
    {
        SQLiteDatabase database = this.getWritableDatabase();
        database.execSQL(sql);
        database.close();
    }
}
