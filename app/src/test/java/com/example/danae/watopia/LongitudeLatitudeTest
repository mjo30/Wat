package com.example.danae.watopia;

import android.content.Intent;
import com.example.danae.watopia.Report;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by danae on 4/11/2017.
 */
@RunWith(JUnit4.class)
public class LongitudeLatitudeTest {
    DataReportSource reports;

    @Test
    public void testStringLatLong() {
        String latLong = "A B C D";
        boolean valid = Report.isLatLong(latLong);
        Assert.assertEquals(valid, false);
    }
    @Test
    public void testHalfStringLatLong(){
        String latLong = "A12B34C";
        boolean valid = Report.isLatLong(latLong);
        Assert.assertEquals(valid, false);
    }
    @Test
    public void testEmptyLatLong() {
        String latLong = "";
        boolean valid = Report.isLatLong(latLong);
        Assert.assertEquals(valid, false);
    }
    @Test
    public void testValidLatLng() {
        String latitude= "33.7756";
        boolean valid = Report.isLatLong(latitude);
        Assert.assertEquals(valid, true);
    }
}
