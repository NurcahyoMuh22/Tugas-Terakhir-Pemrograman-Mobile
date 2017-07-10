package muhnu.mobileproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pradika_Gautama_P  on 12/06/2017.
 * M_Nurcahyo 155410199
 */
public class UbahActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataCenter dbHelper;
    Button update, back;
    EditText nim, nama, alamat, jurusan, jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ubah);

        dbHelper = new DataCenter(this);
        nim = (EditText) findViewById(R.id.editText1);
        nama = (EditText) findViewById(R.id.editText2);
        alamat = (EditText) findViewById(R.id.editText3);
        jurusan = (EditText) findViewById(R.id.editText4);
        jk = (EditText) findViewById(R.id.editText5);
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
        update = (Button) findViewById(R.id.button1);
        back = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                SQLiteDatabase db = dbHelper.getWritableDatabase();
                db.execSQL("update mahasiswa set nama='" +
                        nama.getText().toString() + "', alamat='" +
                        alamat.getText().toString() + "', jurusan='" +
                        jurusan.getText().toString() + "', jk='" +
                        jk.getText().toString() + "' where nim='" +
                        nim.getText().toString() + "'");
                Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                ContentActivity.ma.RefreshList();
                finish();
            }
        });
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
