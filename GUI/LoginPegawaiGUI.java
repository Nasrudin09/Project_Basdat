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


public class LoginPegawaiGUI extends JFrame {

   public LoginPegawaiGUI(){
		initComponent();
	}

	public void initComponent() {
		ProdukController produkController = new ProdukController();
		JLabel lblLoginPegawai = new JLabel("LOGIN Pegawai");
		JLabel lblNama = new JLabel("NAMA");
		JLabel lblPassword = new JLabel("PASSWORD");
		JButton btnLogin = new JButton("Login");

		setBounds(100, 100, 587, 328);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);

		lblLoginPegawai.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblLoginPegawai.setBounds(238, 20, 131, 21);
		getContentPane().add(lblLoginPegawai);

		lblNama.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNama.setBounds(32, 78, 141, 45);
		getContentPane().add(lblNama);

		lblPassword.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblPassword.setBounds(32, 152, 141, 45);
		getContentPane().add(lblPassword);

		JTextField fieldNama = new JTextField();
		fieldNama.setBounds(217, 86, 188, 34);
		getContentPane().add(fieldNama);
		fieldNama.setColumns(10);

		JPasswordField fieldPassword = new JPasswordField();
		fieldPassword.setColumns(10);
		fieldPassword.setBounds(217, 160, 188, 34);
		getContentPane().add(fieldPassword);

		btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = fieldNama.getText();
				String password = fieldPassword.getText();
				int cek = AllObjectModel.produkModel.LoginPegawai(username,password);

				if(username.isEmpty() || password.isEmpty()){
					JOptionPane.showMessageDialog(null,"Tidak boleh kosong");

				}else if(cek > 0){
					JOptionPane.showMessageDialog(null,"Berhasil Login sebagai pegawai");
					dispose();
					new DashboardGui(cek);
				}else {
					JOptionPane.showMessageDialog(null,"Username atau password salah");
					fieldNama.setText(null);
					fieldPassword.setText(null);
				}

			}
		});
		btnLogin.setBounds(261, 231, 108, 34);
		getContentPane().add(btnLogin);
		setVisible(true);
	}

}
