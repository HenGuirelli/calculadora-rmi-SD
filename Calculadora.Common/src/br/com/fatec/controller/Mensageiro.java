package br.com.fatec.controller;

import br.com.fatec.model.Expressao;
import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Mensageiro extends Remote {
    public double somar(Expressao expressao)       throws RemoteException;
    public double subitrair(Expressao expressao)   throws RemoteException;
    public double multiplicar(Expressao expressao) throws RemoteException;
    public double dividir(Expressao expressao)     throws RemoteException;
}
