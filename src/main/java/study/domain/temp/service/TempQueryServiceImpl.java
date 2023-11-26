package study.domain.temp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import study.common.apiResponse.code.status.ErrorStatus;
import study.common.apiResponse.exception.handler.TempHandler;

@Service
@RequiredArgsConstructor
public class TempQueryServiceImpl implements TempQueryService{

    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}
