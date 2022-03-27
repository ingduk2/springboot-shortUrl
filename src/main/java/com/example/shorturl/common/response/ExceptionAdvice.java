package com.example.shorturl.common.response;

import com.example.shorturl.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<Object> businessException(BusinessException e, WebRequest request) {

        return super.handleExceptionInternal(
                e,
                ApiResponse.fail(
                        e.getErrorCode()
                ),
                HttpHeaders.EMPTY,
                HttpStatus.OK,
                request
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> unExpectedException(Exception e, WebRequest request) {

        return super.handleExceptionInternal(
                e,
                ApiResponse.fail(
                        ErrorCode.UNEXPECTED_ERROR
                ),
                HttpHeaders.EMPTY,
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(
            NoHandlerFoundException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request) {

        return super.handleExceptionInternal(
                ex,
                ApiResponse.fail(
                        ErrorCode.HANDLER_NO_FOUND_EXCEPTION
                ),
                HttpHeaders.EMPTY,
                HttpStatus.NOT_FOUND,
                request
        );
    }
}
