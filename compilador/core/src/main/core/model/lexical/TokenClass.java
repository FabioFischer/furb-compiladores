package core.model.lexical;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

public class TokenClass {
    public enum Class {
        PALAVRA_RESERVADA,
        IDENTIFICADOR,
        SIMBOLO_ESPECIAL,
        CONSTANTE_HEX,
        CONSTANTE_BIN,
        CONSTANTE_REAL,
        CONSTANTE_INTEIRO,
        CONSTANTE_STRING,
        CONSTANTE_CHAR,
        COMENTARIO_BLOCO,
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
            case SIMBOLO_ESPECIAL:
                return "simbolo especial";
            case CONSTANTE_HEX:
                return "constante hexadecimal";
            case CONSTANTE_BIN:
                return "constante binário";
            case CONSTANTE_REAL:
                return "constante real";
            case CONSTANTE_INTEIRO:
                return "constante inteiro";
            case CONSTANTE_STRING:
                return "constante string";
            case CONSTANTE_CHAR:
                return "constante caracter";
            case COMENTARIO_BLOCO:
                return "comentário de bloco";
            default:
                return "Token Desconhecido";
        }
    }
}
