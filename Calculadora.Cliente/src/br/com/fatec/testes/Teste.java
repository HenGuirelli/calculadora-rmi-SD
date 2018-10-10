package br.com.fatec.testes;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;

public class Teste {
    
    public static void main(String[] args){
        //testar();
        Expressao a = Expressao.getInstance();
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
        a.toggleSinal();
        a.addNum("1");        
        a.toggleSinal();
        a.addNum("1");
        a.addSymbol(Operador.ADD);
        a.setInDecimalPart(false);
        a.addNum("5");
        a.toggleSinal();
        a.toggleSinal();
        a.addSymbol(Operador.DIV);
        System.out.println(a.getExpr());
        
        System.out.println("----------------------------------");
        a.deleteAll();
        a.addNum("1");
        a.addNum("2");
        a.addNum("3");
        a.setInDecimalPart(true);
        a.addNum("5");
        a.addNum("5");
        a.addNum("7");
        System.out.println(a.getExpr());
        a.delete();
        System.out.println(a.getExpr());
        a.delete();
        System.out.println(a.getExpr());
        a.delete();
        System.out.println(a.getExpr());
        a.delete();
        System.out.println(a.getExpr());

    }
}
