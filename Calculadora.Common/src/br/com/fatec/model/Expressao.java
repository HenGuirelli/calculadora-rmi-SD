package br.com.fatec.model;

import java.util.ArrayList;
import br.com.fatec.enuns.Operador;
import br.com.fatec.enuns.Type;

public class Expressao implements java.io.Serializable, java.lang.Cloneable {
    
    private static Expressao instancia;
    
    private ArrayList<Parte> expr;    
    
    private Expressao(){
        expr = new ArrayList<>();
    }
    
    public ArrayList<Parte> getModel(){
        return expr;
    }
    
    public static Expressao getInstance(){
        if (instancia == null){
            instancia = new Expressao();
            return instancia;
        }else {
            return instancia;
        }
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
    
    public void addNum(char num){
        double novoNum = 0;
        
        // caso vetor vazio
        if (expr.size() == 0){
            Numerico numerico = new Numerico();
            numerico.addNum(num);
            expr.add(numerico);           
        }else{
            // com numero no visor
            if (getLast().getType() == Type.operador){
                Numerico numerico = new Numerico();
                numerico.setType(Type.numerico);
                numerico.addNum(num);
                expr.add(numerico);
            }
            else if (getLast().getType() == Type.numerico){
                Numerico numerico = (Numerico) getLast();
                numerico.addNum(num);
            }
        }
    }
    
    public void addNum(String nums){
        for (char num : nums.toCharArray()){
            addNum(num);
        }
    }    
    
    public void deleteAll(){
        expr.clear();
    }
    
    public void delete(){
        if (expr.isEmpty())
            return;
        
        if (getLast().getType() == Type.operador){
            expr.remove(getLast());
        }else{
            //remove o ultimo numero
            Numerico numero = (Numerico) getLast();
            try{
                numero.removeLast();
            }catch (java.util.EmptyStackException e){
                // já apagou tudo
                expr.remove(getLast());
                delete();
            }
        }
    }
    
    public br.com.fatec.model.Operador getOperador(){
        for (Parte parte : expr){
            if (parte.getType() == Type.operador){
                return ((br.com.fatec.model.Operador) parte);
            }
        }
        return null;
    }
    
    private boolean acceptSymbol(Operador symbol){
        boolean aceitavel = true;
        for (Parte parte : expr){
            if (parte.getType() == Type.operador){
                if (((br.com.fatec.model.Operador) parte).getOperador() != symbol)
                    aceitavel = false;
            }
        }
        return aceitavel;
    }
    
    public void addSymbol(Operador symbol){
        if (getLast().getType() == Type.operador)
            return;
        
        if (!acceptSymbol(symbol))
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
    
    public Object clone()throws CloneNotSupportedException{  
        return super.clone();  
    }  
}
