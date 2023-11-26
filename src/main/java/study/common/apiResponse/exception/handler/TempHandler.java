package study.common.apiResponse.exception.handler;

import study.common.apiResponse.code.BaseErrorCode;
import study.common.apiResponse.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
