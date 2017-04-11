package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.danae.watopia.model.RegisteredUsers;
import com.example.danae.watopia.model.Standing;

import java.util.Arrays;

public class Registration extends AppCompatActivity {
    private EditText fullName;
    private EditText email;
    private EditText newPassword;
    private Spinner standingSpinner;
    private DataBaseHandler db;
    // --Commented out by Inspection (4/11/2017 1:41 AM):private Standing standing = Standing.USER;
    /**
     * This onCreate method is called when users try to register.
     * Field for full name, email, and password are filled by users by typing their info in.
     * They also have to choose their standing and default standing is set to user standing
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fullName = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.email);
        newPassword = (EditText) findViewById(R.id.newPass);
        Button register = (Button) findViewById(R.id.registered);
        standingSpinner = (Spinner) findViewById(R.id.spinner);
        ArrayAdapter<Standing> adapter = new ArrayAdapter<>(
                this, android.R.layout.simple_spinner_item,
                Arrays.asList(Standing.values()));
        standingSpinner.setAdapter(adapter);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DataBaseHandler(Registration.this);
                RegisteredUsers user = new RegisteredUsers(fullName.getText().toString(),
                        email.getText().toString(), newPassword.getText().toString(),
                        (Standing) standingSpinner.getSelectedItem());
                db.addRegister(user);

                startActivity(new Intent(getApplicationContext(), LoginActivityPage.class));
            }
        });
    }

}
