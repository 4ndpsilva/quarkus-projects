package br.com.quarkus.finder.controller;

import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import java.util.List;
import java.util.Locale;

public abstract class AbstractController {
    @Context
    HttpHeaders headers;

    public Locale resolve(){
        Locale locale = headers.getLanguage();

        if(locale != null){
            return locale;
        }

        /*return headers.getAcceptableLanguages()
            .stream()
            .findFirst()
            .orElse(Locale.ENGLISH);*/

        List<Locale> acceptable = headers.getAcceptableLanguages();
        if (acceptable != null && !acceptable.isEmpty()) {
            return acceptable.get(0);
        }

        // Se nada foi informado (ou informado mas vazio), use idioma padrão
        return Locale.ENGLISH;
    }
}