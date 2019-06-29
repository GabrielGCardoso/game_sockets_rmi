package connection;




import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almir
 */
public class RMIImObjeto extends UnicastRemoteObject implements RIMensagem{
    
    public RMIImObjeto() throws RemoteException{
        super();
    }
    public String mensagem(String m) throws RemoteException{
//        System.out.println("Mensagem Cliente: "+ m);
        return m;
    }
}
