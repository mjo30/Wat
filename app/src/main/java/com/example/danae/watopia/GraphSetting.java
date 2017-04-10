package com.example.danae.watopia;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GraphSetting extends AppCompatActivity {
    private DataSource data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        data = new ReportDataBase(this);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_graph_setting);
    }
}
