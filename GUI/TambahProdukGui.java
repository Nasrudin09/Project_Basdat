package GUI;

import Controller.AllObjectModel;
import Entity.ProdukEntity;
import Helper.KoneksiDb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class TambahProdukGui extends JFrame {
    Connection conn = KoneksiDb.getconnection();
    JComboBox boxKategori = new JComboBox();
    JComboBox boxMerk = new JComboBox();
    JComboBox boxSupplier = new JComboBox();
    JTextField fieldNamaProduk = new JTextField();
    JTextField fieldStok = new JTextField();
    JTextField fieldHarga = new JTextField();
    JTextField fieldJenisProduk = new JTextField();
    JButton btnTambah = new JButton("TAMBAH");
    JButton btnKembali = new JButton("KEMBALI");
    JButton btnOk = new JButton("OK");

    TambahProdukGui(int id) {
        initComponent(id);
        boxKategori();
        boxMerk();
    }

    public void initComponent(int id) {
        setBounds(100, 100, 623, 654);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);

        JLabel labelKategori = new JLabel("PILIH KATEGORI");
        labelKategori.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelKategori.setBounds(87, 62, 150, 43);
        getContentPane().add(labelKategori);

        boxKategori.setBounds(270, 70, 201, 30);
        getContentPane().add(boxKategori);


        btnOk.setBounds(495, 70, 53, 30);
        getContentPane().add(btnOk);

        btnOk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int kategori = boxKategori.getSelectedIndex() + 1;
                String jenis_produk = AllObjectModel.produkModel.getJenisProduk(kategori);
                fieldJenisProduk.setText(jenis_produk);
            }
        });

        JLabel lblJenisProduk = new JLabel("JENIS PRODUK");
        lblJenisProduk.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblJenisProduk.setBounds(87, 120, 150, 43);
        getContentPane().add(lblJenisProduk);

        fieldJenisProduk.setColumns(10);
        fieldJenisProduk.setBounds(270, 132, 201, 30);
        fieldJenisProduk.setEditable(false);
        getContentPane().add(fieldJenisProduk);

        JLabel labelMerk = new JLabel("PILIH MERK");
        labelMerk.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelMerk.setBounds(87, 190, 150, 43);
        getContentPane().add(labelMerk);

        boxMerk.setBounds(270, 197, 201, 30);
        getContentPane().add(boxMerk);

        JLabel labelNamaProduk = new JLabel("NAMA PRODUK");
        labelNamaProduk.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelNamaProduk.setBounds(87, 266, 150, 43);
        getContentPane().add(labelNamaProduk);

        fieldNamaProduk.setColumns(10);
        fieldNamaProduk.setBounds(270, 273, 201, 30);
        getContentPane().add(fieldNamaProduk);

        JLabel labelStok = new JLabel("STOK");
        labelStok.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelStok.setBounds(87, 338, 150, 43);
        getContentPane().add(labelStok);

        fieldStok.setColumns(10);
        fieldStok.setBounds(270, 345, 201, 30);
        getContentPane().add(fieldStok);

        JLabel labelHarga = new JLabel("HARGA");
        labelHarga.setFont(new Font("Times New Roman", Font.BOLD, 16));
        labelHarga.setBounds(87, 407, 150, 43);
        getContentPane().add(labelHarga);

        fieldHarga.setColumns(10);
        fieldHarga.setBounds(270, 414, 201, 30);
        getContentPane().add(fieldHarga);

        JLabel lblSupplier = new JLabel("SUPPLIER");
        lblSupplier.setFont(new Font("Times New Roman", Font.BOLD, 16));
        lblSupplier.setBounds(87, 468, 150, 43);
        getContentPane().add(lblSupplier);


        boxSupplier.setBounds(270, 479, 201, 30);
        boxSupplier();
        getContentPane().add(boxSupplier);

        btnTambah.setFont(new Font("Times New Roman", Font.BOLD, 16));
        btnTambah.setBounds(228, 536, 150, 43);
        getContentPane().add(btnTambah);
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama_produk;
                int id_kategori = boxKategori.getSelectedIndex() + 1;
                int id_merk = boxMerk.getSelectedIndex() + 1;
                int id_supplier = boxSupplier.getSelectedIndex() + 1;
                int stok;
                int harga;


                if(fieldNamaProduk.getText().length() == 0 || fieldStok.getText().length() == 0 || fieldHarga.getText().length() == 0){
                    JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                }else{
                    nama_produk = fieldNamaProduk.getText();
                    stok = Integer.parseInt(fieldStok.getText());
                    harga = Integer.parseInt(fieldHarga.getText());
                    AllObjectModel.produkModel.insertData(new ProdukEntity(id_kategori,id_merk,id_supplier,nama_produk,stok,harga));
                    JOptionPane.showMessageDialog(null,"Data Berhasil ditambahkan");
                    dispose();
                    new DashboardGui(id);
                }
            }
        });

        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnKembali.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashboardGui(id);
            }
        });
        btnKembali.setBounds(10, 22, 120, 30);
        getContentPane().add(btnKembali);

        setVisible(true);
    }

    public void boxKategori() {
        String sql;
        try {
            sql = "SELECT nama_kategori FROM kategori";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String kategori = rs.getString("nama_kategori");

                boxKategori.addItem(kategori);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void boxMerk() {
        String sql;
        try {
            sql = "SELECT nama_merk FROM merk";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()) {
                String merk = rs.getString("nama_merk");

                boxMerk.addItem(merk);
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void boxSupplier(){
        Connection conn = KoneksiDb.getconnection();
        String sql;
        try{
            sql = "SELECT * FROM supplier";
            PreparedStatement stat = conn.prepareStatement(sql);
            ResultSet rs = stat.executeQuery();

            while (rs.next()){
                String nama = rs.getString("nama_supplier");
                boxSupplier.addItem(nama);

            }

        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
