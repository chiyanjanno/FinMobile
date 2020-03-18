package com.example.finmobile.other;

public class Cont {

    private  String Monthly_contribution;
    private String Month;
    private String date_of_payment;
    private String Paid_through;
    // private String Full_name;

    public Cont(String Monthly_contribution,String Month, String date_of_payment,String Paid_through) {
        this.Month = Month;
        this.Paid_through =Paid_through;
        this.date_of_payment = date_of_payment;
        this.Monthly_contribution = Monthly_contribution;
        // this.Full_name =Full_name;
    }


    public String getMonth() {
        return Month;
    }

    public  String getPaid_through(){
        return Paid_through;
    }

    public  String getDate_of_payment(){
        return date_of_payment;
    }
    public String getMonthly_contribution(){
        return Monthly_contribution;
    }
}