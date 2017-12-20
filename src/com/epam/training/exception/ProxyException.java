package com.epam.training.exception;

/**
 * Created by Valiantsin Pshanichnik on 20.12.2017.
 */
public class ProxyException extends Exception {
    /**
     * Instantiates a new Proxy exception.
     */
    public ProxyException() {
    }

    /**
     * Instantiates a new Proxy exception.
     *
     * @param message the message
     */
    public ProxyException(final String message) {
        super(message);
    }

    /**
     * Instantiates a new Proxy exception.
     *
     * @param message the message
     * @param cause   the cause
     */
    public ProxyException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Instantiates a new Proxy exception.
     *
     * @param cause the cause
     */
    public ProxyException(final Throwable cause) {
        super(cause);
    }
}
