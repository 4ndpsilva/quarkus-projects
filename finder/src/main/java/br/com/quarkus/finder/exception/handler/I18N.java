package br.com.quarkus.finder.exception.handler;

import io.quarkus.qute.i18n.MessageBundle;

@MessageBundle
public interface I18N {

    String api001();

    String api002(String param);

    String api003(String param);

    String api004();
}