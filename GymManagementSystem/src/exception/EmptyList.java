package exception;

import enums.ExceptionEnums;

import java.time.LocalDateTime;

public class EmptyList extends RuntimeException{
    private String message;
    private LocalDateTime localDateTime;

    public EmptyList(ExceptionEnums exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.message = exceptionEnum.getMessage();
        this.localDateTime = exceptionEnum.getLocalDateTime();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}

