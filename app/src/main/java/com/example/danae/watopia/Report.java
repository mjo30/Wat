package com.example.danae.watopia;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
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

import java.util.ArrayList;
import java.util.List;

public class Report extends AppCompatActivity {

    private TextView nameEdit;
    private EditText latEdit;
    private EditText longEdit;
    private EditText dateEdit;
    private Spinner typeSpinner;
    private Spinner conditionSpinner;
    private DataBaseHandler db;
    private DataReportSource data;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        data = new SourceDataBase(this);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date = df.format(Calendar.getInstance().getTime());
        dateEdit = (EditText) findViewById(R.id.dateEdit);
        dateEdit.setText(date);
        db = new DataBaseHandler(Report.this);
        nameEdit = (TextView) findViewById(R.id.nameEdit);
        nameEdit.setText(db.getName(LoginActivityPage.getUserName()));

        TextView numberEdit = (TextView) findViewById(R.id.numberEdit);
        for (WaterReport r: data.getAllReports()) {
            count++;
        }
        String number = "" + count;
        numberEdit.setText(number);
        count++;

        typeSpinner = (Spinner) findViewById(R.id.typeSpinner);
        conditionSpinner = (Spinner) findViewById(R.id.conditionSpinner);

        latEdit = (EditText) findViewById(R.id.latEdit);
        longEdit = (EditText) findViewById(R.id.longEdit);

        List<String> types = new ArrayList<>();
        for (int i = 0; i < WaterType.values().length; i++) {
            types.add(WaterType.values()[i].toString());
        }
        ArrayAdapter<String> typesAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, types);
        typesAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(typesAdapter);

        List<String> conditions = new ArrayList<>();
        for (int i = 0; i < WaterCondition.values().length; i++) {
            conditions.add(WaterCondition.values()[i].toString());
        }
        ArrayAdapter<String> conditionsAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, conditions);
        conditionsAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        conditionSpinner.setAdapter(conditionsAdapter);

        Button submitBtn = (Button) findViewById(R.id.submitBtn);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean allLongNum = true;
                String longitude = longEdit.getText().toString();
                allLongNum = isLatLong(longitude);
                boolean allLatNum = true;
                String latitude = latEdit.getText().toString();
                allLatNum = isLatLong(latitude);
                if (allLatNum && allLongNum) {
                    data.createReport(nameEdit.getText().toString(), dateEdit.getText().toString(),
                            latEdit.getText().toString(), longEdit.getText().toString(),
                            typeSpinner.getSelectedItem().toString(), conditionSpinner.getSelectedItem().toString());
                    if (db.getKeyStanding(LoginActivityPage.getUserName()).equals("User")) {
                        startActivity(new Intent(getApplicationContext(), LoggedIn2.class));
                    } else if (db.getKeyStanding(LoginActivityPage.getUserName()).equals("Worker")) {
                        startActivity(new Intent(getApplicationContext(), workerLoggedIn.class));
                    } else {
                        startActivity(new Intent(getApplicationContext(), managerLoggedIn.class));
                    }

                } else {
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(Report.this);
                    builder1.setMessage("Invalid input for longitude or latitude.");
                    builder1.setCancelable(true);
                    builder1.setPositiveButton(
                            "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int id) {
                                    dialog.cancel();
                                }
                            });
                    AlertDialog alert11 = builder1.create();
                    alert11.show();
                }
            }
        });
    }

    /**
     * this method checks whether the input of latitude and longitude is a valid
     * String that consists of digits and sign.
     * @param latitude lat or long input
     * @return whether or not the latitude or longitude is valid
     */
    public static boolean isLatLong(String latitude) {
        if (latitude == null || latitude.equals("")) {
            return false;
        }
        boolean allLatNum = true;
        for (int i = 0; i < latitude.length(); i++) {
            if (latitude.contains("-")) {
                int point = latitude.indexOf(".");
                int direction = latitude.indexOf("-");
                if (!Character.isDigit(latitude.charAt(i))
                        && i != point && i != direction) {
                    allLatNum = false;
                }
            } else {
                int point = latitude.indexOf(".");
                if (!Character.isDigit(latitude.charAt(i)) && i != point) {
                    allLatNum = false;
                }
            }
        }
        return allLatNum;
    }
}
