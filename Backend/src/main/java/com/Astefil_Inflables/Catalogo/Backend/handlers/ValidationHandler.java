package com.Astefil_Inflables.Catalogo.Backend.handlers;

import com.Astefil_Inflables.Catalogo.Backend.exceptions.ItemNotFoundException;
import com.Astefil_Inflables.Catalogo.Backend.exceptions.NotAllowedException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@ControllerAdvice
public class ValidationHandler extends ResponseEntityExceptionHandler {
    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("status", status.value());
        List<String> errors = ex.getBindingResult().getFieldErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).distinct().collect(Collectors.toList());
        body.put("errors", errors);
        return new ResponseEntity<>(body, headers, status);
    }

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<Object> handleItemNotFoundException(ItemNotFoundException ex, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.NOT_FOUND.value());
        body.put("errors", ex.getMessage());
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NotAllowedException.class)
    public ResponseEntity<Object> handleNotAllowedException(NotAllowedException ex, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.FORBIDDEN.value());
        body.put("errors", ex.getMessage());
        return new ResponseEntity<>(body, new HttpHeaders(), HttpStatus.FORBIDDEN);
    }

    @Override
    public ResponseEntity<Object> handleMaxUploadSizeExceededException(MaxUploadSizeExceededException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request){
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.EXPECTATION_FAILED.value());
        body.put("errors", "One or more files are too large!");
        return new ResponseEntity<>(body, headers, status);
    }
}