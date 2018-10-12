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
        if (inDecimalPart){
            // clicou em um ponto sem nenhum numero
            if (getLast() == null || getLast().getType() == Type.operador){
                Numerico numerico = new Numerico();
                numerico.setInDecimalPart(true);
                expr.add(numerico);
            } 
            // clicou no ponto com numero
            else{
                Numerico numerico = (Numerico) getLast();
                // verifica se clicou no ponto já na parte decimal
                if (!numerico.isInDecimalPart()){
                    numerico.setInDecimalPart(inDecimalPart);
                }
            }
        }
        this.inDecimalPart = inDecimalPart;
    }
    
    private Parte getLast(){
        if (!expr.isEmpty())
            return expr.get(expr.size() - 1);
        return null;
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
                numerico.setDecimal(Long.toString(num));
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
                    numerico.setDecimal(numerico.getDecimal() + num);      
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
        if (getLast().getType() == Type.operador){
            expr.remove(getLast());
            // removeu operador então o anterior é um numerico
            setInDecimalPart(((Numerico)getLast()).isInDecimalPart());
        }else{
            //remove o ultimo numero
            Numerico numero = (Numerico) getLast();
            setInDecimalPart(numero.deleteLast());            
        }
    }
    
    public void addSymbol(Operador symbol){
        if (getLast().getType() == Type.operador)
            return;
        
        br.com.fatec.model.Operador operador = new br.com.fatec.model.Operador();
        operador.setOperador(symbol);
        expr.add(operador);
        setInDecimalPart(false);
    }
    
    public void toggleSinal(){
        if (getLast().getType() == Type.numerico){
            Numerico ultimo = (Numerico) getLast();
            ultimo.toggleSinal();
        }
    }
}
