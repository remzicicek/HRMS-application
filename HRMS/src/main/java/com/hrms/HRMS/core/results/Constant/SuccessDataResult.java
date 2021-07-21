package com.hrms.HRMS.core.results.Constant;

import com.hrms.HRMS.core.results.DataResult;

public class SuccessDataResult<T> extends DataResult {
    public SuccessDataResult(T data) {
        super(data, true);
    }

    public SuccessDataResult(T data, String message) {
        super(data, true, message);
    }

    /*
        if we do not want to return data
    */
    public SuccessDataResult(String message){
        super(null, true, message);
    }

    public SuccessDataResult(){
        super(null, true);
    }
}
