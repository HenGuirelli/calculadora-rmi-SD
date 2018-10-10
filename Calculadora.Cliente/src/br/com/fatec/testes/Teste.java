package br.com.fatec.testes;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;

public class Teste {
    
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
        a.addSymbol(Operador.ADD);
        a.addNum("5");
        a.addSymbol(Operador.ADD);
        a.addNum("5");
        a.addSymbol(Operador.ADD);
        a.addNum("5");
        a.setInDecimalPart(true);
        a.addNum("2");
        a.addNum("1");
        a.addNum("1");
        a.addNum("1");
        a.addNum("1");
        a.addSymbol(Operador.ADD);
        a.setInDecimalPart(false);
        a.addNum("5");
        System.out.println(a.getExpr());
    }
}
