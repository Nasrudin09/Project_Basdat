package GUI;

import Controller.AllObjectModel;
import Helper.KoneksiDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BeliGuI extends JFrame {
    private String nama;
    private int stok;
    public BeliGuI(int id_produk,int id_pegawai){
        InitComponent(id_produk,id_pegawai);
    }
    
    public void InitComponent(int id_produk, int id_pegawai){
        JLabel lblNamaProduk = new JLabel("NAMA PRODUK");
        JLabel lblStokProduk = new JLabel("STOK PRODUK");
        JLabel lblJumlahProduk = new JLabel("JUMLAH PRODUK");
        JLabel lblTotalHarga = new JLabel("TOTAL HARGA");
        JButton btnBeli = new JButton("BELI");
        JButton btnKembali= new JButton("KEMBALI");
        JTextField fieldHarga = new JTextField();
        
        
        setBounds(100, 100, 560, 750);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        setLocationRelativeTo(null);
        setLayout(null);
        
        lblNamaProduk.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNamaProduk.setBounds(28, 61, 136, 54);
        getContentPane().add(lblNamaProduk);

        JTextField fieldNamaProduk = new JTextField();
        fieldNamaProduk.setBounds(281, 73, 200, 34);
        nama = AllObjectModel.produkModel.getNamaProduk(id_produk);
        fieldNamaProduk.setEditable(false);
        fieldNamaProduk.setText(nama);

        getContentPane().add(fieldNamaProduk);
        fieldNamaProduk.setColumns(10);
        
        lblStokProduk.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblStokProduk.setBounds(28, 148, 136, 54);
        getContentPane().add(lblStokProduk);

        JTextField fieldStok = new JTextField();
        fieldStok.setColumns(10);
        stok = AllObjectModel.produkModel.getStokProduk(id_produk);
        fieldStok.setText(String.valueOf(stok));
        fieldStok.setEditable(false);
        fieldStok.setBounds(281, 161, 200, 34);
        getContentPane().add(fieldStok);
        
        lblJumlahProduk.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblJumlahProduk.setBounds(28, 240, 149, 54);
        getContentPane().add(lblJumlahProduk);

        JSpinner Jumlah = new JSpinner(new SpinnerNumberModel(1,1,100,1));
        Jumlah.setBounds(281, 253, 200, 34);
        getContentPane().add(Jumlah);
        
        lblTotalHarga.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblTotalHarga.setBounds(28, 333, 149, 54);
        getContentPane().add(lblTotalHarga);

        JTextField fieldTotal = new JTextField();
        int total;
        fieldTotal.setColumns(10);
        fieldTotal.setBounds(281, 337, 200, 34);
        total = AllObjectModel.produkModel.getHarga(id_produk);
        fieldTotal.setText(String.valueOf(total));
        fieldTotal.setEditable(false);


        JButton btnOk = new JButton("OK");
        btnOk.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnOk.setBounds(491, 253, 60, 34);
        getContentPane().add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            int harga,jumlah,total;

            @Override
            public void actionPerformed(ActionEvent e) {
                jumlah = (int) Jumlah.getValue();
                int stok = AllObjectModel.produkModel.getStokProduk(id_produk);
                    harga = AllObjectModel.produkModel.getHarga(id_produk);
                    total  = harga * jumlah;
                    fieldTotal.setText(String.valueOf(this.total));
            }
        });


        getContentPane().add(fieldTotal);
        JLabel lblNamaPembeli = new JLabel("NAMA PEMBELI");
        lblNamaPembeli.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNamaPembeli.setBounds(28, 405, 149, 54);
        getContentPane().add(lblNamaPembeli);

        JTextField fieldNamaPembeli = new JTextField();
        fieldNamaPembeli.setBounds(281, 417, 200, 34);
        getContentPane().add(fieldNamaPembeli);

        JLabel lblNoHp = new JLabel("NO HP");
        lblNoHp.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblNoHp.setBounds(28, 481, 149, 54);
        getContentPane().add(lblNoHp);

        JTextField fieldNoHp = new JTextField();
        fieldNoHp.setBounds(281, 487, 200, 34);
        getContentPane().add(fieldNoHp);

        JLabel lblAlamat = new JLabel("ALAMAT");
        lblAlamat.setFont(new Font("Times New Roman", Font.BOLD, 17));
        lblAlamat.setBounds(28, 556, 149, 54);
        getContentPane().add(lblAlamat);

        JTextField fieldAlamat = new JTextField();
        fieldAlamat.setBounds(281, 562, 200, 34);
        getContentPane().add(fieldAlamat);
        
        btnBeli.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnBeli.setBounds(211, 635, 114, 54);
        getContentPane().add(btnBeli);

        btnBeli.addActionListener(new ActionListener() {
            Connection conn = KoneksiDb.getconnection();
            String sql,sql2;
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String nama,nohp,alamat;
                    int jumlah = (int) Jumlah.getValue();
                    int total_harga = Integer.parseInt(fieldTotal.getText());
                    int stok,lastId,id_pembeli;
                    nama = fieldNamaPembeli.getText();
                    nohp = fieldNoHp.getText();
                    alamat = fieldAlamat.getText();
                    stok = AllObjectModel.produkModel.getStokProduk(id_produk);
                    if(jumlah > stok){
                        JOptionPane.showMessageDialog(null, "Stok tidak cukup");
                        Jumlah.setValue(1);
                    }else{
                        id_pembeli = AllObjectModel.produkModel.pembeli(nama,nohp,alamat);
                        lastId = AllObjectModel.produkModel.transaksi(id_pegawai,id_pembeli);
                        stok  = stok -  Integer.parseInt(String.valueOf(Jumlah.getValue())) ;
                        sql2 = "INSERT INTO detail_transaksi(id_transaksi,id_produk,jumlah_harga,jumlah_produk)" +
                                " VALUES (?,?,?,?)";
                        PreparedStatement stat1 = conn.prepareStatement(sql2);
                        stat1.setInt(1,lastId);
                        stat1.setInt(2,id_produk);
                        stat1.setInt(3,total_harga);
                        stat1.setInt(4,jumlah);
                        stat1.executeUpdate();
                        AllObjectModel.produkModel.updateStokProduk(stok,id_produk);
                        JOptionPane.showMessageDialog(null,"Transaksi Berhasil");
                        new DashboardGui(id_pegawai);
                        dispose();
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                }
            }
        });
        
        btnKembali.setFont(new Font("Times New Roman", Font.BOLD, 17));
        btnKembali.setBounds(28, 17, 120, 34);
        getContentPane().add(btnKembali);
        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashboardGui(id_pegawai);
            }
        });
            setVisible(true);
    }
}

