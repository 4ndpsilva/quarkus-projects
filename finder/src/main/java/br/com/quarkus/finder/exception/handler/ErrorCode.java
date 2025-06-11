package br.com.quarkus.finder.exception.handler;

import lombok.Getter;

@Getter
public enum ErrorCode {
    API_001("API-001"),
    API_002("API-002"),
    API_003("API-003"),
    API_004("API-004");

    private final String code;

    ErrorCode(String code){
        this.code = code;
    }
}