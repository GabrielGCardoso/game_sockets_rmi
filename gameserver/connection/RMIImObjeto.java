package connection;




import game.ForcaRMI;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author almir
 */
public class RMIImObjeto extends UnicastRemoteObject implements RIMensagem{
    static ForcaRMI forcaRmi = new ForcaRMI();
    public RMIImObjeto() throws RemoteException{
        super();
    }
    public String mensagem(String m) throws RemoteException{
        try {
            //        System.out.println("Mensagem Cliente: "+ m);
            return this.forcaRmi.game(m);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return " ";
    }
}
