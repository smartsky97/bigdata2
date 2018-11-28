package com.pl.web.model;

public class Month_saturation_collection_a {
    private String mailname;

    private String date;

    private String saturability;

    public String getMailname() {
        return mailname;
    }

    public void setMailname(String mailname) {
        this.mailname = mailname == null ? null : mailname.trim();
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date == null ? null : date.trim();
    }

    public String getSaturability() {
        return saturability;
    }

    public void setSaturability(String saturability) {
        this.saturability = saturability == null ? null : saturability.trim();
    }
}