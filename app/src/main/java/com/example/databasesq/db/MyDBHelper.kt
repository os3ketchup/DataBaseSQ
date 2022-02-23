package com.example.databasesq.db

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.databasesq.adapter.models.User
import com.example.databasesq.db.Constants.AGE
import com.example.databasesq.db.Constants.DB_VERSION
import com.example.databasesq.db.Constants.ID
import com.example.databasesq.db.Constants.NAME
import com.example.databasesq.db.Constants.TABLE_NAME

class MyDBHelper(context: Context) : SQLiteOpenHelper(context, NAME, null, DB_VERSION),
    MyDBInterface {


    override fun onCreate(p0: SQLiteDatabase?) {
        val query =
            "create table $TABLE_NAME ($ID integer not null primary key autoincrement unique, $NAME text not null, $AGE integer not null)"
        p0?.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        TODO("Not yet implemented")
    }

    override fun add(user: User) {
        val db = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(NAME, user.name)
        contentValues.put(AGE, user.age)
        db.insert(TABLE_NAME, null, contentValues)
        db.close()
    }

    override fun getAll(): List<User> {
        val list = ArrayList<User>()
        val query = "select * from $TABLE_NAME"
        val db = this.readableDatabase
        val cursor = db.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(0)
                val name = cursor.getString(1)
                val age = cursor.getInt(2)
                val user = User(id, name, age)
                list.add(user)
            }while (cursor.moveToNext())
        }
        return  list
    }


}