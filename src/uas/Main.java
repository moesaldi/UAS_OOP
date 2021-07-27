/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uas;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Optimoes
 */
public class Main {

    private static ArrayList<Event> arrayEvent;
    private static ArrayList<Organizer> arrayOrg;
    private static ArrayList<Pengumuman> arrayPengumuman;
    private static ArrayList<Player> arrayPlayer;
    

    public static void main(String[] args) {
        arrayEvent  = new ArrayList<>();
        arrayOrg  = new ArrayList<>();
        arrayPengumuman  = new ArrayList<>();
        arrayPlayer = new ArrayList<>();
        home();
    }
    
    private static void home(){
        Scanner input = new Scanner(System.in);
        
        int pilihLogin = 0;
        do{
                System.out.println("--------------Sportify--------------");
                System.out.println("\nSelamat datang di aplikasi Sportify");
                System.out.println("\nPENGUMUMAN");
                for(int i=0;i<arrayPengumuman.size();i++){
                    if(arrayPengumuman.size()>=0){
                        System.out.println((i+1)+". "+arrayPengumuman.get(i).getJudulPengumuman());
                        System.out.println(arrayPengumuman.get(i).getIsiPengumuman());
                    }
                }
                System.out.println("\nSilahkan memilih anda akan login sebagai apa : ");
                System.out.println("1. Admin");
                System.out.println("2. Player");
                System.out.println("3. Organizer");
                System.out.println("4. Exit");
                
                do{
                System.out.print("\nPilihan : ");
                try{
                    pilihLogin = input.nextInt();
                } catch(Exception e){
                    System.out.println("Input anda harus numeric");
                    pilihLogin = 0;
                }
                } while(pilihLogin<0 || pilihLogin>4);
                switch(pilihLogin){
                    case 1 -> {
                        menuAdmin();
                    }
                    case 2 -> {
                        menuPlayer();
                    }
                    case 3 -> {
                        menuOrganizer();
                    }
                }
            } while(pilihLogin<4);
    }

    private static void menuAdmin() {
        Scanner input = new Scanner(System.in);
        String username,password;
        
        System.out.println("\nLogin sebagai admin");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        
        if(username.equals("admin")  && password.equals("123")){
            mainMenuAdmin();
        } 
        
        else{
            System.out.print("Username & password salah");
        }
        
    }

    private static void menuPlayer() {
        Scanner input = new Scanner(System.in);
        int pilihMenu = 0;
        
        System.out.println("\nPLAYER");
        do{
                System.out.println("1. Daftar");
                System.out.println("2. Login");                
                System.out.println("3. Kembali");
                
                do{
                System.out.print("\nPilihan : ");
                    try{
                        pilihMenu = input.nextInt();
                    } catch(Exception e){
                        System.out.println("Input anda harus numeric");
                        pilihMenu = 0;
                    }
                } while(pilihMenu<1 || pilihMenu>3);
                switch(pilihMenu){
                    case 1 -> {
                         daftarPlayer();
                    }
                    case 2 -> {
                        loginPlayer();
                    }      
                    case 3 -> {
                        home();
                    }                          
                }
            } while(pilihMenu<4);
    }

    private static void menuOrganizer() {
        Scanner input = new Scanner(System.in);
        int pilihMenu = 0;
        
        System.out.println("\nORGANIZER");
        do{
                System.out.println("1. Daftar");
                System.out.println("2. Login");                
                System.out.println("3. Kembali");
                
                do{
                System.out.print("\nPilihan : ");
                try{
                    pilihMenu = input.nextInt();
                } catch(Exception e){
                    System.out.println("Input anda harus numeric");
                    pilihMenu = 0;
                }
                } while(pilihMenu<1 || pilihMenu>3);
                switch(pilihMenu){
                    case 1 -> {
                         daftarOrganizer();
                    }
                    case 2 -> {
                        loginOrganizer();
                    }      
                    case 3 -> {
                        home();
                    }                          
                }
            } while(pilihMenu<4);
        
    }

