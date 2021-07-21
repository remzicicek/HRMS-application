package com.hrms.HRMS.core.results.Constant;

import com.hrms.HRMS.core.results.DataResult;

public class ErrorDataResult<T> extends DataResult {

    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult(T data, String message) {
        super(data, false, message);
    }

    /*
    if we do not want to return data. For example exception error
*/
    public ErrorDataResult(String message){
        super(null, false, message);
    }

    public ErrorDataResult(){
        super(null, false);
    }
}
