package br.com.fatec.testes;

import br.com.fatec.controller.Compilador;

public class Teste {
    private static boolean isIgual(double[] vet1, double[] vet2){
        assert(vet1.length == vet2.length);
        for (int i = 0; i < vet1.length; i++)
            assert(vet1[i] == vet2[i]);
        return true;
    }
    public static void testarCompilador(){
        assert(isIgual(Compilador.compilar("1*3*4"), new double []{1, 3, 4})): "Teste quberado";
        assert(isIgual(Compilador.compilar("5+2+4"), new double []{1, 3, 4})): "Teste quberado";
        assert(isIgual(Compilador.compilar("1-3-4"), new double []{1, 3, 4})): "Teste quberado";
        assert(isIgual(Compilador.compilar("1/3/4/.5"), new double []{1, 3, 4})): "Teste quberado";
        assert(isIgual(Compilador.compilar(".1*3*4"), new double []{1, 3, 4})): "Teste quberado";
        assert(isIgual(Compilador.compilar("-1*-3*4"), new double []{1, 3, 4})): "Teste quberado";
    }
    public static void main(String[] args){
        testarCompilador();
    }
}
