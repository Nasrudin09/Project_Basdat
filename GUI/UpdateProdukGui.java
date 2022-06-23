package GUI;
import Controller.AllObjectModel;
import Controller.ProdukController;
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

public class UpdateProdukGui extends JFrame {
    JTextField fieldNama = new JTextField();
    JTextField fieldStok = new JTextField();
    JTextField fieldHarga = new JTextField();
    JButton btnUpdateNama = new JButton("Update Nama");
    JButton btnUpdateStok = new JButton("Update Stok");
    JButton btnUpdateHarga = new JButton("Update Harga");
    int stok,harga;
    String nama_produk;

    UpdateProdukGui (int id,int id_produk){
        initcomponent(id,id_produk);
    }

    public void initcomponent(int id,int id_produk){
        for(ProdukEntity produkEntity : AllObjectModel.produkModel.getProduk(id_produk)){
            this.nama_produk = produkEntity.getNama_pdk();
            this.stok = produkEntity.getStok();
            this.harga = produkEntity.getHarga();
        }

        setBounds(100, 100, 803, 429);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        btnKembali.setBounds(10, 20, 112, 28);
        getContentPane().add(btnKembali);
        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new DashboardGui(id);
            }
        });

        JLabel btnNamaproduk = new JLabel("NAMA PRODUK");
        btnNamaproduk.setFont(new Font("Times New Roman", Font.BOLD, 20));
        btnNamaproduk.setBounds(10, 102, 180, 28);
        getContentPane().add(btnNamaproduk);

        JLabel lblStokProduk = new JLabel("STOK PRODUK");
        lblStokProduk.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblStokProduk.setBounds(10, 188, 169, 28);
        getContentPane().add(lblStokProduk);

        JLabel lblHargaProduk = new JLabel("HARGA PRODUK");
        lblHargaProduk.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblHargaProduk.setBounds(10, 273, 180, 28);
        getContentPane().add(lblHargaProduk);

        
        fieldNama.setBounds(239, 102, 237, 26);
        fieldNama.setText(nama_produk);
        fieldNama.setEditable(false);
        getContentPane().add(fieldNama);
        fieldNama.setColumns(10);


        fieldStok.setColumns(10);
        fieldStok.setBounds(239, 188, 237, 26);
        fieldStok.setText(String.valueOf(stok));
        fieldStok.setEditable(false);
        getContentPane().add(fieldStok);


        fieldHarga.setColumns(10);
        fieldHarga.setBounds(239, 273, 237, 26);
        fieldHarga.setEditable(false);
        fieldHarga.setText(String.valueOf(harga));
        getContentPane().add(fieldHarga);


        btnUpdateNama.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        btnUpdateNama.setBounds(530, 102, 132, 27);
        getContentPane().add(btnUpdateNama);
        btnUpdateNama.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputHarga = JOptionPane.showInputDialog("Masukkan Nama Baru");
                try {
                    if(!inputHarga.isEmpty()){
                        AllObjectModel.produkModel.updateNamaProduk(inputHarga, id_produk);
                        JOptionPane.showMessageDialog(null,"Berhasil Update");
                        fieldNama.setText(inputHarga);
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }

                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Canceled");
                }
            }
        });

        btnUpdateStok.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        btnUpdateStok.setBounds(530, 189, 132, 27);
        getContentPane().add(btnUpdateStok);
        btnUpdateStok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int inputHarga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Stok Baru"));
                try {
                    if(inputHarga != 0){
                        AllObjectModel.produkModel.updateStokProduk(inputHarga, id_produk);
                        JOptionPane.showMessageDialog(null,"Berhasil Update");
                        fieldStok.setText(String.valueOf(inputHarga));
                    }else{
                        JOptionPane.showMessageDialog(null, "Data Kosong");
                    }

                }catch (Exception e1){
                    JOptionPane.showMessageDialog(null,"Canceled");
                }
            }
        });
        
        btnUpdateHarga.setFont(new Font("Times New Roman", Font.PLAIN, 17));
        btnUpdateHarga.setBounds(530, 272, 132, 27);
        getContentPane().add(btnUpdateHarga);
        btnUpdateHarga.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int inputHarga = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Stok Baru"));
                    try {
                        if(inputHarga != 0){
                            AllObjectModel.produkModel.updateHargaProduk(inputHarga, id_produk);
                            JOptionPane.showMessageDialog(null,"Berhasil Update");
                            fieldHarga.setText(String.valueOf(inputHarga));
                        }else{
                            JOptionPane.showMessageDialog(null, "Data Kosong");
                        }

                    }catch (Exception e1){
                        JOptionPane.showMessageDialog(null,"Canceled");
                    }
            }
        });

        setVisible(true);
    }
}

