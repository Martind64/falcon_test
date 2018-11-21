package io.falcon.assignment.exception;

class ApiValidationError extends ApiSubError {
    private String object;
    private String field;
    private Object rejectedValue;
    private String message;

    public ApiValidationError(String object, String field, Object rejectedValue, String message) {
        this.object = object;
        this.field = field;
        this.rejectedValue = rejectedValue;
        this.message = message;
    }

    ApiValidationError(String object, String field, String message) {
        this.object = object;
        this.message = message;
        this.field = field;
    }

    ApiValidationError(String object, String message) {
        this.object = object;
        this.message = message;
    }
}
