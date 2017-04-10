package
        com.example.danae.watopia;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.danae.watopia.model.Data;
import com.example.danae.watopia.model.QualityReport;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChartActivity extends AppCompatActivity {
    private DataSource db;
    private List<Data> data = new ArrayList<>();
    private int startYear;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        db = new ReportDataBase(ChartActivity.this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chart);
        LineChart lineChart = (LineChart) findViewById(R.id.chart);
        List<QualityReport> reports = db.getAllReports();
        GraphSetting settings = new GraphSetting();
        startYear = settings.getYearStart();
        int yearApart = settings.getYearEnd() - startYear;
        //dummy year data
        for (int i = 0; i < yearApart; i++) {
            Random rand = new Random();
            data.add(new Data(startYear + i, (double) rand.nextInt(50)));
        }
        String location = settings.getSelectedLoc();
        for (QualityReport r : reports) {
            if (r.getLocation().equals(location)) {
                data.add(new Data(r.getYear(), r.getContamination()));
            }
        }
        List<Entry> entries = convertDataSetToEntry(data);
        LineDataSet dataset = new LineDataSet(entries, "# of Reports");
        Log.d("APP", "Made dataset with : " + entries.size());

        LineData data = new LineData(dataset);
        dataset.setColors(ColorTemplate.COLORFUL_COLORS); //

        dataset.setDrawFilled(true);

        lineChart.setData(data);
        lineChart.animateY(5000);

        lineChart.getDescription().setText("Number of Reports per Year");

        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.
        client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
    }
    /**
     * adds data points to the graph
     *@return list of entries
     */
    private List<Entry> convertDataSetToEntry(List<Data> data) {
        List<Entry> entries = new ArrayList<>();

        for (Data d : data) {
            entries.add(new Entry(d.x, (int) d.y));
        }

        return entries;
    }

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    public Action getIndexApiAction() {
        Thing object = new Thing.Builder()
                .setName("Chart Page") // TODO: Define a title for the content shown.
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
