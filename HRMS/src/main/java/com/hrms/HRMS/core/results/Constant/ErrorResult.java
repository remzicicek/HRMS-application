package com.hrms.HRMS.core.results.Constant;

import com.hrms.HRMS.core.results.Result;

public class ErrorResult extends Result {

    public ErrorResult() {
        super(false);
    }

    public ErrorResult(String message) {
        super(false, message);
    }
}
