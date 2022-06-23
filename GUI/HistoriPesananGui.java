package GUI;

import Controller.AllObjectModel;
import Controller.ProdukController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HistoriPesananGui extends JFrame {
    JTable tablePesanan = new JTable();
    JScrollPane spPesanan = new JScrollPane(tablePesanan);
    ProdukController produkController = new ProdukController();
    HistoriPesananGui(int id){
        initComponent(id);
    }

    public void initComponent(int id){
        setBounds(100, 100, 633, 489);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);

        spPesanan.setBounds(29, 51, 561, 372);
        tablePesanan.setModel(produkController.daftarTransaksi());
        this.add(spPesanan);

        JButton btnKembali = new JButton("KEMBALI");
        btnKembali.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnKembali.setBounds(29, 11, 89, 23);

        btnKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DashboardGui(id);
                dispose();
            }
        });

        this.add(btnKembali);





        setVisible(true);
    }

}
