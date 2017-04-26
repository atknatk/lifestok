
package com.lifeweb;


import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class LifewebDateUtils
{
  public static Date myGetNow()
  {
    return new Date();
  }

  public static Date myGetNowDate()
  {
    Date d = new Date();
    return new Date(d.getYear(), d.getMonth(), d.getDate());
  }

  public static int myGetYear(Date parDate)
  {
    return parDate.getYear() + 1900;
  }

  public static int myGetMonth(Date parDate)
  {
    return parDate.getMonth() + 1;
  }

  public static int myGetDate(Date parDate)
  {
    return parDate.getDate();
  }

  public static int myGetDay(Date parDate)
  {
    return parDate.getDay();
  }

  public static String myD2S(Date parDate) {
    Format frmt = new SimpleDateFormat("yyyy-MM-dd");
    return frmt.format(parDate);
  }

  public static Date myS2D(String parDate)
  {
    int lYear = Integer.valueOf(parDate.substring(0, 4)).intValue() - 1900;
    int lMonth = Integer.valueOf(parDate.substring(5, 7)).intValue() - 1;
    int lDay = Integer.valueOf(parDate.substring(8)).intValue();
    return new Date(lYear, lMonth, lDay);
  }

  public static Date myAddMonth(Date parDate, int parN) {
    Calendar lCal = Calendar.getInstance();
    lCal.setTime(parDate);
    lCal.add(2, parN);
    return lCal.getTime();
  }

  public static Date myAddDay(Date parDate, int parN) {
    Calendar lCal = Calendar.getInstance();
    lCal.setTime(parDate);
    lCal.add(5, parN);
    return lCal.getTime();
  }

  public static Date myAddMinute(Date parDate, int parN) {
    Calendar lCal = Calendar.getInstance();
    lCal.setTime(parDate);
    lCal.add(12, parN);
    return lCal.getTime();
  }

  public static String myT2S(Date parTime, int parFormatType) {
    Format frmt = null;
    switch (parFormatType) {
    case 4:
      frmt = new SimpleDateFormat("HH:mm");
      break;
    case 6:
      frmt = new SimpleDateFormat("HH:mm:ss");
      break;
    case 12:
      frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm");
      break;
    case 14:
      frmt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    return frmt.format(parTime);
  }

  public static int myDaysBetween(Date parANow, Date parAThen) {
    long fark = 0L;
    if (parANow.before(parAThen))
      fark = parAThen.getTime() - parANow.getTime();
    else
      fark = parANow.getTime() - parAThen.getTime();
    return (int)(fark / 86400000L);
  }

  public static Date myEncodeDate(int parYear, int parMonth, int parDay)
  {
    return new Date(parYear - 1900, parMonth - 1, parDay);
  }

  public static Date myStartOfTheYear(Date parDate) {
    int lYear = myGetYear(parDate);
    return myEncodeDate(lYear, 1, 1);
  }

  public static Date myStartOfTheYear(int parYear) {
    return myEncodeDate(parYear, 1, 1);
  }

  public static Date myEndOfTheYear(Date parDate) {
    int lYear = myGetYear(parDate);
    return myEncodeDate(lYear, 12, 31);
  }

  public static Date myEndOfTheYear(int parYear) {
    return myEncodeDate(parYear, 12, 31);
  }

  public static Date myStartOfTheMonth(Date parDate) {
    int lYear = myGetYear(parDate);
    int lMonth = myGetMonth(parDate);
    return myEncodeDate(lYear, lMonth, 1);
  }

  public static Date myStartOfTheMonth(int parYear, int parMonth) {
    return myEncodeDate(parYear, parMonth, 1);
  }

  public static Date myEndOfTheMonth(Date parDate) {
    int lYear = myGetYear(parDate);
    int lMonth = myGetMonth(parDate);
    Calendar calendar = Calendar.getInstance();
    calendar.setTime(parDate);
    int maxDay = calendar.getActualMaximum(5);
    return myEncodeDate(lYear, lMonth, maxDay);
  }

  public static Date myEndOfTheMonth(int parYear, int parMonth) {
    Calendar calendar = Calendar.getInstance();
    calendar.set(parYear, parMonth, 1);
    int maxDay = calendar.getActualMaximum(5);
    return myEncodeDate(parYear, parMonth, maxDay);
  }
}