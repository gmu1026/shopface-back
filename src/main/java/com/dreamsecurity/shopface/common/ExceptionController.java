package com.dreamsecurity.shopface.common;

import com.dreamsecurity.shopface.common.exception.InvalidValueException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({InvalidValueException.class})
    public ResponseEntity<Object> branchException(final InvalidValueException invalidValueException) {
        return ResponseEntity.status(invalidValueException.getErrorCode().getStatus()).body(invalidValueException.getMessage());
    }

//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<Object> badRequestException(final RuntimeException runtimeException) {
//        return ResponseEntity.badRequest().body(runtimeException.getMessage());
//    }
//
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<Object> accessDeniedException(final RuntimeException runtimeException) {
//        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(runtimeException.getMessage());
//    }
//
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<Object> jdbcException(final RuntimeException runtimeException) {
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(runtimeException.getMessage());
//    }
//
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<Object> handAll(final Exception exception) {
//        return new ResponseEntity<>(exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
//    }
}
