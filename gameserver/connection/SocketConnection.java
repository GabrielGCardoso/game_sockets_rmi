/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import game.Forca;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class SocketConnection extends Thread implements Connection {

    DataInputStream in;
    DataOutputStream out;
    Socket aSocket = null;
    Forca forca;

    
   public void socketIni() throws Exception {
        this.in = new DataInputStream(aSocket.getInputStream());
        this.out = new DataOutputStream(aSocket.getOutputStream());
    }
    
    public void setSocket(Socket s) throws Exception{
        this.aSocket = s;
        this.socketIni();
        System.out.println("Servidor inicializado....");
        this.start();
    }

    @Override
    public void sendMessage(String msg) throws IOException {
        this.out.writeUTF(msg);
    }

    @Override
    public String reciveMessage() throws IOException {
        try{
            return this.in.readUTF();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            System.out.println("deu erro no recivemessage");
        }
        return null;
    }

    @Override
    public void closeConection() throws IOException {
        if (aSocket != null) {
            aSocket.close();
            System.out.println("fechou conexao!");  
        }
    }
    
    public void run(){
        try {
            this.forca = new Forca(this);
            this.forca.game();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
