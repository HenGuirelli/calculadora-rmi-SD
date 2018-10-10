package br.com.fatec.model;

import java.util.ArrayList;
import br.com.fatec.enuns.Operador;
import br.com.fatec.enuns.Type;

public class Expressao {
    
    private static Expressao instancia;
    
    private ArrayList<Parte> expr;
    
    // está na parte decimal
    private boolean inDecimalPart;
    private int concatDecimal;
    
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
                Numerico numerico = (Numerico) getLast();
                if (!inDecimalPart)
                    novoNum = (Double.parseDouble(numerico.getValue()) * 10) + num;
                else{
                    // ciclo de 'concatenação' da parte decimal
                    int sinal = numerico.getNum() < 0 ? -1 : 1;
                    novoNum = (numerico.getNum()) + ((num / concatDecimal) * sinal);
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
        setInDecimalPart(false);
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
                String valor = ultimo.getValue();
                //verifica se termina com .0
                if (valor.split("\\.")[1].equals("0")){
                    setInDecimalPart(false);
                    System.out.println("decimal");
                    valor = ((int) (ultimo.getNum()) / 10) + "";
                }else{
                    System.out.println("else");
                    // remove o ultimo caractere
                    valor = valor.substring(0, valor.length() - 1);
                }
                ultimo.setNum(Double.parseDouble(valor));
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
    
    public void toggleSinal(){
        if (getLast().getType() == Type.numerico){
            Numerico ultimo = (Numerico) getLast();
            double valor = ultimo.getNum();
            ultimo.setNum(-valor);
        }
    }
}
