package Model;
import Helper.KoneksiDb;
import Entity.ProdukEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProdukModel {
    public Connection conn = KoneksiDb.getconnection();
    String sql;
    Scanner input = new Scanner(System.in);
    public ProdukModel(){}

    public int  LoginPegawai(String username, String password){
        int cek = 0;
        try {
            sql = "SELECT * FROM pegawai where username = ? and password = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1, username);
            stat.setString(2, password);
            ResultSet rs = stat.executeQuery();
            if(rs.next()){
                cek = rs.getInt("id_pegawai");
            } else {
                cek = 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return cek;
    }

   public ArrayList<ProdukEntity> getProduk(){
        ArrayList<ProdukEntity> arrayListProduk = new ArrayList<>();
        try{
            Statement stnt = conn.createStatement();
            sql = "SELECT produk.ID_PRODUK, produk.NAMA_PRODUK, merk.NAMA_MERK, kategori.NAMA_KATEGORI,jenis_produk.NAMA_JENIS_PRODUK,produk.STOK, produk.HARGA\n" +
                    "FROM produk\n" +
                    "INNER JOIN merk ON produk.ID_MERK = merk.ID_MERK\n" +
                    "INNER JOIN kategori ON produk.ID_KATEGORI = kategori.ID_KATEGORI\n" +
                    "INNER JOIN jenis_produk ON kategori.ID_KATEGORI = jenis_produk.ID_JENIS_PRODUK\n" +
                    "ORDER BY produk.ID_PRODUK ASC ";
            ResultSet Rs = stnt.executeQuery(sql);
            while(Rs.next()){
                ProdukEntity produkEntity = new ProdukEntity();
                produkEntity.setId_produk(Rs.getInt("id_produk"));
                produkEntity.setNama_pdk(Rs.getString("nama_produk"));
                produkEntity.setNama_merk(Rs.getString("nama_merk"));
                produkEntity.setNama_kategori(Rs.getString("nama_kategori"));
                produkEntity.setJenis(Rs.getString("nama_jenis_produk"));
                produkEntity.setStok(Rs.getInt("stok"));
                produkEntity.setHarga(Rs.getInt("harga"));
                arrayListProduk.add(produkEntity);
            }
        }catch (SQLException e){
            System.out.println("ERROR DI INNER JOIN");
            e.printStackTrace();

        }
        return  arrayListProduk;
   }

   public ArrayList<ProdukEntity>getProduk(int id){
        ArrayList<ProdukEntity>produk = new ArrayList<>();
        try {
            sql = "SELECT nama_produk, harga, stok FROM produk WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                ProdukEntity produkEntity = new ProdukEntity();
                produkEntity.setNama_pdk(rs.getString("nama_produk"));
                produkEntity.setHarga(rs.getInt("harga"));
                produkEntity.setStok(rs.getInt("stok"));
                produk.add(produkEntity);
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return produk;
   }

    public int insertData(ProdukEntity produkEntity) {
        try {
            sql = "INSERT INTO produk (id_kategori,id_merk,id_supplier,nama_produk,stok,harga)" +
                    " VALUES (?,?,?,?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,produkEntity.getKategori());
            stat.setInt(2, produkEntity.getMerk());
            stat.setInt(3, produkEntity.getId_supplier());
            stat.setString(4, produkEntity.getNama_pdk());
            stat.setInt(5, produkEntity.getStok());
            stat.setInt(6, produkEntity.getHarga());
            return stat.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public ArrayList<ProdukEntity>getTransaksi(){
        ArrayList<ProdukEntity>produk = new ArrayList<>();
        try{
            sql = "SELECT pembeli.NAMA_PEMBELI,produk.NAMA_PRODUK, detail_transaksi.JUMLAH_HARGA,detail_transaksi.JUMLAH_PRODUK\n" +
                    "FROM detail_transaksi\n" +
                    "INNER JOIN transaksi ON detail_transaksi.ID_TRANSAKSI = transaksi.ID_TRANSAKSI\n" +
                    "INNER JOIN pembeli ON transaksi.ID_PEMBELI = pembeli.ID_PEMBELI\n" +
                    "INNER JOIN produk ON detail_transaksi.ID_PRODUK = produk.ID_PRODUK";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                ProdukEntity produkEntity = new ProdukEntity();
                produkEntity.setNama_pembeli(rs.getString("pembeli.nama_pembeli"));
                produkEntity.setNama_pdk(rs.getString("produk.nama_produk"));
                produkEntity.setHarga(rs.getInt("jumlah_harga"));
                produkEntity.setJumlah_produk(rs.getInt("jumlah_produk"));
                produk.add(produkEntity);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return produk;
    }

    public void show_data(){
        for(ProdukEntity produkEntity : getProduk()){
            System.out.println("id_produk : " + produkEntity.getId_produk());
            System.out.println("nama_produk : " + produkEntity.getNama_pdk());
            System.out.println("nama_merk : " + produkEntity.getNama_merk());
            System.out.println("nama_kategori : " + produkEntity.getNama_kategori());
            System.out.println("stok: " + produkEntity.getStok());
            System.out.println("harga : " + produkEntity.getHarga());
        }
    }

    public int updateNamaProduk(String nama_produk, int id){
        try{
            sql = "UPDATE produk SET nama_produk = ? WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setString(1,nama_produk);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateStokProduk(int stok, int id){
        try{
            sql = "UPDATE produk SET stok = ? WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,stok);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int updateHargaProduk(int harga, int id){
        try{
            sql = "UPDATE produk SET harga = ? WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,harga);
            stat.setInt(2,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int deleteProduk(int id){
        try {
            sql = "DELETE FROM produk WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            return stat.executeUpdate();

        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public String getNamaProduk(int id){
        try {
            sql = "SELECT * FROM produk WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getString("nama_produk");
            }

        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public String getJenisProduk(int id_kategori){
        try {
            sql = "SELECT jenis_produk.NAMA_JENIS_PRODUK\n" +
                    "FROM kategori\n" +
                    "INNER JOIN jenis_produk ON kategori.ID_JENIS_PRODUK = jenis_produk.ID_JENIS_PRODUK\n" +
                    "WHERE kategori.ID_KATEGORI = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id_kategori);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getString("jenis_produk.NAMA_JENIS_PRODUK");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    public int getStokProduk(int id){
        try {
            sql = "SELECT * FROM produk WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getInt("stok");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int getHarga(int id){
        try {
            sql = "SELECT * FROM produk WHERE id_produk = ?";
            PreparedStatement stat = conn.prepareStatement(sql);
            stat.setInt(1,id);
            ResultSet rs = stat.executeQuery();

            if(rs.next()){
                return rs.getInt("harga");
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }


    public int transaksi(int id_pegawai, int id_pembeli){
        try {
           sql = "INSERT INTO transaksi(id_pegawai,id_pembeli,tanggal_transaksi) VALUES(?,?,NOW())";
           PreparedStatement stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
           stat.setInt(1,id_pegawai);
           stat.setInt(2,id_pembeli);
           stat.executeUpdate();
           ResultSet rs = stat.getGeneratedKeys();
           if(rs.next()){
               return rs.getInt(1);
           }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }

    public int pembeli(String nama, String no_hp, String alamat){
        try{
            sql = "INSERT INTO pembeli(nama_pembeli,no_hp,alamat)VALUES(?,?,?)";
            PreparedStatement stat = conn.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            stat.setString(1,nama);
            stat.setString(2,no_hp);
            stat.setString(3,alamat);
            stat.executeUpdate();
            ResultSet rs = stat.getGeneratedKeys();

            if(rs.next()){
                return rs.getInt(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return -1;
    }
}
