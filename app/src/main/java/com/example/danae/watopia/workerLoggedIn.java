// how to write javadoc for menu??

package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

// workerLoggedIn class provides menu for workers
public class workerLoggedIn extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_logged_in);
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(myToolbar);
    }

    /**
     * This method is called when users with worker standing log into their account
     * They have option of edit profile, view source report and purity report, create source report
     * and purity report, and view the map showing the location of water sources.
     **/
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_view_report, menu);
        return true;
    }

    /**
     * The onCreate method is called when the Fragment instances are created
     * When report button is pressed, users will be able to write a report
     * When edit button is pressed, users will be able to edit their profile
     * When view button is pressed, users will be able to see a list of reports
     * When logout button is pressed, users will log out from the system
     * */
    @Override
    public boolean onOptionsItemSelected(android.view.MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add1:
                startActivity(new Intent(workerLoggedIn.this, Report.class));
                break;
            case R.id.add2:
                startActivity(new Intent(workerLoggedIn.this, qualityReport.class));
                break;
            case R.id.view1:
                startActivity(new Intent(workerLoggedIn.this, ViewReport.class));
                break;
            case R.id.view2:
                startActivity(new Intent(workerLoggedIn.this, viewPurity.class));
                break;
            case R.id.profile:
                startActivity(new Intent(workerLoggedIn.this, LoggedIn.class));
                break;
            case R.id.logout:
                startActivity(new Intent(workerLoggedIn.this, LoginActivityPage.class));
                break;
            default:
                break;
        }
        return true;
    }
}
