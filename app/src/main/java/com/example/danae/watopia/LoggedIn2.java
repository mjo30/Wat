package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class LoggedIn2 extends AppCompatActivity {
    /**
     * The onCreate method is called when the Fragment instances are created
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in2);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }
    
   /**
     * inflates the options menu for the logged in screen
     * @returs true the option menu is inflated.
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_user, menu);
        return true;
    }
    
   /**
     * The onCreate method is called when the Fragment instances are created
     * When report button is pressed, users will be able to write a report
     * When edit button is pressed, users will be able to edit their profile
     * When view button is pressed, users will be able to see a list of reports
     * When logout button is pressed, users will log out from the system
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add1:
                startActivity(new Intent(LoggedIn2.this, Report.class));
                break;
            case R.id.view1:
                startActivity(new Intent(LoggedIn2.this, ViewReport.class));
                break;
            case R.id.profile:
                startActivity(new Intent(LoggedIn2.this, LoggedIn.class));
                break;
            case R.id.logout:
                startActivity(new Intent(LoggedIn2.this, LoginActivityPage.class));
                break;
            default:
                break;
        }
        return true;
    }


}
