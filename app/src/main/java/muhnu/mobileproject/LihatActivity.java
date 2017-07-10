package muhnu.mobileproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Pradika_Gautama_P  on 12/06/2017.
 * M_Nurcahyo 155410199
 */
public class LihatActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataCenter dbHelper;
    Button back;
    TextView nim, nama, alamat, jurusan, jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat);

        dbHelper = new DataCenter(this);
        nim = (TextView) findViewById(R.id.textView1);
        nama = (TextView) findViewById(R.id.textView2);
        alamat = (TextView) findViewById(R.id.textView3);
        jurusan = (TextView) findViewById(R.id.textView4);
        jk = (TextView) findViewById(R.id.textView5);
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM mahasiswa WHERE nama = '" +
                getIntent().getStringExtra("nama") + "'", null);
        cursor.moveToFirst();
        if (cursor.getCount() > 0) {
            cursor.moveToPosition(0);
            nim.setText(cursor.getString(0).toString());
            nama.setText(cursor.getString(1).toString());
            alamat.setText(cursor.getString(2).toString());
            jurusan.setText(cursor.getString(3).toString());
            jk.setText(cursor.getString(4).toString());
        }
        back = (Button) findViewById(R.id.button1);
        back.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

}