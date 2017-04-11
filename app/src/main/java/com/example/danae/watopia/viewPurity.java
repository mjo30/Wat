package com.example.danae.watopia;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.danae.watopia.model.QualityReport;

import java.util.ArrayList;
import java.util.List;

// class that enables workers and managers to view Purity report
public class viewPurity extends AppCompatActivity {
    private static int placed;
    @SuppressWarnings("Convert2Diamond")
    @Override
    // method that sets appropriate layout
    // creates button that directs user to chart activity class
    // creates a list of purity reports submitted by workers and managers
    // selecting a report will direct user to Edit Report class
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int order = 0;
        DataSource data = new ReportDataBase(this);
        setContentView(R.layout.activity_view_purity);
        Button chartButton = (Button) findViewById(R.id.chart);
        chartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), ChartActivity.class));
            }
        });
        ListView lv = (ListView) findViewById(R.id.list2);
        final List<QualityReport> report_list = data.getAllReports();
        List<String> reportString = new ArrayList<>();
        for(QualityReport r: report_list) {
            reportString.add( "" + order + r.toString());
            order++;
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportString);
        lv.setAdapter(arrayAdapter);

        arrayAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, reportString);
        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                placed = position;
                startActivity(new Intent(getApplicationContext(), EditPurity.class));
            }
        });
        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(myToolbar);

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_worker, menu);
        return true;
    }

    /**
     * Overridden method that describes what happens when the method is selected.
     * @param item item selected from the menu
     * @return whether or not the item was selected and operated as it was supposed to.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.GraphSetting:
                startActivity(new Intent(viewPurity.this, GraphSetting.class));
                break;
            default:
                break;
        }
        return true;
    }
    public int getPlaced() {
        return placed;
    }

}
