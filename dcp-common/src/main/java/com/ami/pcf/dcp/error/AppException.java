package com.ami.pcf.dcp.error;

public class AppException extends RuntimeException {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -3045558983725071879L;

    public AppException() {
        super();
    }

    public AppException(String message) {
        super(message);
    }

    public AppException(String message, Throwable error) {
        super(message, error);
    }
}
