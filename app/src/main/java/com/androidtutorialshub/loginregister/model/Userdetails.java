package com.androidtutorialshub.loginregister.model;

public class Userdetails {
    private int ud_id;
    private String ud_name;
    private String ud_email;
    private String ud_flatno;
    private int bill_ep1;
    private int bill_ep2;
    private int bill_ep3;
    private int bill_flat;
    private int usage_ep1;
    private int usage_ep2;
    private int usage_ep3;
    private int usage_flat;

    public Userdetails(int i, String name, String email, String flatno, int i1, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
    }

    public Userdetails() {

    }

    public int getBill_ep1() {
        return bill_ep1;
    }

    public void setBill_ep1(int bill_ep1) {
        this.bill_ep1 = bill_ep1;
    }

    public int getBill_ep2() {
        return bill_ep2;
    }

    public void setBill_ep2(int bill_ep2) {
        this.bill_ep2 = bill_ep2;
    }

    public int getBill_ep3() {
        return bill_ep3;
    }

    public void setBill_ep3(int bill_ep3) {
        this.bill_ep3 = bill_ep3;
    }

    public int getBill_flat() {
        return bill_flat;
    }

    public void setBill_flat(int bill_flat) {
        this.bill_flat = bill_flat;
    }

    public int getUsage_ep1() {
        return usage_ep1;
    }

    public void setUsage_ep1(int usage_ep1) {
        this.usage_ep1 = usage_ep1;
    }

    public int getUsage_ep2() {
        return usage_ep2;
    }

    public void setUsage_ep2(int usage_ep2) {
        this.usage_ep2 = usage_ep2;
    }

    public int getUsage_ep3() {
        return usage_ep3;
    }

    public void setUsage_ep3(int usage_ep3) {
        this.usage_ep3 = usage_ep3;
    }

    public int getUsage_flat() {
        return usage_flat;
    }

    public void setUsage_flat(int usage_flat) {
        this.usage_flat = usage_flat;
    }

    public int getUd_id() {
        return ud_id;
    }

    public void setUd_id(int ud_id) {
        this.ud_id = ud_id;
    }

    public String getUd_name() {
        return ud_name;
    }

    public void setUd_name(String ud_name) {
        this.ud_name = ud_name;
    }

    public String getUd_email() {
        return ud_email;
    }

    public void setUd_email(String ud_email) {
        this.ud_email = ud_email;
    }

    public String getUd_flatno() {
        return ud_flatno;
    }

    public void setUd_flatno(String ud_flatno) {
        this.ud_flatno = ud_flatno;
    }


}

