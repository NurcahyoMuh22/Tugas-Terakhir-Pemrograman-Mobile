package muhnu.mobileproject;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Pradika_Gautama_P  on 12/06/2017.
 * M_Nurcahyo 155410199
 */
public class DataCenter extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "data_mhs.db";
    private static final int DATABASE_VERSION = 1;
    private SQLiteDatabase db;

    public DataCenter(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String sql = "create table mahasiswa(nim integer primary key, nama text null," +
                " alamat text null, jurusan text null, jk text null);";
        Log.d("Data", "onCreate: " + sql);
        db.execSQL(sql);

/*
        String login = "CREATE TABLE login(_id integer primery key autoincrement, username text not null, password text not null);";
        Log.e("Data", "onCreate: " + login);
        db.execSQL(login);
        db.execSQL("insert into login values ('1','admin','admin');"); */
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub

    }
   /* public boolean Login(String username, String password) throws SQLException {
        Cursor mCursor = db.rawQuery("SELECT * FROM login"
                + " WHERE username=? AND password=?", new String[]{username, password});
        if (mCursor != null) {
            if (mCursor.getCount() > 0) {
                return true;
            }
        }
        return false;
    }

    public boolean Register(String username, String password) throws SQLException
    {

        Cursor mCursor = db.rawQuery("insert into login (username, password) values (?,?)", new String[]{username,password});
        if (mCursor != null) {
            if(mCursor.getCount() > 0)
            {
                return true;
            }
        }
        return false;
    }

*/

}
