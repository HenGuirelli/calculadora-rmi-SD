package br.com.fatec.testes;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;
import br.com.fatec.model.Numerico;

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
        
        System.out.println("----------------------------------");
        Numerico numero = new Numerico();
        numero.setMilhar(1);
        numero.setMilhar(numero.getMilhar() * 10 + 2);
        numero.setMilhar(numero.getMilhar() * 10 + 3);
        System.out.println(numero.getValue() + " == 123");
        numero.setDecimal(1);
        numero.setDecimal(numero.getDecimal() *10 + 2);
        System.out.println(numero.getValue() + " == 123.12");
        System.out.println("----------------------------------");
        
        a.deleteAll();
        a.addNum("1");
        a.addNum("2");
        a.addNum("3");
        System.out.println(a.getExpr());
        a.setInDecimalPart(true);
        a.addNum("1");
        System.out.println(a.getExpr());
        a.delete();
        System.out.println(a.getExpr());
        a.addNum("3");
        System.out.println(a.getExpr());
        
    }
}
