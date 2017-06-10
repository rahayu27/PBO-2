/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bajuonline;

import java.util.Scanner;

/**
 *
 * @author YUMMY
 */
public class BajuOnline {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        // TODO code application logic here
        onlinebaju entityObjk =new onlinebaju();
        QueryB0nline tambah = new QueryB0nline();
        Scanner input=new Scanner(System.in);
        String nama,jwb = null,alamat;
        long id = 0;
        
        System.out.println("SELAMAT DATANG DI Baju Online ");
        System.out.println("Apakah anda ingin menambah data ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        System.out.println("Masukkan Biodata Anda :");
        System.out.print("Nama Lengkap :");nama = input.nextLine();
        System.out.print("Alamat :");alamat=input.nextLine();
        entityObjk.setNama(nama);
        entityObjk.setAlamat(alamat);
        tambah.Add(entityObjk);
        }
        
        System.out.println("Apakah data anda ingin dilihat kan ? jawab ya/no");jwb=input.nextLine();
        if(jwb.equals("ya")){
        tambah.Show();
        }
        
        System.out.println("Apakah data anda ingin di rubah/di hapus kan ?\n"
                + "jawab lanjut : untuk rubah "
                + "\n jawab ok : untuk hapus");
        jwb=input.nextLine();
        
        if(jwb.equals("lanjut")){
            System.out.print("Nama :");nama = input.nextLine();
            System.out.print("Alamat :");alamat = input.nextLine();
            System.out.print("ID :");id=input.nextLong();
            tambah.update(id, nama, alamat);
            tambah.Show();
            
        }else if(jwb.equals("ok")){
            tambah.Show();
            System.out.print("Masukan ID :");id=input.nextLong();
            tambah.hapus(id);
            tambah.Show();
        }
        
    
        
    }
    }
   
    

