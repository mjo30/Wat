package com.example.danae.watopia;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import com.example.danae.watopia.model.WaterReport;


public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {
    private static int number = 0;
    boolean isClicked = true;
    private DataReportSource db;
    PopupWindow popUpWindow;
    TextView myMsg;
    LinearLayout mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        db = new SourceDataBase(this);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        for (WaterReport myReport : db.getAllReports()) {
            LatLng myLatLng = new LatLng(myReport.getLatitude(),myReport.getLongitude());
            googleMap.addMarker(new MarkerOptions().position(myLatLng).title(("condition:"+myReport.getWaterCondition()+" / "+"type:"+myReport.getWaterType())));
        }

    }
}

