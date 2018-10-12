package br.com.fatec.controller;

import br.com.fatec.enuns.Type;
import br.com.fatec.model.Expressao;
import br.com.fatec.model.Numerico;
import br.com.fatec.model.Parte;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {
    public MensageiroImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(Expressao expressao) throws RemoteException {
        double resp = 0;
        
         for (Parte item : expressao.getModel()){
             System.out.println(item.getType());
             System.out.println(item.getValue());
         
         }
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico){
                resp += Double.parseDouble(((Numerico) item).getValue());
                System.out.println("valor: " + item.getValue());
            }
        }
        return resp;
    }

    @Override
    public double subtrair(Expressao expressao) throws RemoteException {
        double resp = 0;
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico)
                resp -= Double.parseDouble(((Numerico) item).getValue());
        }
        return resp;
    }

    @Override
    public double multiplicar(Expressao expressao) throws RemoteException {
        double resp = 0;
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico)
                resp *= Double.parseDouble(((Numerico) item).getValue());
        }
        return resp;
    }

    @Override
    public double dividir(Expressao expressao) throws RemoteException {
        double resp = 0;
        for (Parte item : expressao.getModel()){
            if (item.getType() == Type.numerico)
                resp /= Double.parseDouble(((Numerico) item).getValue());
        }
        return resp;
    }

   
}
