package br.com.fatec.model;

import java.util.ArrayList;
import br.com.fatec.enuns.Operador;
import br.com.fatec.enuns.Type;

public class Expressao {
    
    private static Expressao instancia;
    
    private ArrayList<Parte> expr;
    
    // está na parte decimal
    private boolean inDecimalPart;
    
    private Expressao(){
        expr = new ArrayList<>();
        inDecimalPart = false;
    }
    
    public static Expressao getInstance(){
        if (instancia == null){
            instancia = new Expressao();
            return instancia;
        }else {
            return instancia;
        }
    }
    
    public boolean getInDecimalPart(){
        return inDecimalPart;
    }
    
    public void setInDecimalPart(boolean inDecimalPart){
        this.inDecimalPart = inDecimalPart;
    }
    
    private Parte getLast(){
        return expr.get(expr.size() - 1);
    }
    
    private void addParte(Parte parte){
        expr.add(parte);
    }
    
    public String getExpr(){
        String resp = "";
        for(Parte parte : expr){
            resp += parte.getValue() + " ";
        }
        return resp;
    }
    
    public void addNum(long num){
        double novoNum = 0;
        
        // caso vetor vazio
        if (expr.size() == 0){
            if (!inDecimalPart){
                Numerico numerico = new Numerico();
                numerico.setMilhar(num);
                expr.add(numerico);
                
            }else {
                Numerico numerico = new Numerico();
                numerico.setDecimal(num);
                expr.add(numerico);
            }            
        }else{
            // com numero no visor
            if (getLast().getType() == Type.operador){
                Numerico numerico = new Numerico();
                numerico.setType(Type.numerico);
                numerico.setMilhar(num);
                expr.add(numerico);
            }
            else if (getLast().getType() == Type.numerico){
                Numerico numerico = (Numerico) getLast();
                if (!inDecimalPart)
                    // fluxo de 'concatenação' da parte milhar
                    numerico.setMilhar(numerico.getMilhar() * 10 + num);
                else{
                    // fluxo de 'concatenação' da parte decimal
                    numerico.setDecimal(numerico.getDecimal() * 10 + num);      
                }          
            }
        }
        System.out.println("adiconou " + num);
    }
    
    public void addNum(String num){
        addNum(Long.parseLong(num));
    }
    
    public void deleteAll(){
        expr.clear();
        setInDecimalPart(false);
    }
    
    public void delete(){
        if (getLast().getType() == Type.operador)
            expr.remove(getLast());
        else{
            //remove o ultimo numero
            Numerico numero = (Numerico) getLast();
            if (numero.getDecimal() != 0){
                double novoDecimal = numero.getDecimal();
                numero.setDecimal((int)novoDecimal / 10);
            }else{
                double novoMilhar = numero.getMilhar();
                numero.setMilhar((int)novoMilhar / 10);
            }
        }            
    }
    
    public void addSymbol(Operador symbol){
        if (getLast().getType() == Type.operador)
            return;
        
        br.com.fatec.model.Operador operador = new br.com.fatec.model.Operador();
        operador.setOperador(symbol);
        expr.add(operador);
    }
    
    public void toggleSinal(){
        if (getLast().getType() == Type.numerico){
            Numerico ultimo = (Numerico) getLast();
            ultimo.toggleSinal();
        }
    }
}
