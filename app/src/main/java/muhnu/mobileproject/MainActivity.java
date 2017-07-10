package muhnu.mobileproject;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Pradika_Gautama_P  on 12/06/2017.
 * M_Nurcahyo 155410199
 */
public class MainActivity extends Activity {
    DataCenter dbcenter;
    EditText txtUserName, txtPassword;
    Button btnLogin, btnKeluar;
    private SQLiteDatabase db;
    SessionManager sessionManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        //Login(username, password);

        txtUserName = (EditText) findViewById(R.id.editUser);
        txtPassword = (EditText) findViewById(R.id.editPassw);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnKeluar = (Button) findViewById(R.id.btnKeluar);

        btnKeluar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //moveTaskToBack(true);
                finish();
            }
        });

        btnLogin.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                String username = txtUserName.getText().toString();
                String password = txtPassword.getText().toString();
                sessionManager = new SessionManager(getApplicationContext());
                try {
                    if (username.equals("admin") && password.equals("admin")) {

                        sessionManager.createLoginSession(username, password);
                        Intent intent = new Intent(MainActivity.this, ContentActivity.class);
                        Toast.makeText(MainActivity.this, "Login Sukses", Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(MainActivity.this, "Invalid Username/Password", Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                    }
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.getMessage(), Toast.LENGTH_LONG).show();
                }
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