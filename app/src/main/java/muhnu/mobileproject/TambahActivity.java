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
public class TambahActivity extends AppCompatActivity {
    protected Cursor cursor;
    DataCenter dbHelper;
    Button simpan, back;
    EditText nim, nama, alamat, jurusan, jk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah);

        dbHelper = new DataCenter(this);
        nim = (EditText) findViewById(R.id.editText1);
        nama = (EditText) findViewById(R.id.editText2);
        alamat = (EditText) findViewById(R.id.editText3);
        jurusan = (EditText) findViewById(R.id.editText4);
        jk = (EditText) findViewById(R.id.editText5);
        simpan = (Button) findViewById(R.id.button1);
        back = (Button) findViewById(R.id.button2);
        // daftarkan even onClick pada btnSimpan
        simpan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                try {
                    SQLiteDatabase db = dbHelper.getWritableDatabase();
                    db.execSQL("insert into mahasiswa(nim, nama, alamat, jurusan, jk) values('" +
                            nim.getText().toString() + "','" +
                            nama.getText().toString() + "','" +
                            alamat.getText().toString() + "','" +
                            jurusan.getText().toString() + "','" +
                            jk.getText().toString() + "')");
                    Toast.makeText(getApplicationContext(), "Berhasil", Toast.LENGTH_LONG).show();
                    ContentActivity.ma.RefreshList();
                    finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
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
