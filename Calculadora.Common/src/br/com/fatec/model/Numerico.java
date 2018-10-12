package br.com.fatec.model;

import br.com.fatec.enuns.Sinal;
import br.com.fatec.enuns.Type;

public class Numerico extends Parte{
    private long decimal;
    private long milhar;
    private Sinal sinal;
    
    public Numerico(){
        this.setType(Type.numerico);
        sinal = Sinal.POSITIVE;
    }

    public long getDecimal() {
        return decimal;
    }

    public void setDecimal(long decimal) {
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
        return decimal != 0 ? milhar + "." + decimal : Long.toString(milhar);
    }    
}
