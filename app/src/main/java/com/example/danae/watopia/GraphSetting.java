package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.danae.watopia.model.QualityReport;

import java.util.ArrayList;
import java.util.List;

public class GraphSetting extends AppCompatActivity {
    private DataSource data;
    private Spinner locationSet;
    private EditText yearSet;
    private static int yearStart = 2006;
    private static int yearEnd = 2016;
    private String selectedLoc = "GT";
    private Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_setting);
        data = new ReportDataBase(this);
        yearSet = (EditText) findViewById(R.id.numberEdit);
        locationSet = (Spinner) findViewById(R.id.graphSpinner);
        ok = (Button) findViewById(R.id.ok);
        List<String> locations = new ArrayList<>();
        for (QualityReport r : data.getAllReports()) {
            if (!locations.contains(r.getLocation())) {
                locations.add(r.getLocation());
            }
        }
        ArrayAdapter<String> settingAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, locations);
        settingAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        locationSet.setAdapter(settingAdapter);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedLoc = locationSet.getSelectedItem().toString();
                String years = yearSet.getText().toString();
                if (years.contains("-")) {
                    String[] year = new String[2];
                    year = years.split("-");
                    yearStart = Integer.parseInt(year[0]);
                    yearEnd = Integer.parseInt(year[1]);
                    startActivity(new Intent(getApplicationContext(), viewPurity.class));
                }
            }
        });

    }
    public GraphSetting() {

    }
    public String getSelectedLoc() {
        return selectedLoc;
    }
    public int getYearStart() {
        return yearStart;
    }
    public int getYearEnd() {
        return yearEnd;
    }
}
