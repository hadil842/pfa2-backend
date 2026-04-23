package com.example.backend.DTO;

public class Alerterequest {
 private String numerocpt;
 public String getNumerocpt() {
    return numerocpt;
}

 public void setNumerocpt(String numerocpt) {
    this.numerocpt = numerocpt;
 }

 private String cause;
public String getCause() {
    return cause;
}

 public void setCause(String cause) {
    this.cause = cause;
 }

private String codesecret;

 public String getCodesecret() {
    return codesecret;
}

public void setCodesecret(String codesecret) {
    this.codesecret = codesecret;
}

 public Alerterequest(String numerocpt, String cause, String codesecret) {
    this.numerocpt = numerocpt;
    this.cause = cause;
    this.codesecret = codesecret;
}

 
}
