package br.com.fatec.model;

import br.com.fatec.enuns.Sinal;
import br.com.fatec.enuns.Type;
import java.util.Stack;

public class Numerico extends Parte{
    private Stack<Character> num;
    private Sinal sinal;
    public static char decimalSeparator;
    
    public Numerico(){
        num = new Stack<>();
        setType(Type.numerico);
        decimalSeparator = '.';
        sinal = Sinal.POSITIVE;
    }
    
    public void addNum(Character num){
        if (isNumeric(num))
            this.num.add(num);
        else{
            if (num == decimalSeparator){
                boolean achouPonto = false;
                for (char item : this.num){
                    if (item == decimalSeparator)
                        achouPonto = true;
                }
                if (!achouPonto)
                    this.num.add(num);
            }
        }
    }
    
    public void removeLast(){
        num.pop();
    }
    
    public Sinal toggleSinal(){
        if (this.sinal == Sinal.POSITIVE)
            sinal = Sinal.NEGATIVE;
        else
            sinal = Sinal.POSITIVE;
        return sinal;
    }
    
    private String convertToString(){
        String resp = "";
        for (Character item : num){
            resp += item;
        }
        return resp;
    }
    
    @Override
    public String getValue() {
        return sinal == Sinal.NEGATIVE ? "-" + convertToString() : convertToString();
    }
    
    private static boolean isNumeric(char str){
        return str >= 48 && str <= 57;
    }
}
