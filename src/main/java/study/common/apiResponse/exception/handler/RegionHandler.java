package study.common.apiResponse.exception.handler;

import study.common.apiResponse.code.BaseErrorCode;
import study.common.apiResponse.exception.GeneralException;

public class RegionHandler extends GeneralException {
    public RegionHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}