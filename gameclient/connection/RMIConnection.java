/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author gabriel
 */
public class RMIConnection implements Connection{
    
    RIMensagem objremoto;
    Registry registro;
    String msg = " ";
    
    public RMIConnection() throws RemoteException{
        this.registro = LocateRegistry.getRegistry(1099);
    }

    @Override
    public void sendMessage(String msg) throws Exception {
//        registro.rebind("MensagemRMI", new RMIImObjeto());
        try {
            objremoto = (RIMensagem) registro.lookup("MensagemRMI");
            this.msg = objremoto.mensagem(msg);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public String reciveMessage() throws Exception {
        return this.msg;
    }

    @Override
    public void closeConection() throws Exception {
        ;
    }

}


