package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivityPage extends AppCompatActivity {
    // --Commented out by Inspection (4/11/2017 1:37 AM):EditText user, pass;
    private DataBaseHandler db;
    // --Commented out by Inspection (4/11/2017 1:37 AM):Cursor cursor;

    private EditText ed1;
    private EditText ed2;

    private static String userName;
    /**
     * This method create a main screen of the login page.
     * Field for username and password is provided.
     * Users can log into their account by clicking login button
     * or cancel and go back to the main screen by clicking cancel button.
     * Also, they can register, by clicking register button.
     * */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        ed1 = (EditText)findViewById(R.id._username);
        ed2 = (EditText)findViewById(R.id._password);
        Button login = (Button) findViewById(R.id._login);
        Button cancel = (Button) findViewById(R.id.button5);
        Button regi = (Button) findViewById(R.id.regBtn);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = new DataBaseHandler(LoginActivityPage.this);
                userName = ed1.getText().toString();
                String password = ed2.getText().toString();
                String storedPw = db.getRegister(userName);
                String standing = db.getKeyStanding(userName);
                System.out.println(standing);
                if(password.equals(storedPw)) {
                    switch (standing) {
                        case "User":
                            startActivity(new Intent(getApplicationContext(), LoggedIn2.class));
                            break;
                        case "Worker":
                            startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
                            break;
                        case "Manager":
                            startActivity(new Intent(getApplicationContext(), managerLoggedIn.class));
                            break;
                    }
                } else {
                    startActivity(new Intent(getApplicationContext(),ErrorScreen.class));
                }
            }
        });

        regi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), Registration.class));
            }
        });


        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), WelcomeScreen.class));
            }
        });
    }
   /**
     * This method will return the userName of the instance
     * @return username of the instance.
     */
    public static String getUserName() {
        return userName;
    }
}
