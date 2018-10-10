package br.com.fatec.controller;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MensageiroImpl extends UnicastRemoteObject implements Mensageiro {
    public MensageiroImpl() throws RemoteException {
        super();
    }

    @Override
    public double somar(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp += valor;
        return resp;
    }

    @Override
    public double subitrair(double[] valores) throws RemoteException {
        double resp = 0;
        for(double valor : valores)
            resp -= valor;
        return resp;
    }

    @Override
    public double multiplicar(double[] valores) throws RemoteException {
        double resp = 1;
        for(double valor : valores)
            resp *= valor;
        return resp;
    }

    @Override
    public double dividir(double[] valores) throws RemoteException {
        double resp = 1;
        
        for(int i = 0; i < valores.length; i++)
            if (i == 0)
                resp = valores[i];
            else
                resp /= valores[i];
        return resp;
    }
	

}
