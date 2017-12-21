package com.epam.training.exception;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class CompareObjectsException extends RuntimeException {
    /**
     * Instantiates a new Compare objects exception.
     */
    public CompareObjectsException() {
    }

    /**
     * Instantiates a new Compare objects exception.
     *
     * @param message the message
     */
    public CompareObjectsException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Compare objects exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public CompareObjectsException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Compare objects exception.
     *
     * @param cause the cause
     */
    public CompareObjectsException(final Throwable cause) {
        super(cause);
    }
}
