package br.com.fatec.testes;

import br.com.fatec.controller.Compilador;

public class Teste {
    private static boolean isIgual(double[] vet1, double[] vet2){
        testar(vet1.length == vet2.length);
        for (int i = 0; i < vet1.length; i++)
            if(vet1[i] != vet2[i]){
                throw new TesteQuebradoException("recebido: " + vet1[i] + " esperado: " + vet2[i]);
            }
        return true;
    }
    
    private static void testar(boolean assertion){
        if (!assertion)
            throw new TesteQuebradoException();
    }
    
    public static void testarCompilador(){
        testar(isIgual(Compilador.getNumeros("1*3*4"), new double []{1, 3, 4}));
        testar(isIgual(Compilador.getNumeros("5+2+4"), new double []{5, 2, 4}));
        testar(isIgual(Compilador.getNumeros("1-3-4"), new double []{1, 3, 4}));
        testar(isIgual(Compilador.getNumeros("1/3/4/.5"), new double []{1, 3, 4, .5}));
        testar(isIgual(Compilador.getNumeros(".1*3*4"), new double []{.1, 3, 4}));
        testar(isIgual(Compilador.getNumeros("-1*-3*4"), new double []{-1, -3, 4}));
    }
    
    public static void testarSinal(){
        testar(Compilador.getSinal("1*3*4")== '*');
        testar(Compilador.getSinal("5+2+4") == '+');
        testar(Compilador.getSinal("1-3-4") == '-');
        testar(Compilador.getSinal("1/3/4/.5") == '/');
        testar(Compilador.getSinal(".1*3*4") == '*');
        testar(Compilador.getSinal("-1*-3*-4") == '*');
    }
    
    public static void main(String[] args){
        testarCompilador();
        testarSinal();
    }
}
