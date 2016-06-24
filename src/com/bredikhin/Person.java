package com.bredikhin;

/**
 * Created by Pavel on 22.06.2016.
 */
public class Person {
    private String fName;
    private String sName;
    private String bDate;
    private long hash;
    boolean isDateValid;

    public Person(String firstName, String secondName, String date){
        fName = firstName;
        sName = secondName;
        bDate = Utilities.dateValidate(date);
    }

    @Override
    public String toString() {
        return "Person{" +
                "fName='" + fName + '\'' +
                ", sName='" + sName + '\'' +
                ", bDate='" + bDate + '\'' +
                ", hash=" + hash +
                '}';
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getbDate() {
        return bDate;
    }

    public void setbDate(String bDate) {
        this.bDate = bDate;
    }

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public void createHash(){
        hash = Utilities.compareWord(fName);
        hash |= Utilities.compareWord(sName);
        String[] dd = bDate.split("\\D");
        int dateHash = Integer.valueOf(dd[2]);
        dateHash<<=2;
        dateHash+=Integer.valueOf(dd[1]);
        dateHash<<=2;
        dateHash+=Integer.valueOf(dd[0]);
        hash |= dateHash;
    }


}
