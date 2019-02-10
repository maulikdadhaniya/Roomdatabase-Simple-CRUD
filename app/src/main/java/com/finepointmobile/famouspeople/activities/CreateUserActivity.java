package com.finepointmobile.famouspeople.activities;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.finepointmobile.famouspeople.database.AppDatabase;
import com.finepointmobile.famouspeople.R;
import com.finepointmobile.famouspeople.model.User;

/**
 * Created by danielmalone on 10/28/17.
 */

public class CreateUserActivity extends AppCompatActivity {

    private static final String TAG = "CreateUserActivity";

    EditText firstName;
    EditText lastName;
    EditText email;
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_user);

        firstName = findViewById(R.id.first_name);
        lastName = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        button = findViewById(R.id.button);

        final AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "production")
                .allowMainThreadQueries()
                .build();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // TODO: 10/28/17 Save to database
                Log.d(TAG, "onClick: firstName: " + firstName.getText().toString());


                User user = new User(firstName.getText().toString(), lastName.getText().toString(), email.getText().toString());
                db.userDao().insertAll(user);
                startActivity(new Intent(CreateUserActivity.this, MainActivity.class));
            }
        });
    }
}
