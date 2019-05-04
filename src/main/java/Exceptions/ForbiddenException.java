package Exceptions;

public class ForbiddenException extends RuntimeException {
    public static final Integer CODE = 403;
    private static final String DEFAULT_MESSAGE = "Forbidden";
    private Integer code;

    public ForbiddenException() {
        super(DEFAULT_MESSAGE);
        this.code = CODE;
    }

    public ForbiddenException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

}
