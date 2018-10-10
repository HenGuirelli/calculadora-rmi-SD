package br.com.fatec.model;

import br.com.fatec.enuns.Type;


public class Operador extends Parte{
    private br.com.fatec.enuns.Operador operador;

    public Operador(){
        this.setType(Type.operador);
    }
    
    public br.com.fatec.enuns.Operador getOperador() {
        return operador;
    }

    public void setOperador(br.com.fatec.enuns.Operador operador) {
        this.operador = operador;
    }

    @Override
    public String getValue() {
        if (null != operador)
            switch (operador) {
            case ADD:
                return "+";
            case SUB:
                return "-";
            case MULT:
                return "*";
            case DIV:
                return "/";
            default:
                break;
        }
        return null;
    }
}
