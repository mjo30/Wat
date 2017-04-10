package com.example.danae.watopia;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.danae.watopia.model.WaterCondition;
import com.example.danae.watopia.model.WaterReport;
import com.example.danae.watopia.model.WaterType;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;

public class EditReport extends AppCompatActivity {
    private int placed;
    ViewReport reports;
    WaterReport selected;
    EditText nameEdit;
    EditText locationEdit;
    DataReportSource databaseReport;
    EditText latEdit;
    EditText longEdit;
    EditText dateEdit;
    TextView numberEdit;
    Spinner typeSpinner;
    Spinner conditionSpinner;
    Button submitBtn;
    DataBaseHandler db;
    private String date = null;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        reports = new ViewReport();
        placed = reports.getPlaced();
        databaseReport = new SourceDataBase(this);
        int j = 0;
        for (WaterReport r: databaseReport.getAllReports()) {
            if (j != placed) {
                j++;
            } else {
                selected = r;
            }
        }
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = df.format(Calendar.getInstance().getTime());
        dateEdit = (EditText) findViewById(R.id.dateEdit);
        dateEdit.setText(selected.getDate());
        db = new DataBaseHandler(EditReport.this, null, null, 5);
        nameEdit = (EditText) findViewById(R.id.nameEdit);
        nameEdit.setText(db.getName(LoginActivityPage.getUserName()));
        numberEdit = (TextView) findViewById(R.id.numberEdit);
        String number = "" + placed;
        numberEdit.setText(number);
        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);

        latEdit = (EditText) findViewById(R.id.latEdit);
        String lat = "" + selected.getLatitude();
        latEdit.setText(lat);
        longEdit = (EditText) findViewById(R.id.longEdit);
        String longt = "" + selected.getLongitude();
        longEdit.setText(longt);
        List<String> types = new ArrayList<String>();
        int selection = 0;
        for (int i = 0; i < WaterType.values().length; i++) {
            if (WaterType.values()[i].toString().equals(selected.getWaterType())) {
                selection = i;
            }
            types.add(WaterType.values()[i].toString());
        }
        ArrayAdapter<String> typesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typesAdapter);
        typeSpinner.setSelection(selection);
        List<String> conditions = new ArrayList<String>();
        for (int i = 0; i < WaterCondition.values().length; i++) {
            if (WaterCondition.values()[i].toString().equals(selected.getWaterCondition())) {
                selection = i;
            }
            conditions.add(WaterCondition.values()[i].toString());
        }
        ArrayAdapter<String> conditionsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, conditions);
        conditionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(conditionsAdapter);
        conditionSpinner.setSelection(selection);
        submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseReport.createReport(nameEdit.getText().toString(),dateEdit.getText().toString(),
                        latEdit.getText().toString(), longEdit.getText().toString(),
                        typeSpinner.getSelectedItem().toString(),
                        conditionSpinner.getSelectedItem().toString());
                databaseReport.deleteReport(selected);
                //report.getReportList().set(placed, report);
                Location newLocation = new Location(Double.parseDouble(latEdit.getText().toString()), Double.parseDouble(longEdit.getText().toString()));
                //report.setLocation(newLocation);
                if (db.getKeyStanding(LoginActivityPage.getUserName()).equals("Manager")) {
                    startActivity(new Intent(getApplicationContext(), managerLoggedIn.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
                }
            }
        });
        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("EditReport Page") // TODO: Define a title for the content shown.
                // TODO: Make sure this auto-generated URL is correct.
                .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
                .build();
        return new Action.Builder(Action.TYPE_VIEW)
                .setObject(object)
                .setActionStatus(Action.STATUS_TYPE_COMPLETED)
                .build();
    }

    @Override
    public void onStart() {
        super.onStart();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client.connect();
        AppIndex.AppIndexApi.start(client, getIndexApiAction());
    }

    @Override
    public void onStop() {
        super.onStop();

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        AppIndex.AppIndexApi.end(client, getIndexApiAction());
        client.disconnect();
    }
}
