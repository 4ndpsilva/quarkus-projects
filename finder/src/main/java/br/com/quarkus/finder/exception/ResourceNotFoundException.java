package br.com.quarkus.finder.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ResourceNotFoundException extends RuntimeException{
    private String code;
    private Object args;

    public ResourceNotFoundException(String msg){
        super(msg);
    }

    public ResourceNotFoundException(String code, Object...args){
        this.code = code;
        this.args = args;
    }
}