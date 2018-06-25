package com.carton.exception;

/*******************************************  
 * @Description:
 * @Author: jerry.zheng
 * @Date Created in 14:16 2018\2\24 0024        
 *******************************************/

public class BaseServiceException extends BaseException {

    public BaseServiceException(String errorCode) {
        super(errorCode, null);
    }

    public BaseServiceException(String errorCode, Throwable e) {
        super(errorCode, null, e);
    }

    public BaseServiceException(String errorCode, String errorMsg) {
        super(errorCode, errorMsg);
    }

    public BaseServiceException(String errorCode, String errorMsg, Throwable e) {
        super(errorCode, errorMsg, e);
    }
}
