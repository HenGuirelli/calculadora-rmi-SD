package br.com.fatec.model;

import br.com.fatec.enuns.Sinal;
import br.com.fatec.enuns.Type;

public class Numerico extends Parte{
    private String decimal; // precisa ser string pra ter 0 a esquerda
    private long milhar;
    private Sinal sinal;
    
    private boolean inDecimalPart;

    public boolean isInDecimalPart() {
        return inDecimalPart;
    }

    public void setInDecimalPart(boolean inDecimalPart) {
        if (inDecimalPart)
            setDecimal(".");
        this.inDecimalPart = inDecimalPart;
    }
    
    public boolean deleteLast(){
        // está na parte decimal
        if (inDecimalPart){
            decimal = decimal.substring(0, decimal.length() - 1);
            if (decimal.length() == 0)
                inDecimalPart = false;
        }else{
            setMilhar(getMilhar() / 10);
        }
        return inDecimalPart;
    }
    
    public Numerico(){
        this.setType(Type.numerico);
        sinal = Sinal.POSITIVE;
    }

    public String getDecimal() {
        return decimal == null ? "" : decimal;
    }

    public void setDecimal(String decimal) {
        inDecimalPart = true;
        if (decimal.length() > 0 && decimal.charAt(0) != '.')
            decimal = "." + decimal;            
        this.decimal = decimal;        
    }

    public long getMilhar() {
        return milhar;
    }

    public void setMilhar(long milher) {
        this.milhar = milher;
    }
    
    public double getNum(){
        return Double.parseDouble(getValue());
    }
    
    public void toggleSinal(){
        if (sinal == Sinal.POSITIVE)
            sinal = Sinal.NEGATIVE;
        else
            sinal = Sinal.POSITIVE;
    }
    
    public Sinal getSinal() {
        return sinal;
    }

    public void setSinal(Sinal sinal) {
        this.sinal = sinal;
    }
    
    @Override
    public String getValue() {
        String resp = "";
        if (inDecimalPart)
            resp = milhar + decimal;
        else
            resp = Long.toString(milhar);
        
        return sinal == Sinal.NEGATIVE ? "-" + resp : resp;
    }    
}
