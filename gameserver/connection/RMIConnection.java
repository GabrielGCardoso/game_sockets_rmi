/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connection;

import game.Forca;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 * 
 * @author gabriel
 */
public class RMIConnection {
    
    RIMensagem objremoto;
    Registry registro;
    String msg = " ";
    Forca forca;
    public RMIConnection() throws RemoteException{
        this.registro = LocateRegistry.createRegistry(1099);
        registro.rebind("MensagemRMI", new RMIImObjeto());
    }

}


