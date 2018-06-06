package trabalho3.backend;

public interface ScannerConstants
{

    int[] TOKEN_STATE = {-2,  0, -2, -2, -2, -2, -2, -2, -2, -2, -2, -2,  8, -2,  8,  8,  8,  8,  8,  8,  6,  6,  8, -2, -2,  2, -2,  8,  8,  8,  8,  8,  8,  8, -2,  5, -2, -2,  3,  8, -2, -2, -2, -2, -2,  8,  8,  8, -2, -2, -2, -2, -2,  8,  8,  8,  8,  8, -2, -2, -2, -2, -2, -2, -2,  8,  8,  8,  8,  8,  8,  8,  8,  8, -2, -2, -2, -2, -2, -2, -2, -2,  4, -2,  8,  7,  7,  8 };

    int[] SPECIAL_CASES_INDEXES =
        { 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 4, 4, 4, 4 };

    String[] SPECIAL_CASES_KEYS =
        {  "Bicombustível", "Diesel", "Gasolina", "Álcool" };

    int[] SPECIAL_CASES_VALUES =
        {  9, 12, 11, 10 };

    String[] SCANNER_ERROR =
    {
        "sequência de símbolos não identificada",
        "",
        "sequência de símbolos não identificada",
        " sequência de símbolos não identificada", //Erro identificando motor ou ano ou km ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando motor ou ano ou km ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando motor ou ano ou km ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando motor ou ano ou km ou chassi ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando chassi ou placa ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando valor ou chassi ou placa ou modelomarcacombustivel",
        " sequência de símbolos não identificada",//Erro identificando modelomarcacombustivel",
        "KM inválido",
        " sequência de símbolos não identificada",//Erro identificando modelomarcacombustivel",
        "",
        "motor ou KM inválido",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "valor inválido",
        " KM inválido",
        "",
        "KM inválido",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "valor inválido",
        "",
        "KM inválido",
        "KM inválido",
        "",
        "",
        " sequência de símbolos não identificada",//Erro identificando placa ou modelomarcacombustivel",
        " placa inválida",
        "valor inválido",
        "valor inválido",
        "KM inválido",
        "",
        "",
        "",
        "placa inválida",
        "placa inválida",
        "valor inválido",
        "valor inválido",
        "valor inválido",
        "",
        "",
        "",
        "",
        "",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "valor inválido",
        "valor inválido",
        "valor inválido",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "placa inválida",
        "",
        " valor inválido",
        "",
        "",
        "",
        ""
    };

}
