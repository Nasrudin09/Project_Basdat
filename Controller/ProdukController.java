package Controller;

import Entity.ProdukEntity;
import GUI.DashboardGui;

import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

public class ProdukController {
    public void insertData(int id_kategori, int merk,int id_supplier, String nama_produk, int stok, int harga){
        AllObjectModel.produkModel.insertData(new ProdukEntity(id_kategori,merk,id_supplier,nama_produk,stok,harga));
    }

    public void updateProduk(int urut, int param, int id ){
        switch (urut){
            case 1 ->{
                AllObjectModel.produkModel.updateStokProduk(param,id);
            }
            case 2 -> {
                AllObjectModel.produkModel.updateHargaProduk(param,id);
            }
        }
    }

    public void updateNamaProduk(String namaProduk, int id){
        AllObjectModel.produkModel.updateNamaProduk(namaProduk, id);
    }

    public ArrayList<ProdukEntity> getProduk(){
        return AllObjectModel.produkModel.getProduk();

    }

    public ArrayList<ProdukEntity>getTransaksi(){
        return AllObjectModel.produkModel.getTransaksi();
    }

    public ArrayList<ProdukEntity> getProduk(int id_produk){
        return AllObjectModel.produkModel.getProduk(id_produk);
    }

    public DefaultTableModel daftarProduk(){
        DefaultTableModel daftarProduk = new DefaultTableModel();
        Object[] kolom = {"ID_PRODUK", "NAMA PRODUK","MERK","KATEGORI","JENIS", "STOK", "HARGA"};
        daftarProduk.setColumnIdentifiers(kolom);
        int size = getProduk().size();
        for(int i = 0; i < size; i++ ){
            Object[] data = new Object[kolom.length];
            data[0] = AllObjectModel.produkModel.getProduk().get(i).getId_produk();
            data[1] = AllObjectModel.produkModel.getProduk().get(i).getNama_pdk();
            data[2] = AllObjectModel.produkModel.getProduk().get(i).getNama_merk();
            data[3] = AllObjectModel.produkModel.getProduk().get(i).getNama_kategori();
            data[4] = AllObjectModel.produkModel.getProduk().get(i).getJenis();
            data[5] = AllObjectModel.produkModel.getProduk().get(i).getStok();
            data[6] = AllObjectModel.produkModel.getProduk().get(i).getHarga();
            daftarProduk.addRow(data);
        }
        return daftarProduk;
    }

    public DefaultTableModel daftarTransaksi(){
        DefaultTableModel daftarTransaksi = new DefaultTableModel();
        Object[]kolom = {"NAMA","PRODUK","JUMLAH HARGA","JUMLAH BARANG"};
        daftarTransaksi.setColumnIdentifiers(kolom);
        int size = getTransaksi().size();
        for(int i = 0; i<size; i++){
            Object[] data = new Object[kolom.length];
            data[0] = AllObjectModel.produkModel.getTransaksi().get(i).getNama_pembeli();
            data[1] = AllObjectModel.produkModel.getTransaksi().get(i).getNama_pdk();
            data[2] = AllObjectModel.produkModel.getTransaksi().get(i).getHarga();
            data[3] = AllObjectModel.produkModel.getTransaksi().get(i).getJumlah_produk();
            daftarTransaksi.addRow(data);
        }
        return daftarTransaksi;
    }

    public int LoginPegawai(String username, String password){
        return AllObjectModel.produkModel.LoginPegawai(username, password);
    }

    public String getNama(int id){
        return AllObjectModel.produkModel.getNamaProduk(id);
    }

    public int getStok(int id){
        return AllObjectModel.produkModel.getStokProduk(id);
    }

    public int getHarga(int id){
        return AllObjectModel.produkModel.getHarga(id);
    }

    public String getJenisProduk(int id_kategori){
        return AllObjectModel.produkModel.getJenisProduk(id_kategori);
    }

    public int pembeli(String nama, String no_hp, String alamat){
        return AllObjectModel.produkModel.pembeli(nama, no_hp, alamat);
    }

}
