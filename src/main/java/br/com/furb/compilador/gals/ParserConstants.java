package br.com.furb.compilador.gals;

public interface ParserConstants
{
    int START_SYMBOL = 47;

    int FIRST_NON_TERMINAL    = 47;
    int FIRST_SEMANTIC_ACTION = 87;

    int[][] PARSER_TABLE =
    {
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 54, 54, 54, 54, 54, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, -1, -1, -1, 54, -1, -1, -1, -1, -1, 54, 54, -1, -1, -1, -1, -1, -1, 54 },
        { -1,  1, -1, -1, -1, -1, -1,  1, -1,  1, -1, -1, -1, -1, -1,  1, -1, -1,  1,  1,  1, -1, -1,  1,  1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  2, -1, -1, -1, -1, -1,  2, -1,  2, -1, -1, -1, -1, -1,  2, -1, -1,  2,  2,  2, -1, -1,  2,  2, -1, -1, -1, -1, -1, -1, -1, -1,  3, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  4, -1, -1, -1, -1, -1,  4, -1,  4, -1, -1, -1, -1, -1,  4, -1, -1,  4,  4,  4, -1, -1,  5,  6, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1,  7, -1, -1, -1, -1, -1,  7, -1,  7, -1, -1, -1, -1, -1,  7, -1, -1,  7,  7,  7, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  8, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,  9, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 10, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 11, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 12, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 14, -1, -1, 15, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 16, 17, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 18, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 19, 20, -1, 19, 19, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, 25, -1, 23, -1, -1, -1, -1, 22, -1, -1, 21, -1, -1, -1, -1, 24, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, 26, 27, 28, 29, -1, -1, -1, -1, -1, -1, 31, -1, -1, -1, -1, -1, -1, -1, -1, -1, 30, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 32, -1, -1, -1, -1, -1, 37, -1, 36, -1, -1, -1, -1, -1, 35, -1, -1, 34, 34, 33, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 38, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 39, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 40, 41, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 42, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 44, 43, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, 45, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 47, -1, -1, -1, 46, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 48, -1, -1, -1, -1, -1, 48, -1, 48, -1, -1, -1, -1, -1, 48, -1, -1, 48, 48, 48, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 50, -1, -1, -1, -1, -1, 50, -1, 50, 49, 49, -1, -1, -1, 50, -1, -1, 50, 50, 50, -1, -1, -1, -1, 49, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, 51, 51, 51, 51, 51, -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, -1, -1, -1, 51, -1, -1, -1, -1, -1, 51, 51, -1, -1, -1, -1, -1, -1, 51 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 53, -1, -1, 52, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 55, 55, -1, 55, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 56, 57, -1 },
        { -1, 58, 58, 58, 58, 58, -1, -1, -1, -1, -1, -1, 60, -1, -1, -1, -1, -1, -1, -1, -1, -1, 59, -1, -1, -1, -1, -1, -1, -1, -1, 58, -1, -1, -1, -1, -1, 58, 58, -1, -1, -1, -1, -1, -1, 61 },
        { -1, 62, 62, 62, 62, 62, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, -1, -1, 62, 62, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 63, 63, -1, 63, -1, -1, -1, 64, 64, 64, -1, -1, -1, -1, -1, 64, 63, 63, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 65, 67, 68, -1, -1, -1, -1, -1, 66, -1, -1, -1 },
        { -1, 69, 69, 69, 69, 69, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 69, -1, -1, -1, -1, -1, 69, 69, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 70, 70, -1, 70, -1, -1, -1, 70, 70, 70, 71, 72, -1, -1, -1, 70, 70, 70, -1 },
        { -1, 73, 73, 73, 73, 73, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 73, -1, -1, -1, -1, -1, 73, 73, -1, -1, -1, -1, -1, -1, -1 },
        { -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 74, 74, -1, 74, -1, -1, -1, 74, 74, 74, 74, 74, 75, 76, 77, 74, 74, 74, -1 },
        { -1, 78, 79, 80, 81, 82, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 83, -1, -1, -1, -1, -1, 84, 85, -1, -1, -1, -1, -1, -1, -1 }
    };

    int[][] PRODUCTIONS =
    {
        { 15, 18, 33, 49, 34 },
        { 51 },
        { 51 },
        {  0 },
        { 52 },
        { 53 },
        { 54 },
        { 65, 50 },
        { 55, 50 },
        { 56, 50 },
        { 57 },
        { 58 },
        { 24, 61, 59, 29 },
        { 25, 61, 59, 29 },
        { 27, 63, 60 },
        { 30, 64 },
        {  0 },
        { 30, 64 },
        {  2, 62 },
        {  0 },
        { 28, 61 },
        { 17 },
        { 14 },
        {  9 },
        { 22 },
        {  7 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 23 },
        { 13 },
        { 66 },
        { 67 },
        { 68 },
        { 69 },
        { 71 },
        {  8, 29 },
        {  2, 30, 48, 29 },
        { 21, 32, 72, 61, 31, 29 },
        { 19, 32, 75, 31, 29 },
        { 20, 32, 75, 31, 29 },
        { 16, 32, 48, 31, 73, 70, 12, 29 },
        {  0 },
        { 11, 73 },
        { 10, 73, 26, 32, 48, 31, 12, 29 },
        {  6, 28 },
        {  0 },
        { 65, 74 },
        {  0 },
        { 73 },
        { 48, 76 },
        {  0 },
        { 28, 75 },
        { 78, 77 },
        {  0 },
        { 44, 78, 77 },
        { 45, 78, 77 },
        { 79 },
        { 23 },
        { 13 },
        { 46, 78 },
        { 82, 80 },
        {  0 },
        { 81, 82 },
        { 35 },
        { 43 },
        { 36 },
        { 37 },
        { 84, 83 },
        {  0 },
        { 38, 84, 83 },
        { 39, 84, 83 },
        { 86, 85 },
        {  0 },
        { 40, 86, 85 },
        { 41, 86, 85 },
        { 42, 86, 85 },
        {  2 },
        {  3 },
        {  4 },
        {  5 },
        {  6 },
        { 32, 48, 31 },
        { 38, 86 },
        { 39, 86 }
    };

    String[] PARSER_ERROR =
    {
        "",
        // "Era esperado fim de programa",
        "esperado EOF",
        // "Era esperado identificador",
        "esperado identificador",
        // "Era esperado cint",
        "esperado constante int",
        // "Era esperado cfloat",
        "esperado constante float",
        // "Era esperado cchar",
        "esperado constante char",
        // "Era esperado cstring",
        "esperado constante string",
        // "Era esperado boolean",
        "esperado boolean",
        // "Era esperado break",
        "esperado break",
        // "Era esperado char",
        "esperado char",
        // "Era esperado do",
        "esperado do",
        // "Era esperado else",
        "esperado else",
        // "Era esperado end",
        "esperado end",
        // "Era esperado false",
        "esperado false",
        // "Era esperado float",
        "esperado float",
        // "Era esperado fun",
        "esperado fun",
        // "Era esperado if",
        "esperado if",
        // "Era esperado int",
        "esperado int",
        // "Era esperado main",
        "esperado main",
        // "Era esperado print",
        "esperado print",
        // "Era esperado println",
        "esperado println",
        // "Era esperado readln",
        "esperado readln",
        // "Era esperado string",
        "esperado string",
        // "Era esperado true",
        "esperado true",
        // "Era esperado val",
        "esperado val",
        // "Era esperado var",
        "esperado var",
        // "Era esperado while",
        "esperado while",
        // "Era esperado \":\"",
        "esperado :",
        // "Era esperado \",\"",
        "esperado ,",
        // "Era esperado \";\"",
        "esperado ;",
        // "Era esperado \"=\"",
        "esperado =",
        // "Era esperado \")\"",
        "esperado )",
        // "Era esperado \"(\"",
        "esperado (",
        // "Era esperado \"{\"",
        "esperado {",
        // "Era esperado \"}\"",
        "esperado }",
        // "Era esperado \"==\"",
        "esperado ==",
        // "Era esperado \"<\"",
        "esperado <",
        // "Era esperado \">\"",
        "esperado >",
        // "Era esperado \"+\"",
        "esperado +",
        // "Era esperado \"-\"",
        "esperado -",
        // "Era esperado \"*\"",
        "esperado *",
        // "Era esperado \"/\"",
        "esperado /",
        // "Era esperado \"%\"",
        "esperado %",
        // "Era esperado \"!=\"",
        "esperado !=",
        // "Era esperado \"&&\"",
        "esperado &&",
        // "Era esperado \"||\"",
        "esperado ||",
        // "Era esperado \"!\"",
        "esperado !",
        //"<programa> inválido",
        "esperado fun",

        //"<expressao> inválido",
        "esperado expressão",

        //"<lista_instrucoes> inválido",
        "esperado id break do if print println readln val var",

        //"<aux_lista_instrucoes> inválido",
        "esperado id break do if print println readln val var }",

        //"<aux_listas> inválido",
        "esperado id break do if print println readln val var",

        //"<aux_lista_comandos> inválido",
        "esperado id break do if print println readln",

        //"<aux_lista_constantes> inválido",
        "esperado val",

        //"<aux_lista_variaveis> inválido",
        "esperado var",

        //"<aux_constantes> inválido",
        "esperado val",

        //"<aux_variaveis> inválido",
        "esperado var",

        //"<declaracao_constantes> inválido",
        "esperado val",

        //"<declaracao_variaveis> inválido",
        "esperado var",

        //"<aux_declaracao> inválido",
        "esperado : =",

        //"<aux_declaracao_> inválido",
        "esperado ; =",

        //"<lista_identificadores> inválido",
        "esperado id",

       //"<lista_identificadores_> inválido",
        " esperado : , ) =",

        //"<tipo> inválido",
        "esperado boolean char float int string",

        //"<valor> inválido",
        "esperado constante int constante float constante char constante string false true",

        //"<comando> inválido",
        "esperado id break do if print println readln",

        //"<cmd_atribuicao> inválido",
        "esperado id",

        //"<cmd_entrada> inválido",
        "esperado readln",

        //"<cmd_saida> inválido",
        "esperado print println",

        //"<cmd_selecao> inválido",
        "esperado if",

        //"<cmd_selecao_> inválido",
        "esperado else end",

        //"<cmd_repeticao> inválido",
        "esperado do",

        // "<op_cstring> inválido",
        "esperado id constante string",

        //"<lista_comandos> inválido",
        "esperado id break do if print println readln",

        //"<lista_comandos_> inválido",
        "esperado id break do else end if print println readln while",

        //"<lista_expressoes> inválido",
        "esperado expressão",

        //"<lista_expressoes_> inválido",
        //"esperado \",\", \")\"", -> Duvida
        "esperado expressão",

        //"<expressao_> inválido",
        "esperado expressão",

        //"<elemento> inválido",
        "esperado expressão",

        //"<relacional> inválido",
        "esperado expressão",

        //"<relacional_> inválido",
        "esperado expressão",

        //"<operador_relacional> inválido",
        "esperado == < > !=",

        //"<aritmetica> inválido",
        "esperado expressão",

        //"<aritmetica_> inválido",
        "esperado expressão",

        //"<termo> inválido",
        "esperado expressão",

        //"<termo_> inválido",
        "esperado expressão",

        //"<fator> inválido"
        "esperado expressão"
    };
}
