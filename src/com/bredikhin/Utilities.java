package com.bredikhin;

import com.sun.org.apache.bcel.internal.generic.NEW;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Utilities {
    private static ArrayList<ParseWord> dictionary = new ArrayList<>();
    public static final int K = 2;
    public static final String DATE_FORMAT = "dd.MM.yyyy";

    public static String[] get2Gramm(String word) {
        word = word.toLowerCase();
        String[] result = new String[word.length() - 1];
        for (int i = 0; i < word.length() - 1; i++) {
            result[i] = word.substring(i, i + K);
        }
        return result;
    }

    public static void printArr(String[] array) {
        for (String string : array) {
            System.out.println(string);
        }
    }

    public static long hashLy(String str) {
        int hash = 0;
        for (int i = 0; i < str.length(); i++) {
            hash = (hash * 1664525) + (int) (str.charAt(i)) + 1013904223;
        }
        return hash;

    }

    public static long compareWord(String string) {
        String[] array = get2Gramm(string);
        int mistake;
        String[] array2;
        for (ParseWord word : dictionary) {
            mistake = 0;
            array2 = word.getnGram();
            for (String string1 : array) {
                for (String string2 : array2) {
                    if (string1.equals(string2)) {
                        mistake++;
                    }
                }
            }
            if (mistake >= getInterval(array.length + array2.length)) {
                return word.getHash();
            }
        }
        dictionary.add(new ParseWord(string));
        return hashLy(string);
    }

    public static int getInterval(int avgLength) {
        int result;
        switch (avgLength) {
            case 6:
            case 7:
            case 8:
            case 9:
                result = 2;
                break;
            case 10:
            case 11:
                result = 3;
                break;
            case 12:
            case 13:
                result = 4;
                break;
            default:
                result = -1;
        }
        return result;
    }

    public static int getDayInMonth(int month, int year) {
        int result;
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                result = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                result = 30;
                break;
            case 2:
                if (year % 4 == 0) {
                    result = 29;
                } else {
                    result = 28;
                }
                break;
            default:
                result = -1;
        }
        return result;
    }

    public static String fixDate(int day, int month, int year) {
        if (year % 100 >= 0 && year % 100 <= 16) {
            year = 2000 + year % 100;
        } else if (year % 100 > 16 && year % 100 < 100) {
            year = 1900 + year % 100;
        }

        if (month > 12) {
            if (month % 10 > 2) {
                month = month % 10;
            } else {
                month = 10 + month % 10;
            }
        }

        if(month == 0){
            month = 10;
        }

        if(day>getDayInMonth(month,year)){
            day = getDayInMonth(month,year);
        }

//        int s = 0, temp = 0;
//        switch (year / 1000) {
//            case 1:
//            case 2:
//                if (year % 1000 >= 0 && year % 1000 <= 16) {
//                    year = 2000 + year % 100;
//                } else if(year % 1000 > 900 && year % 1000 < 1000){
//                    year = 1000 + year % 100;
//                }
//                break;
//            case 3:
//            case 4:
//            case 5:
//            case 6:
//            case 7:
//            case 8:
//            case 9:
//            case 0:
//                s = year % 1000;
//                if (s > 900 && s < 1000) {
//                    year = 1000 + year % 1000;
//                } else if (s >= 0 && s <= 16) {
//                    year = 2000 + year % 1000;
//                }
//                break;
//        }
        StringBuilder buffer = new StringBuilder();
        if(day<10){
            buffer.append("0"+day+".");
        } else {
            buffer.append(day+".");
        }
        if(month<10){
            buffer.append("0"+month+".");
        } else {
            buffer.append(month+".");
        }
        buffer.append(year);


        return buffer.toString();
    }


    public static String dateValidate(String dateString) {
        SimpleDateFormat format = new SimpleDateFormat(DATE_FORMAT);
        format.setLenient(false);
        Date date;
        String[] dd = dateString.split("\\D");
        dateString = fixDate(Integer.valueOf(dd[0]),Integer.valueOf(dd[1]),Integer.valueOf(dd[2]));
        try {
            date = format.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return dateString;
        }
        Calendar curCalendar = new GregorianCalendar();
        Calendar myCalendar = new GregorianCalendar();
        curCalendar.setTime(new Date());

        myCalendar.setTime(date);
        if (myCalendar.get(Calendar.YEAR) > curCalendar.get(Calendar.YEAR) - 120) {
            return dateString;
        }
        return dateString;
    }
}
