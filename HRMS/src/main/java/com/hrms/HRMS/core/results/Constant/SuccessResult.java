package com.hrms.HRMS.core.results.Constant;

import com.hrms.HRMS.core.results.Result;

public class SuccessResult extends Result {
    public SuccessResult() {
        super(true);
    }

    public SuccessResult(String message) {
        super(true, message);
    }
}
