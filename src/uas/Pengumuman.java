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
public class Pengumuman {
    private String judulPengumuman,
                   isiPengumuman;

    Pengumuman(String judulPengumuman, String isiPengumuman) {
        this.judulPengumuman = judulPengumuman;
        this.isiPengumuman = isiPengumuman;
    }
    
    public String getJudulPengumuman(){
        return judulPengumuman;
    }
    public String getIsiPengumuman(){
        return isiPengumuman;
    }
}
