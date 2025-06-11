package br.com.quarkus.finder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BusinessException extends RuntimeException{
    private String code;
    private Object args;

    public BusinessException(String message){
        super(message);
    }

    public BusinessException(String code, Object...args){
        this.code = code;
        this.args = args;
    }
}