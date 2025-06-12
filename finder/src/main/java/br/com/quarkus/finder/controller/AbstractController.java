package br.com.quarkus.finder.controller;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import java.util.Locale;

public abstract class AbstractController {
    @Context
    HttpHeaders headers;

    public Locale resolve(){
        return headers.getAcceptableLanguages()
            .stream()
            .findFirst()
            .orElse(Locale.ENGLISH);
    }
}