package br.com.fatec.model;

import br.com.fatec.enuns.Type;

public class Numerico extends Parte{
    private double num;
    
    public Numerico(){
        this.setType(Type.numerico);
    }
    
    public double getNum() {
        return num;
    }

    public void setNum(double num) {
        this.num = num;
    }

    @Override
    public String getValue() {
        return Double.toString(num);
    }
    
}
