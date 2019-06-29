/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameclient;

import connection.Connection;
import connection.FactoryConnection;
import connection.SocketConnection;
import game.Forca;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class GameClient {

    /**
     * @param args the command line arguments
     */
    static String recivedMessage;
    static Connection con;
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        try {
            String typeCon;
            do{
                System.out.print("Digite o tipo de Conexão(\'RMI\'|\'socket\'): ");
                typeCon = input.nextLine();
            }while(!(typeCon.equals("socket") || typeCon.equals("RMI")));
            con = FactoryConnection.getInstace(typeCon);
            
        }catch (Exception ex) {
            System.err.println(ex.getMessage());
            System.out.println("Erro ao tentar conexão com servidor!");
        }
        
        try {
            Forca game = new Forca(con);
            game.start();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
    
    
}
