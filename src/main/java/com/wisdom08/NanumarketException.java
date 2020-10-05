package com.wisdom08;

public class NanumarketException extends RuntimeException {

    int responseCode;
    String errorCode;

    public NanumarketException(int responseCode, String errorCode) {
        super(errorCode);
        this.responseCode = responseCode;
        this.errorCode = errorCode;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}
