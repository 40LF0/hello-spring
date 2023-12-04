package study.common.apiResponse.exception.handler;

import study.common.apiResponse.code.BaseErrorCode;
import study.common.apiResponse.exception.GeneralException;

public class ErrorHandler extends GeneralException {

    public ErrorHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