    private static void buatEvent() {
        Scanner input = new Scanner(System.in);
        
        String  namaEvent,
                jenisOlahraga,
                level,
                tanggalEvent,
                tempat,                
                biaya,
                status;
        
        int minimumPeserta,
            maksimumPeserta,
            jumlahPendaftar;
        
        System.out.println("Masukkan data Event Anda\n");
        System.out.println("Nama Event : ");
        namaEvent = input.nextLine();
             
        System.out.println("Jenis Olahraga : ");
        jenisOlahraga = input.nextLine();
        
        System.out.println("Level : ");
        level = input.nextLine();
        
        System.out.println("Tanggal Event : ");
        tanggalEvent = input.nextLine();
        
        System.out.println("Tempat : ");
        tempat = input.nextLine();
        
        System.out.println("Minimum Peserta : ");
        minimumPeserta = input.nextInt();
        
        System.out.println("Masimal Peserta : ");
        maksimumPeserta = input.nextInt();
        
        input.nextLine();
        
        System.out.println("Biaya Pendaftaran : ");
        biaya = input.nextLine();
        
        input.nextLine();
        
        status = "1";
        jumlahPendaftar = 0;
        
        arrayEvent.add(new Event(namaEvent,jenisOlahraga,level,tanggalEvent,tempat,minimumPeserta,maksimumPeserta,biaya,jumlahPendaftar,status));
        
        System.out.println("Data telah dimasukkan!");
        
        
        
    }


    

    private static void daftarOrganizer() {
        Scanner input = new Scanner(System.in);
        String username,password;
        int status = 0;
        
        System.out.println("Daftar Sebagai Organizer\n");
        
        System.out.print("Masukan Useername : ");
        username = input.nextLine();
        
        System.out.print("Masukan Password : ");
        password = input.nextLine();
        
        arrayOrg.add(new Organizer(username,password,status));
        System.out.print("Daftar akun berhasil! Tunggu approval dari admin\n");  
        
        menuOrganizer();
    }

    private static void loginOrganizer() {
        Scanner input  = new Scanner(System.in);
        String username,password;
        int pilihMenu = 0;
        
        System.out.println("Masukkan Username dan Password");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        
        for(int i=0;i<arrayOrg.size();i++){
            if(username.equals(arrayOrg.get(i).getUsername())  && password.equals(arrayOrg.get(i).getPassword()) && arrayOrg.get(i).getStatus() == 1){
                do{
                System.out.println("\nSelamat datang di Organizer!");
                    System.out.println("\nMAIN MENU ");
                    System.out.println("1. Buat Event Olahraga");
                    System.out.println("2. Logout");                

                    do{
                    System.out.print("\nPilihan : ");
                    try{
                    pilihMenu = input.nextInt();
                } catch(Exception e){
                    System.out.println("Input anda harus numeric");
                    pilihMenu = 0;
                }
                } while(pilihMenu<1 || pilihMenu>2);
                    switch(pilihMenu){
                        case 1 -> {
                             buatEvent();
                        }
                        case 2 -> {
                            home();
                        }                    
                    }
                } while(pilihMenu<3);

            }
            else{
                System.out.print("Username & password salah / Akun anda belum diapprove");
            }
        }
    }

    private static void mainMenuAdmin() {
        Scanner input = new Scanner(System.in);
        int pilihMenu = 0;
        
        System.out.println("\nADMIN");
        do{
                System.out.println("1. Buat Pengumuman");
                System.out.println("2. Approval akun baru player");                
                System.out.println("3. Approval akun baru organizer");
                System.out.println("4. Block akun baru Player");
                System.out.println("5. Block akun baru organizer");
                System.out.println("6. Logout");
                
                do{
                System.out.print("\nPilihan : ");
                try{
                    pilihMenu = input.nextInt();
                } catch(Exception e){
                    System.out.println("Input anda harus numeric");
                    pilihMenu = 0;
                }
                } while(pilihMenu<1 || pilihMenu>6);
                switch(pilihMenu){
                    case 1 -> {
                         buatPengumuman();
                    }
                    case 2 -> {
                        approvePlayer();
                    }      
                    case 3 -> {
                        approveOrganizer();
                    }  
                    case 4 -> {
                        blockPlayer();
                    }  
                    case 5 -> {
                        blockOrganizer();
                    }  
                    case 6 -> {
                        home();
                    } 
                }
            } while(pilihMenu<4);
    }

