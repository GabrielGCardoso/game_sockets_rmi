/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import connection.Connection;
import connection.SocketConnection;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author gabriel
 */
public class Forca {
    Connection c;
    int wordLenght,life;
    String wordToBeGuessed;
    char sortedWordChar[], actualWordChar[];
    String[] wordsDB = {"Cadeira", "Mesa", "Banana","Inaudivel"};
    Random rand;
    
    
    public Forca(Connection c){
        this.c =c;
        this.rand = new Random();
    }
    
    public String sortWord(){
        return wordsDB[rand.nextInt(wordsDB.length)];
    }
    
    public String getActualWord(){
        return Arrays.toString(this.actualWordChar);
    }
    
    public void startGame() throws Exception{
        this.life = 6;
        this.wordToBeGuessed = this.sortWord();
        this.wordLenght = this.wordToBeGuessed.length();
        //LOG
        System.out.println(this.wordToBeGuessed);
        
        this.sortedWordChar = this.wordToBeGuessed.toCharArray();
        this.actualWordChar = this.wordToBeGuessed.toCharArray();
        for(int i=0; i<this.wordToBeGuessed.length();i++){
            this.actualWordChar[i] = '_';
        }
        this.c.sendMessage("started");
        //LOG
        System.out.println("enviou started");
    }
    
    public void game() throws Exception{
        try {
            
            String message = " ";
            
            boolean is_correct = false;
             
            while(true){
                is_correct = false;
                message = c.reciveMessage();
                //LOG
                System.out.println("recebeu: " + message);
                if (message.equals("exit")) {
                    c.sendMessage("Conexão Encerrada");
                    break;
                } else if (message.equals("startGame()")) {
                    this.startGame();
                } else if (message.equals("getQtdLetters()")) {
                    c.sendMessage(Integer.toString(this.wordLenght));
                } else if (message.equals("getLife()")) {
                    c.sendMessage(Integer.toString(this.life));
                } else if (message.equals("getActualWord()")) {
                    c.sendMessage(getActualWord());
                } else {
                    for (int k = 0; k < wordToBeGuessed.length(); k++) {
                        if ( Character.toUpperCase(message.charAt(0))== Character.toUpperCase(sortedWordChar[k]) ) {
                            is_correct = true;
                            this.actualWordChar[k]=this.sortedWordChar[k];
                            this.sortedWordChar[k] = ' ';
                            this.wordLenght--;
                        }
                    }
                    if(!is_correct){
                        this.life--;                        
                    }
                }
            }
        }
        catch (IOException ioe){
            System.err.println(ioe.getMessage());
        }
        finally {
            try {
                c.closeConection();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            } 
           
        }
    }
    
}
