package br.com.fatec.testes;

import br.com.fatec.enuns.Operador;
import br.com.fatec.model.Expressao;
import br.com.fatec.model.Numerico;

public class Teste {
    
    public static void main(String[] args){
        //testar();
        Expressao a = Expressao.getInstance();
        
        a.addNum('1');
        a.addNum('2');
        a.addNum('3');
        a.addNum('4');
        a.addSymbol(Operador.SUB);
        a.addNum('3');
        a.addNum('.');
        a.addNum('2');
        a.addNum('3');
        a.addNum('.');
        a.addNum('2');
        a.toggleSinal();
        
        System.out.println(a.getExpr());
    }
}