    private static void buatPengumuman() {
        Scanner input = new Scanner(System.in);
        String judulPengumuman,
               isiPengumuman;
        
        System.out.println("\nBUAT PENGUMUMAN");
        System.out.print("\nMasukkan judul Pengumuman : ");
        judulPengumuman = input.nextLine();
        
        System.out.print("Masukkan isi Pengumuman : ");
        isiPengumuman = input.nextLine();
        
        arrayPengumuman.add(new Pengumuman(judulPengumuman,isiPengumuman));
        
        System.out.println("\nPengumuman berhasil diinputkan!");
        
        mainMenuAdmin();
        
    }

    private static void approvePlayer() {
        Scanner input = new Scanner(System.in);
        String username;
        int status, indexPlayer = -1;
        
        System.out.println("\nAPPROVE AKUN PLAYER");
        System.out.println("\nDaftar akun yang belum diapprove");
        System.out.println("| NO | Username     | Status |");
        
        for(int i=0;i<arrayPlayer.size();i++){
            String display = "";
            if(arrayPlayer.get(i).getStatus() == 0){
                display = "Belum aktif";
            }
            else{
                display = "Aktif";
            }
            System.out.println((i+1)+arrayPlayer.get(i).getUsername()+display);
        }
        
        System.out.print("Masukkan username yang ingin diapprove : ");
        username = input.nextLine();
        
        for(int i=0;i<arrayPlayer.size();i++){
            if(arrayPlayer.get(i).getUsername().equals(username)){
                indexPlayer = i;
            }
        }        
        
        if(indexPlayer != -1){
            System.out.println("0 : Tidak diapprove");
            System.out.println("1 : Approved");
            System.out.print("Beri status approve pada akun [0 / 1] : ");
            status = input.nextInt();
                
            arrayPlayer.get(indexPlayer).setStatus(status);
            System.out.println("Berhasil!");
        }
        else{
            System.out.println("Username tidak ditemukan");
        }
    }

    private static void approveOrganizer() {
        Scanner input = new Scanner(System.in);
        int status,indexOrg = -1;
        String username;
        
        
        System.out.println("\nAPPROVE AKUN ORGANIZER\n");
        System.out.println("\nDaftar akun yang belum diapprove");
        System.out.println("| NO | Username     | Status |");
        
        for(int i=0;i<arrayOrg.size();i++){
            String display = "";
            if(arrayOrg.get(i).getStatus() == 0){
                display = "Belum aktif";
            }
            else{
                display = "Aktif";
            }
            System.out.println((i+1)+arrayOrg.get(i).getUsername()+display);
        }
        
        System.out.print("Masukkan username yang ingin diapprove : ");
        username = input.nextLine();
        
        for(int i=0;i<arrayOrg.size();i++){
            if(arrayOrg.get(i).getUsername().equals(username)){
                indexOrg = i;
            }
        }        
        
        if(indexOrg != -1){
            System.out.println("0 : Tidak diapprove");
            System.out.println("1 : Approved");
            System.out.print("Beri status approve pada akun [0 / 1] : ");
            status = input.nextInt();
                
            arrayOrg.get(indexOrg).setStatus(status);
            System.out.println("Berhasil!");
        }
        else{
            System.out.println("Username tidak ditemukan");
        }
        
    }

    private static void blockOrganizer() {
        Scanner input = new Scanner(System.in);
        int status,indexOrg = -1;
        String username;
        
        
        System.out.println("\nBLOKIR AKUN ORGANIZER\n");
        System.out.println("\nDaftar akun yang belum diapprove");
        System.out.println("| NO | Username     | Status |");
        
        for(int i=0;i<arrayOrg.size();i++){
            String display = "";
            if(arrayOrg.get(i).getStatus() == 0){
                display = "Belum aktif";
            }
            else{
                display = "Aktif";
            }
            System.out.println((i+1)+arrayOrg.get(i).getUsername()+display);
        }
        
        System.out.print("Masukkan username yang ingin diblokir : ");
        username = input.nextLine();
        
        for(int i=0;i<arrayOrg.size();i++){
            if(arrayOrg.get(i).getUsername().equals(username)){
                indexOrg = i;
            }
        }        
        
        if(indexOrg != -1){
            System.out.println("0 : Blokir");
            System.out.println("1 : Aktif");
            System.out.print("Beri status blokir pada akun [0 / 1] : ");
            status = input.nextInt();
                
            arrayOrg.get(indexOrg).setStatus(status);
            System.out.println("Berhasil!");
        }
        else{
            System.out.println("Username tidak ditemukan");
        }
    }

