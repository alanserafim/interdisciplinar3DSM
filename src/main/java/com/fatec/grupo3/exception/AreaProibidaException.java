package com.fatec.grupo3.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class AreaProibidaException extends Exception {
    public AreaProibidaException(String cpf) {
        super(String.format("O usuario de cpf %s está tentando acessar uma area probibida para ele.", cpf));
    }
}
