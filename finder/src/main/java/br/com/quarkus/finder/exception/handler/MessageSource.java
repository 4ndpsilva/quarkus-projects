package br.com.quarkus.finder.exception.handler;

import jakarta.enterprise.context.ApplicationScoped;
import java.util.ResourceBundle;

@ApplicationScoped
public class MessageSource {
    private ResourceBundle resourceBundle;
}