package cz.skolakrizik.c2sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseWrapper extends SQLiteOpenHelper {

    public static final String STUDENTS = "Students";
    public static final String STUDENT_ID = "_id";
    public static final String STUDENT_NAME = "_name";

    private static final String DATABASE_NAME = "Students.db";
    //private static final int DATABASE_VERSION = 2;
    private static final int DATABASE_VERSION = 2025032101;

    // creation SQLite statement
    private static final String DATABASE_CREATE = "create table " + STUDENTS
            + "(" + STUDENT_ID + " integer primary key autoincrement, "
            + STUDENT_NAME + " text not null);";


    private static final String DATABASE_INSERT = "INSERT INTO  Students ('_name') VALUES ('test');";





    public DataBaseWrapper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
        db.execSQL(DATABASE_INSERT);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // you should do some logging in here
        // ..

        db.execSQL("DROP TABLE IF EXISTS " + STUDENTS);
        onCreate(db);
    }


}
