package GUI;

import Controller.AllObjectModel;
import Controller.ProdukController;
import Model.ProdukModel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardGui extends JFrame {
    ProdukController produkController = new ProdukController();
    JTable tableProduk = new JTable();
    JScrollPane spProduk = new JScrollPane(tableProduk);
    JTextField teksPilih = new JTextField();
    JTextField field_idProduk = new JTextField();


    public DashboardGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 1189, 549);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        spProduk.setBounds(0, 0, 581, 410);
        tableProduk.setModel(produkController.daftarProduk());
        this.add(spProduk);

        tableProduk.addMouseListener(new MouseAdapter() {
            int id_produk;
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tableProduk.getSelectedRow();
                teksPilih.setText(produkController.daftarProduk().getValueAt(i,0).toString());
                id_produk = produkController.getProduk().get(i).getId_produk();
                field_idProduk.setText(String.valueOf(id_produk));
            }
        });

        this.add(field_idProduk);

        JButton btnTambah = new JButton("Tambah Produk");
        btnTambah.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnTambah.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new TambahProdukGui(id);
                dispose();
            }
        });



        btnTambah.setBounds(698, 25, 170, 50);
        getContentPane().add(btnTambah);

        JButton btnUpdate = new JButton("Update Produk");
        btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnUpdate.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id_produk = Integer.parseInt(field_idProduk.getText());
                new UpdateProdukGui(id,id_produk);
                dispose();
            }
        });
        btnUpdate.setBounds(698, 126, 170, 43);
        getContentPane().add(btnUpdate);

        JButton btnKeluar = new JButton("Keluar");
        btnKeluar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        btnKeluar.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnKeluar.setBounds(698, 456, 170, 43);
        getContentPane().add(btnKeluar);

        JButton btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    int i = Integer.parseInt(field_idProduk.getText());
                    AllObjectModel.produkModel.deleteProduk(i);
                    tableProduk.setModel(produkController.daftarProduk());
                    JOptionPane.showMessageDialog(null, "Berhasil HAPUS Produk");
            }
        });
        btnDelete.setBounds(698, 216, 170, 43);
        getContentPane().add(btnDelete);

        JButton btnBeli = new JButton("Beli");
        btnBeli.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int id_produk = Integer.parseInt(field_idProduk.getText());
                new BeliGuI(id_produk,id);
                dispose();

            }
        });
        btnBeli.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnBeli.setBounds(698, 310, 170, 43);
        getContentPane().add(btnBeli);

        JButton btnHistoriPesanan = new JButton("Histori Pesanan");
        btnHistoriPesanan.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new HistoriPesananGui(id);
                dispose();
            }
        });
        btnHistoriPesanan.setFont(new Font("Tahoma", Font.PLAIN, 17));
        btnHistoriPesanan.setBounds(698, 380, 170, 43);
        getContentPane().add(btnHistoriPesanan);


        setVisible(true);
    }

}

