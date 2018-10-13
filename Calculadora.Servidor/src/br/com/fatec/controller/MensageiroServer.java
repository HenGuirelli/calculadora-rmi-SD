package br.com.fatec.controller;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class MensageiroServer {
    
    public static void main(String[] args){
        System.out.print("Servidor ativo...\n");
        new MensageiroServer();
    }
    
    public MensageiroServer(){
        try {
            Mensageiro m = new MensageiroImpl();        
            LocateRegistry.createRegistry(8080);
            Naming.rebind("rmi://localhost:8080/MensageiroService", m);
        }catch( Exception e ) { 
            System.out.println(" Erro: " + e );
        }
    }
}


