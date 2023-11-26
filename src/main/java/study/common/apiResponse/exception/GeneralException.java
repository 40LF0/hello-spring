package study.common.apiResponse.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import study.common.apiResponse.code.BaseErrorCode;
import study.common.apiResponse.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
