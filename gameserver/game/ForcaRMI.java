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
public class ForcaRMI {
    int wordLenght,life;
    String wordToBeGuessed;
    char sortedWordChar[], actualWordChar[];
    String[] wordsDB = {"Cadeira", "Mesa", "Banana","Inaudivel"};
    Random rand;
    
    
    public ForcaRMI(){
        this.rand = new Random();
    }
    
    public String sortWord(){
        return wordsDB[rand.nextInt(wordsDB.length)];
    }
    
    public String getActualWord(){
        return Arrays.toString(this.actualWordChar);
    }
    
    public String startGame() throws Exception{
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
        //LOG
        System.out.println("enviou started");
        return "started";
        
        
    }
    
    public String game(String jogada) throws Exception{
        try {
            
            String message = jogada;

            boolean is_correct = false;

            is_correct = false;
           
            //LOG
            System.out.println("recebeu: " + message);
            if (message.equals("exit")) {
                return ("Conexão Encerrada");
            } else if (message.equals("startGame()")) {
                return this.startGame();
            } else if (message.equals("getQtdLetters()")) {
                return (Integer.toString(this.wordLenght));
            } else if (message.equals("getLife()")) {
               return (Integer.toString(this.life));
            } else if (message.equals("getActualWord()")) {
                return (getActualWord());
            } else {
                for (int k = 0; k < wordToBeGuessed.length(); k++) {
                    if (Character.toUpperCase(message.charAt(0)) == Character.toUpperCase(sortedWordChar[k])) {
                        is_correct = true;
                        this.actualWordChar[k] = this.sortedWordChar[k];
                        this.sortedWordChar[k] = ' ';
                        this.wordLenght--;
                    }
                }
                if (!is_correct) {
                    this.life--;
                }

            }
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }
        
        return " ";
    }
    
}
