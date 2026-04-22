package com.example.backend.DTO;

public class Verificationrequest {

    private int code ;
    
    public Verificationrequest(int code, int id_u) {
        this.code = code;
        this.id_u = id_u;
    }
    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    private int id_u;
    public int getId_u() {
        return id_u;
    }
    public void setId_u(int id_u) {
        this.id_u = id_u;
    }



}
