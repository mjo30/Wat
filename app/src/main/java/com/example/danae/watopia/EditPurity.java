package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.danae.watopia.model.QualityReport;

import java.util.ArrayList;
import java.util.List;



public class EditPurity extends AppCompatActivity {
    private TextView date;
    private TextView name;
    private EditText location;
    private EditText virus;
    private EditText contamination;
    private Spinner condition;
    private DataBaseHandler db;
    private DataSource reportdata;
    private QualityReport myReport;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quality_report);
        reportdata = new ReportDataBase(this);
        viewPurity purity = new viewPurity();
        int position = purity.getPlaced();
        //final QualityReport report = new QualityReport();
        //QualityReport myReport = report.getQualityReports().get(index);
        myReport = null;
        int i = 0;
        for (QualityReport r: reportdata.getAllReports()) {
            if (i != position) {
                i++;
            } else {
                myReport = r;
            }
        }
        date = (TextView) findViewById(R.id.dateEdit);
        name = (TextView) findViewById(R.id.nameEdit);
        TextView number = (TextView) findViewById(R.id.numberEdit);
        location = (EditText) findViewById(R.id.locationEdit);
        virus = (EditText) findViewById(R.id.virusEdit);
        contamination = (EditText) findViewById(R.id.contaminationEdit);
        condition = (Spinner) findViewById(R.id.conditionSpinner);
        Button editBtn = (Button) findViewById(R.id.edit);
        Button cancelBtn = (Button) findViewById(R.id.cancelBtn);
        List<String> types = new ArrayList<>();
        types.add(0, "Safe");
        types.add(1, "Treatable");
        types.add(2, "Unsafe");
        ArrayAdapter<String> typesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        condition.setAdapter(typesAdapter);
        date.setText(myReport.getDate());
        name.setText(myReport.getName());
        number.setText(getString(R.string.blank, myReport.getNumber()));
        location.setText(myReport.getLocation());
        virus.setText(getString(R.string.blank, myReport.getVirus()));
        contamination.setText(getString(R.string.blank, myReport.getContamination()));

        editBtn = (Button) findViewById(R.id.edit);
        db = new DataBaseHandler(EditPurity.this);
        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                reportdata.createReport(name.getText().toString(),date.getText().toString(),
                        location.getText().toString(),virus.getText().toString(),
                        contamination.getText().toString(), condition.getSelectedItem().toString());
                reportdata.deleteReport(myReport);
                //report.getQualityReports().add(index, newReport);
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
                startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
            }
        });

    }
}
