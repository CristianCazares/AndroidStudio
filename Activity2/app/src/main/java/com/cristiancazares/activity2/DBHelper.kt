package com.cristiancazares.activity2

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import androidx.core.content.contentValuesOf

class DBHelper(context: Context) : SQLiteOpenHelper(context, DB_FILE, null, 1) {

    companion object {
        private const val DB_FILE = "Activity2.db"

    }

    override fun onCreate(db: SQLiteDatabase?) {
        val queryHobby = "CREATE TABLE Hobbies(" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT)"
        db?.execSQL(queryHobby)

        val queryFriends = "CREATE TABLE Friends(" +
                "id INTEGER primary KEY," +
                "name TEXT," +
                "hobby TEXT)"
        db?.execSQL(queryFriends)

        val queryGreets = "CREATE TABLE Greets(" +
                "id INTEGER PRIMARY KEY," +
                "greet TEXT)"
        db?.execSQL(queryGreets)
    }

    override fun onUpgrade(db: SQLiteDatabase?, last: Int, current: Int) {
        val query  = "DROP TABLE IF EXISTS ?"
        val args = arrayOf("Hobbies")

        db?.execSQL(query, args)
        onCreate(db)
    }

    fun saveHobby(name: String){
        val cursor = readableDatabase.query("Hobbies", null, null, null, null, null, null)

        if (cursor.moveToFirst()){
            //Update
            val values = ContentValues()
            values.put("name", name)
            writableDatabase.update("Hobbies", values, "id = ?", arrayOf("1"))
        }else{
            //Save
            val values = ContentValues()
            values.put("name", name)
            writableDatabase.insert("Hobbies", null, values)
        }
    }

    fun getHobby(): String {
        val query = "SELECT * FROM Hobbies WHERE id = 1;"
        val cursor = readableDatabase.rawQuery(query, null)

        if(cursor.moveToFirst()){
            return cursor.getString(1) //Returns second column of the query result
        }
        return ""
    }

    fun deleteHobby(name: String) : Int{
        val clause = "name = ?"
        val args = arrayOf(name)
        return writableDatabase.delete("Hobbies", clause, args)
    }



    fun saveFriend(name: String, hobby: String){
        val values = ContentValues()
        values.put("name", name)
        values.put("hobby", hobby)
        writableDatabase.insert("Friends", null, values)
    }

    fun searchFriend(name: String) : Int{
        val clause = "name = ?"
        val args = arrayOf(name)

        val cursor = readableDatabase.query("Friends", null, clause, args, null, null, null)
        var result = -1

        if(cursor.moveToFirst()){
            result = cursor.getInt(0)
        }

        return result
    }

    fun deleteFriend(name: String) : Int{
        val clause = "name = ?"
        val args = arrayOf(name)
        return writableDatabase.delete("Friends", clause, args)
    }

    fun getGreet(id: Int) : String{
        val query = "SELECT * FROM Greets WHERE id = ${id};"
        val cursor = readableDatabase.rawQuery(query, null)

        if(cursor.moveToFirst()){
            return cursor.getString(1) //Returns second column of the query result
        }
        return ""

    }

    fun saveGreet(id: Int, greet: String){
        val values = ContentValues()
        values.put("id", id)
        values.put("greet", greet)
        writableDatabase.insert("Greets", null, values)
    }

}