package br.com.fatec.testes;

import br.com.fatec.controller.*;
import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Teste {
    public static void testar(){
        try {
            MensageiroClient m = new MensageiroClient();
            m.conectar();
            
            String[] expressoes = new String[] 
            {
                "1*3*4", 
                "5+2+4", 
                "1-3-4", 
                "69/3/.5/2", 
                ".1*3*4", 
                "-1*-3*-4"
            };
            
            for (String expressao : expressoes){
                char sinal = Compilador.getSinal(expressao);
                double[] numeros = Compilador.getNumeros(expressao);
                System.out.println("---------------------------------------------");
            
                System.out.println("sinal: " + sinal);
                System.out.println("numeros:");
                for (double num  : numeros)
                    System.out.print(num + "  ");
                System.out.println("");
                System.out.println("resultado: ");

                System.out.println(m.calcular(expressao));
            }
        } catch (RemoteException ex) {
            Logger.getLogger(MensageiroClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public static void main(String[] args){
        //testar();
        Expressao a = new Expressao();
        a.addNum("1");
        a.addNum("2");
        a.addNum("3");
        a.addSymbol(Operador.SUB);
        a.addSymbol(Operador.SUB);
        a.addSymbol(Operador.ADD);
        a.addSymbol(Operador.DIV);
        a.addNum("5");
        System.out.println(a.getExpr());
    }
}
