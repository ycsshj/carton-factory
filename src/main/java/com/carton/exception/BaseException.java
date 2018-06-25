/*
 * Copyright (C) 2014 SEC BFO, Inc. All Rights Reserved.
 */
package com.carton.exception;

/**
 * Base exception
 *
 * @author Spring
 */
public class BaseException extends Exception {

    private static final long serialVersionUID = 4374039979963462421L;

    protected String errorCode;
    protected String errorMsg;
    protected Object[] args;

    public BaseException(String errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorCode, String errorMsg, Object[] args) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.args = args;
    }

    public BaseException(String errorCode, String errorMsg, Throwable t) {
        super(errorMsg, t);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public BaseException(String errorCode, String errorMsg, Object[] args, Throwable t) {
        super(errorMsg, t);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
        this.args = args;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
