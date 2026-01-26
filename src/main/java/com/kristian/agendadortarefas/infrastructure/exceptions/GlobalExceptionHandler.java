package com.kristian.agendadortarefas.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice//“Essa classe fica observando todos os controllers
//Se alguma exceção acontecer, eu trato aqui.”
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)//“Se QUALQUER controller lançar ResourceNotFoundException,
    //use ESTE método para responder.”
    public ResponseEntity<String> handleResourceNotFoundException(ResourceNotFoundException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<String> handleUnauthorizedException(UnauthorizedException ex){
        return  new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
// Obs: Precisa criar a classe ResourceNotFoundException?
// SIM, obrigatoriamente
// O Spring não cria isso para minha pessoa.