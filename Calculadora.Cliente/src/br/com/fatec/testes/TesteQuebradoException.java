package br.com.fatec.testes;

public class TesteQuebradoException extends RuntimeException{
    public TesteQuebradoException(){
        super();
    }
    
    public TesteQuebradoException(String msg){
        super(msg);
    }
}
