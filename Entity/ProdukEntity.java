package Entity;

public class ProdukEntity {
    private String nama_pdk;
    private int id_produk,id_supplier,jumlah_produk;
    private String nama_kategori,nama_merk, jenis, nama_pembeli;

    public int getId_produk() {
        return id_produk;
    }

    public ProdukEntity(){}

    public void setId_produk(int id_produk) {
        this.id_produk = id_produk;
    }

    private int stok;
    private int harga;
    private int merk;
    private int kategori;


    public ProdukEntity(int kategori, int merk,int id_supplier, String nama_pdk, int stok, int harga) {
        this.nama_pdk = nama_pdk;
        this.stok = stok;
        this.harga = harga;
        this.id_supplier = id_supplier;
        this.merk = merk;
        this.kategori = kategori;
    }

    public String getNama_pembeli() {
        return nama_pembeli;
    }

    public void setNama_pembeli(String nama_pembeli) {
        this.nama_pembeli = nama_pembeli;
    }

    public int getId_supplier() {
        return id_supplier;
    }

    public void setId_supplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public void setMerk(int merk){
        this.merk = merk;
    }

    public void setNama_pdk(String nama) {
        this.nama_pdk = nama;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getKategori() {
        return kategori;
    }

    public void setKategori(int kategori) {
        this.kategori = kategori;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String getNama_pdk() {
        return this.nama_pdk;
    }

    public int getHarga() {
        return this.harga;
    }

    public int getStok() {
        return this.stok;
    }

    public int getMerk(){
        return this.merk;
    }

    public String getNama_kategori() {
        return nama_kategori;
    }

    public void setNama_kategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }

    public String getNama_merk() {
        return nama_merk;
    }

    public void setNama_merk(String nama_merk) {
        this.nama_merk = nama_merk;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public int getJumlah_produk() {
        return jumlah_produk;
    }

    public void setJumlah_produk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }
}