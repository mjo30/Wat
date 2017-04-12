import junit.framework.Assert;

import model.QualityReport;

/**
 * Created by Hongsik Son on 2017-04-05.
 */
public class GetYearTest {
    QualityReport qr;
    int year;
    String date;

    public GetYearTest() {
    }

    @Before
    public void setUp() throws Exception {
        this.year = qr.getYear();
        this date = qr.getDate();
    }

    @Test
    public void testDateIsNull() {
        Assert.assertTrue("Date is null", (this.date == null));
    }

    @Test
    public void testDateFormat() {
        Assert.assertTrue("Date format is wrong", (this.date.length() != 8));
    }

    @Test
    public void testYearFormat() {
        Assert.assertTrue("Year format is wrong", (this.year <= 0));
    }

    @Test
    public void testYearIsCorrect() {
        Assert.assertEquals("Year is wrong", 2017L, (long)this.year);
    }
}
