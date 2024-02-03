package com.example.currencyexchange.domain.exception;

public class BlockedException extends RuntimeException {
    public BlockedException() {
        super();
    }

    public BlockedException(String message) {
        super(message);
    }

}
