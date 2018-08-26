package constants;

/**
 * FURB - Bacharelado em Ciências da Computação
 * Compiladores - Interface
 * <p>
 * Fábio Luiz Fischer & Matheus Felipe Klauberg
 **/

public interface ScannerConstants {
    ScannerResources SCANNER_RESOURCES = new ScannerResources();

    /*
    **   Criado arquivo .txt avulso pois vetor é maior que 64k, causando o erro "java: code too large"
    */
    int[][] SCANNER_TABLE = SCANNER_RESOURCES.getScannerTable();

    int[] TOKEN_STATE = {2, 0, -1, -2, 22, 23, 34, 32, 36, 33, 35, 2, 28, -1, 30, 2, 24, 25, 7, -1, -1, -1, -2, -1, 2, 29, 27, 26, 31, 4, 5, -1, -1, -1, -2, 6, -1, -1, -1, -2, -2, -1, -1, 8, 9, -1, -1, -1, -1};

    int[] SPECIAL_CASES_INDEXES =
            {0, 0, 0, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};

    String[] SPECIAL_CASES_KEYS =
            {"and", "display", "do", "false", "if", "let", "not", "or", "read", "set", "true", "until"};

    int[] SPECIAL_CASES_VALUES =
            {10, 16, 17, 13, 18, 15, 12, 11, 19, 20, 14, 21};

    String[] SCANNER_ERROR =
            {
                    " simbolo invalido",
                    "",
                    "constante string invalida ou nao finalizada",
                    "constante binaria, hexadecimal, caracter ou comentario de bloco invalido",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "Erro identificando ==",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "constante binaria invalida",
                    "constante hexadecimal invalida",
                    "constante caracter invalida ou nao finalizada",
                    "comentario de bloco invalido ou nao finalizado",
                    "constante real invalida",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "comentario de bloco invalido ou nao finalizado",
                    "",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "comentario de bloco invalido ou nao finalizado",
                    "comentario de bloco invalido ou nao finalizado",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "",
                    "",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
                    "constante caracter invalida ou nao finalizada",
            };

}
