package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import model.Personel;
import model.*;
import helper.*;
import java.awt.Color;
import java.awt.Component;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PersonelGUI extends JFrame {
     
	static Personel personel = new Personel();
	ybmoil ybmoil_ = new ybmoil();
	private JPanel w_pane;
	private JTextField fld_adsoyad;
	private JTextField fld_tcno;
	private JTextField fld_plaka;
	private JTextField fld_adsoyadıd;
	private JTable table_taşıt;
	private DefaultTableModel MüsteriModel = null;
	private Object[] MüsteriData = null;
	private DefaultTableModel ybmoilModel = null;
	private Object[] ybmoilData = null;
	private JTable table_ybmoil;
	private JTextField fld_ybmoil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonelGUI frame = new PersonelGUI(personel);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException
	 */
	public  PersonelGUI(Personel personel) throws SQLException {
		
		MüsteriModel = new DefaultTableModel();
		Object[] colMüsteriName = new Object[4];
		colMüsteriName[0] = "ID";
		colMüsteriName[1] = "Ad Soyad";
		colMüsteriName[2] = "T.C. No";
		colMüsteriName[3] = "Araç Plaka";
		MüsteriModel.setColumnIdentifiers(colMüsteriName);
		MüsteriData = new Object[4];
		
		for(int i=0; i < personel.getMüsteriList().size(); i++) {
			
			MüsteriData[0] = personel.getMüsteriList().get(i).getId();
			MüsteriData[1] = personel.getMüsteriList().get(i).getName();
			MüsteriData[2] = personel.getMüsteriList().get(i).getTcno();
			MüsteriData[3] = personel.getMüsteriList().get(i).getPassword();
			MüsteriModel.addRow(MüsteriData);
			
		}
		
		ybmoilModel = new DefaultTableModel();
		Object[] colybmoilname = new Object[2];
		colybmoilname[0] = "ID";
		colybmoilname[1] = "Benzinlik Ürünleri";
		
		ybmoilModel.setColumnIdentifiers(colybmoilname);
		ybmoilData = new Object[2];
		
		for(int i=0; i < ybmoil_.getList().size(); i++) {
			
			ybmoilData[0] = ybmoil_.getList().get(i).getId();
			ybmoilData[1] = ybmoil_.getList().get(i).getName();
            ybmoilModel.addRow(ybmoilData);
			
			
		}
		
		
	    
		
		setResizable(false);
		setTitle("Benzinlik Yönetim Sistemi");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 750, 500);
		w_pane = new JPanel();
		w_pane.setBackground(Color.WHITE);
		w_pane.setBorder(new EmptyBorder(5, 5, 5, 5));
		

		setContentPane(w_pane);
		w_pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Hoşgeldiniz sayın :"+ personel.getName());
		lblNewLabel.setBounds(0, 7, 217, 22);
		lblNewLabel.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		w_pane.add(lblNewLabel);
		
		
		JButton btnNewButton = new JButton("Çıkış Yap");
		btnNewButton.setBounds(615, 10, 109, 20);
		btnNewButton.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 11));
		w_pane.add(btnNewButton);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.LIGHT_GRAY);
		tabbedPane.setBackground(Color.GRAY);
		tabbedPane.setBounds(0, 63, 734, 398);
		w_pane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		
		tabbedPane.addTab("Taşıt Tanıma Sistemi", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Ad Soyad ");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(607, 0, 112, 31);
		panel.add(lblNewLabel_1);
		
		fld_adsoyad = new JTextField();
		fld_adsoyad.setBounds(576, 29, 143, 20);
		panel.add(fld_adsoyad);
		fld_adsoyad.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("T.C. No");
		lblNewLabel_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(607, 60, 112, 31);
		panel.add(lblNewLabel_1_1);
		
		fld_tcno = new JTextField();
		fld_tcno.setColumns(10);
		fld_tcno.setBounds(576, 102, 143, 20);
		panel.add(fld_tcno);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Araç Plaka");
		lblNewLabel_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1.setBounds(607, 133, 112, 31);
		panel.add(lblNewLabel_1_1_1);
		
		fld_plaka = new JTextField();
		fld_plaka.setColumns(10);
		fld_plaka.setBounds(576, 164, 143, 20);
		panel.add(fld_plaka);
		
		JButton btnNewButton_1 = new JButton("EKLE");
		
		btnNewButton_1.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
		      
			  if(fld_adsoyad.getText().length() == 0 || fld_plaka.getText().length() == 0 || fld_tcno.getText().length() == 0) {
				  
				  helper.ShowMsg("Fill");
			  }else {
				  try {
					boolean control = personel.addmüsteri(fld_tcno.getText(),fld_plaka.getText() , fld_adsoyad.getText() );
					if(control) {
						helper.ShowMsg("success");
						fld_tcno.setText(null);
						fld_plaka.setText(null);
						fld_adsoyad.setText(null);
						updatemüsterimodel();
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			  }
				
			}
			
		});
		
		btnNewButton_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btnNewButton_1.setBounds(596, 205, 105, 25);
		panel.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("ID");
		lblNewLabel_1_1_1_1.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 16));
		lblNewLabel_1_1_1_1.setBounds(636, 241, 112, 31);
		panel.add(lblNewLabel_1_1_1_1);
		
		fld_adsoyadıd = new JTextField();
		fld_adsoyadıd.setColumns(10);
		fld_adsoyadıd.setBounds(576, 268, 143, 20);
		panel.add(fld_adsoyadıd);
		
		JButton btn_silme = new JButton("Sil");
		
		btn_silme.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(fld_adsoyadıd.getText().length() == 0) {
					helper.ShowMsg("Lütfen geçerli bir müşteri seçiniz !");
				}else {
					if(helper.confirm("sure")) {
						int selectıd = Integer.parseInt(fld_adsoyadıd.getText());
						try {
							boolean control = personel.deletemüsteri(selectıd);
							if(control) {
								helper.ShowMsg("success");
								fld_adsoyadıd.setText(null);
								updatemüsterimodel();
							}
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				}
				
			}
			
		});
		
		
		
		
		btn_silme.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btn_silme.setBounds(596, 310, 105, 25);
		panel.add(btn_silme);
		
		JScrollPane w_scrolltaşıt = new JScrollPane();
		w_scrolltaşıt.setBounds(10, 11, 556, 348);
		panel.add(w_scrolltaşıt);
		
		
		table_taşıt = new JTable(MüsteriModel);
		w_scrolltaşıt.setViewportView(table_taşıt);
		
		
	
		
		
		table_taşıt.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				try {
					fld_adsoyadıd.setText(table_taşıt.getValueAt(table_taşıt.getSelectedRow(), 0).toString());
				} catch (Exception ex) {
					
				}
			
			}
			
		});
		
		JPanel w_oil = new JPanel();
		w_oil.setBackground(Color.LIGHT_GRAY);
		tabbedPane.addTab("Y B M O İ L", null, w_oil, null);
		w_oil.setLayout(null);
		
		JScrollPane w_scrolybmoil = new JScrollPane();
		w_scrolybmoil.setBounds(10, 11, 460, 348);
		w_oil.add(w_scrolybmoil);
		
		table_ybmoil = new JTable(ybmoilModel);
		w_scrolybmoil.setViewportView(table_ybmoil);
		
		JLabel lblNewLabel_1_2 = new JLabel("Y B M O İ  L");
		lblNewLabel_1_2.setFont(new Font("Yu Gothic UI Semilight", Font.PLAIN, 20));
		lblNewLabel_1_2.setBounds(552, 112, 112, 31);
		w_oil.add(lblNewLabel_1_2);
		
		fld_ybmoil = new JTextField();
		fld_ybmoil.setColumns(10);
		fld_ybmoil.setBounds(530, 154, 143, 20);
		w_oil.add(fld_ybmoil);
		
		JButton btn_ybmoil = new JButton("EKLE");
		btn_ybmoil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(fld_ybmoil.getText().length() ==0) {
					helper.ShowMsg("Fill");
				}else {
					try {
						if(ybmoil_.addybmoil(fld_ybmoil.getText())) {
							helper.ShowMsg("success");
							fld_ybmoil.setText(null);
						}
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btn_ybmoil.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 17));
		btn_ybmoil.setBounds(540, 188, 127, 31);
		w_oil.add(btn_ybmoil);
		
		
	}
	
	
	
	public void updatemüsterimodel() throws SQLException {
		DefaultTableModel clearmodel = (DefaultTableModel) table_taşıt.getModel();
		clearmodel.setRowCount(0);
	for(int i=0; i < personel.getMüsteriList().size(); i++) {
			
			MüsteriData[0] = personel.getMüsteriList().get(i).getId();
			MüsteriData[1] = personel.getMüsteriList().get(i).getName();
			MüsteriData[2] = personel.getMüsteriList().get(i).getTcno();
			MüsteriData[3] = personel.getMüsteriList().get(i).getPassword();
			MüsteriModel.addRow(MüsteriData);
			
		}
		
	}
}
