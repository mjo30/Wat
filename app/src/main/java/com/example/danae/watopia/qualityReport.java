package com.example.danae.watopia;

import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.danae.watopia.model.QualityReport;
import com.example.danae.watopia.model.WaterReport;

import java.util.ArrayList;
import java.util.List;

// Page that manager and worker can view. 
// Creates a new quality report.
// Contains date, number, name, location, virus PPM, contamination PPM, and water condition.
public class qualityReport extends AppCompatActivity {
    TextView date, number, name;
    EditText location, virus, contamination;
    Spinner condition;
    Button submitBtn, cancelBtn;
    DataBaseHandler db;
    private DataSource data;
    static int count = 0;
    
    // Generates date and time by using Calendar and shows it to users
    // Number is incremented when new report is created.
    // Name is retrieved from login.db database according to username.
    // Saves location, virusPPM, contaminationPPM, and water condition that user provides.
    // Saved data goes into purity report database.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_report);
        data = new ReportDataBase(this);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = df.format(Calendar.getInstance().getTime());
        date = (TextView) findViewById(R.id.dateEdit);
        date.setText(dateStr);

        db = new DataBaseHandler(qualityReport.this, null, null, 4);
        name = (TextView) findViewById(R.id.nameEdit);
        name.setText(db.getName(LoginActivityPage.getUserName()));

        //final QualityReport report = new QualityReport();
        number = (TextView) findViewById(R.id.numberEdit);
        for (QualityReport r: data.getAllReports()) {
            count++;
        }
        number.setText(""+count);

        location = (EditText) findViewById(R.id.locationEdit);
        virus = (EditText) findViewById(R.id.virusEdit);
        contamination = (EditText) findViewById(R.id.contaminationEdit);

        condition = (Spinner) findViewById(R.id.conditionSpinner);

        List<String> types = new ArrayList<String>();
        types.add(0, "Safe");
        types.add(1, "Treatable");
        types.add(2, "Unsafe");
        ArrayAdapter<String> typesAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition.setAdapter(typesAdapter);

        submitBtn = (Button) findViewById(R.id.edit);
        cancelBtn = (Button) findViewById(R.id.cancelBtn);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                data.createReport(name.getText().toString(), date.getText().toString(),
                         location.getText().toString(), virus.getText().toString(),
                        contamination.getText().toString(), condition.getSelectedItem().toString());
                if (db.getKeyStanding(LoginActivityPage.getUserName()).equals("Manager")) {
                    startActivity(new Intent(getApplicationContext(), managerLoggedIn.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
                }
            }
        });

        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (db.getKeyStanding(LoginActivityPage.getUserName()).equals("Manager")) {
                    startActivity(new Intent(getApplicationContext(), managerLoggedIn.class));
                } else {
                    startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
                }
            }
        });

    }
}
