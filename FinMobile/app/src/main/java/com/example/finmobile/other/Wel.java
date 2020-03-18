
package com.example.finmobile.other;

public class Wel {
    private  String welfare_contribution;
    private String welfare_month;
    private String welfare_date;
    private String welfare_mode;


    // private String Full_name;

    public Wel(String welfare_contribution,String welfare_month,String welfare_date,String welfare_mode) {

        this.welfare_contribution = welfare_contribution;
        this.welfare_month = welfare_month;
        this.welfare_date = welfare_date;
        this.welfare_mode =welfare_mode;


        // this.Full_name =Full_name;
    }


    // public  String getFull_name(){
    //    return Full_name;
    // }

    public String getWelfare_contribution(){
        return welfare_contribution;
    }

    public String getWelfare_month() {

        return welfare_month;
    }
    public  String getWelfare_date(){
        return welfare_date;
    }
    public  String getWelfare_mode(){
        return welfare_mode;
    }



}

