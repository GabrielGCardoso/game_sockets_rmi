/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

/**
 *
 * @author gabriel
 */
public interface Connection {
            
    public void sendMessage(String msg) throws Exception;
    
    public String reciveMessage() throws Exception;
    
    public void closeConection() throws Exception;
    
}
