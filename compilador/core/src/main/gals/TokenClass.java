package gals;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Sintatico
 *
 *   Fábio Luiz Fischer
 **/

public class TokenClass {
    public enum Class {
        PALAVRA_RESERVADA,
        IDENTIFICADOR,
        CONSTANTE_NUMERICA,
        CONSTANTE_CARACTERE,
        CONSTANTE_LITERAL,
        SIMBOLO_ESPECIAL,
        COMENTARIO_LINHA,
        NAO_IDENTIFICADO
    }

    private Class tokenClass;

    public TokenClass(Class tokenClass) {
        this.setTokenClass(tokenClass);
    }

    public Class getTokenClass() {
        return tokenClass;
    }

    public void setTokenClass(Class tokenClass) {
        this.tokenClass = tokenClass;
    }

    public String getDescription() {
        switch (this.getTokenClass()) {
            case PALAVRA_RESERVADA:
                return "palavra reservada";
            case IDENTIFICADOR:
                return "identificador";
            case CONSTANTE_NUMERICA:
                return "constante numerica";
            case CONSTANTE_CARACTERE:
                return "constante caractere";
            case CONSTANTE_LITERAL:
                return "constante literal";
            case SIMBOLO_ESPECIAL:
                return "simbolo especial";
            case COMENTARIO_LINHA:
                return "comentario de linha";
            case NAO_IDENTIFICADO:
                return "token desconhecido";
            default:
                return "token desconhecido";
        }
    }
}
