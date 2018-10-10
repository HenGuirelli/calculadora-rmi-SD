package br.com.fatec.model;

import br.com.fatec.enuns.Type;

public abstract class Parte {
    private Type type;

    public abstract String getValue();
    
    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
