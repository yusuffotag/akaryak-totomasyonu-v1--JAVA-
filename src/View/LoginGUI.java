package View;
import java.awt.BorderLayout;
import java.awt.EventQueue;




import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import helper.*;
import model.Personel;

public class LoginGUI extends JFrame {

	private JPanel w_pane;
	private JTextField fld_personeltc;
	private JPasswordField fld_personelpass;
	private DBConnection conn = new DBConnection();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginGUI frame = new LoginGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginGUI() {
		setResizable(false);
		setTitle("Benzinlik Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 492, 395);
		w_pane = new JPanel();
		w_pane.setBackground(new Color(0, 255, 128));
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lbl_logo = new JLabel(new ImageIcon(getClass().getResource("benzin.png")));
		lbl_logo.setBounds(148, 0,196, 138);
		w_pane.add(lbl_logo);
		
		JTabbedPane w_tabpane = new JTabbedPane(JTabbedPane.TOP);
		w_tabpane.setBounds(0, 180, 484, 181);
		w_pane.add(w_tabpane);
		
		JPanel panel = new JPanel();
		w_tabpane.addTab("Personel Girişi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("TC Numaranız :");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(28, 30, 163, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Şifre :");
		lblNewLabel_2.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(102, 71, 100, 24);
		panel.add(lblNewLabel_2);
		
		fld_personeltc = new JTextField();
		fld_personeltc.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		fld_personeltc.setBounds(159, 24, 228, 24);
		panel.add(fld_personeltc);
		fld_personeltc.setColumns(10);
		
		JButton btn_personellogin = new JButton("Giriş Yap");
		btn_personellogin.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 15));
		btn_personellogin.setBounds(169, 104, 168, 38);
		btn_personellogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
			   
				if(fld_personeltc.getText().length() ==0 || fld_personelpass.getText().length() == 0  ) {
					helper.ShowMsg("Lütfen Tüm Alanları Doldurunuz !");
				}else {
					
				
				
					try {	
						Connection con = conn.connDB();
						Statement st = con.createStatement();
						ResultSet rs = st.executeQuery("SELECT * FROM personellistesi");
						while(rs.next()) {
							if(fld_personeltc.getText().equals(rs.getString("tcno"))&&fld_personelpass.getText().equals(rs.getString("password"))) {
								Personel personel = new Personel();
								personel.setId(rs.getInt("İd"));
								personel.setPassword("password");
								personel.setTcno(rs.getString("tcno"));
								personel.setName(rs.getString("name"));
								personel.setType(rs.getString("type"));
								System.out.println(personel.getName());
								PersonelGUI pGUI = new PersonelGUI(personel);
								pGUI.setVisible(true);
								dispose();
								
								
							}
						}
					} catch (SQLException e1) {
					
						e1.printStackTrace();
					}
				}
				
			}
			
		});
		panel.add(btn_personellogin);
		
		fld_personelpass = new JPasswordField();
		fld_personelpass.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 18));
		fld_personelpass.setBounds(159, 70, 224, 24);
		panel.add(fld_personelpass);
		
		JLabel lblNewLabel = new JLabel("Benzinlik Yönetim Sistemine Hoşgeldiniz");
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		lblNewLabel.setBounds(100, 149, 355, 20);
		w_pane.add(lblNewLabel);
	}
}
