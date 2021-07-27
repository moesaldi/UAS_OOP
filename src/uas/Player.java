/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;
import uas.Level;
/**
 *
 * @author Optimoes
 */
class Player extends Akun implements Level{
    
    private int status, level;
    private String lencana = "";
    public Player(String username, String password, int Status, String lencana,int level) {
        super(username, password);
        this.status = Status;
        this.lencana = lencana;
        this.level = level;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int status){
        this.status = status;
        
    }
    
    public String getLencana(){
        return lencana;
    }
    
    public int getLevel(){
        return level;
    }
    
    public void setLencana(String lencana){
        this.lencana = lencana;
    }
    
    @Override
    public void tambahLevel(){
        level++;
    }
    
}
