package io.falcon.assignment.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ApiError {
    private HttpStatus status;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp;
    private String message;
    private String debugMessage;
    private List<ApiSubError> subErrors;

    public ApiError() {
        timestamp = LocalDateTime.now();
    }

    private void addValidationError(FieldError fieldError) {
        ApiValidationError error = new ApiValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getRejectedValue(), fieldError.getDefaultMessage());
        this.addSubError(error);
    }

    void addValidationErrors(List<FieldError> fieldErrors) {
        if (this.subErrors == null){
            subErrors = new ArrayList<>();
        }
        for (FieldError fieldError : fieldErrors) {
            System.out.println("---------------" + fieldError.toString() + "--------------\n");
            System.out.println("---------------" + fieldError.getDefaultMessage() + "--------------\n");
            System.out.println("---------------" + fieldError.getObjectName() + "--------------\n");
            System.out.println("---------------" + fieldError.getRejectedValue() + "--------------\n");
            System.out.println("---------------" + fieldError.getField() + "--------------\n");
            this.subErrors.add(new ApiValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage()));
//            this.addSubError(new ApiValidationError(fieldError.getObjectName(), fieldError.getField(), fieldError.getDefaultMessage()));
        }
//        fieldErrors.forEach(this::addValidationError);
//        System.out.println(this.subErrors);
    }

    private void addValidationError(ObjectError objectError) {
        ApiValidationError error = new ApiValidationError(objectError.getObjectName(), objectError.getDefaultMessage());
        this.addSubError(error);
    }

    void addValidationError(List<ObjectError> globalErrors) {
        globalErrors.forEach(this::addValidationError);
    }

    private void addSubError(ApiSubError subError) {
        if (subErrors == null) {
            subErrors = new ArrayList<>();
        }
        subErrors.add(subError);
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public List<ApiSubError> getSubErrors() {
        return subErrors;
    }

    public void setSubErrors(List<ApiSubError> subErrors) {
        this.subErrors = subErrors;
    }
}