    private static void blockPlayer() {
        Scanner input = new Scanner(System.in);
        String username;
        int status, indexPlayer = -1;
        
        System.out.println("\nBLOKIR AKUN PLAYER");
        System.out.println("\nDaftar akun yang belum diapprove");
        System.out.println("| NO | Username     | Status |");
        
        for(int i=0;i<arrayPlayer.size();i++){
            String display = "";
            if(arrayPlayer.get(i).getStatus() == 0){
                display = "Belum aktif";
            }
            else{
                display = "Aktif";
            }
            System.out.println((i+1)+arrayPlayer.get(i).getUsername()+display);
        }
        
        System.out.print("Masukkan username yang ingin diblokir : ");
        username = input.nextLine();
        
        for(int i=0;i<arrayPlayer.size();i++){
            if(arrayPlayer.get(i).getUsername().equals(username)){
                indexPlayer = i;
            }
        }        
        
        if(indexPlayer != -1){
            System.out.println("0 : blokir");
            System.out.println("1 : Aktif");
            System.out.print("Beri status blokir pada akun [0 / 1] : ");
            status = input.nextInt();
                
            arrayPlayer.get(indexPlayer).setStatus(status);
            System.out.println("Berhasil!");
        }
        else{
            System.out.println("Username tidak ditemukan");
        }
    }

    private static void loginPlayer() {
        Scanner input  = new Scanner(System.in);
        String username,password;
        int pilihMenu = 0, indexPlayer = -1;
        
        System.out.println("Masukkan Username dan Password");
        System.out.print("Username : ");
        username = input.nextLine();
        System.out.print("Password : ");
        password = input.nextLine();
        
        for(int i=0;i<arrayPlayer.size();i++){
            if(username.equals(arrayPlayer.get(i).getUsername())  && password.equals(arrayPlayer.get(i).getPassword()) && arrayPlayer.get(i).getStatus() == 1){
                indexPlayer = i;
                do{
                System.out.println("\nSelamat datang Player!!");
                    System.out.println("\nMAIN MENU ");
                    System.out.println("1. Daftar Event");
                    System.out.println("2. Lihat lencana");
                    System.out.println("3. Beri lencana ke player lain");
                    System.out.println("4. Lihat Level");
                    System.out.println("5. Logout");                

                    System.out.print("\nPilihan : ");
                    pilihMenu = input.nextInt();

                    switch(pilihMenu){
                        case 1 -> {
                             daftarEvent(indexPlayer);
                        }
                        case 2 -> {
                            System.out.println("Username : "+arrayPlayer.get(indexPlayer).getUsername());
                            if(arrayPlayer.get(indexPlayer).getLencana().equals("")){
                                System.out.println("Anda masih belum punya lencana");
                            }
                            else{
                                System.out.println("Lencana anda :"+arrayPlayer.get(indexPlayer).getLencana());
                            }
                        }
                        case 3 -> {
                            beriLencana();
                        }
                        case 4 -> {
                            System.out.println("Username : "+arrayPlayer.get(indexPlayer).getUsername());
                            System.out.println("Level anda : "+arrayPlayer.get(indexPlayer).getLevel());
                            
                        }
                    }
                } while(pilihMenu<5);

            }
            else{
                System.out.print("Username & password salah / Akun anda belum diapprove");
            }
        }
    }

    private static void daftarPlayer() {
        Scanner input = new Scanner(System.in);
        String username,password,lencana="";
        int status = 0,level=0;
        
        System.out.println("Daftar Sebagai Player\n");
        
        System.out.print("Masukan Useername : ");
        username = input.nextLine();
        
        System.out.print("Masukan Password : ");
        password = input.nextLine();
        
        arrayPlayer.add(new Player(username,password,status,lencana,level));
        System.out.print("Daftar akun berhasil! Tunggu approval dari admin\n");  
        
        menuPlayer();
    }
    
