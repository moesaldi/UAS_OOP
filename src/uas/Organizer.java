/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;

/**
 *
 * @author Optimoes
 */
class Organizer extends Akun{
    
    private int status;
    public Organizer(String username, String password, int status) {
        super(username, password);
        this.status = status;
    }
    
    public int getStatus(){
        return status;
    }
    
    public void setStatus(int status){
        this.status = status;
        
    }
    
}
