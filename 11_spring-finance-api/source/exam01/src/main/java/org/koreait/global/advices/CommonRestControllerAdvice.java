package org.koreait.global.advices;

import org.koreait.global.exceptions.BadRequestException;
import org.koreait.global.rests.JSONError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackages = "org.koreait")
public class CommonRestControllerAdvice {
    /**
     * Error가 발생했을 시 유입됨
     * - @ExceptionHandler: Spring MVC에서 전역 예외를 처리
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<JSONError<Object>> errorHandler(Exception e) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        Object message = e.getMessage();
        if (e instanceof BadRequestException badRequestException) {
            message = badRequestException.getMessages();
        }
        JSONError<Object> error = new JSONError<>(status, message);

        return ResponseEntity.status(status).body(error);
    }
}
