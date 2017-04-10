package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.danae.watopia.model.RegisteredUsers;

public class LoggedIn extends AppCompatActivity {
    Button cancel, edit;
    DataBaseHandler db;
    EditText password, name, username;
    TextView standing;
    /**
     * The onCreate method is called when the Fragment instance is created
     * Users are allowed to input their username and password or to cancel to
     * go back to the main screen
     * Upon providing correct username and password, the screen will change to
     * LoggedIn2
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);
        db = new DataBaseHandler(LoggedIn.this, null, null, 3);
        password = (EditText) findViewById(R.id.password);
        name = (EditText) findViewById(R.id.name);
        username = (EditText) findViewById(R.id.username);
        standing = (TextView) findViewById(R.id.standing);

        final String myusername = LoginActivityPage.getUserName();
        String storedPw = db.getRegister(myusername);
        String myname = db.getName(myusername);
        String mystanding = db.getKeyStanding(myusername);

        name.setText(myname);
        username.setText(myusername);
        password.setText(storedPw);
        standing.setText(mystanding);

        edit = (Button) findViewById(R.id.button);

        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (name.getText().toString().equals("") || username.getText().toString().equals("")
                        || password.getText().toString().equals("")) {
                    new AlertDialog.Builder(LoggedIn.this)
                            .setTitle("Field Empty")
                            .setMessage("One or more field is empty").show();
                } else {
                    RegisteredUsers user = new RegisteredUsers(name.getText().toString(),
                            username.getText().toString(), password.getText().toString());
                    db.addRegister(user);
                }
            }
        });

        cancel = (Button)findViewById(R.id.button3);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoggedIn.this, LoginActivityPage.class));
            }
        });
    }
}
