package com.example.test1

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import androidx.core.content.contentValuesOf
import java.security.AccessControlContext

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_FILE, null, 1) {
    companion object {
        private const val DB_FILE = "Students.db"
        private const val TABLE = "students"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_AGE = "age"

    }

    override fun onCreate(db: SQLiteDatabase?) {

        val query = "CREATE TABLE $TABLE(" +
                "$COLUMN_ID INTEGER PRIMARY KEY, " +
                "$COLUMN_NAME TEXT, " +
                "$COLUMN_AGE INTEGER)"
        db?.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, last: Int, current: Int) {
        val query  = "DROP TABLE IF EXISTS ?"
        val args = arrayOf(TABLE)

        db?.execSQL(query, args)
        onCreate(db)
    }

    fun save(name: String, age: Int){
        val values = ContentValues()
        values.put(COLUMN_NAME, name)
        values.put(COLUMN_AGE, age)
        writableDatabase.insert(TABLE, null, values)
    }

    fun delete(name: String) : Int{
        val clause = "$COLUMN_NAME = ?"
        val args = arrayOf(name)
        return writableDatabase.delete(TABLE, clause, args)
    }

    fun search(name: String) : Int {
        val clause = "$COLUMN_NAME = ?"
        val args = arrayOf(name)

        val cursor = readableDatabase.query(TABLE, null, clause, args, null, null, null)
        var result = -1

        if(cursor.moveToFirst()){
            result = cursor.getInt(0)
        }

        return result
    }

}