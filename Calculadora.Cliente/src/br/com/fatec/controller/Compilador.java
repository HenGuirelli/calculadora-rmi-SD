package br.com.fatec.controller;

public class Compilador {
    private Compilador(){
        
    }
    
    public static double[] compilar(String expressao){
        // Sinal matematico da expressao
        char sinal = getSinal(expressao);
        
        return getNumeros(expressao, sinal);        
    }
    
    private static double[] getNumeros(String expressao, char sinal){
        String[] strNumeros = expressao.split("\\*");
        double[] numeros = new double[strNumeros.length];
        
        for (int i = 0; i < strNumeros.length; i ++)
            numeros[i] = Double.parseDouble(strNumeros[i]);
        return numeros;
    }
    
    private static char getSinal(String expressao){
        for (char item : expressao.toCharArray()){
            // Caso especial para o menos 
            // (o menos nem sempre é o sinal que queremos, ele pode ser um numero negativo)
            if (item != '-'){
                if (!isNumeric(item))
                    return item;
            }
        }
        
        return '-';
    }
    
    private static boolean isNumeric(char caractere){
        return caractere >= 48 && caractere <= 57;
    }
}
