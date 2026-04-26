package com.example.backend.DTO;

public class VerificationVirement {
    private int code;

    public VerificationVirement(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
