package constants;

import core.model.lexical.TokenClass;
import core.model.lexical.TokenKind;

/**
 *   FURB - Bacharelado em Ciências da Computação
 *   Compiladores - Interface
 *
 *   Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

public interface Constants extends ScannerConstants, ParserConstants
{
    TokenKind EPSILON = new TokenKind(0, TokenClass.Class.SIMBOLO_ESPECIAL);
    TokenKind DOLLAR = new TokenKind(1, TokenClass.Class.SIMBOLO_ESPECIAL);

    TokenKind t_identificador = new TokenKind(2, TokenClass.Class.IDENTIFICADOR);
    TokenKind t_inteiro = new TokenKind(3, TokenClass.Class.CONSTANTE_INTEIRO);
    TokenKind t_binario = new TokenKind(4, TokenClass.Class.CONSTANTE_BIN);
    TokenKind t_hexadecimal = new TokenKind(5, TokenClass.Class.CONSTANTE_HEX);
    TokenKind t_real = new TokenKind(6, TokenClass.Class.CONSTANTE_REAL);
    TokenKind t_string = new TokenKind(7, TokenClass.Class.CONSTANTE_STRING);
    TokenKind t_caracter = new TokenKind(8, TokenClass.Class.CONSTANTE_CHAR);
    TokenKind t_comentario = new TokenKind(9, TokenClass.Class.COMENTARIO_BLOCO);
    TokenKind t_AND = new TokenKind(10, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_OR = new TokenKind(11, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_NOT = new TokenKind(12, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_FALSE = new TokenKind(13, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_TRUE = new TokenKind(14, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_LET = new TokenKind(15, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_DISPLAY = new TokenKind(16, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_DO = new TokenKind(17, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_IF = new TokenKind(18, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_READ = new TokenKind(19, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_SET = new TokenKind(20, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_UNTIL = new TokenKind(21, TokenClass.Class.PALAVRA_RESERVADA);
    TokenKind t_TOKEN_22 = new TokenKind(22, TokenClass.Class.SIMBOLO_ESPECIAL); //"("
    TokenKind t_TOKEN_23 = new TokenKind(23, TokenClass.Class.SIMBOLO_ESPECIAL); //")"
    TokenKind t_TOKEN_24 = new TokenKind(24, TokenClass.Class.SIMBOLO_ESPECIAL); //"["
    TokenKind t_TOKEN_25 = new TokenKind(25, TokenClass.Class.SIMBOLO_ESPECIAL); //"]"
    TokenKind t_TOKEN_26 = new TokenKind(26, TokenClass.Class.SIMBOLO_ESPECIAL); //"=="
    TokenKind t_TOKEN_27 = new TokenKind(27, TokenClass.Class.SIMBOLO_ESPECIAL); //"<>"
    TokenKind t_TOKEN_28 = new TokenKind(28, TokenClass.Class.SIMBOLO_ESPECIAL); //"<"
    TokenKind t_TOKEN_29 = new TokenKind(29, TokenClass.Class.SIMBOLO_ESPECIAL); //"<="
    TokenKind t_TOKEN_30 = new TokenKind(30, TokenClass.Class.SIMBOLO_ESPECIAL); //">"
    TokenKind t_TOKEN_31 = new TokenKind(31, TokenClass.Class.SIMBOLO_ESPECIAL); //">="
    TokenKind t_TOKEN_32 = new TokenKind(32, TokenClass.Class.SIMBOLO_ESPECIAL); //"+"
    TokenKind t_TOKEN_33 = new TokenKind(33, TokenClass.Class.SIMBOLO_ESPECIAL); //"-"
    TokenKind t_TOKEN_34 = new TokenKind(34, TokenClass.Class.SIMBOLO_ESPECIAL); //"*"
    TokenKind t_TOKEN_35 = new TokenKind(35, TokenClass.Class.SIMBOLO_ESPECIAL); //"/"
    TokenKind t_TOKEN_36 = new TokenKind(36, TokenClass.Class.SIMBOLO_ESPECIAL); //","
}
