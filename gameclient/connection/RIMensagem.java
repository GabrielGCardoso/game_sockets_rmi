package connection;



import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almir
 */
public interface RIMensagem extends Remote{
    public String mensagem(String m) throws RemoteException;
}
