package com.example.finmobile.other;


public class Fin {

    private  String fine_amount;
    private String fine_month;
    private String fine_date;
    private String fine_mode;
    private String fine_description;


    // private String Full_name;

    public Fin(String fine_amount,String fine_month,String fine_date,String fine_description, String fine_mode) {

        this.fine_amount = fine_amount;
        this.fine_month = fine_month;
        this.fine_date = fine_date;
        this.fine_description = fine_description;
        this.fine_mode = fine_mode;





        // this.Full_name =Full_name;
    }


    // public  String getFull_name(){
    //    return Full_name;
    // }

    public String getFine_amount(){
        return fine_amount;
    }

    public String getFine_month() {

        return fine_month;
    }
    public  String getFine_date(){
        return fine_date;
    }
    public  String getFine_description(){
        return fine_description;
    }
    public  String getFine_mode(){
        return fine_mode;
    }



}

