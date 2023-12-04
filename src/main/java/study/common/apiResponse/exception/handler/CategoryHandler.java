package study.common.apiResponse.exception.handler;

import study.common.apiResponse.code.BaseErrorCode;
import study.common.apiResponse.exception.GeneralException;

public class CategoryHandler extends GeneralException {
    public CategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}