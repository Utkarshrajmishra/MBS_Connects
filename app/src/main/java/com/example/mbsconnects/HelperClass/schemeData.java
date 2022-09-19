package com.example.mbsconnects.HelperClass;

public class schemeData {


    String pdfTitle,pdfUrl,date;
    public schemeData() {
    }

    public schemeData(String pdfTitle, String pdfUrl, String date) {
        this.pdfTitle = pdfTitle;
        this.pdfUrl = pdfUrl;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }


}
