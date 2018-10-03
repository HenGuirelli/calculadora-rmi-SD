package br.com.fatec.controller;

public class Compilador {
    private Compilador(){
        
    }
    
    public static double[] getNumeros(String expressao){
        // Sinal matematico da expressao
        char sinal = getSinal(expressao);        
        return _getNumeros(expressao, sinal);        
    }
    private static void print(String [] a){
        System.out.println("numeros");
        for(String num : a)
            System.out.print(num + " ");
    }
    private static double[] _getNumeros(String expressao, char sinal){
        System.out.println(expressao.replace(sinal + "", "#"));
        String[] strNumeros = expressao.replace(sinal + "", "#").split("#");
        print(strNumeros);
        double[] numeros = new double[strNumeros.length];
        
        for (int i = 0; i < strNumeros.length; i ++)
            numeros[i] = Double.parseDouble(strNumeros[i]);
        return numeros;
    }
    
    public static char getSinal(String expressao){
        for (char item : expressao.toCharArray()){
            // Caso especial para o menos 
            // (o menos nem sempre é o sinal que queremos, ele pode ser um numero negativo)
            if (item != '-' && item != '.'){
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
