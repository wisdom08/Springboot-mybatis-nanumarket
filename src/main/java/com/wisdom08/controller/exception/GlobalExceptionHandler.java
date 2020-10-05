package com.wisdom08.controller.exception;

import com.wisdom08.NanumarketException;
import com.wisdom08.TypeMap;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Type;

@RestControllerAdvice
public class GlobalExceptionHandler {
    /**
     * 모든 예외는 이쪽으로
     * @param e
     * @return
     */
    @ExceptionHandler(NanumarketException.class)
    public Object handleNanumarketException(NanumarketException e) {
        int rsCode = e.getResponseCode();
        String errorCode = e.getErrorCode();
        //HttpStatus.BAD_REQUEST;

        HttpStatus status = findStatus(rsCode);

        TypeMap body = TypeMap.fail("cause", errorCode);
        return new ResponseEntity<TypeMap>(body, status);
    }

    private HttpStatus findStatus(int rsCode) {
        HttpStatus[] responses = HttpStatus.values();
        for (HttpStatus status : responses) {
            if (status.value() == rsCode) {
                return status;
            }
        }
        return HttpStatus.BAD_REQUEST; //400
    }
}
