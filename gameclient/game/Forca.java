/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import connection.Connection;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class Forca {
    String actualWord;
    int life = 6,qtdLetters=6;
    Connection con;
    Scanner sc;
    
    public Forca (Connection con){
        this.con = con;
        this.sc = new Scanner(System.in);
    }
    
    public void showForca(int life) {
        if (life == 6){
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println(" ");
        }
        if (life == 5) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|");
            System.out.println("|");
            System.out.println("|");
            System.out.println(" ");
        }
        if (life == 4) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|         |");
            System.out.println("|");
            System.out.println("|");
            System.out.println(" ");

        }
        if (life == 3) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|      ---|");
            System.out.println("|          ");
            System.out.println("|");
            System.out.println(" ");
        }
        if (life == 2) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|      ---|---");
            System.out.println("|          ");
            System.out.println("|");
            System.out.println(" ");
        }
        if (life == 1) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|      ---|---");
            System.out.println("|        / ");
            System.out.println("|       / ");
            System.out.println(" ");
        }
        if (life == 0) {
            System.out.println("|----------");
            System.out.println("|         |");
            System.out.println("|         O");
            System.out.println("|      ---|---");
            System.out.println("|        / \\");
            System.out.println("|       /   \\");
            System.out.println(" ");
            System.out.println("VOCE PERDEU x-x");
        }
    }
    
    private void updateStatus() throws Exception
    {
        this.con.sendMessage("getQtdLetters()");
        this.qtdLetters = Integer.parseInt(con.reciveMessage());
        
        this.con.sendMessage("getLife()");
        this.life = Integer.parseInt(con.reciveMessage());
        
        this.con.sendMessage("getActualWord()");
        this.actualWord = con.reciveMessage();
        
    }
    
    public void showStatus() throws Exception {
        System.out.println("Faltam: "+qtdLetters+" Letras");
        System.out.println("Você tem "+this.life+" Vidas");
        System.out.println(this.actualWord);
    }
    
    public void startedStatus(){
        System.out.println("A palavra tem: " + this.qtdLetters + " letras");
        System.out.println("Você tem " + this.life + " chances");
    }
    
    private void endGame() throws Exception{
        if(this.life>0){
            System.out.println("Parabêns você venceu! ;) ");
        }
        con.sendMessage("exit");
        System.out.println(con.reciveMessage());
        con.closeConection();
        this.con.closeConection();
    }

    public void start() throws Exception {       
        
        String letter;
        con.sendMessage("startGame()");
        
        if(con.reciveMessage().equals("started")) {
            
            this.updateStatus();
            this.startedStatus();
            this.showForca(this.life);
            while (this.life > 0 && this.qtdLetters > 0) {
                
                System.out.print("Digite uma letra:");
                letter = sc.next();
                this.cleanScreen();
                
                while (letter.charAt(0) == ' ') {
                    System.out.print("Digite uma letra:");
                    letter = sc.next();
                }
                con.sendMessage(Character.toString(letter.charAt(0)).toUpperCase());
                this.updateStatus();
                this.showForca(this.life);
                this.showStatus();
            }
        }
        this.endGame();
    }
    
    public void cleanScreen() {
        for (int i = 0; i < 100; ++i) {
            System.out.println();
        }
    }

    public void start(Connection con) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
