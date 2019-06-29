/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connection;

import connection.SocketConnection;
import connection.RMIConnection;

/**
 *
 * @author gabriel
 */
public class FactoryConnection {    

    public static Connection getInstace(String type) throws Exception {
        if (type.equals("socket")) {
            return new SocketConnection();
        } else {
            return new RMIConnection();
        }
    }

}
