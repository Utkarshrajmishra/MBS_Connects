package com.example.mbsconnects.HelperClass;

public class AssigmentData {

    public AssigmentData() {
    }



    String date,pdfTitle,pdfUrl,time;

    public AssigmentData(String date, String pdfTitle, String pdfUrl, String time) {
        this.date = date;
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
        this.time = time;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPdfTitle() {
        return pdfTitle;
    }

    public void setPdfTitle(String pdfTitle) {
        this.pdfTitle = pdfTitle;
    }

    public String getPdfUrl() {
        return pdfUrl;
    }

    public void setPdfUrl(String pdfUrl) {
        this.pdfUrl = pdfUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
