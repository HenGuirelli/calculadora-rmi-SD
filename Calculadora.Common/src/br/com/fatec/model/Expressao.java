package br.com.fatec.model;

import java.util.ArrayList;
import br.com.fatec.enuns.Operador;
import br.com.fatec.enuns.Type;

public class Expressao {
    
    private ArrayList<Parte> expr = new ArrayList<>();
    
    // está na parte decimal
    private boolean inDecimalPart = false;
    private int concatDecimal;
    
    public boolean getInDecimalPart(){
        return inDecimalPart;
    }
    
    public void setInDecimalPart(boolean inDecimalPart){
        concatDecimal = inDecimalPart ? 10 : 0;
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
    
    public void addNum(double num){
        double novoNum = 0;
        
        // caso vetor vazio
        if (expr.size() == 0){
            if (!inDecimalPart){
                Numerico numerico = new Numerico();
                numerico.setNum(num);
                expr.add(numerico);
                
            }else {
                Numerico numerico = new Numerico();
                numerico.setNum(num / 10);
                expr.add(numerico);
            }            
        }else{
            if (getLast().getType() == Type.operador){
                Numerico numerico = new Numerico();
                numerico.setType(Type.numerico);
                numerico.setNum(num);
                expr.add(numerico);
            }
            else if (getLast().getType() == Type.numerico){
                // TODO: POR REFERENCIA?
                Numerico numerico = (Numerico) getLast();
                if (!inDecimalPart)
                    novoNum = (Double.parseDouble(numerico.getValue()) * 10) + num;
                else{
                    // ciclo de 'concatenação' da parte decimal
                    novoNum = (Double.parseDouble(numerico.getValue())) + (num / concatDecimal);
                    concatDecimal *= 10;
                }
                numerico.setNum(novoNum);                
            }
        }
        System.out.println("adiconou " + num);
    }
    
    public void addNum(String num){
        addNum(Double.parseDouble(num));
    }
    
    public void deleteAll(){
        expr.clear();
    }
    
    public void delete(){
        if (getLast().getType() == Type.operador)
            expr.remove(getLast());
        else{
            //remove o ultimo numero
            if (getLast().getValue().length() == 1 || getLast().getValue().length() == 0){
                expr.remove(getLast());
            }else{
                Numerico ultimo = (Numerico) getLast();
                expr.remove(getLast());
                // remove o ultimo caractere
                String novoValor = ultimo.getValue().substring(0, ultimo.getValue().length() - 1);
                ultimo.setNum(Double.parseDouble(novoValor));
                expr.add(ultimo);
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
}