    private static void daftarEvent(int indexPlayer) {
        String namaEvent, jawab;
        int indexEvent = -1;
        Scanner input = new Scanner(System.in);
        if(arrayEvent.size()>0){
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("|\tNO\t|\tNama Event\t|\tJenis Olahraga\t|\tLevel\t|\tTanggal Event\t|\tTempat\t|\tBiaya Pendaftaran\t|\tMinimum Peserta\t|\tMaksimal Peserta\t|\tJumlah Pendaftar\t|");
            System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------");
            for(int i=0;i<arrayEvent.size();i++){
                if(arrayEvent.get(i).status.equals("1")){                    
                    System.out.println("|\t"+(i+1)+"\t|\t"+arrayEvent.get(i).getNama()+"\t|\t"+arrayEvent.get(i).jenisOlahraga+"\t|\t"+arrayEvent.get(i).level+"\t|\t"+arrayEvent.get(i).tanggalEvent+"\t|\t"+arrayEvent.get(i).tempat+"\t|\t"+arrayEvent.get(i).biaya+"\t|\t"+arrayEvent.get(i).minimumPeserta+"\t|\t"+arrayEvent.get(i).maksimumPeserta+"\t|\t"+arrayEvent.get(i).jumlahPendaftar+"\t|" );
                }
            }
        }
        else {
            System.out.print("blom ada event");
        }
        System.out.println("\nMasukkan nama event yang ingin anda daftar : ");
        namaEvent = input.nextLine();
        
        for(int i=0;i<arrayEvent.size();i++){
            if(arrayEvent.get(i).getNama().equals(namaEvent)){
                indexEvent = i;
            }
        }        
        
        if(indexEvent != -1){
            System.out.println("Nama Event : "+arrayEvent.get(indexEvent).namaEvent);
            System.out.println("Jenis Olahraga : "+arrayEvent.get(indexEvent).jenisOlahraga);
            System.out.println("Level : "+arrayEvent.get(indexEvent).level);
            System.out.println("Tanggal Event : "+arrayEvent.get(indexEvent).tanggalEvent);
            System.out.println("Tempat : "+arrayEvent.get(indexEvent).tempat);
            System.out.println("Biaya pendaftaran : "+arrayEvent.get(indexEvent).biaya);
            System.out.print("Apakah anda ingin mendaftar ke event ini? [y / n] : ");
            jawab = input.nextLine();
            
            if(jawab.equals("y")){
                if(arrayEvent.get(indexEvent).getJumlahPendaftar() == arrayEvent.get(indexEvent).maksimumPeserta){
                    System.out.println("Kuota sudah penuh");
                }
                else{
                    arrayEvent.get(indexEvent).tambahPendaftar();
                    arrayPlayer.get(indexPlayer).tambahLevel();
                    System.out.println("Anda berhasil mendaftar di event ini");
                    input.nextLine();
                }
                arrayEvent.get(indexEvent).tambahPendaftar();
                arrayPlayer.get(indexPlayer).tambahLevel();
                System.out.println("Anda berhasil mendaftar di event ini");
                input.nextLine();
            }
            else {
                System.out.println("Anda tidak terdaftar di event ini");
            }
                
            
        }
        else{
            System.out.println("Event tidak ditemukan");
        }
        
        
    }

    private static void beriLencana() {
        Scanner input = new Scanner(System.in);
        String username,lencana;
        int indexPlayer = -1;
        
        System.out.println("\nBERI LENCANA");
        System.out.println("| NO | Username     |");
        
        for(int i=0;i<arrayPlayer.size();i++){           
            System.out.println((i+1)+arrayPlayer.get(i).getUsername());
        }
        
        System.out.print("Masukkan username player yang ingin anda beri lencana : ");
        username = input.nextLine();
        
        for(int i=0;i<arrayPlayer.size();i++){
            if(arrayPlayer.get(i).getUsername().equals(username)){
                indexPlayer = i;
            }
        }
        
        if(indexPlayer != -1){
            System.out.print("Berikan lencana anda : ");
            lencana = input.nextLine();
            
            arrayPlayer.get(indexPlayer).setLencana(lencana);
            System.out.println("Anda berhasil memberi lencana");
        }
        else{
            System.out.println("Username tidak ditemukan");
        }
        
    }
}
