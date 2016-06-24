package com.bredikhin;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<>();
        persons.add(new Person("Yana", "Petrova", "21.01.1991"));
        persons.add(new Person("Kseniya", "Ivanova", "22.02.1990"));
        persons.add(new Person("Kseniya", "Ivvanova", "22.02.1990"));
        persons.add(new Person("Jana", "Petrova", "21.01.1091"));
        String name1 = "Ivanova";
        String name2 = "iVvanova";
        String name3 = "kseniya";
        String date1 = "29.03.2015";
        String[] strings1 = Utilities.get2Gramm(name1);
        String[] strings2 = Utilities.get2Gramm(name2);
        String[] strings3 = Utilities.get2Gramm(name3);
        System.out.println(Utilities.hashLy(name1));
        System.out.println(Utilities.hashLy(name2));
        System.out.println(Utilities.hashLy(name3));
//        printArr(strings1);
//        printArr(strings2);
//        printArr(strings3);
//        System.out.println(compareWord(strings1,strings2));
        for(Person p:persons){
            p.createHash();
            System.out.println(p);
        }
        //System.out.println(Utilities.dateValidate(date1));
        //Test();
    }


    public static void Test() {
        ArrayList<Long> integers = new ArrayList<>();
        long res;
        int c = 0;
        for (int i = 1800; i < 2017; i++) {
            for (int j = 1; j < 13; j++) {
                for (int k = 1; k < 32; k++) {
                    String s = k+"."+j+"."+i;
                    res = Utilities.hashLy(s);
                    if (integers.contains(res) || integers.contains(Math.abs(res))) {
                        System.out.println("year=" + i + " maonth=" + j + " day=" + k + " hash=" + res);
                        integers.add(res);
                    } else {
                        integers.add(res);
                    }
                }
            }
        }
        //integers.sort(Integer::compareTo);
        System.out.println("kek="+c);
    }



}
