package com.ninyo.crudcore.controller;

import com.ninyo.crudcore.model.ErrorMessage;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;
import java.nio.file.AccessDeniedException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /* Default handler to any uncought exception */
    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorMessage> handleAnyException(Exception ex, HttpServletRequest req) {
        return handleException(ex, req, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({AccessDeniedException.class})
    public ResponseEntity<ErrorMessage> handleAccessDenied(Exception ex, HttpServletRequest req) {
        return handleException(ex, req, HttpStatus.FORBIDDEN);
    }

    @ExceptionHandler({UnsupportedOperationException.class})
    public ResponseEntity<ErrorMessage> handleUnsupportedOperation(Exception ex, HttpServletRequest req) {
        return handleException(ex, req, HttpStatus.NOT_IMPLEMENTED);
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<ErrorMessage> handleConstraintViolation(Exception ex, HttpServletRequest req) {
        return handleException(ex, req, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({NoSuchElementException.class})
    public ResponseEntity<ErrorMessage> handleNoSuchElementException(Exception ex, HttpServletRequest req) {
        return handleException(ex, req, HttpStatus.NOT_FOUND);
    }

    @Override
    @SuppressWarnings("unchecked")
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, @Nullable Object body, HttpHeaders headers, HttpStatusCode statusCode, WebRequest request) {
        HttpServletRequest req = ((ServletWebRequest) request).getRequest();
        String uri = req.getRequestURI();
        if (req.getQueryString() != null) {
            uri += '?' + req.getQueryString();
        }
        log.error("Request URI: {}, method: {}, raised an exception with HTTP status: {}", uri, req.getMethod(), statusCode, ex);

        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(generateTimestamp())
                .status(statusCode.value())
                .exception(ex.getClass().getName())
                .message(ex.getMessage())
                .path(uri)
                .build();
        return new ResponseEntity(errorMessage, new HttpHeaders(), statusCode);
    }

    private ResponseEntity<ErrorMessage> handleException(Exception ex, HttpServletRequest req, HttpStatus status) {
        String uri = req.getRequestURI();
        if (req.getQueryString() != null) {
            uri += '?' + req.getQueryString();
        }
        log.error("Request URI: {}, method: {}, raised an exception with HTTP status: {}", uri, req.getMethod(), status, ex);

        ErrorMessage errorMessage = ErrorMessage.builder()
                .timestamp(generateTimestamp())
                .status(status.value())
                .exception(ex.getClass().getName())
                .message(ex.getMessage())
                .path(uri)
                .build();
        return new ResponseEntity<ErrorMessage>(errorMessage, new HttpHeaders(), status);
    }

    private static String generateTimestamp() {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        return dateFormatter.format(new Date());
    }
}
