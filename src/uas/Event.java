/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;
import uas.Pendaftar;
/**
 *
 * @author Optimoes
 */
public class Event implements Pendaftar{
    String namaEvent,
           jenisOlahraga,
           level,
           tanggalEvent,
           tempat,          
           biaya,
           status;
    int  minimumPeserta,
           maksimumPeserta,
            jumlahPendaftar;
    

    Event(String namaEvent, String jenisOlahraga, String level, String tanggalEvent, String tempat, int minimumPeserta, int maksimumPeserta, String biaya, int jumlahPendaftar, String status) {
        this.namaEvent = namaEvent;
        this.jenisOlahraga = jenisOlahraga;
        this.level = level;
        this.tanggalEvent = tanggalEvent;
        this.tempat = tempat;
        this.minimumPeserta = minimumPeserta;
        this.maksimumPeserta = maksimumPeserta;
        this.jumlahPendaftar = jumlahPendaftar;
        this.biaya = biaya;
        this.status = status;
    }
    
    public String getNama(){
        return namaEvent;
    }
    
    @Override
    public void tambahPendaftar() {
        jumlahPendaftar++;
    }

    public int getJumlahPendaftar() {
        return jumlahPendaftar;
    }
    
    
            
}
