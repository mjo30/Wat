package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.danae.watopia.model.WaterReport;

import java.util.ArrayList;
import java.util.List;


public class ViewReport extends AppCompatActivity {
    private ListView lv;
    private static String name;
    private static int placed = 0;
    private WaterReport report = new WaterReport();
    Button viewMapButton;
    private DataReportSource data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int order = 0;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_report);
        data = new SourceDataBase(this);
        viewMapButton = (Button)findViewById(R.id.viewMapButton);

        viewMapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), MapsActivity.class));
            }
        });
        lv = (ListView) findViewById(R.id.list);
        final List<WaterReport> report_list = data.getAllReports();
        List<String> reportString = new ArrayList<String>();
        for(WaterReport r: report_list) {
            reportString.add( "" + order + r.toString());
            order++;
        }
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, reportString);
        lv.setAdapter(arrayAdapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    final int position, long id) {
                placed = position;
                startActivity(new Intent(ViewReport.this, EditReport.class));
            }
        });
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
    public ViewReport(){}
    public int getPlaced() {
        return placed;
    }

}
