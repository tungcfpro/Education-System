package HelperTest;


import org.testng.Assert;
import org.testng.annotations.Test;

import Helper.DateHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateHelperTest {

    @Test(priority = 1)
    public void testToDate() throws ParseException {
        // Kiểm tra phương thức toDate
        Date date = DateHelper.toDate("01/01/2022");
        Assert.assertNotNull(date);
        Assert.assertEquals(date.getYear(), 122);
        Assert.assertEquals(date.getMonth(), Calendar.JANUARY);
        Assert.assertEquals(date.getDate(), 1);
    }

    @Test(priority = 2)
    public void testToDateWithCustomPattern() throws ParseException {
        // Kiểm tra phương thức toDate với định dạng tùy chỉnh
        Date date = DateHelper.toDate("01-01-2022", "dd-MM-yyyy");
        Assert.assertNotNull(date);
        Assert.assertEquals(date.getYear(), 122);
        Assert.assertEquals(date.getMonth(), Calendar.JANUARY);
        Assert.assertEquals(date.getDate(), 1);
    }

    @Test(priority = 3)
    public void testToString() throws ParseException {
        // Kiểm tra phương thức toString
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
        String dateString = DateHelper.toString(date);
        Assert.assertNotNull(dateString);
        Assert.assertEquals(dateString, "01/01/2022");
    }

    @Test(priority = 4)
    public void testToStringWithCustomPattern() throws ParseException {
        // Kiểm tra phương thức toString với định dạng tùy chỉnh
        Date date = new SimpleDateFormat("dd-MM-yyyy").parse("01-01-2022");
        String dateString = DateHelper.toString(date, "dd/MM/yyyy");
        Assert.assertNotNull(dateString);
        Assert.assertEquals(dateString, "01/01/2022");
    }

    @Test(priority = 5)
    public void testNow() throws InterruptedException {
        // Kiểm tra phương thức now
        Thread.sleep(1000); // chờ 1 giây để chắc chắn thời gian đã thay đổi
        Date now = DateHelper.now();
        Date currentTime = new Date();
        Assert.assertTrue(now.after(currentTime) || now.equals(currentTime));
    }

    @Test(priority = 4)
    public void testAddDays() throws ParseException {
        // Kiểm tra phương thức addDays
        Date date = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2022");
        Date result = DateHelper.addDays(date, 10);
        Assert.assertNotNull(result);
        Assert.assertEquals(result.getYear(), 122);
        Assert.assertEquals(result.getMonth(), Calendar.JANUARY);
        Assert.assertEquals(result.getDate(), 11);
    }

    @Test(priority = 5)
    public void testAdd() {
        Date expected = DateHelper.addDays(DateHelper.now(), 1);
        Date actual = DateHelper.add(1);
        Assert.assertEquals(actual, expected);
    }

}
