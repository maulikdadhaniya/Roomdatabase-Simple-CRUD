package com.finepointmobile.famouspeople.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.finepointmobile.famouspeople.R;
import com.finepointmobile.famouspeople.database.AppDatabase;
import com.finepointmobile.famouspeople.model.User;

public class UpdateActivity extends AppCompatActivity {

    EditText f_name, l_name, email;
    Button btn_update, btn_delete;
    String fname, lname, emailid;
    int id;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        f_name = findViewById(R.id.up_firstName);
        l_name = findViewById(R.id.up_lastName);
        email = findViewById(R.id.up_email);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);


        db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();


        Bundle extras = getIntent().getExtras();
        id = extras.getInt("id", 0);
        fname = extras.getString("fName", "");
        lname = extras.getString("lName", "");
        emailid = extras.getString("email", "");

        f_name.setText(fname);
        l_name.setText(lname);
        email.setText(emailid);


        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(UpdateActivity.this, "" + emailid, Toast.LENGTH_SHORT).show();
                User user = new User("", "", "");
                user.setId(id);

                db.userDao().delete(user);
                Toast.makeText(UpdateActivity.this, "Delete sucessful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, MainActivity.class));
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                db.userDao().update(f_name.getText().toString(), l_name.getText().toString(), email.getText().toString(), id);

                Toast.makeText(UpdateActivity.this, "Update sucessful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(UpdateActivity.this, MainActivity.class));


            }
        });
    }
}
