package net.njsharpe.netclient.exception;

public class ApiException extends RuntimeException {

    public ApiException() {
        super();
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(String message, Throwable exception) {
        super(message, exception);
    }

    public ApiException(Throwable exception) {
        super(exception);
    }

}
