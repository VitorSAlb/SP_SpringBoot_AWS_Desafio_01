package exception;

import java.io.Serial;

public class DefaultException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1L;

    public DefaultException(String msg) {
        super(msg);
    }

}
