package enums;

import java.time.LocalDateTime;


public enum ExceptionEnums {
    MEMBER_NOT_FOUND("Member not Found", LocalDateTime.now()),
    LACK_OF_DEPARTURES("Lack of Departures", LocalDateTime.now()),
    INVALID_OPTION("Invalid Option", LocalDateTime.now()),
    WRONG_FORMAT("Wrong format!", LocalDateTime.now()),
    EMPTY_LIST("Empty list ", LocalDateTime.now());


    ExceptionEnums(String message, LocalDateTime localDateTime) {
        this.message = message;
        this.localDateTime = localDateTime;
    }

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
    String message;
    LocalDateTime localDateTime;
}

