package com.example.backend.DTO;

public class Alerterequest {
 private long numerocpt;
 public long getNumerocpt() {
    return numerocpt;
}

 public void setNumerocpt(long numerocpt) {
    this.numerocpt = numerocpt;
 }

 private String cause;
public String getCause() {
    return cause;
}

 public void setCause(String cause) {
    this.cause = cause;
 }

private int codesecret;

 public int getCodesecret() {
    return codesecret;
}

public void setCodesecret(int codesecret) {
    this.codesecret = codesecret;
}

 public Alerterequest(long numerocpt, String cause, int codesecret) {
    this.numerocpt = numerocpt;
    this.cause = cause;
    this.codesecret = codesecret;
}

 
}
