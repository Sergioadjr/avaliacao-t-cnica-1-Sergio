package com.example.Desafio.exception;

public class IdadeInvalidaException extends Exception {
    public IdadeInvalidaException() {
        super("A idade para dependente deve ser inferior a 18.");
    }
}